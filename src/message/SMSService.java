package message;

import java.util.List;
import api.InterfaceServiceMessage;
import util.PageUtil;

public class SMSService extends SMSServiceBase implements InterfaceServiceMessage<SMS> {

	// 发送短消息
	public String send(String smsReader, String smsContent) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写信息
		sms.setSmsSender(currentUser);
		sms.setSmsUser(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(simpleDateFormat.format(date));
		// 存至数据库
		if(smsDAO.insert(sms))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定短消息
	public String delete(Integer smsID) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser))
			return NONE;
		if (smsDAO.delete(smsID))
			return SUCCESS;
		return ERROR;
	}

	// 查询用户短消息
	public List<SMS> getMessageByUserName(Integer pageNow, Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> smsList = smsDAO.findDataByUserName(currentUser);
			PageUtil<SMS> page = new PageUtil<SMS>();
			List<SMS> smsPartPage = page.partPage(smsList, pageNow, pageSize);
			return smsPartPage;
		}
		return null;
	}
	
	// 查询分页总数
	public Integer getPageCount(Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		List<SMS> smsList = smsDAO.findDataByUserName(currentUser);
		PageUtil<SMS> page = new PageUtil<SMS>();
		Integer pageCount = page.pageCount(smsList,pageSize);
		return pageCount;
	}

	// 查询指定短消息
	public SMS get(Integer smsID) {
		SMS sms = smsDAO.find(smsID);
		return sms;
	}

	// 编辑短消息
	public String edit(Integer smsID, String smsReader, String smsContent) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取短消息
		sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// 编辑短消息
		sms.setSmsUser(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(simpleDateFormat.format(date));
		// 存至数据库
		if(smsDAO.update(sms))
			return SUCCESS;
		return ERROR;
	}

}
