package message;

import api.InterfaceActionMessage;

@SuppressWarnings("serial")
public class SMSAction extends SMSActionBase implements InterfaceActionMessage {

	// ����һҳ����Ϣ
	public String readFirst() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		pageNow = 1;
		allSMS = smsService.getMessageByUserName(pageNow, pageSize);
		pageCount = smsService.getPageCount(pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ������Ϣ
	public String read() throws Exception {
		if (smsPageSize==null || smsPageSize <= 0)
			smsPageSize = 5;
		if (smsPageNow==null || smsPageNow <= 0)
			smsPageNow = 1;
		pageNow = smsPageNow;
		pageSize = smsPageSize;
		allSMS = smsService.getMessageByUserName(pageNow, pageSize);
		pageCount = smsService.getPageCount(pageSize);
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readNext() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageNow < pageCount) 
			pageNow++;
		allSMS = smsService.getMessageByUserName(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ����һҳ����Ϣ
	public String readLast() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageNow > 1) 
			pageNow--;
		allSMS = smsService.getMessageByUserName(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// �����һҳ����Ϣ
	public String readEnd() throws Exception {
		if (pageSize==null || pageSize <= 0)
			pageSize = 5;
		if (pageNow==null || pageNow <= 0)
			pageNow = 1;
		if (pageCount==null || pageCount <= 0)
			pageCount = smsService.getPageCount(pageSize);
		if (pageCount > 1) 
			pageNow = pageCount;
		allSMS = smsService.getMessageByUserName(pageNow, pageSize);
		smsPageNow = pageNow;
		smsPageSize = pageSize;
		smsPageCount = pageCount;
		return SUCCESS;	
	}
	
	// ���Ͷ���Ϣ
	public String send() throws Exception {
		// ��������
		if (smsReader==null || smsReader.trim().length()==0) {
			this.addFieldError("smsReader", "�����˲���Ϊ��");
			return INPUT;
		}
		if (smsContent==null || smsContent.trim().length()==0) { 
			this.addFieldError("smsContent", "�������ݲ���Ϊ��");
			return INPUT;
		}
		// ���Ͷ���Ϣ
		String result = smsService.send(smsReader,smsContent);
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("�û�������");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("���Ͷ���Ϣ�ɹ�");
			return SUCCESS;
		}
		this.addActionError("���Ͷ���Ϣʧ��");
		return ERROR;
	}

	// ɾ������Ϣ
	public String delete() throws Exception {
		// ��������
		if (smsID==null || smsID <= 0) {
			this.addFieldError("smsID", "��ѡ����Ҫɾ���Ķ���Ϣ");
			return INPUT;
		}
		// ɾ������Ϣ
		String result = smsService.delete(smsID);
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "��ѡ����Ҫɾ���Ķ���Ϣ");
			return INPUT;
		}
		if (result.equals(NONE)) {
			this.addActionError("����Ȩɾ������Ϣ");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("ɾ������Ϣ�ɹ�");
			return SUCCESS;
		}
		this.addActionError("ɾ������Ϣʧ��");
		return ERROR;
	}

	// �޸Ķ���Ϣ
	public String edit() throws Exception {
		// ��������
		if (smsID==null || smsID <= 0) {
			this.addFieldError("smsID", "��ѡ����Ҫ�޸ĵĶ���Ϣ");
			return INPUT;
		}
		if (smsReader==null || smsReader.trim().length()==0) {
			this.addFieldError("smsReader", "�����˲���Ϊ��");
			return INPUT;
		}
		if (smsContent==null || smsContent.trim().length()==0) { 
			this.addFieldError("smsContent", "�������ݲ���Ϊ��");
			return INPUT;
		}
		// �޸Ķ���Ϣ
		String result = smsService.edit(smsID,smsReader,smsContent);
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("smsID", "��ѡ����Ҫ�޸ĵĶ���Ϣ");
			return INPUT;
		}
		if (result.equals(NONE)) {
			this.addActionError("����Ȩ�޸Ĵ���Ϣ");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�޸Ķ���Ϣ�ɹ�");
			return SUCCESS;
		}
		this.addActionError("�޸Ķ���Ϣʧ��");
		return ERROR;
	}
	
}
