package message;

import java.util.List;



import util.PageUtil;

public class SMSService extends SMSServiceBase implements ISMSService {

	// 发送短消息
	public String sendSms(String smsReader, String smsContent) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写信息
		sms.setSmsSender(currentUser);
		sms.setSmsUserName(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsIsRead(false);
		sms.setSmsSendTime(simpleDateFormat.format(date));
		// 存至数据库
		if(smsDAO.insertSms(sms))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定短消息
	public String deleteSmsByID(Integer smsID) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		sms = smsDAO.findSmsByID(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser))
			return NONE;
		if (smsDAO.deleteSms(smsID))
			return SUCCESS;
		return ERROR;
	}

	// 查询用户短消息
	public List<SMS> getSmsByCurrentUser(Integer pageNow, Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> smsList = smsDAO.findSmsByUserName(currentUser);
			PageUtil<SMS> page = new PageUtil<SMS>();
			List<SMS> smsPartPage = page.partPage(smsList, pageNow, pageSize);
			return smsPartPage;
		}
		return null;
	}
	
	// 查询分页总数
	public Integer getSmsPageCount(Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		List<SMS> smsList = smsDAO.findSmsByUserName(currentUser);
		PageUtil<SMS> page = new PageUtil<SMS>();
		Integer pageCount = page.pageCount(smsList,pageSize);
		return pageCount;
	}

	// 查询指定短消息
	public SMS getSmsByID(Integer smsID) {
		SMS sms = smsDAO.findSmsByID(smsID);
		return sms;
	}

	// 编辑短消息
	public String editSms(Integer smsID, String smsReader, String smsContent) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取短消息
		sms = smsDAO.findSmsByID(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// 编辑短消息
		sms.setSmsUserName(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsIsRead(false);
		sms.setSmsSendTime(simpleDateFormat.format(date));
		// 存至数据库
		if(smsDAO.updateSms(sms))
			return SUCCESS;
		return ERROR;
	}

}
