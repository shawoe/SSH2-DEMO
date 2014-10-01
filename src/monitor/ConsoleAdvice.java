package monitor;

import org.aspectj.lang.JoinPoint;
import platform.BaseService;

public class ConsoleAdvice extends BaseService<Logger> {
	
	// 用户登录
	public void login(JoinPoint thisJoinPoint) {
	    System.out.println("登录前台");
	}
    
	// 退出登录
	public void logout(JoinPoint thisJoinPoint) {
	    System.out.println("退出前台登录");
	}

    // 发送消息
	public void write(JoinPoint thisJoinPoint) {
	    System.out.println("发送短消息");
	}

}
