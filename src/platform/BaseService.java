package platform;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BaseService<Template> {
	
	// ��������
	protected String currentUser;
	
	// ����ֵ����
	public static final String NONE = "none";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login"; 
	
	// Ĭ�Ϲ��췽��
	protected BaseService(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// ���õ�ǰ�û�
	public boolean setCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// �Ƴ���ǰ�û�
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// ���ϵͳʱ��
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	
	// ��ҳ����
	public List<Template> paging(List<Template> list, Integer pageNow, Integer pageSize) {
		Integer first = pageSize * (pageNow - 1);
		Integer end = pageSize * pageNow;
		Integer listSize = list.size();
		Integer currentPageSize = listSize - first;
		if (currentPageSize >= pageSize) {
			List<Template> partList = list.subList(first, end);
			return partList;
		} else {
			List<Template> partList = list.subList(first, listSize);
			return partList;
		}
	}

	// ҳ�����ݼ���
	public Integer count(List<Template> list, Integer pageSize) {
		Integer listSize = list.size();
		Integer count = (Integer) listSize / pageSize;
		if (listSize % pageSize > 0) 
			count++;
		return count;
	}

}
