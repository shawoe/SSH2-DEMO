package message;

import java.util.List;
import api.InterfaceServiceMessage;
import util.PageUtil;

public class SMSService extends SMSServiceBase implements InterfaceServiceMessage<SMS> {

	// ���Ͷ���Ϣ
	public String send(String smsReader, String smsContent) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��Ϣ
		sms.setSmsSender(currentUser);
		sms.setSmsUser(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(simpleDateFormat.format(date));
		// �������ݿ�
		if(smsDAO.insert(sms))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������Ϣ
	public String delete(Integer smsID) {
		// ��ȡ��ǰ�û�
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

	// ��ѯ�û�����Ϣ
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
	
	// ��ѯ��ҳ����
	public Integer getPageCount(Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		List<SMS> smsList = smsDAO.findDataByUserName(currentUser);
		PageUtil<SMS> page = new PageUtil<SMS>();
		Integer pageCount = page.pageCount(smsList,pageSize);
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
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����Ϣ
		sms = smsDAO.find(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// �༭����Ϣ
		sms.setSmsUser(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsRead(false);
		sms.setSmsTime(simpleDateFormat.format(date));
		// �������ݿ�
		if(smsDAO.update(sms))
			return SUCCESS;
		return ERROR;
	}

}
