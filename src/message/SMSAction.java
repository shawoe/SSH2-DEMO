package message;

import java.util.List;
import platform.BaseAction;
import platform.InterfaceAction;

@SuppressWarnings("serial")
public class SMSAction extends BaseAction implements InterfaceAction {
	
	// ��������
	protected Integer userID;
	protected Integer SMSID;
	protected String SMSReader;
	protected String SMSContent;
	protected ISMSService SMSService;
	protected List<SMS> allSMS;

	protected Integer SMSPageNow; 	//��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected Integer SMSPageSize; 	//ÿҳ��ʾ5����¼
	protected Integer SMSPageCount;	//��ҳ��
	
	protected static Integer pageNow = 1; 	//��ʼ��Ϊ1,Ĭ�ϴӵ�һҳ��ʼ��ʾ
	protected static Integer pageSize = 5; 	//ÿҳ��ʾ5����¼
	protected static Integer pageCount = 0;	//��ҳ��
	

	// ����һҳ����Ϣ
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		pageCount = SMSService.reterPageCount(pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ������Ϣ
	public String read() throws Exception {
		if (SMSPageSize==null || SMSPageSize <= 0)
			SMSPageSize = 5;
		if (SMSPageNow==null || SMSPageNow <= 0)
			SMSPageNow = 1;
		pageNow = SMSPageNow;
		pageSize = SMSPageSize;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		pageCount = SMSService.reterPageCount(pageSize);
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// �����һҳ����Ϣ
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = SMSService.reterPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allSMS = SMSService.findCurrentUser(pageNow, pageSize);
		SMSPageNow = pageNow;
		SMSPageSize = pageSize;
		SMSPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ���Ͷ���Ϣ
	public String send() throws Exception {
		// ��������
		if (SMSReader==null || SMSReader.trim().length()==0) {
			this.addFieldError("SMSReader", "�����˲���Ϊ��");
			return INPUT;
		}
		if (SMSContent==null || SMSContent.trim().length()==0) { 
			this.addFieldError("SMSContent", "�������ݲ���Ϊ��");
			return INPUT;
		}
		// ���Ͷ���Ϣ
		String result = SMSService.send(SMSReader,SMSContent);
		return returnAction(result);
	}

	// ɾ������Ϣ
	public String delete() throws Exception {
		// ��������
		if (SMSID==null || SMSID <= 0) {
			this.addFieldError("SMSID", "��ѡ����Ҫɾ���Ķ���Ϣ");
			return INPUT;
		}
		// ɾ������Ϣ
		String result = SMSService.remove(SMSID);
		if (result.equals(INPUT)) {
			this.addFieldError("SMSID", "��ѡ����Ҫɾ���Ķ���Ϣ");
			return INPUT;
		}
		return returnAction(result);
	}

	// �޸Ķ���Ϣ
	public String edit() throws Exception {
		// ��������
		if (SMSID==null || SMSID <= 0) {
			this.addFieldError("SMSID", "��ѡ����Ҫ�޸ĵĶ���Ϣ");
			return INPUT;
		}
		if (SMSReader==null || SMSReader.trim().length()==0) {
			this.addFieldError("SMSReader", "�����˲���Ϊ��");
			return INPUT;
		}
		if (SMSContent==null || SMSContent.trim().length()==0) { 
			this.addFieldError("SMSContent", "�������ݲ���Ϊ��");
			return INPUT;
		}
		// �޸Ķ���Ϣ
		String result = SMSService.edit(SMSID,SMSReader,SMSContent);
		if (result.equals(INPUT)) {
			this.addFieldError("SMSID", "��ѡ����Ҫ�޸ĵĶ���Ϣ");
			return INPUT;
		}
		return returnAction(result);
	}
	
	
	
	// Ĭ������Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public Integer getSMSID() {
		return SMSID;
	}

	public void setSMSID(Integer SMSID) {
		this.SMSID = SMSID;
	}

	public String getSMSReader() {
		return SMSReader;
	}

	public void setSMSReader(String SMSReader) {
		this.SMSReader = SMSReader;
	}

	public String getSMSContent() {
		return SMSContent;
	}

	public void setSMSContent(String SMSContent) {
		this.SMSContent = SMSContent;
	}

	public ISMSService getSMSService() {
		return SMSService;
	}

	public void setSMSService(ISMSService SMSService) {
		this.SMSService = SMSService;
	}

	public List<SMS> getAllSMS() {
		return allSMS;
	}

	public void setAllSMS(List<SMS> allSMS) {
		this.allSMS = allSMS;
	}

	public Integer getSMSPageNow() {
		return SMSPageNow;
	}

	public void setSMSPageNow(Integer SMSPageNow) {
		this.SMSPageNow = SMSPageNow;
	}

	public Integer getSMSPageSize() {
		return SMSPageSize;
	}

	public void setSMSPageSize(Integer SMSPageSize) {
		this.SMSPageSize = SMSPageSize;
	}

	public Integer getSMSPageCount() {
		return SMSPageCount;
	}

	public void setSMSPageCount(Integer SMSPageCount) {
		this.SMSPageCount = SMSPageCount;
	}

	public static Integer getPageNow() {
		return pageNow;
	}

	public static void setPageNow(Integer pageNow) {
		SMSAction.pageNow = pageNow;
	}

	public static Integer getPageSize() {
		return pageSize;
	}

	public static void setPageSize(Integer pageSize) {
		SMSAction.pageSize = pageSize;
	}

	public static Integer getPageCount() {
		return pageCount;
	}

	public static void setPageCount(Integer pageCount) {
		SMSAction.pageCount = pageCount;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
