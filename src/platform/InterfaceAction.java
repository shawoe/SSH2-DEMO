package platform;

public interface InterfaceAction {

	// 第一页
	public abstract String first() throws Exception;

	// 下一页
	public abstract String next() throws Exception;

	// 上一页
	public abstract String last() throws Exception;

	// 最后一页
	public abstract String end() throws Exception;


}