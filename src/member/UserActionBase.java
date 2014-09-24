package member;

import java.io.File;
import java.util.List;
import util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public abstract class UserActionBase extends ActionSupport {
	
	// 设置属性
	protected String userName;  
	protected String userPassword;
	protected String oldUserPassword;
	protected String newUserPassword;
	protected String passwordConfirm;
	protected String userAvatars;
	protected String userSex;
	protected String userBirth;
	protected String userEmail;    
	
	protected User user;
	protected UserService userService;
	protected List<User> allUsers;
	
	protected File avatarsImage; 				//上传的头像文件
	protected String avatarsImageFileName; 		//头像文件名称
	protected String avatarsImageContentType; 	//头像文件类型
	
	// 声明静态属性
	protected PageUtil<User> page = new PageUtil<User>();
	

	// 默认属性Getter/Setter
	public User getUser() {
		return user;
	}
	public void setUser(member.User user) {
		this.user = user;
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
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public PageUtil<User> getPage() {
		return page;
	}
	public void setPage(PageUtil<User> page) {
		this.page = page;
	}
	public List<User> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
	public String getOldUserPassword() {
		return oldUserPassword;
	}
	public void setOldUserPassword(String oldUserPassword) {
		this.oldUserPassword = oldUserPassword;
	}
	public String getNewUserPassword() {
		return newUserPassword;
	}
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	public File getAvatarsImage() {
		return avatarsImage;
	}
	public void setAvatarsImage(File avatarsImage) {
		this.avatarsImage = avatarsImage;
	}
	public String getUserAvatars() {
		return userAvatars;
	}
	public void setUserAvatars(String userAvatars) {
		this.userAvatars = userAvatars;
	}
	public String getAvatarsImageFileName() {
		return avatarsImageFileName;
	}
	public void setAvatarsImageFileName(String avatarsImageFileName) {
		this.avatarsImageFileName = avatarsImageFileName;
	}
	public String getAvatarsImageContentType() {
		return avatarsImageContentType;
	}
	public void setAvatarsImageContentType(String avatarsImageContentType) {
		this.avatarsImageContentType = avatarsImageContentType;
	}


	
}
