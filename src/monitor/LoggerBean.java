package monitor;

public abstract class LoggerBean {

	// 声明属性
	private Integer loggerID;
	private String loggerOperator;
	private String loggerAction;
	private String loggerTime;
	private Boolean loggerSuccess;
	private String loggerError;

	// 默认构造方法
	public LoggerBean() {
	}

	// 带参构造方法
	public LoggerBean(Integer loggerID) {
		this.setLoggerID(loggerID);
	}

	// 属性Getter/Setter
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

	public String getLoggerTime() {
		return loggerTime;
	}

	public void setLoggerTime(String loggerTime) {
		this.loggerTime = loggerTime;
	}

	public Boolean getLoggerSuccess() {
		return loggerSuccess;
	}

	public void setLoggerSuccess(Boolean loggerSuccess) {
		this.loggerSuccess = loggerSuccess;
	}

	public String getLoggerError() {
		return loggerError;
	}

	public void setLoggerError(String loggerError) {
		this.loggerError = loggerError;
	}

	public void setLoggerOperator(String loggerOperator) {
		this.loggerOperator = loggerOperator;
	}

	public String getLoggerOperator() {
		return loggerOperator;
	}

}
