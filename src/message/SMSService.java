package message;

import java.util.List;



import util.PageUtil;

public class SMSService extends SMSServiceBase implements ISMSService {

	// ���Ͷ���Ϣ
	public String sendSms(String smsReader, String smsContent) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��Ϣ
		sms.setSmsSender(currentUser);
		sms.setSmsUserName(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsIsRead(false);
		sms.setSmsSendTime(simpleDateFormat.format(date));
		// �������ݿ�
		if(smsDAO.insertSms(sms))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������Ϣ
	public String deleteSmsByID(Integer smsID) {
		// ��ȡ��ǰ�û�
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

	// ��ѯ�û�����Ϣ
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
	
	// ��ѯ��ҳ����
	public Integer getSmsPageCount(Integer pageSize) {
		currentUser = sessionUtil.getSessionUser();
		List<SMS> smsList = smsDAO.findSmsByUserName(currentUser);
		PageUtil<SMS> page = new PageUtil<SMS>();
		Integer pageCount = page.pageCount(smsList,pageSize);
		return pageCount;
	}

	// ��ѯָ������Ϣ
	public SMS getSmsByID(Integer smsID) {
		SMS sms = smsDAO.findSmsByID(smsID);
		return sms;
	}

	// �༭����Ϣ
	public String editSms(Integer smsID, String smsReader, String smsContent) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����Ϣ
		sms = smsDAO.findSmsByID(smsID);
		if (sms == null) 
			return INPUT;
		if (!sms.getSmsSender().equals(currentUser)) 
			return NONE;
		// �༭����Ϣ
		sms.setSmsUserName(smsReader);
		sms.setSmsContent(smsContent);
		sms.setSmsIsRead(false);
		sms.setSmsSendTime(simpleDateFormat.format(date));
		// �������ݿ�
		if(smsDAO.updateSms(sms))
			return SUCCESS;
		return ERROR;
	}

}
