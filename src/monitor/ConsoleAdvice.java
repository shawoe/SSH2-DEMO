package monitor;

import org.aspectj.lang.JoinPoint;
import platform.BaseService;

public class ConsoleAdvice extends BaseService<Logger> {
	
	// �û���¼
	public void login(JoinPoint thisJoinPoint) {
	    System.out.println("��¼ǰ̨");
	}
    
	// �˳���¼
	public void logout(JoinPoint thisJoinPoint) {
	    System.out.println("�˳�ǰ̨��¼");
	}

    // ������Ϣ
	public void write(JoinPoint thisJoinPoint) {
	    System.out.println("���Ͷ���Ϣ");
	}

}
