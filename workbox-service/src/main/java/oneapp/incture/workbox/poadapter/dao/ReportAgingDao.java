package oneapp.incture.workbox.poadapter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.ReportAgingDto;
import oneapp.incture.workbox.pmc.entity.ReportAgingDo;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("ReportAgingDao")
@Transactional
public class ReportAgingDao extends BaseDao<ReportAgingDo, ReportAgingDto> {

	private static final Logger logger = LoggerFactory.getLogger(ReportAgingDao.class);
	@Override
	protected ReportAgingDo importDto(ReportAgingDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		ReportAgingDo entity = new ReportAgingDo();
		if (!ServicesUtil.isEmpty(fromDto.getId()))
			entity.setId(fromDto.getId());
		if (!ServicesUtil.isEmpty(fromDto.getReportName()))
			entity.setReportName(fromDto.getReportName());
		if (!ServicesUtil.isEmpty(fromDto.getLowerSegment()))
			entity.setLowerSegment(fromDto.getLowerSegment());
		if (!ServicesUtil.isEmpty(fromDto.getHigherSegment()))
			entity.setHigherSegment(fromDto.getHigherSegment());
		if (!ServicesUtil.isEmpty(fromDto.getDisplayName()))
			entity.setDisplayName(fromDto.getDisplayName());
		if (!ServicesUtil.isEmpty(fromDto.getAgingRange()))
			entity.setAgingRange(fromDto.getAgingRange());
		return entity;
	}

	@Override
	protected ReportAgingDto exportDto(ReportAgingDo entity) {
		ReportAgingDto reportAgingDto = new ReportAgingDto();
		if (!ServicesUtil.isEmpty(entity.getId()))
			reportAgingDto.setId(entity.getId());
		if (!ServicesUtil.isEmpty(entity.getReportName()))
			reportAgingDto.setReportName(entity.getReportName());
		if (!ServicesUtil.isEmpty(entity.getLowerSegment()))
			reportAgingDto.setLowerSegment(entity.getLowerSegment());
		if (!ServicesUtil.isEmpty(entity.getHigherSegment()))
			reportAgingDto.setHigherSegment(entity.getHigherSegment());
		if (!ServicesUtil.isEmpty(entity.getDisplayName()))
			reportAgingDto.setDisplayName(entity.getDisplayName());
		if (!ServicesUtil.isEmpty(entity.getAgingRange()))
			reportAgingDto.setAgingRange(entity.getAgingRange());
		return reportAgingDto;
	}

	public List<ReportAgingDto> getConfigByReportName(String reportName) {
		List<ReportAgingDto>  reportAgingDto = null;
		try {
			reportAgingDto = getSpecificConfigResults("ReportAgingDo", "reportName", reportName);
			for(ReportAgingDto dto : reportAgingDto){
				logger.error("[pmc][ReportAgingDo][Details]  :  Report Name"+reportName +",   [dto]"+dto.toString());
			}
		} catch (NoResultFault e) {
			e.printStackTrace();
		}
		return reportAgingDto;
		
	}
	
	public List<ReportAgingDto> getAllReportConfiguration() {
		List<ReportAgingDto>  reportAgingDto = null;
		try {
			reportAgingDto = getAllReportAegingResults("ReportAgingDo");
		} catch (NoResultFault e) {
			e.printStackTrace();
		}
		return reportAgingDto;
		
	}
	
}
