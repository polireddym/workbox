package oneapp.incture.workbox.pmc.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oneapp.incture.workbox.inbox.dto.WorkBoxActionDto;
import oneapp.incture.workbox.pmc.dto.ManageTasksRequestDto;
import oneapp.incture.workbox.pmc.dto.TaskOwnersListDto;
import oneapp.incture.workbox.pmc.dto.responses.ManageTasksResponseDto;
import oneapp.incture.workbox.pmc.dto.responses.TaskAgeingResponse;
import oneapp.incture.workbox.pmc.dto.responses.TaskEventsResponse;
import oneapp.incture.workbox.pmc.rest.dto.TaskRestDto;
import oneapp.incture.workbox.pmc.services.TaskFacadeLocal;

@RestController
@CrossOrigin
@ComponentScan("oneapp.incture.workbox")
@RequestMapping(value = "/task", produces = "application/json")
public class TaskRest {

	@Autowired
	private TaskFacadeLocal task;

	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public TaskEventsResponse getTaskDetailsByProcessInstance(@RequestBody TaskRestDto dto) {
		String s=null;
		try {
			s = URLDecoder.decode(dto.getProcessId(), "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		return task.getTaskDetailsByProcessInstance(s);
	}

	@RequestMapping(value = "/ageing", method = RequestMethod.GET)
	public TaskAgeingResponse getProcessAging(@RequestParam(name = "processName", required = false) String processName,
			@RequestParam(name = "userGroup", required = false) String userGroup,
			@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "requestId", required = false) String requestId,
			@RequestParam(name = "labelValue", required = false) String labelValue) {
		return task.getTaskAgeing(processName, userGroup, status, requestId, labelValue);
	}

	@RequestMapping(value = "/manager", method = RequestMethod.POST)
	public ManageTasksResponseDto getTasksByUserAndDuration(@RequestBody ManageTasksRequestDto request) {
		return task.getTasksByUserAndDuration(request);
	}

	@RequestMapping(value = "/getOwners", method = RequestMethod.POST)
	public TaskOwnersListDto getTaskOwners(@RequestBody WorkBoxActionDto dto) {
		return task.getTaskOwners(dto);
	}
}
