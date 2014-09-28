package message;

public abstract class SMSBean {

	//��������
	private Integer smsID;
    private String smsReader;
    private String smsContent;
    private String smsTime;
    private Boolean smsRead;
    private String smsSender;
    
    // Ĭ�Ϲ��췽��
    public SMSBean() {
    }
    
    // ���ι��췽��
    public SMSBean(Integer userID) {
        this.setSmsID(userID);
    }
    
    // ����Getter/Setter
	public Integer getSmsID() {
		return smsID;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsTime() {
		return smsTime;
	}

	public void setSmsTime(String smsTime) {
		this.smsTime = smsTime;
	}

	public Boolean getSmsRead() {
		return smsRead;
	}

	public void setSmsRead(Boolean smsRead) {
		this.smsRead = smsRead;
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

	public void setSmsReader(String smsReader) {
		this.smsReader = smsReader;
	}

	public String getSmsReader() {
		return smsReader;
	}



    
	
}
