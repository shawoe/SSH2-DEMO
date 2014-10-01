package message;

import java.util.List;

import platform.InterfaceService;

public interface ISMSService extends InterfaceService<SMS> {

	// 发送短消息
	public abstract String send(String SMSReader, String SMSContent);

	// 删除指定短消息
	public abstract String remove(Integer SMSID);

	// 查询用户短消息
	public abstract List<SMS> findCurrentUser(Integer pageNow, Integer pageSize);

	// 查询分页总数
	public abstract Integer reterPageCount(Integer pageSize);

	// 查询指定短消息
	public abstract SMS find(Integer SMSID);

	// 编辑短消息
	public abstract String edit(Integer SMSID, String SMSReader, String SMSContent);

}