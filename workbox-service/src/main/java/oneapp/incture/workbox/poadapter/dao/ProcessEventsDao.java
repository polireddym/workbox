package oneapp.incture.workbox.poadapter.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.AgingGraphDto;
import oneapp.incture.workbox.pmc.dto.AgingResponseDto;
import oneapp.incture.workbox.pmc.dto.AgingTableDto;
import oneapp.incture.workbox.pmc.dto.AgingTableHeaderDto;
import oneapp.incture.workbox.pmc.dto.ProcessAgeingResponse;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsDto;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsResponse;
import oneapp.incture.workbox.pmc.dto.ReportAgingDto;
import oneapp.incture.workbox.pmc.dto.UserDetailsDto;
import oneapp.incture.workbox.pmc.dto.UserProcessDetailRequestDto;
import oneapp.incture.workbox.pmc.entity.ProcessConfigDo;
import oneapp.incture.workbox.poadapter.dto.ProcessEventsDto;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.poadapter.entity.ProcessEventsDo;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("ProcessEventsDao")
@Transactional
public class ProcessEventsDao extends BaseDao<ProcessEventsDo, ProcessEventsDto> {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessEventsDao.class);
	
	@Override
	protected ProcessEventsDo importDto(ProcessEventsDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		ProcessEventsDo entity = new ProcessEventsDo();
		if (!ServicesUtil.isEmpty(fromDto.getProcessId()))
			entity.setProcessId(fromDto.getProcessId());
		if (!ServicesUtil.isEmpty(fromDto.getName()))
			entity.setName(fromDto.getName());
		if (!ServicesUtil.isEmpty(fromDto.getStartedBy()))
			entity.setStartedBy(fromDto.getStartedBy());
		if (!ServicesUtil.isEmpty(fromDto.getStatus()))
			entity.setStatus(fromDto.getStatus());
		if (!ServicesUtil.isEmpty(fromDto.getSubject()))
			entity.setSubject(fromDto.getSubject());
		if (!ServicesUtil.isEmpty(fromDto.getCompletedAt()))
			entity.setCompletedAt(fromDto.getCompletedAt());
		if (!ServicesUtil.isEmpty(fromDto.getStartedAt()))
			entity.setStartedAt(fromDto.getStartedAt());
		if (!ServicesUtil.isEmpty(fromDto.getRequestId()))
			entity.setRequestId(fromDto.getRequestId());
		if (!ServicesUtil.isEmpty(fromDto.getStartedByDisplayName()))
			entity.setStartedByDisplayName(fromDto.getStartedByDisplayName());
		return entity;
	}

	@Override
	protected ProcessEventsDto exportDto(ProcessEventsDo entity) {
		ProcessEventsDto processEventsDto = new ProcessEventsDto();
		if (!ServicesUtil.isEmpty(entity.getProcessId()))
			processEventsDto.setProcessId(entity.getProcessId());
		if (!ServicesUtil.isEmpty(entity.getName()))
			processEventsDto.setName(entity.getName());
		if (!ServicesUtil.isEmpty(entity.getStartedBy()))
			processEventsDto.setStartedBy(entity.getStartedBy());
		if (!ServicesUtil.isEmpty(entity.getStatus()))
			processEventsDto.setStatus(entity.getStatus());
		if (!ServicesUtil.isEmpty(entity.getSubject()))
			processEventsDto.setSubject(entity.getSubject());
		if (!ServicesUtil.isEmpty(entity.getCompletedAt()))
			processEventsDto.setCompletedAt(entity.getCompletedAt());
		if (!ServicesUtil.isEmpty(entity.getStartedAt()))
			processEventsDto.setStartedAt(entity.getStartedAt());
		if (!ServicesUtil.isEmpty(entity.getRequestId()))
			processEventsDto.setRequestId(entity.getRequestId());
		if (!ServicesUtil.isEmpty(entity.getStartedByDisplayName()))
			processEventsDto.setStartedByDisplayName(entity.getStartedByDisplayName());
		return processEventsDto;
	}

	public ProcessEventsDto getProcessDetail(String processId) {
		ProcessEventsDto processEventsDto = null;
		if (!ServicesUtil.isEmpty(processId)) {
			Query query = this.getSession().createSQLQuery("select pe from ProcessEventsDo pe where pe.processId =:processId");
			query.setParameter("processId", processId);
			ProcessEventsDo processEventsDo = (ProcessEventsDo) query.uniqueResult();
			if (!ServicesUtil.isEmpty(processEventsDo)) {
				query = this.getSession().createSQLQuery("select pe from ProcessConfigDo pe where pe.processName =:processName");
				query.setParameter("processName", processEventsDo.getName());
				processEventsDto = exportDto(processEventsDo);
				ProcessConfigDo processConfigDo = null;
				try {
					Object obj = query.uniqueResult();
					processConfigDo = (ProcessConfigDo) obj;
					if (!ServicesUtil.isEmpty(processConfigDo) && !ServicesUtil.isEmpty(processConfigDo.getProcessDisplayName()))
						processEventsDto.setProcessDisplayName(processConfigDo.getProcessDisplayName());

				} catch (Exception e) {
					processEventsDto.setProcessDisplayName(processEventsDto.getName());
				}
			}
		}
		return processEventsDto;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllProcessName() throws NoResultFault {
		Query query = this.getSession().createSQLQuery("select DISTINCT p.name from ProcessEventsDo p");
		List<String> processNameList = (List<String>) query.list();
		if (ServicesUtil.isEmpty(processNameList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		return processNameList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getProcessDetail(String userId, String processName, String requestId, String labelValue, String status, Integer page) throws NoResultFault {
		logger.error("[PMC] ProcessEventsDao getProcessDetail Started - with request - " + userId);
		String tempQuery = "";
//		int firstIndex = 0;
//		int lastIndex = 0;
		/*if (!ServicesUtil.isEmpty(page)) {
			firstIndex = PMCConstant.PAGE_SIZE * (page - 1) + 1;
			lastIndex = page * PMCConstant.PAGE_SIZE;
		}*/
		
		
		String paginationQuery = "";
				//"SELECT * FROM (SELECT a.*, rownum R_NUM FROM (";
		String query = paginationQuery
				+ "select DISTINCT(pe.PROCESS_ID) AS PROCESS_ID, pe.STARTED_AT AS STARTED_AT, pe.STARTED_BY AS STARTED_BY, pe.SUBJECT as SUBJECT, pe.REQUEST_ID As REQUEST_ID , pe.NAME AS PROCESS_NAME, pe.STARTED_BY_DISP AS STARTED_BY_DISP, pc.PROCESS_DISPLAY_NAME AS PROCESS_DISPLAY_NAME from task_owners tw left join task_events te on tw.event_id = te.event_id left join process_events pe on pe.process_id = te.process_id LEFT JOIN PROCESS_CONFIG_TB pc ON pc.PROCESS_NAME   = pe.NAME where tw.task_owner='"
				+ userId + "'";
		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and pe.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN( " + processName + "))";
		}
		if (!ServicesUtil.isEmpty(requestId)) {
			tempQuery = tempQuery + " and pe.REQUEST_ID = '" + requestId + "'";
		}
		if (!ServicesUtil.isEmpty(labelValue)) {
			tempQuery = tempQuery + " and pe.SUBJECT like '%" + labelValue + "%'";
		}
		if (!ServicesUtil.isEmpty(status)) {
			if (PMCConstant.SEARCH_READY.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "'";
			} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "' and tw.IS_PROCESSED = 1";
			} else {
				tempQuery = tempQuery + " and (te.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' or (te.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and tw.IS_PROCESSED = 1))";
			}
		}
		tempQuery = tempQuery + " and pe.status='" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
		query = query + tempQuery + " order by 2 desc";

		/*if(lastIndex != 0){
			paginationQuery = ")a WHERE ROWNUM <= " + lastIndex + ") WHERE R_NUM >= " + firstIndex;
		}else{
			paginationQuery = ")a)";
		}
*/
		query = query + paginationQuery;
		
		if (!ServicesUtil.isEmpty(page) && page > 0) {
			int first = (page - 1) * PMCConstant.PAGE_SIZE;
			int last = PMCConstant.PAGE_SIZE;
			
			/* Commented for Pagination in HANA */
//			q.setFirstResult(first);
//			q.setMaxResults(last);
			
			query += " LIMIT "+last+" OFFSET "+first+"";
		}
		
		logger.error("get - " + query);
		Query q = this.getSession().createSQLQuery(query);
		
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		logger.error("[PMC] ProcessEventsDao getProcessDetail Ended - with resultList - " + resultList);

		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getProcessAgingCountByDatesRange(Map<String, List<Date>> segmentMap, String processName) throws NoResultFault {

		logger.error("[pmc][processEventsDao][getProcessAgingCountByDatesRange] : ");
		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
		Iterator<Entry<String, List<Date>>> it = segmentMap.entrySet().iterator();
		String query = "";
		int count = 0;
		while (it.hasNext()) {
			++count;
			Entry<String, List<Date>> entry = it.next();
			String range = (String) entry.getKey();
			List<Date> dateRange = (List<Date>) entry.getValue();
			query = query + " Select '" + range
					+ "' AS DATE_RANGE, COUNT(*) AS PROCESS_COUNT, pe.NAME AS PROCESS_NAME, pc.PROCESS_DISPLAY_NAME AS PROCESS_DISPLAY_NAME FROM PROCESS_EVENTS pe LEFT JOIN PROCESS_CONFIG_TB pc ON pc.PROCESS_NAME = pe.NAME WHERE STARTED_AT BETWEEN "
					+"'"+ newDf.format(dateRange.get(1))+"' and '" +newDf.format(dateRange.get(0))+"'"
					//+ " TO_DATE('" + dateFormatter.format(dateRange.get(1)) + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + dateFormatter.format(dateRange.get(0)) + "', 'DD/MM/YY hh:mi:ss PM')
					+"and STATUS = '" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
			if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
				query = query + " and pe.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN (" + processName + "))";
			}
			query = query + "  group by pe.NAME, pc.PROCESS_DISPLAY_NAME";
			if (count < segmentMap.entrySet().size()) {
				query = query + " UNION";
			}
		}

		logger.error("get - " + query);
		Query q = this.getSession().createSQLQuery(query.trim());
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getProcessAgingCountByDates(Date startDate, Date endDate, String processName) throws NoResultFault {

		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tempQuery = "";
		String query = "select pe.NAME AS PROCESS_NAME, count(*) AS PROCESS_COUNT,"
				//	+" trunc(pe.STARTED_AT)"
				+"to_date(pe.STARTED_AT)"
				+ " AS STARTED_DATE, pc.PROCESS_DISPLAY_NAME AS PROCESS_DISPLAY_NAME from PROCESS_EVENTS pe LEFT JOIN PROCESS_CONFIG_TB pc ON pc.PROCESS_NAME = pe.NAME where pe.STATUS='IN_PROGRESS' and to_date(pe.STARTED_AT) between to_date('"
				+ newDf.format(startDate)+"') and to_date('" +newDf.format(endDate)+"')";
		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and pe.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN (" + processName + "))";
		}
		String groupQuery = " group by to_date(pe.STARTED_AT), pe.NAME, pc.PROCESS_DISPLAY_NAME ORDER BY to_date(pe.STARTED_AT)";
				//" group by trunc(pe.STARTED_AT), pe.NAME, pc.PROCESS_DISPLAY_NAME ORDER BY trunc(pe.STARTED_AT)";
		query = query + tempQuery + groupQuery;
		logger.error("get - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		return resultList;
	}

	public Object getProcessCount(String userId, String processName, String requestId, String labelValue, String status) throws NoResultFault {

		String tempQuery = "";
		String query = "select COUNT(DISTINCT(pe.PROCESS_ID)) AS PROCESS_COUNT from task_owners tw left join task_events te on tw.event_id = te.event_id left join process_events pe on pe.process_id = te.process_id where tw.task_owner='"
				+ userId + "'";
		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and pe.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN (" + processName + "))";
		}
		if (!ServicesUtil.isEmpty(requestId)) {
			tempQuery = tempQuery + " and pe.REQUEST_ID = '" + requestId + "'";
		}
		if (!ServicesUtil.isEmpty(labelValue)) {
			tempQuery = tempQuery + " and pe.SUBJECT like '%" + labelValue + "%'";
		}
		if (!ServicesUtil.isEmpty(status)) {
			if (PMCConstant.SEARCH_READY.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "'";
			} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "' and tw.IS_PROCESSED = 1";
			} else {
				tempQuery = tempQuery + " and (te.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' or (te.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and tw.IS_PROCESSED = 1))";
			}
		}
		tempQuery = tempQuery + " and pe.status='" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
		query = query + tempQuery;
		logger.error("get - " + query);
		Query q = this.getSession().createSQLQuery(query);
		Object resultList = q.uniqueResult();
		if (ServicesUtil.isEmpty(resultList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		return resultList;

	}

	public ProcessDetailsResponse getProcessesByTaskOwner(UserProcessDetailRequestDto request) {
		logger.error("[PMC] ProcessEventsDao getProcessesByTaskOwner Started - with request - " + request);
		ProcessDetailsResponse detailResponse = null;
		List<ProcessEventsDto> processEventsDtos = null;
		ResponseMessage message = new ResponseMessage();
		if (!ServicesUtil.isEmpty(request.getUserId())) {
			detailResponse = new ProcessDetailsResponse();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			List<Object[]> resultList = null;
			BigDecimal count = null;
			try {
				count = ServicesUtil.getBigDecimal(/* (Long) */ this.getProcessCount(request.getUserId(), request.getProcessName(), request.getRequestId(), request.getLabelValue(), request.getStatus()));
				logger.error("[PMC] ProcessEventsDao getProcessesByTaskOwner ProcessCount - " + count);
				resultList = this.getProcessDetail(request.getUserId(), request.getProcessName(), request.getRequestId(), request.getLabelValue(), request.getStatus(),
						ServicesUtil.isEmpty(request.getPage()) ? null : request.getPage());
				processEventsDtos = new ArrayList<ProcessEventsDto>();

				for (Object[] obj : resultList) {
					ProcessEventsDto processEventsDto = new ProcessEventsDto();
					processEventsDto.setProcessId(obj[0] == null ? null : (String) obj[0]);
					processEventsDto.setStartedAt(obj[1] == null ? null : ServicesUtil.resultAsDate(obj[1]));
					processEventsDto.setStartedAtInString(obj[1] == null ? null : formatter.format(ServicesUtil.resultAsDate(obj[1])));
					processEventsDto.setStartedBy(obj[2] == null ? null : (String) obj[2]);
					processEventsDto.setSubject(obj[3] == null ? null : (String) obj[3]);
					processEventsDto.setRequestId(obj[4] == null ? null : (String) obj[4]);
					processEventsDto.setName(obj[5] == null ? null : (String) obj[5]);
					processEventsDto.setStartedByDisplayName(obj[6] == null ? null : (String) obj[6]);
					processEventsDto.setProcessDisplayName(obj[7] == null ? obj[5] == null ? null : (String) obj[5] : (String) obj[7]);
					processEventsDtos.add(processEventsDto);
				}
				detailResponse.setProcessEventsList(processEventsDtos);
				detailResponse.setCount(count);
				message.setStatus("Success");
				message.setStatusCode("0");
				message.setMessage("Process Details Fetched Successfully");
				detailResponse.setResponseMessage(message);
			} catch (NoResultFault e) {
				message.setStatus("Failed");
				message.setStatusCode("1");
				message.setMessage("Parse Exception :" + e.getMessage());
				detailResponse.setResponseMessage(message);
			}
		}
		logger.error("[PMC] ProcessEventsDao getProcessesByTaskOwner Ended - with ProcessDetailsResponse - " + detailResponse);
		return detailResponse;
	}

	@SuppressWarnings("unchecked")
	public ProcessDetailsResponse getProcessByDuration(ProcessDetailsDto processDetailsDto) {
		ProcessDetailsResponse detailResponse = new ProcessDetailsResponse();
		ResponseMessage message = new ResponseMessage();
		Date startDateFrom = null;
		Date startDateTo = null;
		if (!ServicesUtil.isEmpty(processDetailsDto.getStartDayFrom()) && !ServicesUtil.isEmpty(processDetailsDto.getStartDayTo())) {
			try {
				startDateFrom = ServicesUtil.getDate(processDetailsDto.getStartDayFrom());
				startDateTo = ServicesUtil.getDate(processDetailsDto.getStartDayTo());
				startDateTo = ServicesUtil.setEndTime(startDateTo);
				logger.error("startDate  - " + startDateFrom +" [] endDate  - " + startDateTo);
				StringBuffer processQuery = new StringBuffer(
						"select p.REQUEST_ID AS REQUEST_ID, p.PROCESS_ID AS PROCESS_ID, p.NAME AS NAME, p.SUBJECT AS SUBJECT, p.STARTED_AT AS STARTED_AT, p.STARTED_BY AS STARTED_BY, p.STARTED_BY_DISP AS STARTED_BY_DISP, c.PROCESS_DISPLAY_NAME AS PROCESS_DISPLAY_NAME FROM PROCESS_EVENTS p LEFT JOIN PROCESS_CONFIG_TB c ON p.NAME = c.PROCESS_NAME where p.STATUS = \'IN_PROGRESS\'");
				if (!ServicesUtil.isEmpty(processDetailsDto.getProcessName())) {
					//processQuery.append(" and p.NAME = ('" + processDetailsDto.getProcessName() + "')");
					processQuery.append(" and p.NAME = '"+processDetailsDto.getProcessName()+"'");
				}
				if (!ServicesUtil.isEmpty(processDetailsDto.getStartDayFrom()) && !ServicesUtil.isEmpty(processDetailsDto.getStartDayTo())) {
					//	DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
					DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					processQuery.append(" and p.STARTED_AT between"
							+ "'"+ newDf.format(startDateFrom)+"' and '" +newDf.format(startDateTo)+"'");
					//+ " TO_DATE('" + dateFormatter.format(startDateFrom) + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + dateFormatter.format(startDateTo) + "', 'DD/MM/YY hh:mi:ss PM')");
				}
				
				if (!ServicesUtil.isEmpty(processDetailsDto.getPage())) {
					int first = (processDetailsDto.getPage() - 1) * PMCConstant.PAGE_SIZE;
					int last = PMCConstant.PAGE_SIZE;
					
					/* Commented for Pagination in HANA */
//					query.setFirstResult(first);
//					query.setMaxResults(last);
					
					processQuery = processQuery.append(" LIMIT "+last+" OFFSET "+first+"");
				}
				
				Query query = this.getSession().createSQLQuery(processQuery.toString());
				
				logger.error("processQuery - " + processQuery.toString());
				List<Object[]> resultList = query.list();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
				if (resultList != null) {
					List<ProcessEventsDto> processEventsList = new ArrayList<ProcessEventsDto>();
					for (Object[] obj : resultList) {
						ProcessEventsDto processEventsDto = new ProcessEventsDto();
						processEventsDto.setRequestId(obj[0] == null ? null : (String) obj[0]);
						processEventsDto.setProcessId(obj[1] == null ? null : (String) obj[1]);
						processEventsDto.setName(obj[2] == null ? null : (String) obj[2]);
						processEventsDto.setSubject(obj[3] == null ? null : (String) obj[3]);
						processEventsDto.setStartedAt(obj[4] == null ? null : ServicesUtil.resultAsDate(obj[4]));
						processEventsDto.setStartedAtInString(obj[4] == null ? null : formatter.format(ServicesUtil.resultAsDate(obj[4])));
						processEventsDto.setStartedByDisplayName(obj[6] == null ? null : (String) obj[6]);
						processEventsDto.setStartedBy(obj[5] == null ? null : (String) obj[5]);
						processEventsDto.setProcessDisplayName(obj[7] == null ? obj[2] == null ? null : (String) obj[2] : (String) obj[7]);
						processEventsList.add(processEventsDto);
					}
					Comparator<ProcessEventsDto> sortByStartedAt = new Comparator<ProcessEventsDto>() {
						@Override
						public int compare(ProcessEventsDto o1, ProcessEventsDto o2) {
							return o2.getStartedAt().compareTo(o1.getStartedAt());
						}
					};
					Collections.sort(processEventsList, sortByStartedAt);

					logger.error("**** " + processEventsList);
					detailResponse.setProcessEventsList(processEventsList);
					message.setStatus("Success");
					message.setStatusCode("0");
					message.setMessage("Process Details Fetched Successfully");
					detailResponse.setResponseMessage(message);
				} else {
					message.setStatus("Success");
					message.setStatusCode("1");
					message.setMessage("No Results Found for the requested query");
					detailResponse.setResponseMessage(message);
				}
			} catch (ParseException e) {
				message.setStatus("Failed");
				message.setStatusCode("1");
				message.setMessage("Parse Exception :" + e.getMessage());
				detailResponse.setResponseMessage(message);
			}
		}
		return detailResponse;
	}

	public ProcessAgeingResponse getProcessAgeing(String ageingType, String processName, List<ReportAgingDto> reportAgingConfigDtos) {
		ProcessAgeingResponse response = new ProcessAgeingResponse();
		ResponseMessage message = new ResponseMessage();
		if (!ServicesUtil.isEmpty(ageingType)) {
			ProcessEventsDao processEventsDao = new ProcessEventsDao();
			Map<String, BigDecimal> headerMap = new LinkedHashMap<String, BigDecimal>();
			if (PMCConstant.GRAPH_TREND_MONTH.equalsIgnoreCase(ageingType)) {
				if (!ServicesUtil.isEmpty(reportAgingConfigDtos)) {
					List<String> tableSegList = new ArrayList<String>();
					List<String> graphSegList = new ArrayList<String>();
					headerMap.put(PMCConstant.PROCESS_NAME_LABEL, new BigDecimal(0));
					for (ReportAgingDto reportAgingDto : reportAgingConfigDtos) {
						String segment = reportAgingDto.getLowerSegment() + " - " + reportAgingDto.getHigherSegment();
						tableSegList.add(segment);
						graphSegList.add(segment);
						headerMap.put(segment, new BigDecimal(0));
					}
					headerMap.put(PMCConstant.PROCESS_TOTAL, new BigDecimal(0));
					try {
						List<Object[]> resultList = processEventsDao.getProcessAgingCountByDatesRange(ServicesUtil.dateSegmentMap(tableSegList), processName);
						ArrayList<AgingGraphDto> agingGraphDtos = new ArrayList<AgingGraphDto>();
						if (!ServicesUtil.isEmpty(resultList)) {
							agingGraphDtos = new ArrayList<AgingGraphDto>();
							List<AgingTableDto> processAgingTableDtos = new ArrayList<AgingTableDto>();
							for (Object[] obj : resultList) {
								// For Table
								AgingTableDto newAegingTableDto = new AgingTableDto((String) obj[2]);
								newAegingTableDto.setProcessDisplayName(obj[3] == null ? (String) obj[2] : (String) obj[3]);
								if (processAgingTableDtos.contains(newAegingTableDto)) {
									AgingTableDto existingDto = processAgingTableDtos.get(processAgingTableDtos.indexOf(newAegingTableDto));
									Map<String, BigDecimal> existingMap = existingDto.getOldDataMap();
									//existingMap.put((String) obj[0], (BigDecimal) obj[1]);
									existingMap.put((String) obj[0], ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
									headerMap.put((String) obj[0], headerMap.get((String) obj[0]).add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
									existingDto.setCount(existingDto.getCount().add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
									existingDto.setDataMap(ServicesUtil.generateMapDtoFromMap(existingMap));
								} else {
									Map<String, BigDecimal> newMap = new LinkedHashMap<String, BigDecimal>();
									for (String segment : tableSegList) {
										newMap.put(segment, new BigDecimal(0));
									}
									headerMap.put((String) obj[0], headerMap.get((String) obj[0]).add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
									newMap.put((String) obj[0], ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
									newAegingTableDto.setOldDataMap(newMap);
									newAegingTableDto.setDataMap(ServicesUtil.generateMapDtoFromMap(newMap));
									newAegingTableDto.setCount(ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
									processAgingTableDtos.add(newAegingTableDto);
									Collections.sort(processAgingTableDtos);
								}
								// For Graph
								AgingGraphDto graphDto = new AgingGraphDto();
								graphDto.setRange((String) obj[0]);
								if (graphSegList.contains((String) obj[0])) {
									graphSegList.remove((String) obj[0]);
								}
								graphDto.setNoOfProcess(ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
								graphDto.setProcessName((String) obj[2]);
								graphDto.setProcessDisplayName(obj[3] == null ? (String) obj[2] : (String) obj[3]);
								agingGraphDtos.add(graphDto);
							}
							for (String segmentRange : graphSegList) {
								AgingGraphDto graphDto = new AgingGraphDto();
								graphDto.setRange(segmentRange);
								agingGraphDtos.add(graphDto);
							}
							Collections.sort(agingGraphDtos, new Comparator<AgingGraphDto>() {
								@Override
								public int compare(AgingGraphDto o1, AgingGraphDto o2) {
									String[] o1Range = o1.getRange().split("-");
									String[] o2Range = o2.getRange().split("-");
									return (Integer.valueOf(o1Range[0].trim())).compareTo(Integer.valueOf(o2Range[0].trim()));
								}
							});
							response.setAgeingGraph(agingGraphDtos);
							response.setAgeingTable(convertTableFormat(processAgingTableDtos, headerMap));
							message.setMessage("Results Fetched Successfully");
							message.setStatus("Success");
							message.setStatusCode("0");
							response.setResponseMessage(message);
						}
					} catch (NoResultFault e) {
						message.setMessage("No Open Processes found for the last 30 Days");
						message.setStatus("Success");
						message.setStatusCode("1");
						response.setResponseMessage(message);
					}
				} else {
					message.setMessage("No Configuartions are maintained for the Last 30 Days.Please contact administartor");
					message.setStatus("Failed");
					message.setStatusCode("1");
					response.setResponseMessage(message);
				}
			} else {
				Calendar calendar = GregorianCalendar.getInstance();
				Date startDate = null, endDate = null;
				calendar.add(Calendar.DAY_OF_MONTH, -(PMCConstant.WEEK_RANGE - 1));
				startDate = ServicesUtil.setInitialTime(calendar.getTime());
				endDate = new Date();
				List<String> tableWeekDates = ServicesUtil.getWeekDateRangeInString(PMCConstant.WEEK_RANGE);
				List<String> graphWeekDates = new ArrayList<String>(tableWeekDates);
				List<AgingTableDto> processAgingTableDtos = new ArrayList<AgingTableDto>();
				try {
					headerMap.put(PMCConstant.PROCESS_NAME_LABEL, new BigDecimal(0));
					for (String dates : tableWeekDates) {
						AgingTableHeaderDto tableHeaderDto = new AgingTableHeaderDto();
						tableHeaderDto.setColumnName(dates);
						headerMap.put(dates, new BigDecimal(0));
					}
					headerMap.put(PMCConstant.PROCESS_TOTAL, new BigDecimal(0));
					List<Object[]> resultList = processEventsDao.getProcessAgingCountByDates(startDate, endDate, processName);
					final DateFormat dateFormatter = new SimpleDateFormat(PMCConstant.PMC_DATE_FORMATE);
					ArrayList<AgingGraphDto> agingGraphDtos = new ArrayList<AgingGraphDto>();
					for (Object[] obj : resultList) {

						AgingTableDto newAegingTempDto = new AgingTableDto((String) obj[0]);
						newAegingTempDto.setProcessDisplayName(obj[3] == null ? (String) obj[0] : (String) obj[3]);
						if (processAgingTableDtos.contains(newAegingTempDto)) {
							AgingTableDto existingDto = processAgingTableDtos.get(processAgingTableDtos.indexOf(newAegingTempDto));
							Map<String, BigDecimal> existingMap = existingDto.getOldDataMap();
							existingMap.put(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])), ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
							headerMap.put(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])), headerMap.get(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2]))).add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
							existingDto.setCount(existingDto.getCount().add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
							existingDto.setDataMap(ServicesUtil.generateMapDtoFromMap(existingMap));
							logger.error("processAgingTableDtos : "+processAgingTableDtos);
						} else {
							Map<String, BigDecimal> newMap = new LinkedHashMap<String, BigDecimal>();
							for (String date : tableWeekDates) {
								newMap.put(date, new BigDecimal(0));
							}
							newMap.put(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])), ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
							newAegingTempDto.setOldDataMap(newMap);
							newAegingTempDto.setDataMap(ServicesUtil.generateMapDtoFromMap(newMap));
							headerMap.put(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])), headerMap.get(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2]))).add(ServicesUtil.getBigDecimal(/* (Long) */ obj[1])));
							newAegingTempDto.setCount(ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
							processAgingTableDtos.add(newAegingTempDto);
							Collections.sort(processAgingTableDtos);
						}

						AgingGraphDto graphDto = new AgingGraphDto();
						graphDto.setProcessName((String) obj[0]);
						graphDto.setProcessDisplayName(obj[3] == null ? (String) obj[0] : (String) obj[3]);
						graphDto.setNoOfProcess(ServicesUtil.getBigDecimal(/* (Long) */ obj[1]));
						graphDto.setRange(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])));
						if (graphWeekDates.contains(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])))) {
							graphWeekDates.remove(dateFormatter.format(ServicesUtil.dateResultAsDate(obj[2])));
						}
						agingGraphDtos.add(graphDto);
					}
					for (String date : graphWeekDates) {
						AgingGraphDto graphDto = new AgingGraphDto();
						graphDto.setRange(date);
						agingGraphDtos.add(graphDto);
					}
					Collections.sort(agingGraphDtos, new Comparator<AgingGraphDto>() {
						@Override
						public int compare(AgingGraphDto o1, AgingGraphDto o2) {
							try {
								return dateFormatter.parse(o1.getRange()).compareTo(dateFormatter.parse(o2.getRange()));
							} catch (ParseException e) {
								logger.error("Parse exception - " + e.getMessage());
							}
							return 0;
						}
					});

					response.setAgeingGraph(agingGraphDtos);
					response.setAgeingTable(convertTableFormat(processAgingTableDtos, headerMap));
					message.setMessage("Results Fetched Successfully");
					message.setStatus("Success");
					message.setStatusCode("0");
					response.setResponseMessage(message);

				} catch (NoResultFault e) {
					message.setMessage("No Open Processes found for the last 7 Days. Please search for last 30 Days");
					message.setStatus("Success");
					message.setStatusCode("1");
					response.setResponseMessage(message);
				}
			}

		} else {
			message.setMessage("Error while fetching results.Please contact administrator.Reason: Trend Type is not set");
			message.setStatus("Failed");
			message.setStatusCode("1");
			response.setResponseMessage(message);
		}
		return response;
	}

	private AgingResponseDto convertTableFormat(List<AgingTableDto> processAgingTableDtos, Map<String, BigDecimal> headerMap) {
		AgingResponseDto response = new AgingResponseDto();
		AgingTableDto totalDto = new AgingTableDto(PMCConstant.PROCESS_TOTAL);
		Map<String, BigDecimal> totalMap = new LinkedHashMap<String, BigDecimal>();
		Iterator<String> it = headerMap.keySet().iterator();
		BigDecimal count = new BigDecimal(0);
		while (it.hasNext()) {
			String key = it.next();
			if (!key.equals(PMCConstant.PROCESS_NAME_LABEL) && !key.equals(PMCConstant.PROCESS_TOTAL)) {
				count = count.add(headerMap.get(key));
				totalMap.put(key, headerMap.get(key));
			}
		}
		totalDto.setCount(count);
//		totalDto.setOldDataMap(totalMap);
		totalDto.setDataMap(ServicesUtil.generateMapDtoFromMap(totalMap));
		processAgingTableDtos.add(totalDto);
		response.setStatus("SUCCESS");
//		response.setHeaderMap(headerMap);
		response.setHeaderMap(ServicesUtil.generateMapDtoFromMap(headerMap));
		response.setTupleDtos(processAgingTableDtos);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<UserDetailsDto> getCreatedByList(String inputValue) {
		if(!ServicesUtil.isEmpty(inputValue)){
			inputValue = inputValue.toLowerCase(); 
			String queryString = "SELECT DISTINCT(pe.STARTED_BY_DISP) AS DISPLAY_NAME, pe.STARTED_BY AS ID FROM PROCESS_EVENTS pe WHERE   lower (pe.STARTED_BY_DISP) LIKE '%"+inputValue+"%' OR   lower(pe.STARTED_BY) LIKE '%"+inputValue+"%'" ;
			Query query = this.getSession().createSQLQuery(queryString.trim());
			List<Object[]> objList =  query.list();
			if(!ServicesUtil.isEmpty(objList)){
				List<UserDetailsDto> dtoList = new ArrayList<UserDetailsDto>();
				for(Object[] obj : objList){
					UserDetailsDto dto= new UserDetailsDto();
					dto.setDisplayName(obj[0] == null ? null : (String) obj[0]);
					dto.setUserId(obj[1] == null ? null : (String) obj[1]);
					dtoList.add(dto);
				}
				return dtoList;
			}
		}
		return null;
	}
	
	public String createProcessInstance(ProcessEventsDto dto) {
	//	  logger.error("[PMC][ProcessEventsDao][createProcessInstance]initiated with " + dto);
			try {
				//this.getEntityManager().getTransaction().begin();
				create(dto);
			//	this.getEntityManager().getTransaction().commit();
				return "SUCCESS";
			} catch (Exception e) {
				logger.error("[PMC][ProcessEventsDao][createProcessInstance][error] " + e.getMessage());
			}
			return "FAILURE";
		}

		public String updateProcessInstance(ProcessEventsDto dto) {
		//	logger.error("[PMC][ProcessEventsDao][updateProcessInstance]initiated with " + dto);
			try {
				update(dto);
				return "SUCCESS";
			} catch (Exception e) {
				logger.error("[PMC][ProcessEventsDao][updateProcessInstance][error] " + e.getMessage());
			}
			return "FAILURE";
		}
}
