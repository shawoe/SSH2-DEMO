package member;

public abstract class FansBean {
	
	// 设置用户属性
	private Integer fansID;
	private String fansFollwer;
	private String fansStar;
	private String fansTime;
	private Boolean fansMutual;
	
	// 默认构造方法
	public FansBean() {
	}
	
	// 带参构造方法
	public FansBean(Integer fansID) {
		this.setFansID(fansID);
	}

	// 默认属性Getter/Setter
	public Integer getFansID() {
		return fansID;
	}

	public void setFansID(Integer fansID) {
		this.fansID = fansID;
	}

	public String getFansFollwer() {
		return fansFollwer;
	}

	public void setFansFollwer(String fansFollwer) {
		this.fansFollwer = fansFollwer;
	}

	public String getFansStar() {
		return fansStar;
	}

	public void setFansStar(String fansStar) {
		this.fansStar = fansStar;
	}

	public String getFansTime() {
		return fansTime;
	}

	public void setFansTime(String fansTime) {
		this.fansTime = fansTime;
	}

	public Boolean getFansMutual() {
		return fansMutual;
	}

	public void setFansMutual(Boolean fansMutual) {
		this.fansMutual = fansMutual;
	}




}