package message;

public abstract class SMSBase {

	//声明属性
	private Integer smsID;
    private String smsUser;
    private String smsContent;
    private String smsTime;
    private Boolean smsRead;
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

	public String getSmsUser() {
		return smsUser;
	}

	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
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



    
	
}
