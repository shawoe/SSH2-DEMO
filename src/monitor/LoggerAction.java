package monitor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class LoggerAction extends LoggerActionBase {
		
	// �鿴����ϵͳ��־
	public String all() throws Exception {
		//ͨ������ҵ���߼����������е���־
		List<Logger> alllogger = loggerService.getAll();
		//�������û�List������request��Χ��
		ServletActionContext.getRequest().setAttribute("alllogger", alllogger);
		return SUCCESS;
	}
}

