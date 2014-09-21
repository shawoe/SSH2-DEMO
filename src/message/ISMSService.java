package message;


import java.util.List;



public interface ISMSService {

	// 发送短消息
	public abstract String sendSms(String smsReader, String smsContent);

	// 删除指定短消息
	public abstract String deleteSmsByID(Integer smsID);

	// 查询用户短消息
	public abstract List<SMS> getSmsByCurrentUser(Integer pageNow, Integer pageSize);

	// 查询分页总数
	public abstract Integer getSmsPageCount(Integer pageSize);

	// 查询指定短消息
	public abstract SMS getSmsByID(Integer smsID);

	// 编辑短消息
	public abstract String editSms(Integer smsID, String smsReader, String smsContent);

}