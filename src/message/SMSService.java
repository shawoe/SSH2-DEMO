package message;

import java.util.List;
import member.UserDAO;
import platform.BaseService;
import platform.InterfaceServiceMessage;

public class SMSService extends BaseService<SMS> implements InterfaceServiceMessage<SMS> {
	
	// 依赖注入属性
	protected SMSDAO smsDAO;
	protected UserDAO userDAO;

	// 发送短消息
	public String send(String smsReader, String smsContent) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 填写信息
		SMS sms = new SMS();
		sms.setSmsSender(currentUser);
		sms.setSmsReader(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(getCurrentDate());
		// 存至数据库
		if(smsDAO.insert(sms))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定短消息
	public String delete(Integer smsID) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		SMS sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser))
			return NONE;
		if (smsDAO.delete(smsID))
			return SUCCESS;
		return ERROR;
	}

	// 查询用户短消息
	public List<SMS> getUserMessage(Integer pageNow, Integer pageSize) {
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> smsList = smsDAO.findUserData(currentUser);
			List<SMS> smsPaging = this.paging(smsList, pageNow, pageSize);
			return smsPaging;
		}
		return null;
	}
	
	// 查询分页总数
	public Integer getPageCount(Integer pageSize) {
		List<SMS> smsList = smsDAO.findUserData(currentUser);
		Integer pageCount = this.count(smsList,pageSize);
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
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取短消息
		SMS sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// 编辑短消息
		sms.setSmsReader(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(getCurrentDate());
		// 存至数据库
		if(smsDAO.update(sms))
			return SUCCESS;
		return ERROR;
	}

	public List<SMS> getAll(Integer pageNow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	// 默认属性Getter/Setter
	public SMSDAO getSmsDAO() {
		return smsDAO;
	}

	public void setSmsDAO(SMSDAO smsDAO) {
		this.smsDAO = smsDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
