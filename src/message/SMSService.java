package message;

import java.util.List;
import member.UserDAO;
import platform.BaseService;
import platform.InterfaceServiceMessage;

public class SMSService extends BaseService<SMS> implements InterfaceServiceMessage<SMS> {
	
	// ����ע������
	protected SMSDAO smsDAO;
	protected UserDAO userDAO;

	// ���Ͷ���Ϣ
	public String send(String smsReader, String smsContent) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��Ϣ
		SMS sms = new SMS();
		sms.setSmsSender(currentUser);
		sms.setSmsReader(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(getCurrentDate());
		// �������ݿ�
		if(smsDAO.insert(sms))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������Ϣ
	public String delete(Integer smsID) {
		// ��ȡ��ǰ�û�
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

	// ��ѯ�û�����Ϣ
	public List<SMS> getUserMessage(Integer pageNow, Integer pageSize) {
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> smsList = smsDAO.findUserData(currentUser);
			List<SMS> smsPaging = this.paging(smsList, pageNow, pageSize);
			return smsPaging;
		}
		return null;
	}
	
	// ��ѯ��ҳ����
	public Integer getPageCount(Integer pageSize) {
		List<SMS> smsList = smsDAO.findUserData(currentUser);
		Integer pageCount = this.count(smsList,pageSize);
		return pageCount;
	}

	// ��ѯָ������Ϣ
	public SMS get(Integer smsID) {
		SMS sms = smsDAO.find(smsID);
		return sms;
	}

	// �༭����Ϣ
	public String edit(Integer smsID, String smsReader, String smsContent) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����Ϣ
		SMS sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// �༭����Ϣ
		sms.setSmsReader(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(getCurrentDate());
		// �������ݿ�
		if(smsDAO.update(sms))
			return SUCCESS;
		return ERROR;
	}

	public List<SMS> getAll(Integer pageNow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	// Ĭ������Getter/Setter
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
