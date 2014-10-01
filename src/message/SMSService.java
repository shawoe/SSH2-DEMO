package message;

import java.util.List;
import platform.BaseService;

public class SMSService extends BaseService<SMS> implements ISMSService {
	
	// ����ע������
	protected ISMSDAO SMSDAO;

	// ���Ͷ���Ϣ
	public String send(String SMSReader, String SMSContent) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��д��Ϣ
		SMS SMS = new SMS();
		SMS.setSMSSender(currentUser);
		SMS.setSMSReader(SMSReader);
		SMS.setSMSContent(SMSContent);
		SMS.setSMSRead(false);
		SMS.setSMSTime(referCurrentDate());
		// �������ݿ�
		if(SMSDAO.insert(SMS))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������Ϣ
	public String remove(Integer SMSID) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		SMS SMS = SMSDAO.select(SMSID);
		if (SMS == null) 
			return INPUT;
		if (!SMS.getSMSSender().equals(currentUser))
			return NONE;
		if (SMSDAO.delete(SMSID))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯ�û�����Ϣ
	public List<SMS> findCurrentUser(Integer pageNow, Integer pageSize) {
		if (currentUser!=null && currentUser.trim().length() > 0) {
			List<SMS> SMSList = SMSDAO.selectReader(currentUser);
			List<SMS> SMSPaging = this.paging(SMSList, pageNow, pageSize);
			return SMSPaging;
		}
		return null;
	}
	
	// ��ѯ��ҳ����
	public Integer reterPageCount(Integer pageSize) {
		List<SMS> SMSList = SMSDAO.selectReader(currentUser);
		Integer pageCount = this.count(SMSList,pageSize);
		return pageCount;
	}

	// ��ѯָ������Ϣ
	public SMS find(Integer SMSID) {
		SMS SMS = SMSDAO.select(SMSID);
		return SMS;
	}

	// �༭����Ϣ
	public String edit(Integer SMSID, String SMSReader, String SMSContent) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����Ϣ
		SMS SMS = SMSDAO.select(SMSID);
		if (SMS == null) 
			return INPUT;
		if (!SMS.getSMSSender().equals(currentUser)) 
			return NONE;
		// �༭����Ϣ
		SMS.setSMSReader(SMSReader);
		SMS.setSMSContent(SMSContent);
		SMS.setSMSRead(false);
		SMS.setSMSTime(referCurrentDate());
		// �������ݿ�
		if(SMSDAO.update(SMS))
			return SUCCESS;
		return ERROR;
	}


	// Ĭ������Getter/Setter
	public ISMSDAO getSMSDAO() {
		return SMSDAO;
	}

	public void setSMSDAO(ISMSDAO sMSDAO) {
		SMSDAO = sMSDAO;
	}
	
}
