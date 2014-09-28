package platform;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BaseService<Template> {
	
	// 设置属性
	protected String currentUser;
	
	// 返回值常量
	public static final String NONE = "none";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login"; 
	
	// 默认构造方法
	protected BaseService(){
		currentUser = SessionContext.getSessionValue("currentUser");
	}
	
	// 设置当前用户
	public boolean setCurrentUser(String userName) {
		return SessionContext.setSessionValue("currentUser", userName);
	}
	
	// 移除当前用户
	public boolean removeCurrentUser() {
		return SessionContext.removeSessionValue("currentUser");
	}
	
	// 获得系统时间
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return simpleDateFormat.format(date);		
	}
	
	// 分页处理
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

	// 页面内容计数
	public Integer count(List<Template> list, Integer pageSize) {
		Integer listSize = list.size();
		Integer count = (Integer) listSize / pageSize;
		if (listSize % pageSize > 0) 
			count++;
		return count;
	}

}
