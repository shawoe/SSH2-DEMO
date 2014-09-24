package monitor;

import org.aspectj.lang.JoinPoint;

public class LoggerAdvice extends LoggerAdviceBase{
	
	// 用户登录
	public void login(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("登录前台");

	}
    
	// 退出登录
	public void logout(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("退出前台登录");
	}

    // 发送消息
	public void write(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("发送短消息");
	}
}


