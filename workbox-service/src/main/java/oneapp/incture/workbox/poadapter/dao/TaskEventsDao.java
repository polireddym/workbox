package oneapp.incture.workbox.poadapter.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.ManageTasksDto;
import oneapp.incture.workbox.pmc.dto.ManageTasksRequestDto;
import oneapp.incture.workbox.pmc.dto.responses.ManageTasksResponseDto;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.poadapter.dto.TaskEventsDto;
import oneapp.incture.workbox.poadapter.entity.TaskEventsDo;
import oneapp.incture.workbox.poadapter.entity.TaskEventsDoPK;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.PMCConstant;
import oneapp.incture.workbox.util.ServicesUtil;

@Repository("TaskEventsDao")
@Transactional
public class TaskEventsDao extends BaseDao<TaskEventsDo, TaskEventsDto> {

	private static final Logger logger = LoggerFactory.getLogger(TaskEventsDao.class);

	@Override
	protected TaskEventsDto exportDto(TaskEventsDo entity) {
		TaskEventsDto taskEventsDto = new TaskEventsDto();
		taskEventsDto.setEventId(entity.getTaskEventsDoPK().getEventId());
		taskEventsDto.setProcessId(entity.getTaskEventsDoPK().getProcessId());
		if (!ServicesUtil.isEmpty(entity.getDescription()))
			taskEventsDto.setDescription(entity.getDescription());
		if (!ServicesUtil.isEmpty(entity.getName()))
			taskEventsDto.setName(entity.getName());
		if (!ServicesUtil.isEmpty(entity.getSubject()))
			taskEventsDto.setSubject(entity.getSubject());
		if (!ServicesUtil.isEmpty(entity.getStatus()))
			taskEventsDto.setStatus(entity.getStatus());
		if (!ServicesUtil.isEmpty(entity.getCurrentProcessor()))
			taskEventsDto.setCurrentProcessor(entity.getCurrentProcessor());
		if (!ServicesUtil.isEmpty(entity.getPriority()))
			taskEventsDto.setPriority(entity.getPriority());
		if (!ServicesUtil.isEmpty(entity.getCreatedAt()))
			taskEventsDto.setCreatedAt(entity.getCreatedAt());
		if (!ServicesUtil.isEmpty(entity.getCompletedAt()))
			taskEventsDto.setCompletedAt(entity.getCompletedAt());
		if (!ServicesUtil.isEmpty(entity.getCompletionDeadLine()))
			taskEventsDto.setCompletionDeadLine(entity.getCompletionDeadLine());
		if (!ServicesUtil.isEmpty(entity.getProcessName()))
			taskEventsDto.setProcessName(entity.getProcessName());
		if (!ServicesUtil.isEmpty(entity.getTaskMode()))
			taskEventsDto.setTaskMode(entity.getTaskMode());
		if (!ServicesUtil.isEmpty(entity.getStatusFlag()))
			taskEventsDto.setStatusFlag(entity.getStatusFlag());
		if (!ServicesUtil.isEmpty(entity.getCurrentProcessorDisplayName()))
			taskEventsDto.setCurrentProcessorDisplayName(entity.getCurrentProcessorDisplayName());
		if (!ServicesUtil.isEmpty(entity.getTaskType()))
			taskEventsDto.setTaskType(entity.getTaskType());
		if (!ServicesUtil.isEmpty(entity.getForwardedBy()))
			taskEventsDto.setForwardedBy(entity.getForwardedBy());
		if (!ServicesUtil.isEmpty(entity.getForwardedAt()))
			taskEventsDto.setForwardedAt(entity.getForwardedAt());
		if(!ServicesUtil.isEmpty(entity.getOrigin()))
			taskEventsDto.setOrigin(entity.getOrigin());
		if(!ServicesUtil.isEmpty(entity.getUrl()))
			taskEventsDto.setDetailUrl(entity.getUrl());
		return taskEventsDto;
	}

	@Override
	protected TaskEventsDo importDto(TaskEventsDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		TaskEventsDo entity = new TaskEventsDo();
		entity.setTaskEventsDoPK(new TaskEventsDoPK());
		if (!ServicesUtil.isEmpty(fromDto.getEventId()))
			entity.getTaskEventsDoPK().setEventId(fromDto.getEventId());
		if (!ServicesUtil.isEmpty(fromDto.getProcessId()))
			entity.getTaskEventsDoPK().setProcessId(fromDto.getProcessId());
		if (!ServicesUtil.isEmpty(fromDto.getStatus()))
			entity.setStatus(fromDto.getStatus());
		if (!ServicesUtil.isEmpty(fromDto.getCurrentProcessor()))
			entity.setCurrentProcessor(fromDto.getCurrentProcessor());
		if (!ServicesUtil.isEmpty(fromDto.getPriority()))
			entity.setPriority(fromDto.getPriority());
		if (!ServicesUtil.isEmpty(fromDto.getCreatedAt()))
			entity.setCreatedAt(fromDto.getCreatedAt());
		if (!ServicesUtil.isEmpty(fromDto.getCompletedAt()))
			entity.setCompletedAt(fromDto.getCompletedAt());
		if (!ServicesUtil.isEmpty(fromDto.getCompletionDeadLine()))
			entity.setCompletionDeadLine(fromDto.getCompletionDeadLine());
		if (!ServicesUtil.isEmpty(fromDto.getCurrentProcessorDisplayName()))
			entity.setCurrentProcessorDisplayName(fromDto.getCurrentProcessorDisplayName());
		if (!ServicesUtil.isEmpty(fromDto.getDescription()))
			entity.setDescription(fromDto.getDescription());
		if (!ServicesUtil.isEmpty(fromDto.getName()))
			entity.setName(fromDto.getName());
		if (!ServicesUtil.isEmpty(fromDto.getSubject()))
			entity.setSubject(fromDto.getSubject());
		if (!ServicesUtil.isEmpty(fromDto.getProcessName()))
			entity.setProcessName(fromDto.getProcessName());
		if (!ServicesUtil.isEmpty(fromDto.getTaskMode()))
			entity.setTaskMode(fromDto.getTaskMode());
		if (!ServicesUtil.isEmpty(fromDto.getStatusFlag()))
			entity.setStatusFlag(fromDto.getStatusFlag());
		if (!ServicesUtil.isEmpty(fromDto.getTaskType()))
			entity.setTaskType(fromDto.getTaskType());
		if (!ServicesUtil.isEmpty(fromDto.getForwardedBy()))
			entity.setForwardedBy(fromDto.getForwardedBy());
		if (!ServicesUtil.isEmpty(fromDto.getForwardedAt()))
			entity.setForwardedAt(fromDto.getForwardedAt());
		if(!ServicesUtil.isEmpty(fromDto.getOrigin()))
			entity.setOrigin(fromDto.getOrigin());
		if(!ServicesUtil.isEmpty(fromDto.getDetailUrl()))
			entity.setUrl(fromDto.getDetailUrl());
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getUserTaskCount(String userId, String processName, String requestId, String labelValue, String status, Date startDate, Date endDate) throws NoResultFault {
		//	DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tempQuery = "";
		String query = "select count(te.CREATED_AT) AS TASK_COUNT, (te.CREATED_AT)"
				//"select count(te.CREATED_AT) AS TASK_COUNT, trunc(te.CREATED_AT)
				+"AS CREATED_DATE from task_events te left join task_owners tw on te.event_id = tw.event_id where tw.task_owner ='"
				+ userId + "'";
		String groupQuery = " group by (te.CREATED_AT) ORDER BY (te.CREATED_AT)";
		//" group by trunc(te.CREATED_AT) ORDER BY trunc(te.CREATED_AT)";
		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and te.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name = '" + processName + "')";
		}
		if (!ServicesUtil.isEmpty(requestId)) {
			tempQuery = tempQuery + " and te.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.REQUEST_ID = '" + requestId + "')";
		}
		if (!ServicesUtil.isEmpty(labelValue)) {
			tempQuery = tempQuery + " and te.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.SUBJECT like '%" + labelValue + "%')";
		}
		if (!ServicesUtil.isEmpty(status)) {
			if (PMCConstant.SEARCH_READY.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "'";
			} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "' and tw.IS_PROCESSED = 1";
			} else {
				tempQuery = tempQuery + " and (te.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' or (te.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and tw.IS_PROCESSED = 1))";
			}
		}
		if (!ServicesUtil.isEmpty(startDate) && !ServicesUtil.isEmpty(endDate)) {
			tempQuery = tempQuery + " and te.CREATED_AT between "
					+"'"+ newDf.format(startDate)+"' and '" +newDf.format(endDate)+"'";
			//	+ "TO_DATE('" + dateFormatter.format(startDate) + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + dateFormatter.format(endDate) + "', 'DD/MM/YY hh:mi:ss PM')";
		}
		query = query + tempQuery + groupQuery;
		logger.error("get - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList)) {
			throw new NoResultFault("NO RECORD FOUND");
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getTaskCountByOwner(String userId, String processName, String requestId, String labelValue, String status, Date startDate, Date endDate) {
		String tempQuery = "";
		//DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd");
		String queryColumn = null;
		if (PMCConstant.SEARCH_COMPLETED.equalsIgnoreCase(status)) {
			queryColumn = "COMPLETED_AT";
			tempQuery = tempQuery + " and te.STATUS = '" + status + "'";
		} else {
			queryColumn = "CREATED_AT";
			if (PMCConstant.SEARCH_READY.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "'";
			} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(status)) {
				tempQuery = tempQuery + " and te.STATUS = '" + status + "' and tw.IS_PROCESSED = 1";
			} else {
				tempQuery = tempQuery + " and (te.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' or (te.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and tw.IS_PROCESSED = 1))";
			}
		}
		String query ="SELECT to_date(te." + queryColumn + ") AS TASK_DATE, COUNT(to_date(te." + queryColumn
				//"SELECT TRUNC(te." + queryColumn + ") AS TASK_DATE, COUNT(TRUNC(te." + queryColumn
				+ ")) AS TASK_COUNT from task_owners tw left join task_events te on tw.event_id = te.event_id left join process_events pe on pe.process_id = te.process_id where tw.task_owner='"
				+ userId + "'";
		if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
			tempQuery = tempQuery + " and pe.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN ('" + processName + "'))";
		}
		if (!ServicesUtil.isEmpty(requestId)) {
			tempQuery = tempQuery + " and pe.REQUEST_ID = '" + requestId + "'";
		}
		if (!ServicesUtil.isEmpty(labelValue)) {
			tempQuery = tempQuery + " and pe.SUBJECT like '%" + labelValue + "%'";
		}
		if (!ServicesUtil.isEmpty(startDate) && !ServicesUtil.isEmpty(endDate)) {
			if (PMCConstant.SEARCH_COMPLETED.equalsIgnoreCase(status))
				tempQuery = tempQuery + " and to_date(te.COMPLETED_AT) between ";
			else
				tempQuery = tempQuery + " and to_date(te.CREATED_AT) between ";
			tempQuery = tempQuery +"TO_DATE('"+ newDf.format(startDate)+"') and TO_DATE('" +newDf.format(endDate)+"')";
			//"TO_DATE('"+dateFormatter.format(startDate) + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + dateFormatter.format(endDate) + "', 'DD/MM/YY hh:mi:ss PM')";
		}
		if (!PMCConstant.SEARCH_COMPLETED.equalsIgnoreCase(status))
			tempQuery = tempQuery + " and pe.status='" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
		String groupQuery = " group by to_date(te." + queryColumn + ") ORDER BY to_date(te." + queryColumn + ")";
		//" group by trunc(te." + queryColumn + ") ORDER BY trunc(te." + queryColumn + ")";
		query = query + tempQuery + groupQuery;
		logger.error("get_getTaskCountByOwner - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList)) {
			try {
				throw new NoResultFault("NO RECORD FOUND");
			} catch (NoResultFault e) {
				logger.error("Error : "+e.getLocalizedMessage());
			}
		}
		return resultList;
	}

	@SuppressWarnings({ "unchecked" })
	public ManageTasksResponseDto getTasksByUserAndDuration(ManageTasksRequestDto request) {
		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ManageTasksResponseDto response = new ManageTasksResponseDto();
		List<ManageTasksDto> tasks = new ArrayList<ManageTasksDto>();
		ResponseMessage message = new ResponseMessage();
		// StringBuffer taskStr = new StringBuffer("select p.requestId,p.name,t.taskEventsDoPK.eventId,t.subject,t.createdAt,t.status,v.taskOwnerDisplayName,c.processDisplayName "
		// + "from ProcessEventsDo p,TaskEventsDo t,TaskOwnersDo v LEFT JOIN ProcessConfigDo c where "
		// + "p.processId=t.taskEventsDoPK.processId and v.taskOwnersDoPK.eventId=t.taskEventsDoPK.eventId and p.name = c.processName and p.status = \'IN_PROGRESS\'");
		Date startDateFrom = null;
		Date startDateTo = null;
		try {
			startDateFrom = ServicesUtil.getDate(request.getStartDayFrom());
			startDateTo = ServicesUtil.getDate(request.getStartDayTo());
			startDateTo = ServicesUtil.setEndTime(startDateTo);
			logger.error("startDate  - " + startDateFrom);
			logger.error("endDate  - " + startDateTo);
			StringBuffer taskStr = new StringBuffer(
					"SELECT p.REQUEST_ID AS REQUEST_ID, p.NAME AS NAME, t.EVENT_ID AS EVENT_ID, t.SUBJECT AS SUBJECT, t.CREATED_AT AS CREATED_AT, t.STATUS AS STATUS, v.TASK_OWNER AS TASK_OWNER, v.TASK_OWNER_DISP AS TASK_OWNER_DISP, c.PROCESS_DISPLAY_NAME AS PROCESS_DISP_NAME FROM PROCESS_EVENTS p LEFT OUTER JOIN PROCESS_CONFIG_TB c ON p.NAME = c.PROCESS_NAME, TASK_EVENTS t, TASK_OWNERS v where p.PROCESS_ID=t.PROCESS_ID and v.EVENT_ID=t.EVENT_ID and p.STATUS = \'IN_PROGRESS\'");
			if (!ServicesUtil.isEmpty(request.getTaskStatus())) {
				if (PMCConstant.SEARCH_READY.equalsIgnoreCase(request.getTaskStatus())) {
					taskStr.append(" and t.STATUS = '" + request.getTaskStatus() + "'"
							+ "AND T.EVENT_ID in (select T.EVENT_ID from TASK_OWNERS v where T.EVENT_ID = V.EVENT_ID and V.TASK_OWNER = '"+request.getOwner()+"')");
				} else if (PMCConstant.SEARCH_RESERVED.equalsIgnoreCase(request.getTaskStatus())) {
					taskStr.append(" and t.STATUS = '" + request.getTaskStatus() + "' and v.IS_PROCESSED = '1'"
							+ " AND v.TASK_OWNER = \'" + request.getOwner() + "\'");
				} else {
					taskStr.append(" and (t.STATUS = '" + PMCConstant.TASK_STATUS_READY + "' "
							+ "AND T.EVENT_ID in (select T.EVENT_ID from TASK_OWNERS v where T.EVENT_ID = V.EVENT_ID and V.TASK_OWNER = '"+request.getOwner()+"')"
							+ "or (t.STATUS = '" + PMCConstant.TASK_STATUS_RESERVED + "' and v.IS_PROCESSED = '1' and v.TASK_OWNER = \'" + request.getOwner() + "\'))");
					//taskStr.append(" and v.TASK_OWNER = \'" + request.getOwner() + "\'");
				}
			}
			if (!ServicesUtil.isEmpty(request.getProcessName()) || !ServicesUtil.isEmpty(request.getLabelValue()) || !ServicesUtil.isEmpty(request.getRequestId())) {
				taskStr.append(" and t.PROCESS_ID IN (select D.PROCESS_ID from PROCESS_EVENTS D where 1=1");
				if (!request.getProcessName().equals(PMCConstant.SEARCH_ALL)&&!request.getProcessName().contains("'")){
					taskStr.append(" and D.NAME = '" + request.getProcessName() + "'");
				}
				else if(!request.getProcessName().equals(PMCConstant.SEARCH_ALL)&&request.getProcessName().contains("'")){
					taskStr.append(" and D.NAME IN (" + request.getProcessName() + ")");
				}
				if (!ServicesUtil.isEmpty(request.getLabelValue()))
					taskStr.append(" and D.SUBJECT like '%" + request.getLabelValue() + "%'");
				if (!ServicesUtil.isEmpty(request.getRequestId()))
					taskStr.append(" and D.REQUEST_ID = '" + request.getRequestId() + "'");
				taskStr.append(")");
			}
			if (request.getStartDayFrom() >= 0 && request.getStartDayTo() >= 0) {
				//				DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
				taskStr.append(" and t.CREATED_AT between "+"'"+ newDf.format(startDateFrom)+"' and '" +newDf.format(startDateTo)+"'");
				//"TO_DATE('" + dateFormatter.format(startDateFrom) + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + dateFormatter.format(startDateTo) + "', 'DD/MM/YY hh:mi:ss PM')");
			}
			//taskStr.append(" and v.TASK_OWNER = \'" + request.getOwner() + "\'");

			if (!ServicesUtil.isEmpty(request.getPage())) {
				int first = (request.getPage() - 1) * PMCConstant.PAGE_SIZE;
				int last = PMCConstant.PAGE_SIZE;

				/* Commented for Pagination in HANA */
				//				query.setFirstResult(first);
				//				query.setMaxResults(last);

				taskStr = taskStr.append(" LIMIT "+last+" OFFSET "+first+"");
			}

			logger.error("Query: " + taskStr);
			Query query = this.getSession().createSQLQuery(taskStr.toString());

			List<Object[]> resultList = query.list();

			if (resultList != null) {
				for (Object[] obj : resultList) {
					ManageTasksDto taskDto = new ManageTasksDto();
					taskDto.setRequestId(obj[0] == null ? "" : (String) obj[0]);
					taskDto.setProcessName(obj[1] == null ? "" : (String) obj[1]);
					taskDto.setEventId(obj[2] == null ? "" : (String) obj[2]);
					taskDto.setTaskSubject(obj[3] == null ? "" : (String) obj[3]);
					taskDto.setCreatedDate(obj[4] == "" ? null : ServicesUtil.resultAsDate(obj[4]));
					taskDto.setStatus(obj[5] == null ? "" : (String) obj[5]);
					taskDto.setOwners(obj[6] == null ? "" : (String) obj[6]);
					taskDto.setOpenSinceinHrs(getDateDifferenceInHours(ServicesUtil.resultAsDate(obj[4])));
					taskDto.setProcessDisplayName(obj[8] == null ? obj[1] == null ? "" : (String) obj[1] : (String) obj[8]);
					tasks.add(taskDto);
				}
			}

			HashMap<String, ManageTasksDto> map = new HashMap<String, ManageTasksDto>();
			for (ManageTasksDto dto : tasks) {
				if (map.containsKey(dto.getEventId())) {
					ManageTasksDto t = map.get(dto.getEventId());
					String owner = t.getOwners() + "," + dto.getOwners();
					dto.setOwners(owner);
					map.put(dto.getEventId(), dto);
				} else {
					map.put(dto.getEventId(), dto);
				}
			}
			List<ManageTasksDto> tasks1 = new ArrayList<ManageTasksDto>();
			for (Entry<String, ManageTasksDto> entry : map.entrySet()) {
				tasks1.add(entry.getValue());
			}
			message.setStatus("Success");
			message.setStatusCode("0");
			message.setMessage("Process Details Fetched Successfully");
			response.setTasks(tasks1);
			response.setMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	private String getDateDifferenceInHours(Date date) {
		long t1 = new Date().getTime();
		long t2 = date.getTime();
		long diffinHrs = (t1 - t2) / (60 * 60 * 1000) % 60;
		return String.valueOf(diffinHrs);

	}



	@SuppressWarnings("unchecked")
	public List<TaskEventsDo> checkIfTaskInstanceExists(String instanceId) {
		Query query = this.getSession().createSQLQuery("select te from TaskEventsDo te where te.taskEventsDoPK.eventId =:instanceId");
		query.setParameter("instanceId", instanceId);
		List<TaskEventsDo> taskEventsDos = (List<TaskEventsDo>) query.list();
		if (taskEventsDos.size() > 0) {
			return taskEventsDos;

		} else {
			return null;
		}

	}


	public String createTaskInstance(TaskEventsDto dto) {
		//	logger.error("[PMC][TaskEventsDao][createTaskInstance]initiated with " + dto);

		try {
			this.create(dto);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][TaskEventsDao][createTaskInstance][error] " + e.getMessage());
		}
		return "FAILURE";

	}

	public String updateTaskInstance(TaskEventsDto dto) {
		//	logger.error("[PMC][TaskEventsDao][updateTaskInstance]initiated with " + dto);
		try {
			update(dto);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][TaskEventsDao][updateTaskInstance][error] " + e.getMessage());
		}
		return "FAILURE";

	}

	public String updateTaskEventToReady(String instanceId) {
		//	logger.error("[PMC][TaskOwnersDao][setTaskOwnersToReady][instanceId]"+instanceId);
		try{
			String queryString = "Update TaskEventsDo te set te.status = 'READY' , te.currentProcessor = '' , te.currentProcessorDisplayName = '' where te.taskEventsDoPK.eventId = '"+instanceId+"'";
			Query q = this.getSession().createSQLQuery(queryString);
			if(q.executeUpdate()>0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskEventsDao][setTaskOwnersToReady][error]"+e.getMessage());
		}
		return "FAILURE";
	}

	public String updateTaskEventToReserved(String instanceId,String user,String userDisplay) {
		try{
			String queryString = "Update TaskEventsDo te set te.status = 'RESERVED' , te.currentProcessor = '"+user+"' , te.currentProcessorDisplayName = '"+userDisplay+"' where te.taskEventsDoPK.eventId = '"+instanceId+"'";
			Query q = this.getSession().createSQLQuery(queryString);
			if(q.executeUpdate()>0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskEventsDao][updateTaskEventToReserved][error]"+e.getMessage());
		}
		return "FAILURE";
	}


	public String checkIfTaskIsReserved(String userId ,String instanceId){

		try{
			String queryString = "select count(te) from TaskEventsDo te where te.status = 'RESERVED' and te.taskEventsDoPK.eventId = '"+instanceId+"' and te.currentProcessor = '"+userId+"'";
			Query q = this.getSession().createSQLQuery(queryString);
			Long count =  (Long) q.uniqueResult();
			if(count > 0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskEventsDao][checkIfTaskIsReserved][error]"+e.getMessage());
		}
		return "FAILURE";

	}


	public String checkIfTaskIsReady(String instanceId){

		try{
			String queryString = "select count(te) from TaskEventsDo te where te.status = 'READY' and te.taskEventsDoPK.eventId = '"+instanceId+"' ";
			Query q = this.getSession().createSQLQuery(queryString);
			Long count =  (Long)  q.uniqueResult();
			if(count > 0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskEventsDao][checkIfTaskIsReady][error]"+e.getMessage());
		}
		return "FAILURE";

	}
	@SuppressWarnings("unchecked")
	public List<TaskEventsDo>	getTaskDetailsByProcessId(String processId){

		Query query = this.getSession()
				.createQuery("select te from TaskEventsDo te where te.taskEventsDoPK.processId =:processId");
		query.setParameter("processId", processId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]>  getSLAByNameAndProcessId(String name,String processId){

		String qry = "select A.SLA AS SLA, A.URGENT_SLA AS URGENT_SLA from TASK_SLA A where TASK_DEF='"
				+ name
				+ "' and PROC_NAME IN( select PROC_NAME from PROCESS_EVENTS where PROCESS_ID = '"
				+ processId+ "')";
		logger.error("Query: " + qry);
		Query query = this.getSession().createSQLQuery(qry.toString());
		return query.list();
	}

}
