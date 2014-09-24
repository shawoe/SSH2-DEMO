package monitor;

public abstract class LoggerBase {

	// ��������
	private Integer loggerID;
	private String loggerUser;
	private String loggerAction;
	private String loggerTime;
	private Boolean loggerSuccess;
	private String loggerError;

	// Ĭ�Ϲ��췽��
	public LoggerBase() {
	}

	// ���ι��췽��
	public LoggerBase(Integer loggerID) {
		this.setLoggerID(loggerID);
	}

	// ����Getter/Setter
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
