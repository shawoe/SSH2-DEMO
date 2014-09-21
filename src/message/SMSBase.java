package message;

public abstract class SMSBase {

	//��������
	private Integer smsID;
    private String smsUserName;
    private String smsContent;
    private String smsSendTime;
    private Boolean smsIsRead;
    private String smsSender;
    
    // Ĭ�Ϲ��췽��
    public SMSBase() {
    }
    
    // ���ι��췽��
    public SMSBase(Integer userID) {
        this.setSmsID(userID);
    }
    
    // ����Getter/Setter
	public Integer getSmsID() {
		return smsID;
	}

	public String getSmsUserName() {
		return smsUserName;
	}

	public void setSmsUserName(String smsUserName) {
		this.smsUserName = smsUserName;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsSendTime() {
		return smsSendTime;
	}

	public void setSmsSendTime(String smsSendTime) {
		this.smsSendTime = smsSendTime;
	}

	public Boolean getSmsIsRead() {
		return smsIsRead;
	}

	public void setSmsIsRead(Boolean smsIsRead) {
		this.smsIsRead = smsIsRead;
	}

	public String getSmsSender() {
		return smsSender;
	}

	public void setSmsSender(String smsSender) {
		this.smsSender = smsSender;
	}

	public void setSmsID(Integer smsID) {
		this.smsID = smsID;
	}

    
	
}
