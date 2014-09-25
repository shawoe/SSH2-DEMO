package monitor;

import java.util.List;
import monitor.Logger;
import monitor.LoggerService;
import util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class LoggerActionBase extends ActionSupport {

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

	protected PageUtil<Logger> page; 		// ҳ�洦����
	protected static Integer pageNow = 1; 	// ��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected static Integer pageSize = 5; 	// ÿҳ��ʾ5����¼
	protected static Integer pageCount = 0; // ��ҳ��

	
	// Ĭ������Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getLoggerID() {
		return loggerID;
	}

	public void setLoggerID(Integer loggerID) {
		this.loggerID = loggerID;
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

	public PageUtil<Logger> getPage() {
		return page;
	}

	public void setPage(PageUtil<Logger> page) {
		this.page = page;
	}

	public static Integer getPageNow() {
		return pageNow;
	}

	public static void setPageNow(Integer pageNow) {
		LoggerActionBase.pageNow = pageNow;
	}

	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		LoggerActionBase.pageSize = pageSize;
	}

	public static Integer getPageCount() {
		return pageCount;
	}

	public static void setPageCount(Integer pageCount) {
		LoggerActionBase.pageCount = pageCount;
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

}
