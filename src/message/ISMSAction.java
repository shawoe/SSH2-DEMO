package message;


public interface ISMSAction {

	// 读第一页短消息
	public abstract String readFirstSms() throws Exception;

	// 读短消息
	public abstract String readSms() throws Exception;

	// 读下一页短消息
	public abstract String readNextSms() throws Exception;

	// 读上一页短消息
	public abstract String readLastSms() throws Exception;

	// 读最后一页短消息
	public abstract String readEndSms() throws Exception;

	// 发送短消息
	public abstract String sendSms() throws Exception;

	// 删除短消息
	public abstract String deleteSms() throws Exception;

	// 修改短消息
	public abstract String editSms() throws Exception;

}