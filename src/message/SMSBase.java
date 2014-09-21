package message;

public abstract class SMSBase {

	//声明属性
	private Integer smsID;
    private String smsUserName;
    private String smsContent;
    private String smsSendTime;
    private Boolean smsIsRead;
    private String smsSender;
    
    // 默认构造方法
    public SMSBase() {
    }
    
    // 带参构造方法
    public SMSBase(Integer userID) {
        this.setSmsID(userID);
    }
    
    // 属性Getter/Setter
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
