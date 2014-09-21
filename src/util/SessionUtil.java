package util;

import com.opensymphony.xwork2.ActionContext;

public class SessionUtil {

	// 获取当前用户
	public String getSessionUser() {
		if (ActionContext.getContext().getSession().containsKey("currentUser")) {
			String currentUser = ActionContext.getContext().getSession().get("currentUser").toString();
			return currentUser;
		}
		return null;
	}

	// 设置当前用户
	public boolean setSessionUser(String userName) {
		ActionContext.getContext().getSession().put("currentUser", userName);
		if (this.getSessionUser().equals(userName))
			return true;
		return false;
	}

	// 移除当前用户
	public boolean removeSessionUser() {
		if (ActionContext.getContext().getSession().containsKey("currentUser")) 
			ActionContext.getContext().getSession().remove("currentUser");
		ActionContext.getContext().getSession().clear(); 
		if (!ActionContext.getContext().getSession().containsKey("currentUser"))
			return true;
		return false;
	}

	// 获取在线用户
	public String getOnlineUser() {
		if (ActionContext.getContext().getSession().containsKey("onlineUser")) {
			String currentUser = ActionContext.getContext().getSession().get("onlineUser").toString();
			return currentUser;
		}
		return null;
		
	}

	// 设置在线用户
	public boolean setOnlineUser(String userName) {
		ActionContext.getContext().getSession().put("onlineUser", userName);
		if (this.getOnlineUser().equals(userName))
			return true;
		return false;
	}

	// 移除当前用户在线
	public boolean removeOnlineUser() {
		if (ActionContext.getContext().getSession().containsKey("onlineUser"))
			ActionContext.getContext().getSession().remove("onlineUser");
		if (!ActionContext.getContext().getSession().containsKey("onlineUser"))
			return true;
		return false;
	}
	
}
