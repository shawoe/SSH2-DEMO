package monitor;

import java.util.List;

import platform.BaseAction;
import platform.InterfaceActionMessage;

@SuppressWarnings("serial")
public class LoggerAction extends BaseAction implements InterfaceActionMessage{

	// ��������
	protected Integer userID;

	protected Integer loggerID;
	protected String loggerUser;
	protected String loggerAction;
	protected String loggerSuccess;
	protected String loggerError;
	protected LoggerService loggerService;
	protected List<Logger> allLogger;

	protected Integer loggerPageNow; 		// ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected Integer loggerPageSize; 		// ÿҳ��ʾ5����¼
	protected Integer loggerPageCount;	 	// ��ҳ��

	protected static Integer pageNow = 1; 	// ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected static Integer pageSize = 5; 	// ÿҳ��ʾ5����¼
	protected static Integer pageCount = 0; // ��ҳ��
	
	
	// ����һҳ����Ϣ
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allLogger = loggerService.getAll(pageNow, pageSize);
		pageCount = loggerService.getPageCount(pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ������Ϣ
	public String read() throws Exception {
		if (loggerPageSize==null || loggerPageSize <= 0)
			loggerPageSize = 5;
		if (loggerPageNow==null || loggerPageNow <= 0)
			loggerPageNow = 1;
		pageNow = loggerPageNow;
		pageSize = loggerPageSize;
		allLogger = loggerService.getAll(pageNow, pageSize);
		pageCount = loggerService.getPageCount(pageSize);
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// �����һҳ����Ϣ
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.getPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allLogger = loggerService.getAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}

	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String edit() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String send() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	// Ĭ������Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public Integer getLoggerID() {
		return loggerID;
	}

	public void setLoggerID(Integer loggerID) {
		this.loggerID = loggerID;
	}

	public String getLoggerUser() {
		return loggerUser;
	}

	public void setLoggerUser(String loggerUser) {
		this.loggerUser = loggerUser;
	}

	public String getLoggerAction() {
		return loggerAction;
	}

	public void setLoggerAction(String loggerAction) {
		this.loggerAction = loggerAction;
	}

	public String getLoggerSuccess() {
		return loggerSuccess;
	}

	public void setLoggerSuccess(String loggerSuccess) {
		this.loggerSuccess = loggerSuccess;
	}

	public String getLoggerError() {
		return loggerError;
	}

	public void setLoggerError(String loggerError) {
		this.loggerError = loggerError;
	}

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}

	public List<Logger> getAllLogger() {
		return allLogger;
	}

	public void setAllLogger(List<Logger> allLogger) {
		this.allLogger = allLogger;
	}

	public Integer getLoggerPageNow() {
		return loggerPageNow;
	}

	public void setLoggerPageNow(Integer loggerPageNow) {
		this.loggerPageNow = loggerPageNow;
	}

	public Integer getLoggerPageSize() {
		return loggerPageSize;
	}

	public void setLoggerPageSize(Integer loggerPageSize) {
		this.loggerPageSize = loggerPageSize;
	}

	public Integer getLoggerPageCount() {
		return loggerPageCount;
	}

	public void setLoggerPageCount(Integer loggerPageCount) {
		this.loggerPageCount = loggerPageCount;
	}

	public static Integer getPageNow() {
		return pageNow;
	}

	public static void setPageNow(Integer pageNow) {
		LoggerAction.pageNow = pageNow;
	}

	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		LoggerAction.pageSize = pageSize;
	}

	public static Integer getPageCount() {
		return pageCount;
	}

	public static void setPageCount(Integer pageCount) {
		LoggerAction.pageCount = pageCount;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

		
}

