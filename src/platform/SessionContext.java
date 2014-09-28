package platform;

import com.opensymphony.xwork2.ActionContext;

public class SessionContext {
	
	// ��ȡ�Ự�ڵ�ֵ
	public static String getSessionValue(String sessionKey) {
		if (ActionContext.getContext().getSession().containsKey(sessionKey)) {
			String sessionValue = ActionContext.getContext().getSession().get(sessionKey).toString();
			return sessionValue;
		}
		return null;
	}

	// ���ûỰ�ڵ�ֵ
	public static boolean setSessionValue(String sessionKey, String sessionValue) {
		ActionContext.getContext().getSession().put(sessionKey, sessionValue);
		if (getSessionValue(sessionKey).equals(sessionValue))
			return true;
		return false;
	}

	// �Ƴ��Ự�ڵ�ֵ
	public static boolean removeSessionValue(String sessionKey) {
		if (ActionContext.getContext().getSession().containsKey(sessionKey)) 
			ActionContext.getContext().getSession().remove(sessionKey);
		ActionContext.getContext().getSession().clear(); 
		if (!ActionContext.getContext().getSession().containsKey(sessionKey))
			return true;
		return false;
	}
	
}
