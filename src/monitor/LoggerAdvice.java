package monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import platform.BaseService;

public class LoggerAdvice extends BaseService<Logger>{
	
	// 声明属性
	protected ILoggerService loggerService;

	// 属性Getter/Setter
	public ILoggerService getLoggerService() {
		return loggerService;
	}
	
	public void setLoggerService(ILoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	// 用户登录
	public void login(JoinPoint thisJoinPoint) {
	    loggerService.send("登录前台");
	}
    
	// 退出登录
	public void logout(JoinPoint thisJoinPoint) {
	    loggerService.send("退出前台登录");
	}

    // 发送消息
	public void write(JoinPoint thisJoinPoint) {
	    loggerService.send("发送短消息");
	}
	
	// 计时器
	public Object timer(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		String clazzName = thisJoinPoint.getTarget().getClass().getName();
		String methodName = thisJoinPoint.getSignature().getName();

		// 计时并调用目标函数
		long start = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		long time = System.currentTimeMillis() - start;

		// 输出计时信息
		System.out.println("北京时间:" + new java.util.Date() + " - 操作计时：" + time + "ms - 执行操作：" + clazzName + "." + methodName + "()");
		
		// 输出目标对象的参数
		System.out.println(thisJoinPoint.getArgs().toString());
		return result;
	}
}


