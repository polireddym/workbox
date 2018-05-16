package oneapp.incture.workbox.pmc.wsdlconsumers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.springframework.stereotype.Service;

import com.incture.pmc.poadapter.services.ResponseDto;
import com.incture.pmc.poadapter.services.SubstitutionManagementFacade;
import com.incture.pmc.poadapter.services.SubstitutionManagementFacadeBindingStub;
import com.incture.pmc.poadapter.services.SubstitutionManagementFacadeServiceLocator;
import com.incture.pmc.poadapter.services.SubstitutionRuleDto;
import com.incture.pmc.poadapter.services.UserDto;

import oneapp.incture.workbox.pmc.dto.responses.SubstitutionResponseDto;
import oneapp.incture.workbox.pmc.dto.responses.UserDtoResponse;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

@Service("SubstitutionManagementConsumer")
public class SubstitutionManagementConsumer {

	private SubstitutionManagementFacade getFacadePort() {
		try {
			return new SubstitutionManagementFacadeServiceLocator().getSubstitutionManagementFacadePort();
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private SubstitutionManagementFacade setStubProperties(SubstitutionManagementFacade port) {
		SubstitutionManagementFacadeBindingStub stub = (SubstitutionManagementFacadeBindingStub) port;
		stub._setProperty(Stub.USERNAME_PROPERTY, PMCConstant.WBuserId);
		stub._setProperty(Stub.PASSWORD_PROPERTY, PMCConstant.WBpassword);
		return port;
	}
	
	/*
	
	public void function(){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		try{
			
		} catch (RemoteException e){
			
		}
	}
	
	*/
	
	public ResponseDto createRule(SubstitutionRuleDto ruleDto){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		ResponseDto responseDto = new ResponseDto();
		try{
			responseDto = port.createRule(ruleDto);
		} catch (RemoteException e) {
			e.printStackTrace();
			responseDto.setMessage("Web Service Call Failure");
			responseDto.setStatus("FAILURE");
			responseDto.setStatusCode("1");
		}
		return responseDto;
	}
	
	public ResponseDto deleteRule(SubstitutionRuleDto ruleDto){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		ResponseDto responseDto = new ResponseDto();
		try{
			return port.deleteRule(ruleDto);
		} catch (RemoteException e){
			e.printStackTrace();
			responseDto.setMessage("Web Service Call Failure");
			responseDto.setStatus("FAILURE");
			responseDto.setStatusCode("1");
		}
		return responseDto;
	}
	
	public ResponseDto updateRule(SubstitutionRuleDto ruleDto){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		ResponseDto responseDto = new ResponseDto();
		try{
			return port.updateRule(ruleDto);
		} catch (RemoteException e){
			e.printStackTrace();
			responseDto.setMessage("Web Service Call Failure");
			responseDto.setStatus("FAILURE");
			responseDto.setStatusCode("1");
		}
		return responseDto;
	}
	
	public SubstitutionResponseDto getActiveRulesBySubstitute(String substitutingUser) {
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getActiveRulesBySubstitute(substitutingUser);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getActiveRulesBySubstitutedUser(String  substitutedUser){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getActiveRulesBySubstitutedUser(substitutedUser);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getInactiveRulesBySubstitute(String  substitutingUser) {
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getInactiveRulesBySubstitute(substitutingUser);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getInactiveRulesBySubstitutedUser(String  substitutedUser) {
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getInactiveRulesBySubstitutedUser(substitutedUser);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getRulesBySubstitute(String  user){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getRulesBySubstitute(user);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getRulesBySubstitutedUser(String  user){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();
		List<SubstitutionRuleDto> substituteList = null;
		try {
			SubstitutionRuleDto[] substitutionRuleDtos = port.getRulesBySubstitutedUser(user);
			if (!ServicesUtil.isEmpty(substitutionRuleDtos)) {
				substituteList = new ArrayList<SubstitutionRuleDto>();
				substituteList = Arrays.asList(substitutionRuleDtos);
				if (!ServicesUtil.isEmpty(substituteList)) {
					respMsg.setMessage("Substitution Rules Fetched");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(substituteList);
					response.setResponse(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setRuleDto(null);
					response.setResponse(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setRuleDto(null);
				response.setResponse(respMsg);
				return response;
			}
		} catch (RemoteException e) {
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setRuleDto(null);
			response.setResponse(respMsg);
		}
		return response;
	}
	
	public UserDtoResponse getSubstituteUsers(String  substitutedUser){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		ResponseMessage respMsg = new ResponseMessage();
		UserDtoResponse response = new UserDtoResponse();
		List<UserDto> usersList = null;
		try{
			UserDto[] usersDto = port.getSubstituteUsers(substitutedUser);
			if(!ServicesUtil.isEmpty(usersDto)){
				usersList = new ArrayList<UserDto>();
				usersList = Arrays.asList(usersDto);
				if (!ServicesUtil.isEmpty(usersList)) {
					respMsg.setMessage("User List Fetched successfully");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setUserDtos(usersList);
					response.setResponseMessage(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setUserDtos(null);
					response.setResponseMessage(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setUserDtos(null);
				response.setResponseMessage(respMsg);
				return response;
			}
		} catch (RemoteException e){
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setUserDtos(null);
			response.setResponseMessage(respMsg);
		}
		return response;
	}
	
	public UserDtoResponse getSubstitutedUsers(String  substitutingUserString){
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		ResponseMessage respMsg = new ResponseMessage();
		UserDtoResponse response = new UserDtoResponse();
		List<UserDto> usersList = null;
		try{
			UserDto[] usersDto = port.getSubstitutedUsers(substitutingUserString);
			if(!ServicesUtil.isEmpty(usersDto)){
				usersList = new ArrayList<UserDto>();
				usersList = Arrays.asList(usersDto);
				if (!ServicesUtil.isEmpty(usersList)) {
					respMsg.setMessage("User List Fetched successfully");
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setUserDtos(usersList);
					response.setResponseMessage(respMsg);
					return response;
				} else {
					respMsg.setMessage(PMCConstant.NO_RESULT);
					respMsg.setStatus("SUCCESS");
					respMsg.setStatusCode("0");
					response.setUserDtos(null);
					response.setResponseMessage(respMsg);
					return response;
				}
			} else {
				respMsg.setMessage(PMCConstant.NO_RESULT);
				respMsg.setStatus("SUCCESS");
				respMsg.setStatusCode("0");
				response.setUserDtos(null);
				response.setResponseMessage(respMsg);
				return response;
			}
		} catch (RemoteException e){
			respMsg.setMessage("Web Service Call Failure");
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("0");
			response.setUserDtos(null);
			response.setResponseMessage(respMsg);
		}
		return response;
	}
	
	public SubstitutionResponseDto getAllRulesByUser(String user) {
		SubstitutionManagementFacade port = this.setStubProperties(this.getFacadePort());
		SubstitutionResponseDto response = new SubstitutionResponseDto();
		ResponseMessage respMsg = new ResponseMessage();

		List<SubstitutionRuleDto> list = new ArrayList<SubstitutionRuleDto>();
		List<SubstitutionRuleDto> substituteList = new ArrayList<SubstitutionRuleDto>();

		try {
			SubstitutionRuleDto[] listDtos = port.getRulesBySubstitutedUser(user);
			SubstitutionRuleDto[] substituteListDtos = port.getRulesBySubstitute(user);
			
			List<SubstitutionRuleDto> tempList =  new ArrayList<SubstitutionRuleDto>();

			if (!ServicesUtil.isEmpty(listDtos)) {
				list = Arrays.asList(listDtos);
				tempList.addAll(list);
			}
			if (!ServicesUtil.isEmpty(substituteListDtos)) {
				substituteList = Arrays.asList(substituteListDtos);
			}
			if(!ServicesUtil.isEmpty(substituteList)){
				if (!ServicesUtil.isEmpty(tempList)) {
					tempList.addAll(substituteList);
//					(Arrays.asList(list)).addAll(Arrays.asList(substituteList));
				} else {
					tempList = substituteList;
				}
			}
			respMsg.setMessage("Substitution Rules Fetched");
			
			if(ServicesUtil.isEmpty(listDtos) && ServicesUtil.isEmpty(substituteListDtos)){
				respMsg.setMessage(PMCConstant.NO_RESULT);
			}
			respMsg.setStatus("SUCCESS");
			respMsg.setStatusCode("0");
			response.setResponse(respMsg);
			response.setRuleDto(tempList);
		} catch (RemoteException e) {
			respMsg.setStatus("FAILURE");
			respMsg.setStatusCode("1");
			response.setResponse(respMsg);
			response.setRuleDto(null);
		}
		return response;
	}
	
	public ResponseDto deleteAndCreate(SubstitutionRuleDto ruleDto){
		ResponseDto dto = deleteRule(ruleDto);
		if(dto.getStatus().equals("SUCCESS")){
			dto = createRule(ruleDto);
			if (dto.getStatus().equals("SUCCESS")){
				dto.setMessage("Rule Successfully updated");
			}
		}
		return dto;
	}
}
