package oneapp.incture.workbox.pmc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oneapp.incture.workbox.pmc.dto.UserSearchRequestDto;
import oneapp.incture.workbox.pmc.dto.UserWorkloadDto;
import oneapp.incture.workbox.pmc.dto.responses.UserWorkloadResponseDto;
import oneapp.incture.workbox.pmc.wsdlconsumers.UMEManagementEngineConsumer;
import oneapp.incture.workbox.poadapter.dao.TaskOwnersDao;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

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

	@Override
	public UserWorkloadResponseDto getUserWorkLoadHeatMap(UserSearchRequestDto request) {

		UserWorkloadResponseDto responseDto = new UserWorkloadResponseDto();

		umeConsumer = new UMEManagementEngineConsumer();

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
								}//end for
							}// end if

							userLoadDto.setUserGroup(userGroups.toString().trim());
						}// end if

						userLoadMap.put(userLoadDto.getUserId(), userLoadDto);
					}
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

}