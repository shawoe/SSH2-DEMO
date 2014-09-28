package platform;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseAdvice<Template> {
	
	// ��������
	protected String currentUser;

	// Ĭ�Ϲ��췽��
	protected BaseAdvice(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// ���õ�ǰ�û�
	public boolean setCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// �Ƴ���ǰ�û�
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// ���ϵͳʱ��
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	

}
