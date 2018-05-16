package oneapp.incture.workbox.poadapter.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.poadapter.dto.TaskOwnersDto;
import oneapp.incture.workbox.poadapter.entity.TaskOwnersDo;
import oneapp.incture.workbox.poadapter.entity.TaskOwnersDoPK;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("TaskOwnersDao")
@Transactional
public class TaskOwnersDao extends BaseDao<TaskOwnersDo, TaskOwnersDto> {

	private static final Logger logger = LoggerFactory.getLogger(TaskOwnersDao.class);

	@Override
	protected TaskOwnersDto exportDto(TaskOwnersDo entity) {
		TaskOwnersDto taskOwnersDto = new TaskOwnersDto();
		taskOwnersDto.setEventId(entity.getTaskOwnersDoPK().getEventId());
		taskOwnersDto.setTaskOwner(entity.getTaskOwnersDoPK().getTaskOwner());
		if (!ServicesUtil.isEmpty(entity.getIsProcessed()))
			taskOwnersDto.setIsProcessed(entity.getIsProcessed());
		if (!ServicesUtil.isEmpty(entity.getTaskOwnerDisplayName()))
			taskOwnersDto.setTaskOwnerDisplayName(entity.getTaskOwnerDisplayName());
		if (!ServicesUtil.isEmpty(entity.getOwnerEmail()))
			taskOwnersDto.setOwnerEmail(entity.getOwnerEmail());
		if (!ServicesUtil.isEmpty(entity.getIsSubstituted()))
			taskOwnersDto.setIsSubstituted(entity.getIsSubstituted());
		return taskOwnersDto;
	}

	@Override
	protected TaskOwnersDo importDto(TaskOwnersDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		TaskOwnersDo entity = new TaskOwnersDo();
		entity.setTaskOwnersDoPK(new TaskOwnersDoPK());
		;
		if (!ServicesUtil.isEmpty(fromDto.getEventId()))
			entity.getTaskOwnersDoPK().setEventId(fromDto.getEventId());
		if (!ServicesUtil.isEmpty(fromDto.getTaskOwner()))
			entity.getTaskOwnersDoPK().setTaskOwner(fromDto.getTaskOwner());
		if (!ServicesUtil.isEmpty(fromDto.getIsProcessed()))
			entity.setIsProcessed(fromDto.getIsProcessed());
		if (!ServicesUtil.isEmpty(fromDto.getTaskOwnerDisplayName()))
			entity.setTaskOwnerDisplayName(fromDto.getTaskOwnerDisplayName());
		if (!ServicesUtil.isEmpty(fromDto.getOwnerEmail()))
			entity.setOwnerEmail(fromDto.getOwnerEmail());
		if (!ServicesUtil.isEmpty(fromDto.getIsSubstituted()))
			entity.setIsSubstituted(fromDto.getIsSubstituted());
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getTaskCountWithOwners(String processName, String requestId, String labelId, String status) throws NoResultFault {
		String tempQuery = "";
		String query = "SELECT C.TASK_OWNER AS OWNER, COUNT(C.TASK_OWNER) AS TASK_COUNT, C.TASK_OWNER_DISP AS OWNER_NAME from PROCESS_EVENTS A, TASK_EVENTS B, TASK_OWNERS C where A.PROCESS_ID = B.PROCESS_ID and B.EVENT_ID = C.EVENT_ID";
		String groupQuery = " group by C.TASK_OWNER, C.TASK_OWNER_DISP";

		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and A.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN ( '" + processName + "'))";
		}
		if (!ServicesUtil.isEmpty(requestId)) {
			tempQuery = tempQuery + " and A.REQUEST_ID = '" + requestId + "'";
		}
		if (!ServicesUtil.isEmpty(labelId)) {
			tempQuery = tempQuery + " and A.SUBJECT like '%" + labelId + "%'";
		}
		if (!ServicesUtil.isEmpty(status)) {
			if (PMCConstant.SEARCH_READY.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and B.STATUS = '" + status + "'";
			} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and B.STATUS = '" + status + "' and C.IS_PROCESSED = 1";
			} else {
				tempQuery = tempQuery + " and (B.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' or (B.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and C.IS_PROCESSED = 1))";
			}
		}
		tempQuery = tempQuery + "  and A.status='" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
		query = query + tempQuery + groupQuery;
		logger.error("getUserList - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList))
			throw new NoResultFault("NO RESULT FOUND");
		return resultList;
	}
}
