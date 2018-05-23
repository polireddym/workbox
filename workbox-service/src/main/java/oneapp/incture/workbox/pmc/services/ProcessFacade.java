package oneapp.incture.workbox.pmc.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oneapp.incture.workbox.pmc.dto.ProcessAgeingResponse;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsDto;
import oneapp.incture.workbox.pmc.dto.ProcessDetailsResponse;
import oneapp.incture.workbox.pmc.dto.UserDetailsDto;
import oneapp.incture.workbox.pmc.dto.UserProcessDetailRequestDto;
import oneapp.incture.workbox.poadapter.dao.ProcessEventsDao;
import oneapp.incture.workbox.poadapter.dto.ProcessEventsDto;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;


@Service("ProcessFacade")
public class ProcessFacade implements ProcessFacadeLocal {


	@Autowired
	private ProcessEventsDao processEventsDao;

	@Autowired
	private ConfigurationFacadeLocal config;

	@Override
	public ProcessDetailsResponse getProcessesByDuration(ProcessDetailsDto processDetailsDto) {
		return processEventsDao.getProcessByDuration(processDetailsDto);
	}

	@Override
	public ProcessDetailsResponse getProcessesByTaskOwner(UserProcessDetailRequestDto request) {
		return processEventsDao.getProcessesByTaskOwner(request);
	}

	@Override
	public ProcessEventsDto getProcessDetailsByInstance(String processId) {
		ProcessEventsDto processEventsDto = processEventsDao.getProcessDetail(processId);
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(PMCConstant.DETAIL_DATE_FORMATE);
		if (!ServicesUtil.isEmpty(processEventsDto) && !ServicesUtil.isEmpty(processEventsDto.getCompletedAt()))
			processEventsDto.setCompletedAtInString(simpleDateFormat1.format(processEventsDto.getCompletedAt()));
		if (!ServicesUtil.isEmpty(processEventsDto) && !ServicesUtil.isEmpty(processEventsDto.getStartedAt()))
			processEventsDto.setStartedAtInString(simpleDateFormat1.format(processEventsDto.getStartedAt()));
		return processEventsDto;
	}

	@Override
	public ProcessAgeingResponse getProcessAgeing(String ageingType, String processName) {
		return processEventsDao.getProcessAgeing(ageingType, processName, config.getAgeingBuckets(PMCConstant.PROCESS_AGING_REPORT));

	}
	@Override
	public List<UserDetailsDto> getCreatedByList(String inputValue) {
		return processEventsDao.getCreatedByList(inputValue);

	}

}
