package oneapp.incture.workbox.poadapter.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.poadapter.entity.BaseDo;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.ExecutionFault;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.MessageUIDto;
import oneapp.incture.workbox.util.NoResultFault;
import oneapp.incture.workbox.util.RecordExistFault;
import oneapp.incture.workbox.util.ServicesUtil;


/**
 * The <code>BaseDao</code> abstract class comprise abstract functions for CRUD
 * operations and a few utility functions for child
 * <code>Data Access Objects<code>
 * 
 * @version 2, 21-June-2012
 * @since CR8313
 */
@Repository("baseDao")
@Transactional
public abstract class BaseDao<E extends BaseDo, D extends BaseDto>  {

	private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

	@Autowired
	private SessionFactory sessionFactory;


	public Session getSession() {
		/*try {
			ServicesUtil.unSetupSOCKS();
			logger.error("basedao"+System.getProperty("socksProxyHost"));
			logger.error("basedao"+System.getProperty("socksProxyPort"));
			logger.error("basedao"+System.getProperty("java.net.socks.username"));
			while(System.getProperty(MurphyConstant.SOCKS_PORT_NAME).equals(MurphyConstant.SOCKS_PORT)) {
			}
		} catch (Exception e) {
			logger.error("[Murphy][BaseDao][getSession][Socks Exception] "+e.getMessage());
		} */
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e){
			logger.error("[Murphy][BaseDao][getSession][error] "+e.getMessage());
			return sessionFactory.openSession();
		}

	}

	// private Integer batchSize;
	// private Integer startIndex = 0;
	// protected final Integer noOfRetries = 5;
	protected final boolean isNotQuery = false;
	protected final boolean isQuery = true;

	// Message
	private final String recordExist = "Record already exist ";
	private final String noRecordFound = "No record found: "; // NOT USED



	// <WRAPPER OVER BASIC CRUD ONES, WITH IMPORT AND EXPORT FUNCTIONS>

	/**
	 * @param dto
	 *            the record to be created
	 * @throws ExecutionFault
	 *             in case for fatal error
	 * @throws InvalidInputFault
	 *             wrong inputs
	 * @throws NoResultFault
	 */
	public void create(D dto) throws ExecutionFault, InvalidInputFault,
	NoResultFault {
		persist(importDto(EnOperation.CREATE, dto));
	}

	/**
	 * @param dto
	 *            input object
	 * @return single record based on the objects primary key
	 * @throws ExecutionFault
	 *             in case for fatal error
	 * @throws InvalidInputFault
	 *             even key is missing
	 * @throws NoResultFault
	 *             when record could be retrieved
	 */
	public D getByKeys(D dto) throws ExecutionFault, InvalidInputFault,
	NoResultFault {
		return exportDto(getByKeysForFK(dto));
	}

	/**
	 * @return the entity, mainly used for setting FK
	 */
	public E getByKeysForFK(D dto) throws ExecutionFault, InvalidInputFault,
	NoResultFault {
		return find(importDto(EnOperation.RETRIEVE, dto));
	}

	/**
	 * @param dto
	 *            the record to be updated
	 * @return the updated record
	 * @throws ExecutionFault
	 *             in case for fatal error
	 * @throws InvalidInputFault
	 *             wrong inputs
	 * @throws NoResultFault
	 */
	public void update(D dto) throws ExecutionFault, InvalidInputFault,
	NoResultFault {
		// return exportDto(merge(importDto(EnOperation.UPDATE, dto)));
		getByKeysForFK(dto);
		merge(importDto(EnOperation.UPDATE, dto));
	}

	public void delete(D dto) throws ExecutionFault, InvalidInputFault,
	NoResultFault {
		// remove(importDto(EnOperation.DELETE, dto));
		remove(getByKeysForFK(dto));
	}

	// </WRAPPER OVER BASIC CRUD ONES, WITH IMPORT AND EXPORT FUNCTIONS>

	// <BASIC CRUD OPERATIONS>
	protected void persist(E pojo) throws ExecutionFault {
		try {
			//	 getSession().getTransaction().begin();
			getSession().persist(pojo);
			//	 getSession().getTransaction().commit();
		} catch (Exception e) {
			MessageUIDto faultInfo = new MessageUIDto();
			logger.error(e.getMessage());
			faultInfo.setMessage(e.getMessage());
			String message = "Create of " + pojo.getClass().getSimpleName()
					+ " with keys " + pojo.getPrimaryKey() + " failed!";
			throw new ExecutionFault(message, faultInfo, e);
		}
	}

	@SuppressWarnings("unchecked")
	protected E find(E pojo) throws ExecutionFault, NoResultFault {
		E result = null;
		try {
			String primaryKey = (String) pojo.getPrimaryKey();
			result = (E) getSession().load(pojo.getClass(),primaryKey );
		} catch (Exception e) {
			logger.error("Exception in find"+e.getMessage());
			// In case of connection or other JPA ones.
			MessageUIDto faultInfo = new MessageUIDto();
			faultInfo.setMessage(e.getMessage());
			String message = "Retrieve of " + pojo.getClass().getSimpleName()
					+ " by keys " + pojo.getPrimaryKey() + " failed!";
			throw new ExecutionFault(message, faultInfo, e);
		}
		if (result == null) {
			throw new NoResultFault(noRecordFound
					+ pojo.getClass().getSimpleName() + "#"
					+ pojo.getPrimaryKey());
			// TODO: Re-think noRecordFound message
		}
		return result;
	}

	protected void merge(E pojo) throws ExecutionFault {
		try {
			getSession().clear();
			//			 getSession().update(pojo);
			getSession().update(pojo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			MessageUIDto faultInfo = new MessageUIDto();
			faultInfo.setMessage(e.getMessage());
			String message = "Update of " + pojo.getClass().getSimpleName()
					+ " having keys " + pojo.getPrimaryKey() + " failed!";
			throw new ExecutionFault(message, faultInfo, e);
		}
	}

	protected void saveOrUpdate(E pojo) throws ExecutionFault {
		try {
			getSession().clear();
			getSession().saveOrUpdate(pojo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			MessageUIDto faultInfo = new MessageUIDto();
			faultInfo.setMessage(e.getMessage());
			String message = "Save Or Update of " + pojo.getClass().getSimpleName()
					+ " having keys " + pojo.getPrimaryKey() + " failed!";
			throw new ExecutionFault(message, faultInfo, e);
		}
	}

	protected void remove(E pojo) throws ExecutionFault {
		try {
			getSession().delete(pojo);
			// getSession().remove(pojo);
		} catch (Exception e) {
			MessageUIDto faultInfo = new MessageUIDto();
			faultInfo.setMessage(e.getMessage());
			String message = "Delete of " + pojo.getClass().getSimpleName()
					+ " having keys " + pojo.getPrimaryKey() + " failed!";
			throw new ExecutionFault(message, faultInfo, e);
		}
	}

	// </BASIC CRUD OPERATIONS>
	// <SIGNATURE FOR DATA TRANSFER FUNCTIONS>
	private E importDto(EnOperation operation, D fromDto)
			throws InvalidInputFault, ExecutionFault, NoResultFault {
		if (fromDto != null) {
			fromDto.validate(operation);
			return importDto(fromDto);
		}
		throw new InvalidInputFault("Empty DTO passed");
	}

	/**
	 * @param fromDto
	 *            Data object from which data needs to be copied to a new entity
	 */
	protected abstract E importDto(D fromDto) throws InvalidInputFault,
	ExecutionFault, NoResultFault;

	// /**
	// * To be used this if copy over existing entity is needed
	// */
	// protected abstract E importDto(D fromDto, E toEntity)
	// throws InvalidInputFault, ExecutionFault;

	/**
	 * @param entity
	 *            Copies data back to a new transfer object from entity
	 */
	protected abstract D exportDto(E entity);

	protected List<D> exportDtoList(Collection<E> listDo) {
		List<D> returnDtos = null;
		if (!ServicesUtil.isEmpty(listDo)) {
			returnDtos = new ArrayList<D>(listDo.size());
			for (Iterator<E> iterator = listDo.iterator(); iterator.hasNext();) {
				returnDtos.add(exportDto(iterator.next()));
			}
		}
		return returnDtos;
	}

	/**
	 * Its negation logic over getByKeys.
	 * 
	 * @param dto
	 * @throws ExecutionFault
	 * @throws RecordExistFault
	 * @throws InvalidInputFault
	 */
	protected void entityExist(D dto) throws ExecutionFault, RecordExistFault,
	InvalidInputFault {
		try {// Report entity exist
			getByKeys(dto);
			throw new RecordExistFault(recordExist, buildRecordExistFault(dto));
		} catch (NoResultFault e) {
		}
	}

	// </SIGNATURE FOR DATA TRANSFER FUNCTIONS>



	/**
	 * 
	 * @param queryName
	 *            used for logging
	 * 
	 * @param query
	 *            object used for execution
	 * @param parameters
	 *            to be set in where clause
	 * @return Single record, depending on columns in SELECT clause, it return a
	 *         object of BaseDo type or an object array
	 * @throws NoResultFault
	 * @throws NonUniqueRecordFault
	 */

	/*
	 * 
	 * Commented by Manogna
	 * 
	 * protected Object getSingleResult(String queryName, Query query,
			Object... parameters) throws NoResultFault, NonUniqueRecordFault {
		// if (!ServicesUtil.isEmpty(parameters)) {
		// final int length = parameters.length;
		// for (int i = 0; i < length; i++) {
		// query.setParameter(i, parameters[i]);
		// }
		// }
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		} catch (NonUniqueResultException e) {
			throw new NonUniqueRecordFault(
					"Failed due to corrupt data, please contact db admin",
					buildNonUniqueRecordFault(queryName, parameters));
		}
	}

	 *//**
	 * @param queryName
	 *            used for logging
	 * @param query
	 *            object used for execution
	 * @param parameters
	 *            to be set in where clause
	 * @return List of records based on startIndex and batchIndex
	 * @throws NoResultFault
	 *//*
	protected List<?> getResultList(String queryName, Query query,
			Object... parameters) throws NoResultFault {
		// if (!ServicesUtil.isEmpty(parameters)) {
		// final int length = parameters.length;
		// for (int i = 0; i < length; i++) {
		// query.setParameter(i, parameters[i]);
		// }
		// }
		List<?> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		}
		return returnList;
	}*/

	protected String uuidGen(BaseDto dto, Class<? extends BaseDo> classDo)
			throws ExecutionFault {
		return UUID.randomUUID().toString();
		// TODO: TO REVIEW: Retrying logic below, ignored for now
	}

	// protected String uuidGen(BaseDto dto, Class<? extends BaseDo> classDo)
	// throws ExecutionFault {
	// int i = 0;
	// String uuid = UUID.randomUUID().toString();
	// while ( getSession().find(classDo, uuid) != null) {
	// if (i++ < noOfRetries) {
	// uuid = UUID.randomUUID().toString();
	// new CELogData(classDo).logError("No of retries(UUID gen):" + i);
	// } else {
	// String message = "UUID Generation Failed!";
	// throw new ExecutionFault("Server busy, please retry later",
	// buildExecutionFault(message));
	// }
	// }
	// return uuid;
	// }

	private MessageUIDto buildRecordExistFault(BaseDto BaseDto) {
		StringBuffer sb = new StringBuffer(recordExist);
		if (BaseDto != null) {
			// sb.append(BaseDto.getClass().getSimpleName());
			// sb.append("#[");
			sb.append(BaseDto.toString());
			// sb.append(']');
		}
		MessageUIDto messageUIDto = new MessageUIDto();
		messageUIDto.setMessage(sb.toString());
		return messageUIDto;
	}

	/*	
	 * 
	 * Commenteed by Manogna
	 * private MessageUIDto buildNonUniqueRecordFault(String queryName,
			Object... parameters) {
		StringBuffer sb = new StringBuffer(
				"Non Unique Record found for query: ");
		sb.append(queryName);
		if (!ServicesUtil.isEmpty(parameters)) {
			sb.append(" for params:");
			sb.append(ServicesUtil.getCSV(parameters));
		}
		MessageUIDto messageUIDto = new MessageUIDto();
		messageUIDto.setMessage(sb.toString());
		return messageUIDto;
	}
	 */
	// TODO: REMOVE BELOW LATER
	// private final String invalidInput = "Invalid input found ";
	//
	// protected E find(String queryName, Class<E> className, Object pk)
	// throws NoResultFault, InvalidInputFault, ExecutionFault {
	// if (pk == null) {
	// throw new InvalidInputFault(ServicesUtil.buildNoRecordMessage(
	// queryName, pk));
	// }
	// E entity =  getSession().find(className, pk);
	// if (entity == null) {
	// throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
	// queryName, pk));
	// }
	// return entity;
	// }
	// /**
	// * @param isQuery
	// * should be true when invoked by read function, and false by
	// * write functions
	// * @param dto
	// * the data object to be validated
	// */
	// protected void validateInput(BaseDto dto, boolean isQuery)
	// throws InvalidInputFault {
	// if (dto == null) {
	// String message = "Request/Parameter object found empty";
	// throw new InvalidInputFault(invalidInput,
	// buildInvalidInputFault(message));
	// } else {
	// dto.validate(isQuery);
	// }
	// }
	//
	// private MessageUIDto buildExecutionFault(String message) {
	// StringBuffer sb = new StringBuffer("Execution failed");
	// if (!ServicesUtil.isEmpty(message)) {
	// sb.append(':');
	// sb.append(message);
	// }
	// MessageUIDto messageUIDto = new MessageUIDto();
	// messageUIDto.setMessage(sb.toString());
	// return messageUIDto;
	// }
	//
	// private MessageUIDto buildNoResultFault(String queryName,
	// Object... parameters) {
	// StringBuffer sb = new StringBuffer(noRecordFound);
	// sb.append("for query:");
	// sb.append(queryName);
	// if (!ServicesUtil.isEmpty(parameters)) {
	// sb.append(" for params:");
	// sb.append(ServicesUtil.getCSV(parameters));
	// }
	// MessageUIDto messageUIDto = new MessageUIDto();
	// messageUIDto.setMessage(sb.toString());
	// return messageUIDto;
	// }
	//
	// private MessageUIDto buildInvalidInputFault(Object... parameters) {
	// StringBuffer sb = new StringBuffer(invalidInput);
	// if (!ServicesUtil.isEmpty(parameters)) {
	// sb.append(" for params:");
	// sb.append(ServicesUtil.getCSV(parameters));
	// }
	// MessageUIDto messageUIDto = new MessageUIDto();
	// messageUIDto.setMessage(sb.toString());
	// return messageUIDto;
	// }

	@SuppressWarnings("unchecked")
	public List<D> getAllResults(String doName, Object... parameters)
			throws NoResultFault {
		String queryName = "SELECT p FROM " + doName + " p ";
		Query query =  getSession().createQuery(queryName);
		List<E> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		}
		logger.error("returnList: "+returnList);
		return exportDtoList(returnList);
	}

	@SuppressWarnings("unchecked")
	public List<D> getAllReportAegingResults(String doName, Object... parameters)
			throws NoResultFault {
		String queryName = "SELECT p FROM " + doName + " p order by p.lowerSegment";
		Query query =  getSession().createQuery(queryName);
		List<E> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		}
		logger.error("returnList: "+returnList);
		return exportDtoList(returnList);
	}


	@SuppressWarnings("unchecked")
	public List<D> getAllActiveResults(String doName, String columnName, String value,Object... parameters)
			throws NoResultFault {
		String queryName = "SELECT p FROM " + doName + " p" + " where p."+columnName+" = "+value+" ";
		logger.error("queryName - "+queryName);
		Query query =  getSession().createQuery(queryName);
		List<E> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		}
		return exportDtoList(returnList);
	}


	@SuppressWarnings("unchecked")
	public List<D> getSpecificActiveResults(String doName, String columnName, String value,Object... parameters)
			throws NoResultFault {
		String queryName = "SELECT p FROM " + doName + " p" + " where p."+columnName+" =:value";
		logger.error("queryName: "+queryName);
		logger.error("[pmc][ReportAging][details] :"+doName +",   "+columnName+",   "+value);
		Query query =  getSession().createQuery(queryName);
		query.setParameter("value", value.trim());
		List<E> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(
					queryName, parameters));
		}          
		logger.error("returnList size: "+returnList.size());
		//                 logger.error("returnList: "+returnList);
		return exportDtoList(returnList);
	}


	@SuppressWarnings("unchecked")
	public List<D> getSpecificConfigResults(String doName, String columnName, String value, Object... params)
			throws NoResultFault {
		String queryName = "SELECT p FROM " + doName + " p" + " WHERE p." + columnName
				+ " =:value order by p.lowerSegment";
		logger.error("queryName: " + queryName);
		logger.error("[pmc][ReportAging][details] :" + doName + ",   " + columnName + ",   " + value);
		Query query =  getSession().createQuery(queryName);
		query.setParameter("value", value.trim());
		List<E> returnList = query.list();
		if (ServicesUtil.isEmpty(returnList)) {
			throw new NoResultFault(ServicesUtil.buildNoRecordMessage(queryName, params));
		}
		logger.error("return List Size : " + returnList.size());
		return exportDtoList(returnList);
	}
	/*
	// <<<<<<<ADDING wrapper functions for Verzionable & Orchestratable
	// Dtos>>>>>>>>>>>
	public D toBeActioned(D dto, ActionHRC actionHRC) throws ExecutionFault,
			InvalidInputFault, NoResultFault {
		if (!(dto instanceof Verzionable) && !(dto instanceof Orchestratable)) {
			ExecutionFault e2 = new ExecutionFault(
					"Invalid operation BaseDao.toBeActioned on "
							+ dto.getClass().getSimpleName());
			throw e2;
		} else if (actionHRC == null) {
			// Just in case summaryStatus needs update, else no change
			return update(dto);
		}
		// NOTE: Validations must be covered by higher layers,
		// must stop Cancel from Resuming, etc...
		E e = null;
		switch (actionHRC) {
		case RETRIGGER_NEW:
			// ONLY used for RETRIGGER functionality in PrimaryScopingUIBean
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
				orchestratorDto.setStatus(STATUS_DONE);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(false);
			}
			try {
				dto = update(dto);
			} catch (NoResultFault e1) {
				// Create
				e = importDto(EnOperation.CREATE, dto);
				persist(e);
				return toBeActioned(dto, ActionHRC.BACK);
			}
			// New record
			dto = makeNewVersion(dto);
			return toBeActioned(dto, ActionHRC.BACK);
		case NEW:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(TO_BE_COLLECTED);
				orchestratorDto.setStatus(STATUS_NEW);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(true);
				verzionableDto.setVerzion(1);
			}
			// Create
			e = importDto(EnOperation.CREATE, dto);
			persist(e);
			return exportDto(e);// In case of serialId
		case BACK:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(TO_BE_COLLECTED);
				orchestratorDto.setStatus(STATUS_NEW);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(true);
			}
			return update(dto);
		case WIP:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(TO_BE_COLLECTED);
				orchestratorDto.setStatus(STATUS_WIP);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(true);
			}
			return update(dto);
		case DONE:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
				orchestratorDto.setStatus(STATUS_DONE);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(false);
			}
			return update(dto);
		case HOLD:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				// int status = orchestratorDto.getStatus().intValue();
				int collectStatus = orchestratorDto.getCollectStatus()
						.intValue();
				if (collectStatus != COLLECT_COMPLETE) {
					orchestratorDto.setCollectStatus(TO_BE_HELD);
					// orchestratorDto.setStatus(STATUS_WIP);
					// } else {
					// ExecutionFault e2 = new ExecutionFault("Invalid status("
					// + status + "," + collectStatus + ") on" + actionHRC);
					// throw e2;
				}
			}
			return update(dto);
		case RESUME:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				int status = orchestratorDto.getStatus().intValue();
				int collectStatus = orchestratorDto.getCollectStatus()
						.intValue();
				if (status == STATUS_HOLD && collectStatus == COLLECT_COMPLETE) {
					orchestratorDto.setCollectStatus(TO_BE_RESUMED);
					// orchestratorDto.setStatus(STATUS_HOLD);
				} else if (status != STATUS_DONE
						&& (collectStatus == TO_BE_CANCELLED || collectStatus == TO_BE_HELD)) {
					// Undoing ToBeHold or ToBeCancel click
					if (status == STATUS_NEW)
						return toBeActioned(dto, ActionHRC.BACK);
					else
						return toBeActioned(dto, ActionHRC.WIP);
				}
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(true);
				// Active back
			}
			return update(dto);
		case CANCEL:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				int status = orchestratorDto.getStatus().intValue();
				int collectStatus = orchestratorDto.getCollectStatus()
						.intValue();
				if (collectStatus != COLLECT_COMPLETE
						|| (status == STATUS_HOLD && collectStatus == COLLECT_COMPLETE)) {
					orchestratorDto.setCollectStatus(TO_BE_CANCELLED);
					// orchestratorDto.setStatus(STATUS_WIP);
					// } else {
					// ExecutionFault e2 = new ExecutionFault("Invalid status("
					// + status + "," + collectStatus + ") on" + actionHRC);
					// throw e2;
				}
			}
			return update(dto);
		case RT_HOLD:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				// int collectStatus = orchestratorDto.getCollectStatus()
				// .intValue();
				// int status = orchestratorDto.getStatus().intValue();
				// if (status == STATUS_WIP && collectStatus == TO_BE_HELD) {
				orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
				orchestratorDto.setStatus(STATUS_HOLD);
				// } else {
				// ExecutionFault e2 = new ExecutionFault("Invalid status("
				// + status + "," + collectStatus + ") on" + actionHRC);
				// throw e2;
				// }
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(false);
			}
			return update(dto);
		case RT_CANCEL:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				// int collectStatus = orchestratorDto.getCollectStatus()
				// .intValue();
				// int status = orchestratorDto.getStatus().intValue();
				// if (status == STATUS_WIP && collectStatus == TO_BE_CANCELLED)
				// {
				orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
				orchestratorDto.setStatus(STATUS_CANCELLED);
				// } else {
				// ExecutionFault e2 = new ExecutionFault("Invalid status("
				// + status + "," + collectStatus + ") on" + actionHRC);
				// throw e2;
				// }
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(false);
			}
			return update(dto);
		case RT_RESUME:
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				if (dto instanceof Verzionable) {
					// Old record
					orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
					orchestratorDto.setStatus(STATUS_REJECTED);
					Verzionable verzionableDto = (Verzionable) dto;
					verzionableDto.setActiveVersion(false);
					dto = update(dto);
					// New record
					dto = makeNewVersion(dto);
					return toBeActioned(dto, ActionHRC.WIP);
				} else {
					// Execute for eg: GMA_MAT_LIN
					if (orchestratorDto.getStatus() == STATUS_NEW)
						return toBeActioned(dto, ActionHRC.BACK);
					else
						return toBeActioned(dto, ActionHRC.WIP);

				}
			}
		case RETRIGGER:
			// ONLY used for RETRIGGER functionality in PrimaryScopingUIBean

//			if (dto instanceof Orchestratable) {
//				Orchestratable orchestratorDto = (Orchestratable) dto;
//				if (dto instanceof Verzionable) {
//					// Old record
//					orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
//					orchestratorDto.setStatus(STATUS_DONE);
//					Verzionable verzionableDto = (Verzionable) dto;
//					verzionableDto.setActiveVersion(false);
//					dto = update(dto);
//					// New record
//					dto = makeNewVersion(dto);
//					return toBeActioned(dto, ActionHRC.WIP);
//				}
//			}
			if (dto instanceof Orchestratable) {
				Orchestratable orchestratorDto = (Orchestratable) dto;
				orchestratorDto.setCollectStatus(COLLECT_COMPLETE);
				orchestratorDto.setStatus(STATUS_DONE);
			}
			if (dto instanceof Verzionable) {
				Verzionable verzionableDto = (Verzionable) dto;
				verzionableDto.setActiveVersion(false);
			}
			try {
				dto = update(dto);
			} catch (NoResultFault e1) {
				// Create
				e = importDto(EnOperation.CREATE, dto);
				persist(e);
				return toBeActioned(dto, ActionHRC.WIP);
			}
			// New record
			dto = makeNewVersion(dto);
			return toBeActioned(dto, ActionHRC.WIP);
		default:
			ExecutionFault e2 = new ExecutionFault("Invalid operation "
					+ actionHRC + " on " + dto.getClass().getSimpleName());
			throw e2;
		}
	}

	@SuppressWarnings("unchecked")
	private D makeNewVersion(D dto) throws ExecutionFault, InvalidInputFault,
			NoResultFault {
		if (dto instanceof Verzionable) {
			Verzionable verzionableDto = ((Verzionable) dto).nextVersion();
			verzionableDto.setVerzion(verzionableDto.getVerzion() + 1);
			verzionableDto.setActiveVersion(true);
			dto = (D) verzionableDto;
		}
		if (dto instanceof Orchestratable) {
			Orchestratable orchestratorDto = (Orchestratable) dto;
			orchestratorDto.setCollectStatus(TO_BE_COLLECTED);
			orchestratorDto.setStatus(STATUS_NEW);
		}
		try {
			getByKeys(dto);
			return update(dto);
		} catch (NoResultFault e2) {
			// Create
			E e = importDto(EnOperation.CREATE, dto);
			persist(e);
			return exportDto(e);// In case of serialId
		}
	}

	protected String summarizeStatus(
			List<? extends Orchestratable> orchestratableDtoList) {
		if (!ServicesUtil.isEmpty(orchestratableDtoList)) {
			int new2 = 0;
			int newToBeCancelled = 0;
			int newToBeHeld = 0;
			int newToBeResumed = 0;
			int wip = 0;
			int wipToBeCancelled = 0;
			int wipToBeHeld = 0;
			int wipToBeResumed = 0;
			int held = 0;
			int holdToBeCancelled = 0;
			int holdToBeResumed = 0;
			int cancelled = 0;
			int done = 0;
			for (Orchestratable orchestratableDto : orchestratableDtoList) {
				if (orchestratableDto.getStatus() == STATUS_NEW
						&& orchestratableDto.getCollectStatus() == TO_BE_COLLECTED) {
					new2++;
				} else if (orchestratableDto.getStatus() == STATUS_WIP
						&& orchestratableDto.getCollectStatus() == TO_BE_COLLECTED) {
					wip++;
				} else if (orchestratableDto.getStatus() == STATUS_DONE
						&& orchestratableDto.getCollectStatus() == COLLECT_COMPLETE) {
					done++;
				} else if (orchestratableDto.getStatus() == STATUS_HOLD
						&& orchestratableDto.getCollectStatus() == COLLECT_COMPLETE) {
					held++;
				} else if (orchestratableDto.getStatus() == STATUS_NEW
						&& orchestratableDto.getCollectStatus() == TO_BE_HELD) {
					newToBeHeld++;
				} else if (orchestratableDto.getCollectStatus() == TO_BE_HELD) {
					wipToBeHeld++;
				} else if (orchestratableDto.getStatus() == STATUS_CANCELLED
						&& orchestratableDto.getCollectStatus() == COLLECT_COMPLETE) {
					cancelled++;
				} else if (orchestratableDto.getStatus() == STATUS_NEW
						&& orchestratableDto.getCollectStatus() == TO_BE_CANCELLED) {
					newToBeCancelled++;
				} else if (orchestratableDto.getStatus() == STATUS_WIP
						&& orchestratableDto.getCollectStatus() == TO_BE_CANCELLED) {
					wipToBeCancelled++;
				} else if (orchestratableDto.getCollectStatus() == TO_BE_CANCELLED) {
					holdToBeCancelled++;
				} else if (orchestratableDto.getStatus() == STATUS_NEW
						&& orchestratableDto.getCollectStatus() == TO_BE_RESUMED) {
					newToBeResumed++;
				} else if (orchestratableDto.getStatus() == STATUS_WIP
						&& orchestratableDto.getCollectStatus() == TO_BE_RESUMED) {
					wipToBeResumed++;
				} else if (orchestratableDto.getCollectStatus() == TO_BE_RESUMED) {
					holdToBeResumed++;
				} else {
					LogUtil.logError("Invalid state"
							+ orchestratableDto.toString());
				}
			}
			int length = orchestratableDtoList.size();
			int possiblyHeld = held + holdToBeResumed + holdToBeCancelled;
			int possiblyNew = new2 + newToBeCancelled + newToBeHeld;
			int possiblyWip = wip + wipToBeCancelled + wipToBeHeld
					+ wipToBeResumed + newToBeResumed;
			int possiblyToBeCancelled = newToBeCancelled + wipToBeCancelled;
			int possiblyToBeHeld = newToBeHeld + wipToBeHeld;
			int possiblyToBeResumed = newToBeResumed + wipToBeResumed
					+ holdToBeResumed;
			// At the least one possibly held and possibly new
			int unchangedByHRC = length - cancelled - done - held - wip - new2;
			if (possiblyHeld > 0 && possiblyNew > 0) {
				if (0 == unchangedByHRC) {
					return "Partially Held, NEW"; // ActionHRC.NEW
				}
				if (possiblyToBeCancelled == unchangedByHRC) {
					return "[Action Required] Partially Held, NEW"; // ActionHRC.NEW
				}
				if ((possiblyToBeCancelled + possiblyToBeHeld) == unchangedByHRC) {
					return "[Action Required] Partially Held, NEW"; // ActionHRC.NEW
				}
				if ((possiblyToBeCancelled + possiblyToBeHeld + possiblyToBeResumed) == unchangedByHRC) {
					return "[Action Required] Partially Held, NEW"; // ActionHRC.NEW
				}
			}
			// All canceled
			if (cancelled == length) {
				return "Fully Cancelled";// ActionHRC.RT_CANCEL
			}
			// At the least one held and possibly WIP
			if (possiblyHeld > 0 && possiblyWip > 0) {
				if (0 == unchangedByHRC) {
					return "Partially Held, WIP"; // ActionHRC.WIP
				}
				if (possiblyToBeCancelled == unchangedByHRC) {
					return "[Action Required] Partially Held, WIP"; // ActionHRC.WIP
				}
				if ((possiblyToBeCancelled + possiblyToBeHeld) == unchangedByHRC) {
					return "[Action Required] Partially Held, WIP"; // ActionHRC.WIP
				}
				if ((possiblyToBeCancelled + possiblyToBeHeld + possiblyToBeResumed) == unchangedByHRC) {
					return "[Action Required] Partially Held, WIP"; // ActionHRC.WIP
				}
			}
			// None Partially held, but at the least one possibly NEW
			if (possiblyNew > 0) {
				if (0 == unchangedByHRC) {
					return "NEW"; // ActionHRC.BACK
				}
				if (possiblyToBeCancelled == unchangedByHRC) {
					if (new2 + wip == 0)
						return "[Action Required] NEW "; // ActionHRC.CANCEL
					else
						return "[Action Required] NEW"; // ActionHRC.BACK
				}
				if (possiblyToBeCancelled + possiblyToBeHeld == unchangedByHRC) {
					if (new2 + wip == 0)
						return "[Action Required] NEW  "; // ActionHRC.HELD
					else
						return "[Action Required] NEW"; // ActionHRC.BACK
				}
				if (possiblyToBeCancelled + possiblyToBeHeld
						+ possiblyToBeResumed == unchangedByHRC) {
					if (new2 + wip == 0)
						return "[Action Required] NEW   "; // ActionHRC.RESUME
					else
						return "[Action Required] NEW"; // ActionHRC.BACK
				}
			}
			// None Partially held and new, but at the least one possibly WIP
			// new2 in unchangedByHRC is 0
			if (possiblyWip > 0) {
				if (0 == unchangedByHRC) {
					return "WIP"; // ActionHRC.WIP
				}
				if (possiblyToBeCancelled == unchangedByHRC) {
					if (wip == 0)
						return "[Action Required] WIP "; // ActionHRC.CANCEL
					else
						return "[Action Required] WIP"; // ActionHRC.WIP
				}
				if (possiblyToBeCancelled + possiblyToBeHeld == unchangedByHRC) {
					if (wip == 0)
						return "[Action Required] WIP  "; // ActionHRC.HOLD
					else
						return "[Action Required] WIP"; // ActionHRC.WIP
				}
				if (possiblyToBeCancelled + possiblyToBeHeld
						+ possiblyToBeResumed == unchangedByHRC) {
					if (wip == 0)
						return "[Action Required] WIP   "; // ActionHRC.RESUME
					else
						return "[Action Required] WIP"; // ActionHRC.WIP
				}
			}
			// None Partially held and new and fullyCanceled and Done
			if (possiblyHeld > 0) {
				if (0 == unchangedByHRC) {
					return "Fully Held";// ActionHRC.RT_HOLD
				}
				if (possiblyToBeCancelled == unchangedByHRC) {
					return "[Action Required] Fully Held ";// ActionHRC.CANCEL
				}
				if (possiblyToBeCancelled + possiblyToBeHeld == unchangedByHRC) {
					return "[Action Required] Fully Held  ";// ActionHRC.HOLD
				}
				if (possiblyToBeCancelled + possiblyToBeHeld
						+ possiblyToBeResumed == unchangedByHRC) {
					return "[Action Required] Fully Held   ";// ActionHRC.RESUME
				}
			}
			// None Partially held and new and fullyCanceled
			if (done > 0 && 0 == unchangedByHRC) {
				return "DONE"; // ActionHRC.DONE
			}
			if (possiblyToBeCancelled == unchangedByHRC) {
				return "[Action Required] WIP";// ActionHRC.WIP
			}
			if ((possiblyToBeCancelled + possiblyToBeHeld) == unchangedByHRC) {
				return "[Action Required] WIP";// ActionHRC.WIP
			}
			if ((possiblyToBeCancelled + possiblyToBeHeld + possiblyToBeResumed) == unchangedByHRC) {
				return "[Action Required] WIP";// ActionHRC.WIP
			}
			LogUtil.logInfo("BaseDao.summarizeStatus(): unhandled case!"
					+ new2 + "," + wip + "," + done + "," + newToBeCancelled
					+ "," + wipToBeCancelled + "," + newToBeHeld + ","
					+ wipToBeHeld + "," + newToBeResumed + "," + wipToBeResumed
					+ "," + holdToBeResumed + "," + cancelled + "," + held
					+ "," + length);
		}
		return null;
	}

	protected ActionHRC getActionFromSummary(String summaryStatus,
			ActionHRC actionHRC) {
		if (!ServicesUtil.isEmpty(summaryStatus)) {
			if (summaryStatus.endsWith("   ")) {
				return ActionHRC.RESUME;
			} else if (summaryStatus.endsWith("  ")) {
				return ActionHRC.HOLD;
			} else if (summaryStatus.endsWith(" ")) {
				return ActionHRC.CANCEL;
			} else if (summaryStatus.endsWith("NEW")) {
				return ActionHRC.BACK;
			} else if (summaryStatus.endsWith("WIP")) {
				return ActionHRC.WIP;
			} else if ("DONE".equals(summaryStatus)) {
				return ActionHRC.DONE;
			} else if ("Fully Cancelled".equals(summaryStatus)) {
				return ActionHRC.RT_CANCEL;
			} else if ("Fully Held".equals(summaryStatus)) {
				return ActionHRC.RT_HOLD;
			} else if ("Fully Resume".equals(summaryStatus)) {
				return ActionHRC.RT_RESUME;
			} else {
				// Means don't change status
				return null;
			}
		}
		// Means no influence from children, hence input overrides
		return actionHRC;
	}*/
}