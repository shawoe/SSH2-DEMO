package platform;

import java.util.List;

public interface InterfaceService<Template> {

	// 返回值常量
	public static final String NONE = "none";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login";

	// 设置当前用户
	public abstract boolean recordCurrentUser(String userName);

	// 移除当前用户
	public abstract boolean removeCurrentUser();

	// 获得系统时间
	public abstract String referCurrentDate();

	// 分页处理
	public abstract List<Template> paging(List<Template> list, Integer pageNow, Integer pageSize);

	// 页面内容计数
	public abstract Integer count(List<Template> list, Integer pageSize);

}