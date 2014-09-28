package monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import platform.BaseAdvice;

public class LoggerAdvice extends BaseAdvice<Logger>{
	
	// ��������
	protected LoggerService loggerService;

	// ����Getter/Setter
	public LoggerService getLoggerService() {
		return loggerService;
	}
	
	public void setLoggerService(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	// �û���¼
	public void login(JoinPoint thisJoinPoint) {
	    loggerService.send("��¼ǰ̨");
	}
    
	// �˳���¼
	public void logout(JoinPoint thisJoinPoint) {
	    loggerService.send("�˳�ǰ̨��¼");
	}

    // ������Ϣ
	public void write(JoinPoint thisJoinPoint) {
	    loggerService.send("���Ͷ���Ϣ");
	}
	
	// ��ʱ��
	public Object timer(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		String clazzName = thisJoinPoint.getTarget().getClass().getName();
		String methodName = thisJoinPoint.getSignature().getName();

		// ��ʱ������Ŀ�꺯��
		long start = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		long time = System.currentTimeMillis() - start;

		// �����ʱ��Ϣ
		System.out.println("����ʱ��:" + new java.util.Date() + " - ������ʱ��" + time + "ms - ִ�в�����" + clazzName + "." + methodName + "()");
		
		// ���Ŀ�����Ĳ���
		System.out.println(thisJoinPoint.getArgs().toString());
		return result;
	}
}


