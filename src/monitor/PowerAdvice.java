package monitor;

import platform.BaseService;

public class PowerAdvice extends BaseService<Logger>{
	
	// ��¼���
	public boolean checkLogin() {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return false;
		return true;
	}
}
