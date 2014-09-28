package member;

public abstract class FriendBean {
	
	// 设置用户属性
	private Integer friendID;
	private String friendUser;
	private String friendTarget;
	private String friendTime;
	private Boolean friendMutual;
	
	// 默认构造方法
	public FriendBean() {
	}
	
	// 带参构造方法
	public FriendBean(Integer friendID) {
		this.setFriendID(friendID);
	}

	// 默认属性Getter/Setter
	public Integer getFriendID() {
		return friendID;
	}

	public void setFriendID(Integer friendID) {
		this.friendID = friendID;
	}

	public String getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(String friendUser) {
		this.friendUser = friendUser;
	}

	public String getFriendTarget() {
		return friendTarget;
	}

	public void setFriendTarget(String friendTarget) {
		this.friendTarget = friendTarget;
	}

	public String getFriendTime() {
		return friendTime;
	}

	public void setFriendTime(String friendTime) {
		this.friendTime = friendTime;
	}

	public Boolean getFriendMutual() {
		return friendMutual;
	}

	public void setFriendMutual(Boolean friendMutual) {
		this.friendMutual = friendMutual;
	}




}