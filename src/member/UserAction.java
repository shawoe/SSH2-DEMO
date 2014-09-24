package member;

@SuppressWarnings("serial")
public class UserAction extends UserActionBase {

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
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登陆");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("用户不存在");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("成功登陆");
			return SUCCESS;
		}
		this.addActionError("退出登陆失败");
		return ERROR;
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
		if (result.equals(SUCCESS)) {
			this.addActionMessage("成功登陆");
			return SUCCESS;
		}
		this.addActionError("注册失败");
		return ERROR;
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
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("用户不存在");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "密码输入有误，请重新输入");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("修改资料成功");
			return SUCCESS;
		}
		this.addActionError("修改资料失败");
		return ERROR;
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
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("用户不存在");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("oldUserPassword", "原密码输入有误，请重新输入");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("修改密码成功");
			return SUCCESS;
		}
		this.addActionError("修改密码失败");
		return ERROR;
	}

	// 查看所有用户
	public String showAllUsers() throws Exception {
		allUsers = userService.getAllUsers();
		if (allUsers != null) {
			this.addActionMessage("查看所有用户成功");
			return SUCCESS;
		}
		this.addActionMessage("当前没有用户");
		return NONE;
	}

	// 查看用户资料
	public String showUser() throws Exception {
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
	public String uploadAvatars() throws Exception {
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
		if (result.equals(LOGIN)) {
			this.addActionError("您尚未登录，请重新登录");
			return LOGIN;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("上传头像成功");
			return SUCCESS;
		}
		this.addActionError("上传头像失败");
		return ERROR;
	}
}
