package oneapp.incture.workbox.pmc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oneapp.incture.workbox.pmc.dto.TaskCountDto;
import oneapp.incture.workbox.pmc.dto.UserProcessDetailRequestDto;
import oneapp.incture.workbox.pmc.dto.UserSearchRequestDto;
import oneapp.incture.workbox.pmc.dto.responses.UserTaskStatusResponseDto;
import oneapp.incture.workbox.pmc.dto.responses.UserWorkloadResponseDto;
import oneapp.incture.workbox.pmc.services.UserWorkloadFacadeLocal;

@RestController
@CrossOrigin
@ComponentScan("oneapp.incture.workbox")
@RequestMapping(value = "/userload", produces = "application/json", consumes = "application/json")
public class UserWorkloadRest {

	@Autowired
	private UserWorkloadFacadeLocal services;

	@RequestMapping(value = "/heatmap", method = RequestMethod.POST)
	public UserWorkloadResponseDto getUserWorkLoadHeatMap(@RequestBody UserSearchRequestDto searchRequestDto) {
		return services.getUserWorkLoadHeatMap(searchRequestDto);
	}

	@RequestMapping(value = "/status/graph", method = RequestMethod.POST)
	public UserTaskStatusResponseDto getUserWorkLoadTaskStausGraph(@RequestBody UserProcessDetailRequestDto request){
		return services.getUserWorkLoadTaskStausGraph(request);
	}

	@RequestMapping(value = "/trend/graph", method = RequestMethod.POST)
	public TaskCountDto getUserWorkLoadTrendGraph(@RequestBody UserProcessDetailRequestDto request){
		return services.getUserWorkLoadTrendGraph(request);
	}	
	

}
