package monitor;

import java.text.SimpleDateFormat;
import java.util.Date;
import util.SessionUtil;
import member.UserDAO;

public abstract class LoggerServiceBase implements util.ConstantUtil {

	// 设置属性
	protected String currentUser;

	// 依赖注入属性
	protected Logger logger;
	protected LoggerDao loggerDAO;
	protected UserDAO userDAO;
	protected Date date;
	protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	protected SessionUtil sessionUtil;
	

	// 属性Getter/Setter
	public LoggerDao getLoggerDAO() {
		return loggerDAO;
	}

	public void setLoggerDAO(LoggerDao loggerDAO) {
		this.loggerDAO = loggerDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public SessionUtil getSessionUtil() {
		return sessionUtil;
	}

	public void setSessionUtil(SessionUtil sessionUtil) {
		this.sessionUtil = sessionUtil;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
