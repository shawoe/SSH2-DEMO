package member;

import java.io.File;
import java.util.List;

import platform.BaseAction;

@SuppressWarnings("serial")
public class UserAction extends BaseAction implements IUserAction {
	
	// 设置属性
	protected String userName;  
	protected String userPassword;
	protected String newPassword;
	protected String passwordConfirm;
	protected String userAvatar;
	protected String userSex;
	protected String userBirth;
	protected String userEmail;    
	
	protected User user;
	protected UserService userService;
	protected List<User> allUsers;
	
	protected File avatarImage; 				//上传的头像文件
	protected String avatarImageFileName; 		//头像文件名称
	protected String avatarImageContentType; 	//头像文件类型
	

	// 用户登录
	public String login() throws Exception {
		// 参数检验
		String[] paramName = {"用户名","密码"};
		String[] paramField = {"userName","userPassword"};
		if (check(paramName, paramField, userName, userPassword)) 
			return INPUT;
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
		return returnAction(result);
	}

	// 退出登录
	public String logout() throws Exception {
		String result = userService.logout();
		return returnAction(result);
	}

	// 用户注册
	public String register() throws Exception {
		// 参数检验
		String[] paramName = {"用户名","密码","确认密码","性别","生日","邮箱"};
		String[] paramField = {"userName","userPassword","passwordConfirm","userSex","userBirth","userEmail"};
		if (check(paramName, paramField, userName, userPassword, passwordConfirm, userSex, userBirth, userEmail)) 
			return INPUT;
		if (!userPassword.equals(passwordConfirm)) {
			this.addFieldError("userPassword", "密码填写不一致");
			this.addFieldError("passwordConfirm", "密码填写不一致");
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
		String[] paramName = {"原密码","性别","生日","邮箱"};
		String[] paramField = {"userPassword","userSex","userBirth","userEmail"};
		if (check(paramName, paramField, userPassword, userSex, userBirth, userEmail)) 
			return INPUT;
		// 编辑用户资料
		String result = userService.edit(userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "密码输入有误，请重新输入");
			return INPUT;
		}
		return returnAction(result);
	}

	// 修改用户密码
	public String changePassword() throws Exception {
		// 参数检验
		String[] paramName = {"原密码","新密码","确认新密码"};
		String[] paramField = {"userPassword","newPassword","passwordConfirm"};
		if (check(paramName, paramField, userPassword, newPassword, passwordConfirm)) 
			return INPUT;
		if (!newPassword.equals(passwordConfirm)) {
			this.addFieldError("newPassword", "密码填写不一致");
			this.addFieldError("passwordConfirm", "密码填写不一致");
			return INPUT;
		}
		// 修改用户密码
		String result = userService.changePassword(userPassword, newPassword);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "原密码输入有误，请重新输入");
			return INPUT;
		}
		return returnAction(result);
	}

	// 查看所有用户
	public String showAll() throws Exception {
		allUsers = userService.findAll();
		if (allUsers != null) {
			this.addActionMessage("查看所有用户成功");
			return SUCCESS;
		}
		this.addActionMessage("当前没有用户");
		return NONE;
	}

	// 查看用户资料
	public String show() throws Exception {
		user = userService.findCurrentUser();
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
		if (avatarImage == null) {
			this.addFieldError("avatarImage", "图片文件不能为空");
			return INPUT;
		}
		String[] paramName = {"图片名称","图片类型"};
		String[] paramField = {"avatarImageFileName","avatarImageContentType"};
		if (check(paramName, paramField, avatarImageFileName, avatarImageContentType)) 
			return INPUT;
		// 上传头像
		String result = userService.uploadAvatar(avatarImage,avatarImageFileName, avatarImageContentType);
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

	public File getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(File avatarImage) {
		this.avatarImage = avatarImage;
	}

	public String getAvatarImageFileName() {
		return avatarImageFileName;
	}

	public void setAvatarImageFileName(String avatarImageFileName) {
		this.avatarImageFileName = avatarImageFileName;
	}

	public String getAvatarImageContentType() {
		return avatarImageContentType;
	}

	public void setAvatarImageContentType(String avatarImageContentType) {
		this.avatarImageContentType = avatarImageContentType;
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

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String end() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String first() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String last() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String next() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
