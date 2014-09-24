package monitor;

public abstract class LoggerBase {

	// 声明属性
	private Integer loggerID;
	private String loggerUser;
	private String loggerAction;
	private String loggerTime;
	private Boolean loggerSuccess;
	private String loggerError;

	// 默认构造方法
	public LoggerBase() {
	}

	// 带参构造方法
	public LoggerBase(Integer loggerID) {
		this.setLoggerID(loggerID);
	}

	// 属性Getter/Setter
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

}
