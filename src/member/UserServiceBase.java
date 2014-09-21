package member;

import java.text.SimpleDateFormat;
import java.util.Date;
import util.SessionUtil;

public abstract class UserServiceBase {

	// 设置属性
	protected String currentUser;
	
	
	// 依赖注入属性
	protected User user;
	protected UserDAO userDAO;
	protected Date date;
	protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	protected SessionUtil sessionUtil;

	// 返回值常量
	public static final String SUCCESS = "success";
	public static final String NONE = "none";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login"; 
	

	// 默认属性Getter/Setter
	public String getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
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

}
