package oneapp.incture.workbox.util;

/**
 * @author Saurabh
 *
 */
public interface PMCConstant {
	String ORDER_TYPE_CREATED_AT="createdAt";
	String ORDER_TYPE_SLA_DUE_DATE="dueDate";
	String ORDER_BY_ASC="ASC";
	String ORDER_BY_DESC="DESC";
	String SEARCH_ALL = "ALL";
	String SEARCH_SMALL_ALL = "All";
	String PROCESS_STATUS_IN_PROGRESS = "IN_PROGRESS";
	String GRAPH_TREND_MONTH = "month";
	String GRAPH_TREND_WEEK = "week";
	String WEEK_PREFIX = "Week";
	String STATUS_ALL = "ALL";
	String TASK_STATUS_RESERVED = "RESERVED";
	String TASK_STATUS_READY = "READY";
	String PROCESS_AGING_REPORT = "process aging";
	String TASK_AGING_REPORT = "task aging";
	String USER_NAME = "User Name";
	String PROCESS_NAME_LABEL = "Process Name";
	String PROCESS_TOTAL = "Total";
	int WEEK_RANGE = 7;
	int MONTH_RANGE = 30;
	int MONTH_INTERVAL = 6;
	int COMPLETED_RANGE = 30;
	String SEARCH_RESERVED = "RESERVED";
	String SEARCH_READY = "READY";
	String UESR_PROCESS_GRAPH_MONTH_FORMATE = "dd MMM";
	String PMC_DATE_FORMATE = "dd MMM yyyy";
	int WEEK_INTERVAL = 1;
	String TASK_CREATED_FORMATE = "YYYY-MM-dd hh:mm:ss.SSS";
	String DETAIL_DATE_FORMATE = "dd MMM YYYY hh:mm:ss";
	String DETAILDATE_AMPM_FORMATE = "dd MMM YYYY hh:mm:ss a";
	int PAGE_SIZE = 20;
	String SEARCH_COMPLETED = "COMPLETED";
	String USER_TASK_STATUS_GRAPH = "task Status Graph";
	String TASK_COMPLETED = "COMPLETED";
	String TASK_INPROGRESS = "IN_PROGRESS";
	String UPDATE = "Update";
	String CREATE = "Create";
	String DELETE = "Delete";
	String STATUS_FAILURE = "FAILURE";
	String STATUS_SUCCESS = "SUCCESS";
	String NO_RESULT = "NO RESULT FOUND";
	String INTERNAL_ERROR = "Internal Error";
	String SEND_NOTIFICATION = "Send Notification";
	String REMIND_ME = "Remind Me";
	String USER_TASK_REPORT = "User workload";
	String PROCESS_TRACKER = "Process Aeging";
	String TASK_AEGING = "Task Aeging";
	String REPORT_EXCEL = "Excel";
	String REPORT_PDF = "PDF";
	String REPORT = "PMC Report";
	String PROCESS_BY_DURATION = "Process By Duration";
	String TASK_MANAGER = "Task Manager";
	int ARCHIVE_DAY = 0; 
	String DAYS = "days";
	String HOURS = "hours";
	String MINUTES = "minute";

	/* User Id And Password For Wsdl Access */

	String WBuserId = "INC00695";
	String WBpassword = "Password@3";

	/*   Add for consuming  odata services */

	String HTTP_METHOD_PUT = "PUT";
	String HTTP_METHOD_POST = "POST";
	String HTTP_METHOD_GET = "GET";

	String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
	String HTTP_HEADER_ACCEPT = "Accept";

	String APPLICATION_JSON = "application/json";
	String APPLICATION_XML = "application/xml";
	String APPLICATION_ATOM_XML = "application/atom+xml";
	String APPLICATION_FORM = "application/x-www-form-urlencoded";
	String METADATA = "$metadata";
	String COUNT = "$count";

	String SEPARATOR = "/";

	boolean PRINT_RAW_CONTENT = true;

	String ECC_URL ="http://sthcigwdq1.kaust.edu.sa:8005/sap/opu/odata/IWPGW/TASKPROCESSING;mo;v=2/";
	String BPM_URL ="http://sap.bpm.host:80/bpmodata/tasks.svc/";
	//String BPM_URL ="http://10.120.28.214:50000/bpmodata/tasks.svc/";
	String WF_URL = "";
	
	/*	Added when destinations are added    */
	
	String BPM_DEST = "workboxbpm";
	String BPM_LOCATION ="houston";
	String ON_PREMISE_PROXY = "OnPremise";

	/*Added for Task Management  */

	String NOT_OWNER = "Not a Owner";
	

}
