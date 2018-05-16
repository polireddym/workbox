package oneapp.incture.workbox.poadapter.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.WorkloadRangeDto;
import oneapp.incture.workbox.pmc.entity.WorkloadRangeDo;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("WorkloadRangeDao")
@Transactional
public class WorkloadRangeDao extends BaseDao<WorkloadRangeDo, WorkloadRangeDto> {
	
	@Override
	protected WorkloadRangeDo importDto(WorkloadRangeDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		WorkloadRangeDo workloadRangeDo = new WorkloadRangeDo();
		if (!ServicesUtil.isEmpty(fromDto.getLoadType())) {
			workloadRangeDo.setLoadType(fromDto.getLoadType());
			if (!ServicesUtil.isEmpty(fromDto.getHighLimit()))
				workloadRangeDo.setHighLimit(fromDto.getHighLimit());
			if (!ServicesUtil.isEmpty(fromDto.getLowLimit()))
				workloadRangeDo.setLowLimit(fromDto.getLowLimit());
		}

		return workloadRangeDo;
	}

	@Override
	protected WorkloadRangeDto exportDto(WorkloadRangeDo entity) {
		WorkloadRangeDto workloadRangeDto = new WorkloadRangeDto();
		workloadRangeDto.setLoadType(entity.getLoadType());
		if (!ServicesUtil.isEmpty(entity.getHighLimit()))
			workloadRangeDto.setHighLimit(entity.getHighLimit());
		if (!ServicesUtil.isEmpty(entity.getLowLimit()))
			workloadRangeDto.setLowLimit(entity.getLowLimit());
		return workloadRangeDto;
	}

}
