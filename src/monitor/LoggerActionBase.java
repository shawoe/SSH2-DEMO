package monitor;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class LoggerActionBase extends ActionSupport {
	
	protected LoggerService loggerService;

	public LoggerService getLoggerService() {
		return loggerService;
	}

	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	

}
