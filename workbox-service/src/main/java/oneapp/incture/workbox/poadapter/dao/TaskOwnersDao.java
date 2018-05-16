package oneapp.incture.workbox.poadapter.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.pmc.dto.AgingResponseDto;
import oneapp.incture.workbox.pmc.dto.AgingTableDto;
import oneapp.incture.workbox.pmc.dto.ReportAgingDto;
import oneapp.incture.workbox.pmc.dto.responses.TaskAgeingResponse;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
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
	
	@Autowired
	private ReportAgingDao agingDao;

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
	@SuppressWarnings("unchecked")
	public List<Object[]> getTaskCountWithUser(String processName, String status, Map<String, List<Date>> segmentMap, List<String> userList, String requestId, String labelValue) throws NoResultFault {
		StringBuffer userQuery = new StringBuffer();
		if (!ServicesUtil.isEmpty(userList)) {
			for (int i = 0; i < userList.size(); i++) {
				if (i == userList.size() - 1)
					userQuery.append(" '").append(userList.get(i).trim()).append("'");
				else if (i == 0)
					userQuery.append("'").append(userList.get(i).trim()).append("',");
				else
					userQuery.append(" '").append(userList.get(i).trim()).append("',");
			}
		}
		//DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yy hh:mm:ss a");
		DateFormat newDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Iterator<Entry<String, List<Date>>> it = segmentMap.entrySet().iterator();
		int count = 0;
		String query = "";

		while (it.hasNext()) {
			++count;
			Entry<String, List<Date>> entry = it.next();
			String range = (String) entry.getKey();
			List<Date> dateRange = (List<Date>) entry.getValue();
			//String initialDate = dateFormatter.format(dateRange.get(1));
			//String finalDate = dateFormatter.format(dateRange.get(0));
			String tempQuery = "";
			/*query = query + " SELECT C.TASK_OWNER AS OWNER,'" + range
					+ "' AS DATE_RANGE, COUNT(C.TASK_OWNER) AS TASK_COUNT, C.TASK_OWNER_DISP AS OWNER_NAME from PROCESS_EVENTS A left join TASK_EVENTS B on A.PROCESS_ID = B.PROCESS_ID left join TASK_OWNERS C on B.EVENT_ID = C.EVENT_ID WHERE B.CREATED_AT BETWEEN "
					+ "TO_DATE('" + initialDate + "', 'DD/MM/YY hh:mi:ss AM') and TO_DATE('" + finalDate + "', 'DD/MM/YY hh:mi:ss PM')";*/

			query = query + " SELECT C.TASK_OWNER AS OWNER,'" + range
					+ "' AS DATE_RANGE, COUNT(C.TASK_OWNER) AS TASK_COUNT, C.TASK_OWNER_DISP AS OWNER_NAME from PROCESS_EVENTS A left join TASK_EVENTS B on A.PROCESS_ID = B.PROCESS_ID left join TASK_OWNERS C on B.EVENT_ID = C.EVENT_ID WHERE B.CREATED_AT BETWEEN '"
					+ newDf.format(dateRange.get(1))+ "' and '"+newDf.format(dateRange.get(0))+"'";

			if (!ServicesUtil.isEmpty(userList))
				query = query + " and C.TASK_OWNER IN (" + userQuery.toString().trim() + ")";
			String groupQuery = " group by C.TASK_OWNER, C.TASK_OWNER_DISP";
			if (!ServicesUtil.isEmpty(processName) && !processName.equals(PMCConstant.SEARCH_ALL)) {
				tempQuery = tempQuery + " and A.PROCESS_ID IN (select D.process_id from PROCESS_EVENTS D where D.name IN( " + processName + "))";
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
			if (!ServicesUtil.isEmpty(requestId)) {
				tempQuery = tempQuery + " and A.REQUEST_ID = '" + requestId + "'";
			}
			if (!ServicesUtil.isEmpty(labelValue)) {
				tempQuery = tempQuery + " and A.SUBJECT like '%" + labelValue + "%'";
			}
			tempQuery = tempQuery + "  and A.status='" + PMCConstant.PROCESS_STATUS_IN_PROGRESS + "'";
			query = query + tempQuery + groupQuery;

			if (count < segmentMap.entrySet().size()) {
				query = query + " UNION";
			}
		}
		logger.error("End Query - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (ServicesUtil.isEmpty(resultList))
			throw new NoResultFault("NO RESULT FOUND");
		return resultList;
	}

	public TaskAgeingResponse getTaskAgeing(String processName, List<String> usersList, String status, String requestId, String labelValue) {
		logger.error("[PMC] TaskOwnersDao getTaskAgeing() Started with \n[processName] - " + processName + " \nUsersList -" + usersList + " \nstatus - " + status + " requestId " + requestId
				+ " labelValue " + labelValue);
		ResponseMessage message = new ResponseMessage();
		TaskAgeingResponse response = new TaskAgeingResponse();
		List<ReportAgingDto> reportAgingConfigDtos = agingDao.getConfigByReportName(PMCConstant.TASK_AGING_REPORT);
		Map<String, BigDecimal> headerMap = new LinkedHashMap<String, BigDecimal>();
		List<Object[]> resultList = null;
		if (!ServicesUtil.isEmpty(reportAgingConfigDtos)) {
			try {
				List<String> segList = new ArrayList<String>();
				headerMap.put(PMCConstant.USER_NAME, new BigDecimal(0));
				for (ReportAgingDto reportAgingDto : reportAgingConfigDtos) {
					if (reportAgingDto.getLowerSegment() < 0 || reportAgingDto.getHigherSegment() < reportAgingDto.getLowerSegment()) {
						message.setMessage(
								"One or  few of Report Agieng intervals (Higher or Lower) are not in correct manner. \nLower segment should be in positive number.\nHigher segment should be greater than Lower segment");
						message.setStatus("Success");
						message.setStatusCode("1");
						response.setResponseMessage(message);
						return response;
					}
					String segment = reportAgingDto.getLowerSegment() + " - " + reportAgingDto.getHigherSegment();
					segList.add(segment);
					if (!ServicesUtil.isEmpty(reportAgingDto.getDisplayName()))
						headerMap.put(reportAgingDto.getDisplayName(), new BigDecimal(0));
					else {
						headerMap.put(segment, new BigDecimal(0));
					}
				}
				resultList = this.getTaskCountWithUser(processName, status, ServicesUtil.dateSegmentMap(segList), usersList, requestId, labelValue);
				if (!ServicesUtil.isEmpty(resultList)) {
					List<AgingTableDto> taskAgingTableDtos = new ArrayList<AgingTableDto>();
					for (Object[] obj : resultList) {
						if (ServicesUtil.isEmpty((String) obj[0]))
							continue;
						AgingTableDto newAegingDto = new AgingTableDto((String) obj[0]);
						if (taskAgingTableDtos.contains(newAegingDto)) {
							AgingTableDto existingDto = taskAgingTableDtos.get(taskAgingTableDtos.indexOf(newAegingDto));
							Map<String, BigDecimal> existingMap = existingDto.getOldDataMap();
							existingMap.put((String) obj[1], ServicesUtil.getBigDecimal(/* (Long) */ obj[2]));
							existingDto.setCount(existingDto.getCount().add(ServicesUtil.getBigDecimal(/* (Long) */ obj[2])));
							existingDto.setDataMap(ServicesUtil.generateMapDtoFromMap(existingMap));
						} else {
							Map<String, BigDecimal> newMap = new LinkedHashMap<String, BigDecimal>();
							for (String segment : segList) {
								newMap.put(segment, new BigDecimal(0));
							}
							newAegingDto.setUserName(obj[3] == null ? null : (String) obj[3]);
							newMap.put((String) obj[1], ServicesUtil.getBigDecimal(/* (Long) */ obj[2]));
							newAegingDto.setOldDataMap(newMap);
							newAegingDto.setDataMap(ServicesUtil.generateMapDtoFromMap(newMap));
							newAegingDto.setCount(ServicesUtil.getBigDecimal(/* (Long) */ obj[2]));
							taskAgingTableDtos.add(newAegingDto);
							Collections.sort(taskAgingTableDtos);
						}
					}
					response.setAgeingTable(convertTableFormat(taskAgingTableDtos, headerMap));
					message.setMessage("Results Fetched Successfully");
					message.setStatus("Success");
					message.setStatusCode("0");
					response.setResponseMessage(message);
				}
			} catch (NoResultFault e) {
				message.setMessage("No open processes found for the given days interval");
				message.setStatus("Success");
				message.setStatusCode("1");
				response.setResponseMessage(message);
			} catch (Exception e) {
				logger.error(e.getMessage());
				message.setMessage("Internal Error : "+e.getMessage());
				message.setStatus("Success");
				message.setStatusCode("1");
				response.setResponseMessage(message);
			}
		} else {
			message.setMessage("Agieng intervals are not specified in DB");
			message.setStatus("Success");
			message.setStatusCode("1");
			response.setResponseMessage(message);
		}
		logger.error("[PMC] TaskOwnersDao getTaskAgeing() Ended with \n[TaskAgeingResponse] - " + response);
		return response;
	}

	private AgingResponseDto convertTableFormat(List<AgingTableDto> taskAgingTableDtos, Map<String, BigDecimal> headerMap) {
		AgingResponseDto response = new AgingResponseDto();
		response.setStatus("SUCCESS");
		//		response.setHeaderMap(headerMap);
		response.setHeaderMap(ServicesUtil.generateMapDtoFromMap(headerMap));
		response.setTupleDtos(taskAgingTableDtos);
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<TaskOwnersDto> getTaskOwners(String taskInstanceId) {

		String query = "SELECT C.TASK_OWNER AS OWNER, C.TASK_OWNER_DISP AS OWNER_NAME from TASK_OWNERS C  WHERE  C.EVENT_ID='" + taskInstanceId + "'";
		logger.error("[PMC][ TaskOwnersDao][getTaskOwners][ End Query] - " + query);
		Query q = this.getSession().createSQLQuery(query);
		List<Object[]> resultList = q.list();
		if (!ServicesUtil.isEmpty(resultList)) {
			List<TaskOwnersDto> dtoList = new ArrayList<TaskOwnersDto>();
			for (Object[] obj : resultList) {
				TaskOwnersDto dto = new TaskOwnersDto();
				if (!ServicesUtil.isEmpty(obj[0]))
					dto.setTaskOwner((String) obj[0]);
				if (!ServicesUtil.isEmpty(obj[1]))
					dto.setTaskOwnerDisplayName((String) obj[1]);
				dtoList.add(dto);
			}

			return dtoList;
		}
		return null;
	}
    // i have to check
	/*@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String deleteInstanceByOwner(String owner) {
		//            System.err.println("[PMC][TaskOwnersDao][deleteInstanceByOwner]initiated with "+owner);
		Query query = this.getSession().createSQLQuery("select te from TaskOwnersDo te where te.taskOwnersDoPK.taskOwner = :owner ");
		query.setParameter("owner", owner);
		List<TaskOwnersDo> processDos = (List<TaskOwnersDo>) query.list();
		//            System.err.println("[PMC][TaskOwnersDao][deleteInstanceByOwner][processDos] "+processDos);
		try {
			if(!ServicesUtil.isEmpty(processDos)){
				for (TaskOwnersDo entity : processDos) {
					delete(exportDto(entity));
					//this.getEntityManager().remove(entity);

				}
				this.getEntityManager().flush();
			}
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][TaskOwnersDao][deleteInstanceByOwner][error] " + e.getMessage());
		}
		return "FAILURE";
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<TaskOwnersDo> getInstanceByOwner(String owner) {
		//            System.err.println("[PMC][TaskOwnersDao][getInstanceByOwner]initiated with "+owner);
		try {
			Query query = this.getEntityManager().createQuery("select te from TaskOwnersDo te where te.taskOwnersDoPK.taskOwner = :owner ");
			query.setParameter("owner", owner);
			List<TaskOwnersDo> processDos = (List<TaskOwnersDo>) query.getResultList();
			//            System.err.println("[PMC][TaskOwnersDao][getInstanceByOwner][processDos] "+processDos);
			if(!ServicesUtil.isEmpty(processDos)){
				return processDos;
			}
		} catch (Exception e) {
			logger.error("[PMC][TaskOwnersDao][getInstanceByOwner][error] " + e.getMessage());
		}
		return null;
	}

	public String deleteNonExistingTasks( List<String> instanceList,String processor) {
		//            System.err.println("[PMC][ConsumeODataFacade][Xpath][Xpath][deleteNonExistingTasks] method invoked with [processor]" + processor+"[instanceList]"+instanceList);
		List<TaskOwnersDo> doList = getInstanceByOwner(processor);
		//            System.err.println("[PMC][ConsumeODataFacade][Xpath][Xpath][deleteNonExistingTasks] method invoked with [doList]" + doList.size()+"[instanceListLength]"+instanceList.size());
		if(!ServicesUtil.isEmpty(doList)){
			for(TaskOwnersDo entity :doList){
				if(!instanceList.contains(entity.getTaskOwnersDoPK().getEventId())){
					if(deleteInstance(entity).equals("FAILURE")){
						return "FAILURE";
					}
				}
			}
		}
		return "SUCCESS";
	}*/

	public String deleteInstance(TaskOwnersDo entity) {
		//            System.err.println("[PMC][TaskOwnersDao][deleteInstance]initiated "+entity);
		try {
			delete(exportDto(entity));
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][TaskOwnersDao][allOwnersInstance][error] " + e.getMessage());
		}
		return "FAILURE";
	}

	public String createTaskOwnerInstance(TaskOwnersDto dto) {
//            System.err.println("[PMC][ConsumeODataFacade][createTaskOwnerInstance]initiated with " + dto);
		try {
			create(dto);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][ConsumeODataFacade][createTaskOwnerInstance][error] " + e.getMessage());
		}
		return "FAILURE";
	}

	public String updateTaskOwnerInstance(TaskOwnersDto dto) {
//            System.err.println("[PMC][ConsumeODataFacade][updateTaskOwnerInstance]initiated with " + dto);
		try {
			update(dto);
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][ConsumeODataFacade][updateTaskOwnerInstance][error] " + e.getMessage());
		}
		return "FAILURE";
	}

	@SuppressWarnings("unchecked")
	public List<TaskOwnersDo> getOwnerInstances(String instanceId) {
		Query query = this.getSession().createSQLQuery("select to from TaskOwnersDo to where to.taskOwnersDoPK.eventId =:instanceId");
		query.setParameter("instanceId", instanceId);

		List<TaskOwnersDo>  dos =  (List<TaskOwnersDo>) query.list();

		if(dos.size()>0){
			return  dos;
		}
		else{
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public String deleteSubstitutedTasks(String owner,List<String> existingList) {
		//    System.err.println("[PMC][TaskOwnersDao][getInstanceByOwner]initiated with "+owner +"existing List "+existingList);
		try {
			Query query = this.getSession().createSQLQuery("select te from TaskOwnersDo te where te.taskOwnersDoPK.taskOwner = :owner and te.isSubstituted = :isSubstitutedTrue");
			query.setParameter("owner", owner);
			query.setParameter("isSubstitutedTrue", true);
			List<TaskOwnersDo> ownerdos = (List<TaskOwnersDo>) query.list();
			if(!ServicesUtil.isEmpty(ownerdos) ){
				for(TaskOwnersDo entity : ownerdos){

					if(!ServicesUtil.isEmpty(existingList) && !existingList.contains(entity.getTaskOwnersDoPK().getEventId()))
						delete(exportDto(entity));
				}
			}
			//	System.err.println("[PMC][TaskOwnersDao][deleteSubstitutedTasks] SUCCESS" +"[ownerdos]"+ownerdos+"[]");
			return "SUCCESS";
		} catch (Exception e) {
			logger.error("[PMC][TaskOwnersDao][deleteSubstitutedTasks][error] " + e.getMessage());
		}
		return "FAILURE";
	}

	@SuppressWarnings("unused")
	public String setTaskOwnersToReady(String instanceId) {
		try{
			String queryString = "Update TaskOwnersDo ts set ts.isProcessed = :isProcessed where ts.taskOwnersDoPK.eventId = '"+instanceId+"' and ts.isProcessed =:isProcessedTrue ";
			Query q = this.getSession().createSQLQuery(queryString);
			q.setParameter("isProcessed", false);
			q.setParameter("isProcessedTrue", true);
			int i = q.executeUpdate();
			return "SUCCESS";
		}
		catch(Exception e){
			logger.error("[PMC][TaskOwnersDao][setTaskOwnersToReady][error]"+e.getMessage());
		}
		return "FAILURE";
	}


	public String updateTaskOwnerToReserved(String instanceId,String user,String taskOwnerDisplayName) {
		try{
			String queryString = "Update TaskOwnersDo ts set ts.isProcessed = :isProcessed where ts.taskOwnersDoPK.eventId = '"+instanceId+"' and ts.taskOwnersDoPK.taskOwner = '"+user+"'";
			Query q = this.getSession().createSQLQuery(queryString);
			q.setParameter("isProcessed", true);
			int i = q.executeUpdate();
			if(i >0 )
				return "SUCCESS";
			else{
				TaskOwnersDto dto = new TaskOwnersDto();
				dto.setEventId(instanceId);
				dto.setIsProcessed(true);
				dto.setTaskOwner(user);
				dto.setTaskOwnerDisplayName(taskOwnerDisplayName);
				if(createOwner(dto).equals("SUCCESS")){
					return "SUCCESS";
				}
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskOwnersDao][updateTaskOwnerToReserved][error]"+e.getMessage());
		}
		return "FAILURE";
	}

	public String createOwner(TaskOwnersDto dto){
		try{
			create(dto);
			return "SUCCESS";
		}catch(Exception e){
			logger.error("[PMC][TaskOwnersDao][createOwner][error]"+e.getMessage());
		}
		return "FAILURE";


	}


	public String checkIfUserExists(String userId ,String instanceId){

		try{
			String queryString = "select count(te) from TaskOwnersDo te where te.taskOwnersDoPK.taskOwner ='"+userId+"' and te.taskOwnersDoPK.eventId = '"+instanceId+"'";
			Query q = this.getSession().createSQLQuery(queryString);
			Long count =  (Long)  q.uniqueResult();
			if(count == 0){
				return PMCConstant.NOT_OWNER;
			}
			else if(count > 0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskOwnersDao][checkIfUserIsOwner][error]"+e.getMessage());
		}
		return "FAILURE";

	}

	public String checkIfUserIsOwner(String userId ,String instanceId){

		try{
			String queryString = "select count(te) from TaskOwnersDo te where te.taskOwnersDoPK.taskOwner ='"+userId+"' and te.taskOwnersDoPK.eventId = '"+instanceId+"' and  ts.isProcessed = :isProcessed ";
			Query q = this.getSession().createSQLQuery(queryString);
			q.setParameter("isProcessed", true);
			Long count =  (Long)  q.uniqueResult();
			if(count == 0){
				return PMCConstant.NOT_OWNER;
			}
			else if(count > 0){
				return "SUCCESS";
			}
		}
		catch(Exception e){
			logger.error("[PMC][TaskOwnersDao][checkIfUserIsOwner][error]"+e.getMessage());
		}
		return "FAILURE";

	}


}
