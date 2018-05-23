package oneapp.incture.workbox.pmc.services;

import oneapp.incture.workbox.inbox.dto.WorkBoxActionDto;
import oneapp.incture.workbox.pmc.dto.ManageTasksRequestDto;
import oneapp.incture.workbox.pmc.dto.TaskOwnersListDto;
import oneapp.incture.workbox.pmc.dto.responses.ManageTasksResponseDto;
import oneapp.incture.workbox.pmc.dto.responses.TaskAgeingResponse;
import oneapp.incture.workbox.pmc.dto.responses.TaskEventsResponse;

public interface TaskFacadeLocal {

	TaskEventsResponse getTaskDetailsByProcessInstance(String processId);
	
	ManageTasksResponseDto getTasksByUserAndDuration(ManageTasksRequestDto request);

	TaskOwnersListDto getTaskOwners(WorkBoxActionDto dto);

	TaskAgeingResponse getTaskAgeing(String processName, String userGroup, String status, String requestId, String labelValue);

}
