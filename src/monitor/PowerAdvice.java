package monitor;

import platform.BaseAdvice;

public class PowerAdvice extends BaseAdvice<Logger>{
	
	// ��¼���
	public boolean checkLogin() {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return false;
		return true;
	}
}
