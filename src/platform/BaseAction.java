package platform;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
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
