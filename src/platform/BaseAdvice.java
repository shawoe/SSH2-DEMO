package platform;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseAdvice<Template> {
	
	// 设置属性
	protected String currentUser;

	// 默认构造方法
	protected BaseAdvice(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// 设置当前用户
	public boolean setCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// 移除当前用户
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// 获得系统时间
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	

}
