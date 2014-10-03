package monitor;

import java.util.List;
import platform.BaseAction;

@SuppressWarnings("serial")
public class LoggerAction extends BaseAction implements ILoggerAction {

	// 设置属性
	protected Integer userID;

	protected Integer loggerID;
	protected String loggerOperator;
	protected String loggerAction;
	protected String loggerSuccess;
	protected String loggerError;
	protected ILoggerService loggerService;
	protected List<Logger> allLogger;

	protected Integer loggerPageNow; 		// 初始化为1,默认从第一页开始显示
	protected Integer loggerPageSize; 		// 每页显示5条记录
	protected Integer loggerPageCount;	 	// 总页数

	protected static Integer pageNow = 1; 	// 初始化为1,默认从第一页开始显示
	protected static Integer pageSize = 5; 	// 每页显示5条记录
	protected static Integer pageCount = 0; // 总页数
	
	
	// 读第一页短消息
	public String first() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allLogger = loggerService.findAll(pageNow, pageSize);
		pageCount = loggerService.count(pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读短消息
	public String read() throws Exception {
		if (loggerPageSize==null || loggerPageSize <= 0)
			loggerPageSize = 5;
		if (loggerPageNow==null || loggerPageNow <= 0)
			loggerPageNow = 1;
		pageNow = loggerPageNow;
		pageSize = loggerPageSize;
		allLogger = loggerService.findAll(pageNow, pageSize);
		pageCount = loggerService.count(pageSize);
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读下一页短消息
	public String next() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.count(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allLogger = loggerService.findAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读上一页短消息
	public String last() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.count(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allLogger = loggerService.findAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}
	
	// 读最后一页短消息
	public String end() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = loggerService.count(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allLogger = loggerService.findAll(pageNow, pageSize);
		loggerPageNow = pageNow;
		loggerPageSize = pageSize;
		loggerPageCount = pageCount;
		return SUCCESS;	
	}	

	
	// 默认属性Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public Integer getLoggerID() {
		return loggerID;
	}

	public void setLoggerID(Integer loggerID) {
		this.loggerID = loggerID;
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

	public ILoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(ILoggerService loggerService) {
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

	public String getLoggerOperator() {
		return loggerOperator;
	}

	public void setLoggerOperator(String loggerOperator) {
		this.loggerOperator = loggerOperator;
	}

		
}

