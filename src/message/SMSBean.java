package message;

public abstract class SMSBean {

	//��������
	private Integer SMSID;
    private String SMSReader;
    private String SMSContent;
    private String SMSTime;
    private Boolean SMSRead;
    private String SMSSender;
    
    // Ĭ�Ϲ��췽��
    public SMSBean() {
    }
    
    // ���ι��췽��
    public SMSBean(Integer userID) {
        this.setSMSID(userID);
    }
    
    // ����Getter/Setter
	public Integer getSMSID() {
		return SMSID;
	}

	public String getSMSContent() {
		return SMSContent;
	}

	public void setSMSContent(String SMSContent) {
		this.SMSContent = SMSContent;
	}

	public String getSMSTime() {
		return SMSTime;
	}

	public void setSMSTime(String SMSTime) {
		this.SMSTime = SMSTime;
	}

	public Boolean getSMSRead() {
		return SMSRead;
	}

	public void setSMSRead(Boolean SMSRead) {
		this.SMSRead = SMSRead;
	}

	public String getSMSSender() {
		return SMSSender;
	}

	public void setSMSSender(String SMSSender) {
		this.SMSSender = SMSSender;
	}

	public void setSMSID(Integer SMSID) {
		this.SMSID = SMSID;
	}

	public void setSMSReader(String SMSReader) {
		this.SMSReader = SMSReader;
	}

	public String getSMSReader() {
		return SMSReader;
	}



    
	
}
