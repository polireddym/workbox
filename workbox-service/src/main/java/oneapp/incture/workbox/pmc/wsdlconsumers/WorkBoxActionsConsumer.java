package oneapp.incture.workbox.pmc.wsdlconsumers;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;

import com.incture.pmc.poadapter.services.NoteDto;
import com.incture.pmc.poadapter.services.WorkBoxActionFacade;
import com.incture.pmc.poadapter.services.WorkBoxActionFacadeBindingStub;
import com.incture.pmc.poadapter.services.WorkBoxActionFacadeServiceLocator;

import oneapp.incture.workbox.inbox.dto.WorkBoxActionDto;
import oneapp.incture.workbox.inbox.dto.WorkBoxActionListDto;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

public class WorkBoxActionsConsumer {
	
	private WorkBoxActionFacade getFacadePort() {
		try {
			return new WorkBoxActionFacadeServiceLocator().getWorkBoxActionFacadePort();
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	private WorkBoxActionFacade setStubProperties(WorkBoxActionFacade port) {
		WorkBoxActionFacadeBindingStub stub = (WorkBoxActionFacadeBindingStub) port;
		stub._setProperty(Stub.USERNAME_PROPERTY, PMCConstant.WBuserId);
		stub._setProperty(Stub.PASSWORD_PROPERTY, PMCConstant.WBpassword);
		return port;
	}
	
	public ResponseMessage claimTask(WorkBoxActionDto dto) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseDto = new ResponseMessage();
		responseDto.setStatus("FAILURE");
		responseDto.setStatusCode("1");
		if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
			try {
				if (port.claimTask(dto.getTaskInstanceId())) {
					responseDto.setMessage("Task claimed successfully");
					responseDto.setStatus("SUCCESS");
					responseDto.setStatusCode("0");
					return responseDto;
				}
			} catch (RemoteException e) {
				responseDto.setMessage("Task claim Failed because" + e.getMessage());
			}
		} else {
			responseDto.setMessage("Instance Id required to claim");
		}
		return responseDto;
	}
	
	public ResponseMessage release(WorkBoxActionDto dto) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseDto = new ResponseMessage();
		responseDto.setStatus("FAILURE");
		responseDto.setStatusCode("1");
		if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
			try {
				System.err
				.println("[PMC][WorkBoxAction][services][release][taskInstanceId] " + dto.getTaskInstanceId());
				if (port.release(dto.getTaskInstanceId())) {
					responseDto.setMessage("Task released successfully");
					responseDto.setStatus("SUCCESS");
					responseDto.setStatusCode("0");
					return responseDto;
				}
			} catch (RemoteException e) {
				responseDto.setMessage("Task release Failed because" + e.getMessage());
			}
		} else {
			responseDto.setMessage("Instance Id required to release");
		}
		return responseDto;
	}
	
	public ResponseMessage delegate(WorkBoxActionDto dto) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseDto = new ResponseMessage();
		responseDto.setStatus("FAILURE");
		responseDto.setStatusCode("1");
		if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
			try {
				System.err
				.println("[PMC][WorkBoxAction][services][delegate][taskInstanceId] " + dto.getTaskInstanceId());
				if (port.delegate(dto.getTaskInstanceId(), dto.getUserId())) {
					responseDto.setMessage("Task delegated successfully");
					responseDto.setStatus("SUCCESS");
					responseDto.setStatusCode("0");
					return responseDto;
				}
			} catch (Exception e) {
				responseDto.setMessage("Task delegate Failed because" + e.getMessage());
			}
		} else {
			responseDto.setMessage("Instance Id required to delegate");
		}
		return responseDto;
	}
	
	public ResponseMessage addNote(WorkBoxActionDto dto) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseDto = new ResponseMessage();
		responseDto.setStatus("FAILURE");
		responseDto.setStatusCode("1");
		if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
			try {
				System.err
				.println("[PMC][WorkBoxAction][services][addNote][taskInstanceId] " + dto.getTaskInstanceId());

				String noteId = port.addNote(dto.getTaskInstanceId(),
						dto.getComment());
				if (!ServicesUtil.isEmpty(noteId)) {
					responseDto.setMessage("Note added to the task successfully with id" + noteId);
					responseDto.setStatus("SUCCESS");
					responseDto.setStatusCode("0");
					return responseDto;
				} else {
					responseDto.setMessage("Note added to the task Failed");
				}
			} catch (Exception e) {
				responseDto.setMessage("Note added to the task Failed because" + e.getMessage());
			}
		} else {
			responseDto.setMessage("Instance Id required to add Note to the task");
		}
		return responseDto;
	}
	
	public ResponseMessage complete(WorkBoxActionListDto dtoList) {
		ResponseMessage responseDto = new ResponseMessage();
		List<WorkBoxActionDto> taskInstanceList = dtoList.getTaskInstanceList();
		if(!ServicesUtil.isEmpty(dtoList)){
			for(WorkBoxActionDto dto : taskInstanceList){

				if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
					try {
						System.err .println("[PMC][WorkBoxAction][services][complete][taskInstanceId] " + dto.getTaskInstanceId()+"[status]"+dto.getStatus()+"[action]"+dto.getAction());
						boolean returnedValue = false;
						if(!ServicesUtil.isEmpty(dto.getStatus()) && dto.getStatus().equals("READY")){
							if(this.claimTask(dto).getStatus().equals("SUCCESS")){
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								returnedValue = this.completeAction(dto);
							}
							else{
								responseDto.setMessage("Task complete Failed as claim is failed");
								returnedValue = false;
							}
						}
						else {
							returnedValue = this.completeAction(dto);
						}
						if (returnedValue) {
							responseDto.setMessage("Task completed successfully");
						}

						else{
							responseDto.setMessage("Task complete Failed");
							break;
						}
					} catch (Exception e) {
						responseDto.setMessage("Task complete Failed because" + e.getMessage());
						break;
					}
				} else {
					responseDto.setMessage("Instance Id required to complete");
					break;
				}
			}
		}
		else{
			responseDto.setMessage("Input Data is empty");
		}
		if(responseDto.getMessage().equals("Task completed successfully")){
			responseDto.setStatus("SUCCESS");
			responseDto.setStatusCode("0");	
		}else{
			responseDto.setStatus("FAILURE");
			responseDto.setStatusCode("1");
		}
		return responseDto;
	}
	
	private boolean completeAction(WorkBoxActionDto dto){
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		boolean b = false;
		try {
			b = port.complete(dto.getTaskInstanceId(),dto.getAction());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public List<NoteDto> getNotes(String taskInstanceId) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		List<NoteDto> noteList = null;
		try {
			noteList = new ArrayList<NoteDto>();
			NoteDto[] dtos = port.getNotes(taskInstanceId);
			noteList = Arrays.asList(dtos);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		 return noteList;
	}
	
	public ResponseMessage claimAndDelegate(WorkBoxActionDto dto) {
		ResponseMessage claimResponse = this.claimTask(dto);
		if (claimResponse.getStatusCode().equals("0")) {
			ResponseMessage delegateResponse = this.delegate(dto);
			return delegateResponse;
		}
		else{
			return claimResponse;
		}
	}
	
	public ResponseMessage nominate(WorkBoxActionDto dto) {
		WorkBoxActionFacade port = setStubProperties(getFacadePort());
		ResponseMessage responseDto = new ResponseMessage();
		responseDto.setStatus("FAILURE");
		responseDto.setStatusCode("1");
		if (!ServicesUtil.isEmpty(dto.getTaskInstanceId())) {
			try {
				System.err
				.println("[PMC][WorkBoxAction][services][nominate][taskInstanceId] " + dto.getTaskInstanceId());
				String status = port.nominate(dto.getTaskInstanceId(), dto.getUserId());
				if (status.equals("SUCCESS")) {
					responseDto.setMessage("Task nominated successfully");
					responseDto.setStatus("SUCCESS");
					responseDto.setStatusCode("0");
					return responseDto;
				}
				else{
					responseDto.setMessage(status);
				}
			} catch (Exception e) {
				responseDto.setMessage("Task nominate Failed because" + e.getMessage());
			}
		} else {
			responseDto.setMessage("Instance Id required to nominate");
		}
		return responseDto;
	}
}
