package member;

public abstract class UserBase {

	// �����û�����
	private Integer userID;
	private String userName;
	private String userPassword;
	private Boolean userSex;
	private String userBirth;
	private String userEmail;
	private Boolean userOnline;
	private String userAvatars;

	// Ĭ�Ϲ��췽��
	public UserBase() {
	}

	// ���ι��췽��
	public UserBase(Integer userID) {
		this.setUserID(userID);
	}

	// Ĭ������Getter/Setter
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getUserSex() {
		return userSex;
	}

	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Boolean getUserOnline() {
		return userOnline;
	}

	public void setUserOnline(Boolean userOnline) {
		this.userOnline = userOnline;
	}

	public String getUserAvatars() {
		return userAvatars;
	}

	public void setUserAvatars(String userAvatars) {
		this.userAvatars = userAvatars;
	}


}