package monitor;

public abstract class LoggerAdviceBase {
	
	// ��������
	protected LoggerService loggerService;

	// ����Getter/Setter
	public LoggerService getLoggerService() {
		return loggerService;
	}
	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}

}
