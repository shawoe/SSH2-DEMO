package util;

import com.opensymphony.xwork2.ActionContext;

public class SessionUtil {

	// ��ȡ��ǰ�û�
	public String getSessionUser() {
		if (ActionContext.getContext().getSession().containsKey("currentUser")) {
			String currentUser = ActionContext.getContext().getSession().get("currentUser").toString();
			return currentUser;
		}
		return null;
	}

	// ���õ�ǰ�û�
	public boolean setSessionUser(String userName) {
		ActionContext.getContext().getSession().put("currentUser", userName);
		if (this.getSessionUser().equals(userName))
			return true;
		return false;
	}

	// �Ƴ���ǰ�û�
	public boolean removeSessionUser() {
		if (ActionContext.getContext().getSession().containsKey("currentUser")) 
			ActionContext.getContext().getSession().remove("currentUser");
		ActionContext.getContext().getSession().clear(); 
		if (!ActionContext.getContext().getSession().containsKey("currentUser"))
			return true;
		return false;
	}

	// ��ȡ�����û�
	public String getOnlineUser() {
		if (ActionContext.getContext().getSession().containsKey("onlineUser")) {
			String currentUser = ActionContext.getContext().getSession().get("onlineUser").toString();
			return currentUser;
		}
		return null;
		
	}

	// ���������û�
	public boolean setOnlineUser(String userName) {
		ActionContext.getContext().getSession().put("onlineUser", userName);
		if (this.getOnlineUser().equals(userName))
			return true;
		return false;
	}

	// �Ƴ���ǰ�û�����
	public boolean removeOnlineUser() {
		if (ActionContext.getContext().getSession().containsKey("onlineUser"))
			ActionContext.getContext().getSession().remove("onlineUser");
		if (!ActionContext.getContext().getSession().containsKey("onlineUser"))
			return true;
		return false;
	}
	
}
