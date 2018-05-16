package oneapp.incture.workbox.poadapter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.ProcessConfigDto;
import oneapp.incture.workbox.pmc.entity.ProcessConfigDo;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("ProcessConfigDao")
@Transactional
public class ProcessConfigDao extends BaseDao<ProcessConfigDo, ProcessConfigDto> {

	private static final Logger logger = LoggerFactory.getLogger(ProcessConfigDao.class);
	
	@Override
	protected ProcessConfigDo importDto(ProcessConfigDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		ProcessConfigDo entity = new ProcessConfigDo();
		if (!ServicesUtil.isEmpty(fromDto.getProcessName()))
			entity.setProcessName(fromDto.getProcessName());
		if (!ServicesUtil.isEmpty(fromDto.getLabelName()))
			entity.setLabelName(fromDto.getLabelName());
		if (!ServicesUtil.isEmpty(fromDto.getSla()))
			entity.setSla(fromDto.getSla());
		if (!ServicesUtil.isEmpty(fromDto.getUrgentSla()))
			entity.setUrgentSla(fromDto.getUrgentSla());
		if (!ServicesUtil.isEmpty(fromDto.getUserGroup()))
			entity.setUserGroup(fromDto.getUserGroup());
		if (!ServicesUtil.isEmpty(fromDto.getUserRole()))
			entity.setUserRole(fromDto.getUserRole());
		/*if (!ServicesUtil.isEmpty(fromDto.getProcessConfigId()))
			entity.setProcessConfigId(fromDto.getProcessConfigId());
		 */if (!ServicesUtil.isEmpty(fromDto.getLaneCount()))
			 entity.setLaneCount(fromDto.getLaneCount());
		 if (!ServicesUtil.isEmpty(fromDto.getProcessDisplayName()))
			 entity.setProcessDisplayName(fromDto.getProcessDisplayName());
		 if (!ServicesUtil.isEmpty(fromDto.getSubject()))
			 entity.setSubject(fromDto.getSubject());
		 if (!ServicesUtil.isEmpty(fromDto.getDescription()))
			 entity.setDescription(fromDto.getDescription());

		 return entity;
	}

	@Override
	protected ProcessConfigDto exportDto(ProcessConfigDo entity) {
		ProcessConfigDto processEventsDto = new ProcessConfigDto();
		if (!ServicesUtil.isEmpty(entity.getProcessName())){
			processEventsDto.setProcessName(entity.getProcessName());
			processEventsDto.setKey("'"+entity.getProcessName()+"'");
		}if (!ServicesUtil.isEmpty(entity.getLabelName()))
			processEventsDto.setLabelName(entity.getLabelName());
		if (!ServicesUtil.isEmpty(entity.getSla()))
			processEventsDto.setSla(entity.getSla());
		if (!ServicesUtil.isEmpty(entity.getUrgentSla()))
			processEventsDto.setUrgentSla(entity.getUrgentSla());
		if (!ServicesUtil.isEmpty(entity.getUserGroup()))
			processEventsDto.setUserGroup(entity.getUserGroup());
		if (!ServicesUtil.isEmpty(entity.getUserRole()))
			processEventsDto.setUserRole(entity.getUserRole());
		if (!ServicesUtil.isEmpty(entity.getProcessDisplayName()))
			processEventsDto.setProcessDisplayName(entity.getProcessDisplayName());
		if (!ServicesUtil.isEmpty(entity.getLaneCount()))
			processEventsDto.setLaneCount(entity.getLaneCount());
		if (!ServicesUtil.isEmpty(entity.getSubject()))
			processEventsDto.setSubject(entity.getSubject());
		if (!ServicesUtil.isEmpty(entity.getDescription()))
			processEventsDto.setDescription(entity.getDescription());
		/*if(!ServicesUtil.isEmpty(entity.getProcessConfigId()))
			processEventsDto.setProcessConfigId(entity.getProcessConfigId());
		 */
		logger.error("[PMC][process_config_det] : "+processEventsDto.toString());
		return processEventsDto;
	}

	@SuppressWarnings("unchecked")
	public List<ProcessConfigDto> getAllProcessConfigEntry() throws NoResultFault {
		List<ProcessConfigDto> processLabelDtos = new ArrayList<ProcessConfigDto>();
		//String queryName = "select pl.processName, pl.labelName, pl.userGroup, pl.processDisplayName,pl.userRole from ProcessConfigDo pl";
		String queryName = "select pl from ProcessConfigDo pl";

		List<ProcessConfigDo> doList = this.getSession().createSQLQuery(queryName).list();
		if (!ServicesUtil.isEmpty(doList)) {
			String processName = "";
			ProcessConfigDto dto = new ProcessConfigDto();
			for (ProcessConfigDo entity : doList) {
				if (!entity.getProcessName().equals("ALL")) {
					if (!ServicesUtil.isEmpty(processName)) {
						processName = processName + "','" + entity.getProcessName();
					} else {
						processName = entity.getProcessName();
					}
					processLabelDtos.add(exportDto(entity));
				} else {
					dto = exportDto(entity);
				}
			}
			dto.setKey("'" + processName + "'");
			if (!ServicesUtil.isEmpty(processLabelDtos)) {
				processLabelDtos.add(dto);
			}
		}
		return processLabelDtos;
	}


	@SuppressWarnings("unchecked")
	public List<ProcessConfigDto> getAllProcessConfigEntryByRole(String user) throws NoResultFault {
		List<ProcessConfigDto> processLabelDtos = new ArrayList<ProcessConfigDto>();
		String queryName = "select pl from ProcessConfigDo pl where (pl.userRole like '%" + user
				+ "%') or ( pl.processName='ALL')";
		List<ProcessConfigDo> doList = this.getSession().createSQLQuery(queryName).list();
		if (!ServicesUtil.isEmpty(doList)) {
			String processName = "";
			ProcessConfigDto dto = new ProcessConfigDto();
			for (ProcessConfigDo entity : doList) {
				if (!entity.getProcessName().equals("ALL")) {
					if (!ServicesUtil.isEmpty(processName)) {
						processName = processName + "','" + entity.getProcessName();
					} else {
						processName = entity.getProcessName();
					}
					processLabelDtos.add(exportDto(entity));
				} else {
					dto = exportDto(entity);
				}
			}
			dto.setKey("'" + processName + "'");
			if (!ServicesUtil.isEmpty(processLabelDtos)) {
				processLabelDtos.add(dto);
			}
		}
		return processLabelDtos;
	}

	/*public void updateForAdminConsole(ProcessConfigDto processConfigDto)
	{

		ProcessConfigDo entity = new ProcessConfigDo();
		if (!ServicesUtil.isEmpty(processConfigDto.getProcessName()))
			entity.setProcessName(processConfigDto.getProcessName());
		if (!ServicesUtil.isEmpty(processConfigDto.getProcessDisplayName()))
				entity.setProcessDisplayName(processConfigDto.getProcessDisplayName());
		if (!ServicesUtil.isEmpty(processConfigDto.getLabelName()))
			entity.setLabelName(processConfigDto.getLabelName());
		if (!ServicesUtil.isEmpty(processConfigDto.getUserGroup()))
			entity.setUserGroup(processConfigDto.getUserGroup());

		logger.error("Update for admin console process dto is successfully done");
	}*/
}
