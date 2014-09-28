package platform;

import com.opensymphony.xwork2.ActionContext;

public class SessionContext {
	
	// 获取会话内的值
	public static String getSessionValue(String sessionKey) {
		if (ActionContext.getContext().getSession().containsKey(sessionKey)) {
			String sessionValue = ActionContext.getContext().getSession().get(sessionKey).toString();
			return sessionValue;
		}
		return null;
	}

	// 设置会话内的值
	public static boolean setSessionValue(String sessionKey, String sessionValue) {
		ActionContext.getContext().getSession().put(sessionKey, sessionValue);
		if (getSessionValue(sessionKey).equals(sessionValue))
			return true;
		return false;
	}

	// 移除会话内的值
	public static boolean removeSessionValue(String sessionKey) {
		if (ActionContext.getContext().getSession().containsKey(sessionKey)) 
			ActionContext.getContext().getSession().remove(sessionKey);
		ActionContext.getContext().getSession().clear(); 
		if (!ActionContext.getContext().getSession().containsKey(sessionKey))
			return true;
		return false;
	}
	
}
