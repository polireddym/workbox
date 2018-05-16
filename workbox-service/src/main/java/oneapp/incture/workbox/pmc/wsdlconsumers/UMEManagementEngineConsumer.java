package oneapp.incture.workbox.pmc.wsdlconsumers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.springframework.stereotype.Service;

import com.incture.pmc.poadapter.services.GroupInfoDto;
import com.incture.pmc.poadapter.services.RoleInfoDto;
import com.incture.pmc.poadapter.services.UMEUserManagementFacade;
import com.incture.pmc.poadapter.services.UMEUserManagementFacadeBindingStub;
import com.incture.pmc.poadapter.services.UMEUserManagementFacadeServiceLocator;
import com.incture.pmc.poadapter.services.UserDetailsDto;
import com.incture.pmc.poadapter.services.UserDto;
import com.incture.pmc.poadapter.services.UserGroupDto;

import oneapp.incture.workbox.pmc.dto.RoleOfPmcDto;
import oneapp.incture.workbox.pmc.dto.UserWorkloadDetailsDto;
import oneapp.incture.workbox.pmc.dto.responses.GroupInfoDtoResponse;
import oneapp.incture.workbox.pmc.dto.responses.RoleInfoResponse;
import oneapp.incture.workbox.pmc.dto.responses.UserDetailsResponse;
import oneapp.incture.workbox.pmc.dto.responses.UserDtoResponse;
import oneapp.incture.workbox.pmc.dto.responses.UserGroupDtoResponse;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

@Service("UMEManagementEngineConsumer")
public class UMEManagementEngineConsumer {

	private UMEUserManagementFacade getFacadePort() {
		try {
			return new UMEUserManagementFacadeServiceLocator().getUMEUserManagementFacadePort();
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	private UMEUserManagementFacade setStubProperties(UMEUserManagementFacade port) {
		UMEUserManagementFacadeBindingStub stub = (UMEUserManagementFacadeBindingStub) port;
		stub._setProperty(Stub.USERNAME_PROPERTY, PMCConstant.WBuserId);
		stub._setProperty(Stub.PASSWORD_PROPERTY, PMCConstant.WBpassword);
		return port;
	}

	public UserDetailsDto getUserDetailsByUserId(String userId) {
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		UserDetailsDto dto = new UserDetailsDto();
		try {
			dto = port.getUserDetailsByUserId(userId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public UserDetailsDto getLoggedInUser() {
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		UserDetailsDto dto = new UserDetailsDto();
		try {
			dto = port.getLoggedInUser();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public String getUserEmailByuserId(String userUniqueId) {
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		String userEmail = "";
		try {
			userEmail = port.getUserEmailByuserId(userUniqueId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return userEmail;
	}

	public UserGroupDtoResponse getAllUserGroup() {
		UserGroupDtoResponse userGroupDtoResponse = new UserGroupDtoResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<UserGroupDto> listDtos = null;
		try {
			UserGroupDto[] dtos = port.getAllUserGroup();
			if(!ServicesUtil.isEmpty(dtos)){
				listDtos = new ArrayList<UserGroupDto>();
				listDtos = Arrays.asList(dtos);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (Exception e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		userGroupDtoResponse.setResponseMessage(responseMessage);
		userGroupDtoResponse.setUserGroupDtos(listDtos);
		return userGroupDtoResponse;
	}

	public List<String> getUsersAssignedInGroup(String userGroup) {
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<String> usersGroup = null;
		try {
			String[] users = port.getUsersAssignedInGroup(userGroup);
			if(!ServicesUtil.isEmpty(users)){
				usersGroup = new ArrayList<String>();
				usersGroup = Arrays.asList(users);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return usersGroup;
	}

	public GroupInfoDtoResponse getUserGroupByuserId(String userUniqueId) {
		GroupInfoDtoResponse groupInfoDtoResponse = new GroupInfoDtoResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<GroupInfoDto> groupInfo = null;
		try {
			GroupInfoDto[] users = port.getUserGroupByuserId(userUniqueId);
			if(!ServicesUtil.isEmpty(users)){
				groupInfo = new ArrayList<GroupInfoDto>();
				groupInfo = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		groupInfoDtoResponse.setResponseMessage(responseMessage);
		groupInfoDtoResponse.setGroupInfoDtos(groupInfo);
		return groupInfoDtoResponse;
	}

	public RoleInfoResponse getUserRoleByuserId(String userUniqueId) {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<RoleInfoDto> roleInfo = null;
		try {
			RoleInfoDto[] users = port.getUserRoleByuserId(userUniqueId);
			if(!ServicesUtil.isEmpty(users)){
				roleInfo = new ArrayList<RoleInfoDto>();
				roleInfo = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		roleInfoResponse.setResponseMessage(responseMessage);
		roleInfoResponse.setRoleInfoDtos(roleInfo);
		return roleInfoResponse;
	}

	public UserDtoResponse getAllUsers(String userSearch) {
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseMessage = new ResponseMessage();
		UserDtoResponse userDtoResponse = new UserDtoResponse();
		List<UserDto> usersList = null;
		try {
			UserDto[] users = port.getAllUsers(userSearch);
			if(!ServicesUtil.isEmpty(users)){
				usersList = new ArrayList<UserDto>();
				usersList = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		userDtoResponse.setResponseMessage(responseMessage);
		userDtoResponse.setUserDtos(usersList);
		return userDtoResponse;
	}

	public RoleInfoResponse getAllUserRole() {
		RoleInfoResponse roleInfoResponse = new RoleInfoResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<RoleInfoDto> userRoles = null;
		try {
			RoleInfoDto[] users = port.getAllUserRole();
			if(!ServicesUtil.isEmpty(users)){
				userRoles = new ArrayList<RoleInfoDto>();
				userRoles = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		roleInfoResponse.setResponseMessage(responseMessage);
		roleInfoResponse.setRoleInfoDtos(userRoles);
		return roleInfoResponse;
	}

	public UserDtoResponse getUserDetailsAssignedInGroup(String getUserDetailsAssignedInGroup) {
		UserDtoResponse userDtoResponse = new UserDtoResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<UserDto> usersList = null;
		try {
			UserDto[] users = port.getUserDetailsAssignedInGroup(getUserDetailsAssignedInGroup);
			if(!ServicesUtil.isEmpty(users)){
				usersList = new ArrayList<UserDto>();
				usersList = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		userDtoResponse.setResponseMessage(responseMessage);
		userDtoResponse.setUserDtos(usersList);
		return userDtoResponse;
	}

	public UserDetailsResponse getUsersByRole(String role) {
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		ResponseMessage responseMessage = new ResponseMessage();
		UMEUserManagementFacade port = setStubProperties(getFacadePort());
		List<UserDetailsDto> usersList = null;
		try {
			UserDetailsDto[] users = port.getUsersByRole(role);
			if(!ServicesUtil.isEmpty(users)){
				usersList = new ArrayList<UserDetailsDto>();
				usersList = Arrays.asList(users);
				responseMessage.setMessage("User Groups Fetched successfully");
			}
			else{
				responseMessage.setMessage(PMCConstant.NO_RESULT);
			}
			responseMessage.setStatus("SUCCESS");
			responseMessage.setStatusCode("1");
		} catch (RemoteException e) {
			responseMessage.setMessage("Failed due to" +e.getMessage());
			responseMessage.setStatus("FAILURE");
			responseMessage.setStatusCode("0");
		}
		userDetailsResponse.setResponseMessage(responseMessage);
		userDetailsResponse.setUserDetailsDtos(usersList);
		return userDetailsResponse;
	}

	public RoleOfPmcDto getPmcUserRolesByLoggedInUser() {

		UserDetailsDto getLoggedInUser = new UserDetailsDto();
		getLoggedInUser = this.getLoggedInUser();
		String userId = getLoggedInUser.getUserId();
		RoleOfPmcDto list = new RoleOfPmcDto();
		Map<String, String> roleMap = new HashMap<String, String>();
		List<RoleInfoDto> allRole = new ArrayList<RoleInfoDto>();
		allRole = this.getUserRoleByuserId(userId).getRoleInfoDtos();
		roleMap.put("CW_RL_WB_READ", "false");
		roleMap.put("CW_RL_WB_ADMIN", "false");
		roleMap.put("CW_RL_WB_WM", "false");
		roleMap.put("CW_RL_WB_PT", "false");
		roleMap.put("CW_RL_WB_SLA", "false");
		roleMap.put("ZXiMdt.EditMonitor", "false");

		for (RoleInfoDto dto : allRole) {
			if (roleMap.containsKey(dto.getRoleUniqName()))
				roleMap.put(dto.getRoleUniqName(), "true");
		}
		list.setRoleMap(roleMap);
		return list;
	}

	public UserWorkloadDetailsDto getUserInformation(String userId) {

		UserWorkloadDetailsDto userWorkloadDetailsDto = null;
		if (!ServicesUtil.isEmpty(userId)) {
			userWorkloadDetailsDto = new UserWorkloadDetailsDto();
			UserDetailsDto userDetailsDto = this.getUserDetailsByUserId(userId);
			if (!ServicesUtil.isEmpty(userDetailsDto)) {

				StringBuffer name = new StringBuffer();
				name = userDetailsDto.getFirstName() == null ? name.append("")
						: name.append(userDetailsDto.getFirstName()).append(" ");
				name = userDetailsDto.getLastName() == null ? name.append("")
						: name.append(userDetailsDto.getLastName());
				userWorkloadDetailsDto.setUserName(name.toString().trim());
				userWorkloadDetailsDto.setUserId(userId);
				userWorkloadDetailsDto.setUserMailId(userDetailsDto.getEmailId());
				userWorkloadDetailsDto.setImage(userDetailsDto.getPhoto());
			}
			List<GroupInfoDto> groupInfoDtos = this.getUserGroupByuserId(userId).getGroupInfoDtos();
			if (!ServicesUtil.isEmpty(groupInfoDtos)) {
				StringBuffer groupsName = new StringBuffer();
				for (int i = 0; i < groupInfoDtos.size(); i++) {
					if (i == groupInfoDtos.size() - 1)
						groupsName.append(" ").append(groupInfoDtos.get(i).getGroupUniqName().trim());
					else if (i == 0)
						groupsName.append(groupInfoDtos.get(i).getGroupUniqName().trim()).append(",");
					else
						groupsName.append(" ").append(groupInfoDtos.get(i).getGroupUniqName().trim()).append(",");
				}
				userWorkloadDetailsDto.setApplicationGroupsName(groupsName.toString().trim());
			}
		}
		return userWorkloadDetailsDto;
	}

}
