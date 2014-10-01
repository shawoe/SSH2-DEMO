package platform;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
	// ��������
	public boolean check(String[] argsName, String[] argsField, String... args) { 		
		int i = 0;
		boolean input = false;
        for (String arg : args) {  
        	if (arg == null || arg.trim().length() == 0) {
        		this.addFieldError(argsField[i], argsName[i] + "����Ϊ��");
        		input = true;
        	}
        	i++;
        }  
        return input;
    }  

	// ������Ϣ
	public String returnAction(String result){
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�����¼");
		}
		if (result.equals(NONE)) {
			this.addActionError("�û������ڻ�����Ȩִ�д˲���");
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�����ɹ�");
		}
		if (result.equals(ERROR)) {
			this.addActionError("����ʧ��");
		}
		return result;
	}
	
	
}
