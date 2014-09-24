package monitor;

import org.aspectj.lang.JoinPoint;

public class LoggerAdvice extends LoggerAdviceBase{
	
	// �û���¼
	public void login(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("��¼ǰ̨");

	}
    
	// �˳���¼
	public void logout(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("�˳�ǰ̨��¼");
	}

    // ������Ϣ
	public void write(JoinPoint thisJoinPoint) {
	    System.out.println(loggerService);
	    loggerService.send("���Ͷ���Ϣ");
	}
}


