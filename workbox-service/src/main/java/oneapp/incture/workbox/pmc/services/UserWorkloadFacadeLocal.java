package oneapp.incture.workbox.pmc.services;

import oneapp.incture.workbox.pmc.dto.UserSearchRequestDto;
import oneapp.incture.workbox.pmc.dto.responses.UserWorkloadResponseDto;

public interface UserWorkloadFacadeLocal {

	UserWorkloadResponseDto getUserWorkLoadHeatMap(UserSearchRequestDto request);
/*
	TaskCountDto getUserWorkLoadTrendGraph(UserProcessDetailRequestDto request);

	UserTaskStatusResponseDto getUserWorkLoadTaskStausGraph(UserProcessDetailRequestDto request);*/
}
