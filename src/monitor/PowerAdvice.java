package monitor;

import platform.BaseService;

public class PowerAdvice extends BaseService<Logger>{
	
	// 登录检查
	public boolean checkLogin() {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return false;
		return true;
	}
}
