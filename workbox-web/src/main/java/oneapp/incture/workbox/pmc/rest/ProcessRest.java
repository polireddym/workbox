package oneapp.incture.workbox.pmc.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oneapp.incture.workbox.pmc.dto.ProcessAgeingResponse;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsDto;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsResponse;
import oneapp.incture.workbox.pmc.dto.UserDetailsDto;
import oneapp.incture.workbox.pmc.dto.UserProcessDetailRequestDto;
import oneapp.incture.workbox.pmc.rest.dto.TaskRestDto;
import oneapp.incture.workbox.pmc.services.ProcessFacadeLocal;
import oneapp.incture.workbox.poadapter.dto.ProcessEventsDto;


@RestController
@CrossOrigin
@ComponentScan("oneapp.incture.workbox")
@RequestMapping(value = "/process", produces = "application/json")
public class ProcessRest {

	@Autowired
	private ProcessFacadeLocal process;

	@RequestMapping(value = "/by/duration", method = RequestMethod.POST)
	public ProcessDetailsResponse getProcessesByDuration(@RequestBody ProcessDetailsDto processDetailsDto){
		return process.getProcessesByDuration(processDetailsDto);
	} 

	@RequestMapping(value = "/by/taskowner", method = RequestMethod.POST)
	public ProcessDetailsResponse getProcessesByTaskOwner(@RequestBody UserProcessDetailRequestDto request){
		return process.getProcessesByTaskOwner(request);
	}


	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public ProcessEventsDto getProcessDetailsByInstance(@RequestBody TaskRestDto dto){
		String s=null;
		try {
			s = URLDecoder.decode(dto.getProcessId(), "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		}
		return process.getProcessDetailsByInstance(s);
	}

	@RequestMapping(value = "/createdBy/{inputString}", method = RequestMethod.GET)
	public List<UserDetailsDto> getCreatedByList(@PathVariable("inputString") String inputString){
		return process.getCreatedByList(inputString);
	}

	@RequestMapping(value = "/ageing", method = RequestMethod.GET)
	public ProcessAgeingResponse getProcessAgingNew(@RequestParam("type") String ageingType, @RequestParam("process") String processName){
		return process.getProcessAgeing(ageingType,processName);
	}
}
