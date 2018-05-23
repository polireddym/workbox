package oneapp.incture.workbox.pmc.services;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oneapp.incture.workbox.pmc.dto.ReportAgingDto;
import oneapp.incture.workbox.pmc.dto.TaskCountDto;
import oneapp.incture.workbox.pmc.dto.UserProcessDetailRequestDto;
import oneapp.incture.workbox.pmc.dto.UserSearchRequestDto;
import oneapp.incture.workbox.pmc.dto.UserWorkloadDto;
import oneapp.incture.workbox.pmc.dto.responses.UserTaskStatusResponseDto;
import oneapp.incture.workbox.pmc.dto.responses.UserWorkloadResponseDto;
import oneapp.incture.workbox.pmc.wsdlconsumers.UMEManagementEngineConsumer;
import oneapp.incture.workbox.poadapter.dao.TaskEventsDao;
import oneapp.incture.workbox.poadapter.dao.TaskOwnersDao;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.MapResponseListDto;
import oneapp.incture.workbox.util.MapResponseTaskListDto;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;
import oneapp.incture.workbox.util.TaskStatusDto;

/**
 * Session Bean implementation class UserWorkloadFacade
 */
@Service("UserWorkloadFacade")
public class UserWorkloadFacade implements UserWorkloadFacadeLocal {

	private static final Logger logger = LoggerFactory.getLogger(UserWorkloadFacade.class);

	@Autowired
	private UMEManagementEngineConsumer umeConsumer;
	
	@Autowired
	private TaskOwnersDao taskOwnersDao;
	
	@Autowired
	private TaskEventsDao taskEventsDao;
	
	@Autowired
	private ConfigurationFacadeLocal config;

	@Override
	public UserWorkloadResponseDto getUserWorkLoadHeatMap(UserSearchRequestDto request) {

		UserWorkloadResponseDto responseDto = new UserWorkloadResponseDto();
		ResponseMessage message = new ResponseMessage();
		message.setStatus("SUCCESS");
		message.setStatusCode("0");

		List<UserWorkloadDto> loadDtos = null;

		if (!ServicesUtil.isEmpty(request.getProcessName()) && !ServicesUtil.isEmpty(request.getGroupName())) {

			Map<String, UserWorkloadDto> userLoadMap = null;
			List<Object[]> resultList;

			try {
				resultList = taskOwnersDao.getTaskCountWithOwners(request.getProcessName(), request.getRequestId(),
						request.getLabelName(), request.getTaskStatus());

				if (!ServicesUtil.isEmpty(resultList)) {
					userLoadMap = new HashMap<String, UserWorkloadDto>();
					loadDtos = new ArrayList<UserWorkloadDto>();

					for (Object[] obj : resultList) {

						UserWorkloadDto userLoadDto = new UserWorkloadDto();

						userLoadDto.setUserId(obj[0] == null ? null : (String) obj[0]);

						logger.error(" ****** " + (String) obj[2]);

						userLoadDto.setUserName(obj[2] == null ? null : (String) obj[2]);

						userLoadDto.setNoOfTask(ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));

						if (request.getGroupName().equals(PMCConstant.SEARCH_SMALL_ALL)) {
							List<com.incture.pmc.poadapter.services.GroupInfoDto> UserGroupInfoDtos = umeConsumer
									.getUserGroupByuserId(userLoadDto.getUserId()).getGroupInfoDtos();
							StringBuffer userGroups = new StringBuffer();
							if (!ServicesUtil.isEmpty(UserGroupInfoDtos)) {
								for (int i = 0; i < UserGroupInfoDtos.size(); i++) {
									if (i == UserGroupInfoDtos.size() - 1)
										userGroups.append(" ")
										.append(UserGroupInfoDtos.get(i).getGroupUniqName().trim());
									else if (i == 0)
										userGroups.append(UserGroupInfoDtos.get(i).getGroupUniqName().trim())
										.append(",");
									else
										userGroups.append(" ")
										.append(UserGroupInfoDtos.get(i).getGroupUniqName().trim()).append(",");
								}
							}

							userLoadDto.setUserGroup(userGroups.toString().trim());
						}

						userLoadMap.put(userLoadDto.getUserId(), userLoadDto);
					}//end for loop
					if (!request.getGroupName().equals(PMCConstant.SEARCH_SMALL_ALL)) {
						List<String> usersList = umeConsumer.getUsersAssignedInGroup(request.getGroupName());
						if (!ServicesUtil.isEmpty(usersList)) {
							for (String user : usersList) {
								if (userLoadMap.containsKey(user)) {
									userLoadMap.get(user).setUserGroup(request.getGroupName());
									loadDtos.add(userLoadMap.get(user));
								}
							}
						} else {
							logger.error("getUserList usersList is empty");
						}
					} else {
						Iterator<Entry<String, UserWorkloadDto>> it = userLoadMap.entrySet().iterator();
						while (it.hasNext()) {
							loadDtos.add(it.next().getValue());
						}
					}
					message.setMessage("Data Fetched Successfully");
				}
			} catch (NoResultFault e) {
				message.setMessage(PMCConstant.NO_RESULT);
			} catch (Exception e1) {
				logger.error("[PMC][UserWorkloadFacadeNew][getUserWorkLoadHeatMap][error]" + e1.getMessage());
				message.setMessage("Failed to fetch data :" + e1.getMessage());
				message.setStatus("FAILURE");
				message.setStatusCode("1");
			}

		}

		responseDto.setUserWorkloadDtos(loadDtos);
		responseDto.setMessage(message);
		return responseDto;
	}
	

	@Override
	public TaskCountDto getUserWorkLoadTrendGraph(UserProcessDetailRequestDto request) {
		TaskCountDto taskCountDto = null;
		if (!ServicesUtil.isEmpty(request.getUserId()) && !ServicesUtil.isEmpty(request.getGraphType())) {
			Calendar calendar = GregorianCalendar.getInstance();
			Date startDate = null, endDate = null;
			Map<String, List<Date>> intervalMap = null;
			try {
				if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(request.getGraphType())) {
					intervalMap = ServicesUtil.getDateIntervalRangeMap(PMCConstant.MONTH_RANGE,
							PMCConstant.MONTH_INTERVAL);
					calendar.add(Calendar.DAY_OF_MONTH, -(PMCConstant.MONTH_RANGE - 1));
				} else {
					intervalMap = ServicesUtil.getDateIntervalRangeMap(PMCConstant.WEEK_RANGE,
							PMCConstant.WEEK_INTERVAL);
					calendar.add(Calendar.DAY_OF_MONTH, -(PMCConstant.WEEK_RANGE - 1));
				}
				startDate = ServicesUtil.setInitialTime(calendar.getTime());
				endDate = new Date();
				List<Object[]> resultList = null;
				try {
					resultList = taskEventsDao.getUserTaskCount(request.getUserId(), request.getProcessName(),
							request.getRequestId(), request.getLabelValue(), request.getStatus(), startDate, endDate);
					taskCountDto = new TaskCountDto();
					Map<String, BigDecimal> taskCountDetail = new LinkedHashMap<String, BigDecimal>();
					for (Object[] obj : resultList) {
						taskCountDto.setUserId(request.getUserId());
						taskCountDto.setMaxCount(
								taskCountDto.getMaxCount().add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
						calendar.setTime(ServicesUtil.dateResultAsDate(obj[0]));
						if (!intervalMap.isEmpty()) {
							for (Map.Entry<String, List<Date>> entry : intervalMap.entrySet()) {
								if (!taskCountDetail.containsKey(entry.getKey()))
									taskCountDetail.put(entry.getKey(), new BigDecimal(0));
								List<Date> DateIntervals = entry.getValue();
								if (calendar.getTime().equals(DateIntervals.get(0))
										|| (calendar.getTime().after(DateIntervals.get(0))
												&& calendar.getTime().before(DateIntervals.get(1)))
										|| calendar.getTime().equals(DateIntervals.get(1))) {
									taskCountDetail.put(entry.getKey(), taskCountDetail.get(entry.getKey())
											.add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
								}
							}
						}
					}
					// taskCountDto.setTaskCountDetail(taskCountDetail);
					MapResponseListDto listDto = ServicesUtil.generateMapDtoFromMap(taskCountDetail);
					taskCountDto.setTaskCountDetail(listDto);
				} catch (NoResultFault e) {
					e.printStackTrace();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return taskCountDto;
	}

	@Override
	public UserTaskStatusResponseDto getUserWorkLoadTaskStausGraph(UserProcessDetailRequestDto request) {
		boolean open = false;
		boolean closed = false;
		UserTaskStatusResponseDto responseDto = new UserTaskStatusResponseDto();
		ResponseMessage message = new ResponseMessage();
		if (!ServicesUtil.isEmpty(request.getUserId()) && !ServicesUtil.isEmpty(request.getGraphType())) {
			Calendar calendar = GregorianCalendar.getInstance();
			Date startDate = null, endDate = null;
			DateFormat dateFormatter = null;
			List<String> weekDates = null;
			Map<String, List<Date>> segmentMap = null;
			if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(request.getGraphType())) {
				List<ReportAgingDto> reportAgingConfigDtos = config
						.getAgeingBuckets(PMCConstant.USER_TASK_STATUS_GRAPH);
				if (!ServicesUtil.isEmpty(reportAgingConfigDtos)) {
					List<String> segList = new ArrayList<String>();
					for (ReportAgingDto reportAgingDto : reportAgingConfigDtos) {
						String segment = reportAgingDto.getLowerSegment() + " - " + (reportAgingDto.getHigherSegment());
						segList.add(segment);
					}
					segmentMap = ServicesUtil.dateSegmentMap(segList);
				}
				calendar.add(Calendar.DAY_OF_MONTH, -(PMCConstant.MONTH_RANGE - 1));
			} else {
				calendar.add(Calendar.DAY_OF_MONTH, -(PMCConstant.WEEK_RANGE - 1));
				weekDates = ServicesUtil.getWeekDateRangeInString(PMCConstant.WEEK_RANGE);
				dateFormatter = new SimpleDateFormat(PMCConstant.PMC_DATE_FORMATE);
			}
			startDate = ServicesUtil.setInitialTime(calendar.getTime());
			endDate = new Date();
			List<Object[]> resultList = null;
			try {
				resultList = taskEventsDao.getTaskCountByOwner(request.getUserId(), request.getProcessName(),
						request.getRequestId(), request.getLabelValue(), request.getStatus(), startDate, endDate);
				Map<String, TaskStatusDto> taskCountDetail = new LinkedHashMap<String, TaskStatusDto>();
				int count = 0;
				System.err
						.println("[PMC][UserWorkloadFacade][getUserWorkLoadTaskStausGraph][resultList][open] : Size : "
								+ resultList.size() + " List : " + resultList);
				if (resultList.size() != 0) {
					for (Object[] obj : resultList) {
						logger.error("OPEN " + ++count + "   " + ServicesUtil.dateResultAsDate(obj[0])
								+ "  couunt " + ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
						calendar.setTime(ServicesUtil.dateResultAsDate(obj[0]));
						if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(request.getGraphType())) {
							logger.error("[PMC][UserWorkloadFacade][getUserWorkLoadTaskStausGraph][mapkeys] : "
									+ segmentMap.keySet());
							for (Map.Entry<String, List<Date>> entry : segmentMap.entrySet()) {
								if (!taskCountDetail.containsKey(entry.getKey()))
									taskCountDetail.put(entry.getKey(), new TaskStatusDto());
								List<Date> DateIntervals = entry.getValue();
								if (calendar.getTime().equals(DateIntervals.get(0))
										|| (calendar.getTime().after(DateIntervals.get(1))
												&& calendar.getTime().before(DateIntervals.get(0)))
										|| calendar.getTime().equals(DateIntervals.get(1))) {
									taskCountDetail.get(entry.getKey())
											.setOpen(taskCountDetail.get(entry.getKey()).getOpen().add(obj[1] == null
													? null : ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
								}
							}
						} else {
							for (String date : weekDates) {
								if (!taskCountDetail.containsKey(date))
									taskCountDetail.put(date, new TaskStatusDto());
								if (dateFormatter.format(calendar.getTime()).equals(date)) {
									taskCountDetail.get(date).setOpen(taskCountDetail.get(date).getOpen().add(
											obj[1] == null ? null : ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));

								}
							}
						}
					}
				} else {
					open = true;
					if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(request.getGraphType())) {
						for (Map.Entry<String, List<Date>> entry : segmentMap.entrySet()) {
							taskCountDetail.put(entry.getKey(), new TaskStatusDto());
						}
					} else {
						for (String date : weekDates) {
							taskCountDetail.put(date, new TaskStatusDto());
						}
					}
				}

				logger.error("taskCountDetail " + taskCountDetail);
				resultList = taskEventsDao.getTaskCountByOwner(request.getUserId(), request.getProcessName(),
						request.getRequestId(), request.getLabelValue(), PMCConstant.TASK_COMPLETED, startDate,
						endDate);
				if (resultList.size() != 0) {
					for (Object[] obj : resultList) {
						logger.error("CLOSED " + ++count + "   " + ServicesUtil.dateResultAsDate(obj[0])
								+ "  couunt " + ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
						calendar.setTime(ServicesUtil.dateResultAsDate(obj[0]));
						if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(request.getGraphType())) {
							for (Map.Entry<String, List<Date>> entry : segmentMap.entrySet()) {
								List<Date> DateIntervals = entry.getValue();
								logger.error("DateIntervals" + DateIntervals);
								if (calendar.getTime().equals(DateIntervals.get(0))
										|| (calendar.getTime().after(DateIntervals.get(1))
												&& calendar.getTime().before(DateIntervals.get(0)))
										|| calendar.getTime().equals(DateIntervals.get(1))) {
									taskCountDetail.get(entry.getKey()).setClosed(
											taskCountDetail.get(entry.getKey()).getClosed().add(obj[1] == null ? null
													: ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
								}
							}
						} else {
							for (String date : weekDates) {
								logger.error("date" + date);
								if (dateFormatter.format(calendar.getTime()).equals(date)) {
									taskCountDetail.get(date).setClosed(taskCountDetail.get(date).getClosed().add(
											obj[1] == null ? null : ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
								}
							}
						}
					}
				} else {
					closed = true;
				}
				if (open == true && closed == true) {
					responseDto.setTaskCountDetail(null);
					message.setStatus("NO RESULT FOUND");
					message.setStatusCode("0");
					responseDto.setResponseMessage(message);
				} /*
					 * else if(open == false && closed == true){
					 * logger.error("taskCountDetail" + taskCountDetail);
					 * responseDto.setTaskCountDetail(taskCountDetail);
					 * message.setStatus("NO CLOSED RESULT FOUND");
					 * message.setStatusCode("1");
					 * responseDto.setResponseMessage(message); } else if(open
					 * == true && closed == false){
					 * logger.error("taskCountDetail" + taskCountDetail);
					 * responseDto.setTaskCountDetail(taskCountDetail);
					 * message.setStatus("NO OPEN RESULT FOUND");
					 * message.setStatusCode("1");
					 * responseDto.setResponseMessage(message); } else if(open
					 * == false && closed == false){
					 */ else {
					logger.error("taskCountDetail" + taskCountDetail);
					// responseDto.setTaskCountDetail(taskCountDetail);
					MapResponseTaskListDto dto = ServicesUtil.generateMapTaskDtoFromMap(taskCountDetail);
					responseDto.setTaskCountDetail(dto);
					message.setStatus("SUCCESS");
					message.setStatusCode("1");
					responseDto.setResponseMessage(message);
				}
			} catch (Exception e) {
				message.setStatus("INTERNAL EXCEPTION : " + e.getMessage());
				message.setStatusCode("0");
				responseDto.setResponseMessage(message);
				e.printStackTrace();
			}
		}
		return responseDto;
	}
}
