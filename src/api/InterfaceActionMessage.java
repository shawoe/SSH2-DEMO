package api;

public interface InterfaceActionMessage {

	// 读信息
	public abstract String read() throws Exception;

	// 读第一页信息
	public abstract String readFirst() throws Exception;

	// 读下一页信息
	public abstract String readNext() throws Exception;

	// 读上一页信息
	public abstract String readLast() throws Exception;

	// 读最后一页信息
	public abstract String readEnd() throws Exception;

	// 发送信息
	public abstract String send() throws Exception;

	// 删除信息
	public abstract String delete() throws Exception;

	// 修改信息
	public abstract String edit() throws Exception;

}