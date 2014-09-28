package member;

import java.io.File;
import java.util.List;

import platform.BaseAction;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {
	
	// 设置属性
	protected String userName;  
	protected String userPassword;
	protected String oldUserPassword;
	protected String newUserPassword;
	protected String passwordConfirm;
	protected String userAvatar;
	protected String userSex;
	protected String userBirth;
	protected String userEmail;    
	
	protected User user;
	protected UserService userService;
	protected List<User> allUsers;
	
	protected File avatarsImage; 				//上传的头像文件
	protected String avatarsImageFileName; 		//头像文件名称
	protected String avatarsImageContentType; 	//头像文件类型
	

	// 用户登录
	public String login() throws Exception {
		// 参数检验
		if (userName == null || userName.trim().length() == 0) {
			this.addFieldError("userName", "用户名不能为空");
			return INPUT;
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "密码不能为空");
			return INPUT;
		}
		// 用户登录
		String result = userService.login(userName, userPassword);
		if (result.equals(NONE)) {
			this.addFieldError("userName", "用户不存在");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "密码输入有误，请重新输入");
			return LOGIN;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("成功登陆");
			return SUCCESS;
		}
		this.addActionError("登陆失败");
		return ERROR;
	}

	// 退出登录
	public String logout() throws Exception {
		String result = userService.logout();
		return returnAction(result);
	}

	// 用户注册
	public String register() throws Exception {
		// 参数检验
		if (userName == null || userName.trim().length() == 0) {
			this.addFieldError("userName", "用户名不能为空");
			return INPUT;
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "密码不能为空");
			return INPUT;
		}
		if (passwordConfirm == null || passwordConfirm.trim().length() == 0) {
			this.addFieldError("passwordConfirm", "密码不能为空");
			return INPUT;
		}
		if (!userPassword.equals(passwordConfirm)) {
			this.addFieldError("userPassword", "密码填写不一致");
			this.addFieldError("passwordConfirm", "密码填写不一致");
			return INPUT;
		}
		if (userSex == null || userSex.trim().length() == 0) {
			this.addFieldError("userSex", "性别不能为空");
			return INPUT;
		}
		if (userBirth == null || userBirth.trim().length() == 0) {
			this.addFieldError("userBirth", "生日不能为空");
			return INPUT;
		}
		if (userEmail == null || userEmail.trim().length() == 0) {
			this.addFieldError("userEmail", "邮箱不能为空");
			return INPUT;
		}
		// 用户注册
		String result = userService.register(userName, userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userName", "用户已存在");
			return INPUT;
		}
		return returnAction(result);
	}

	// 编辑用户资料
	public String edit() throws Exception {
		// 参数检验
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "原密码不能为空");
			return INPUT;
		}
		if (userSex == null || userSex.trim().length() == 0) {
			this.addFieldError("userSex", "性别不能为空");
			return INPUT;
		}
		if (userBirth == null || userBirth.trim().length() == 0) {
			this.addFieldError("userBirth", "生日不能为空");
			return INPUT;
		}
		if (userEmail == null || userEmail.trim().length() == 0) {
			this.addFieldError("userEmail", "邮箱不能为空");
			return INPUT;
		}
		// 编辑用户资料
		String result = userService.editData(userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "密码输入有误，请重新输入");
			return INPUT;
		}
		return returnAction(result);
	}

	// 修改用户密码
	public String changePassword() throws Exception {
		if (oldUserPassword == null || oldUserPassword.trim().length() == 0) {
			this.addFieldError("oldUserPassword", "原密码不能为空");
			return INPUT;
		}
		if (newUserPassword == null || newUserPassword.trim().length() == 0) {
			this.addFieldError("newUserPassword", "新密码不能为空");
			return INPUT;
		}
		if (passwordConfirm == null || passwordConfirm.trim().length() == 0) {
			this.addFieldError("passwordConfirm", "新密码不能为空");
			return INPUT;
		}
		if (!newUserPassword.equals(passwordConfirm)) {
			this.addFieldError("newUserPassword", "密码填写不一致");
			this.addFieldError("passwordConfirm", "密码填写不一致");
			return INPUT;
		}
		// 修改用户密码
		String result = userService.changePassword(oldUserPassword, newUserPassword);
		if (result.equals(INPUT)) {
			this.addFieldError("oldUserPassword", "原密码输入有误，请重新输入");
			return INPUT;
		}
		return returnAction(result);
	}

	// 查看所有用户
	public String showAll() throws Exception {
		allUsers = userService.getAllUsers();
		if (allUsers != null) {
			this.addActionMessage("查看所有用户成功");
			return SUCCESS;
		}
		this.addActionMessage("当前没有用户");
		return NONE;
	}

	// 查看用户资料
	public String show() throws Exception {
		user = userService.getCurrentUserData();
		if (user != null) {
			userName = user.getUserName();
			userSex = user.getUserSex() ? "man" : "woman";
			userBirth = user.getUserBirth();
			userEmail = user.getUserEmail();
			this.addActionMessage("查看用户资料成功");
			return SUCCESS;
		}
		this.addActionError("您尚未登录，请重新登录");
		return LOGIN;
	}

	// 上传头像
	public String uploadAvatar() throws Exception {
		// 参数检验
		if (avatarsImage == null) {
			this.addFieldError("avatarsImage", "图片文件不能为空");
			return INPUT;
		}
		if (avatarsImageFileName == null
				|| avatarsImageFileName.trim().length() == 0) {
			this.addFieldError("avatarsImageFileName", "图片名称不能为空");
			return INPUT;
		}
		if (avatarsImageContentType == null
				|| avatarsImageContentType.trim().length() == 0) {
			this.addFieldError("avatarsImageContentType", "图片类型不能为空");
			return INPUT;
		}
		// 上传头像
		String result = userService.uploadAvatars(avatarsImage,avatarsImageFileName, avatarsImageContentType);
		return returnAction(result);
	}
	

	// 默认属性Getter/Setter
	public User getUser() {
		return user;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

	public File getAvatarsImage() {
		return avatarsImage;
	}

	public void setAvatarsImage(File avatarsImage) {
		this.avatarsImage = avatarsImage;
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

	public void setUser(User user) {
		this.user = user;
	}
	
}
