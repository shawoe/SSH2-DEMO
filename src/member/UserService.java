package member;

import java.io.File;
import java.util.List;
import platform.BaseService;

public class UserService extends BaseService<User> implements IUserService {
	
	// 用户登录
	public String login(String userName, String userPassword) {
		// 获取用户
		User user = userDAO.selectName(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// 用户登录
		if (!this.recordCurrentUser(userName))
			return ERROR;
		// 存至数据库
		user.setUserOnline(true);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// 执行退出登录
	public String logout() {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
		if (user == null)
			return NONE;
		// 执行退出登录
		if (!this.removeCurrentUser())
			return ERROR;
		// 存至数据库
		user.setUserOnline(false);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// 注册新用户
	public String register(String userName, String userPassword, String userSex, String userBirth, String userEmail) {
		// 获取用户
		User user = userDAO.selectName(userName);
		if (user != null)
			return INPUT;
		// 注册新用户
		user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		user.setUserOnline(false);
		user.setUserAvatar("../avatar/default-avatar.jsp");
		// 存至数据库
		if (userDAO.insert(user))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定用户
	public String remove(Integer userID) {
		if (userDAO.select(userID) == null)
			return INPUT;
		if (userDAO.delete(userID))
			return SUCCESS;
		return ERROR;
	}

	// 删除用户
	public String removeName(String userName) {
		if (userDAO.selectName(userName) == null)
			return INPUT;
		if (userDAO.deleteName(userName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定用户
	public User find(Integer userID) {
		return userDAO.select(userID);
	}

	// 查询用户
	public User findName(String userName) {
		return userDAO.selectName(userName);
	}

	// 获取当前用户资料
	public User findCurrentUser() {
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.selectName(currentUser);
		return null;
	}

	// 查询所有用户
	public List<User> findAll() {
		return userDAO.findAll();
	}

	// 编辑用户
	public String edit(String userPassword, String userSex, String userBirth, String userEmail) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(userPassword)) 
			return INPUT;
		// 编辑用户
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		// 存至数据库
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// 修改用户密码
	public String changePassword(String oldUserPassword, String newUserPassword) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(oldUserPassword))
			return INPUT;
		// 修改用户密码
		user.setUserPassword(newUserPassword);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// 上传头像
	public String uploadAvatar(File avatarImage, String avatarImageFileName, String avatarImageContentType) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 保存图片
		String avatarImageFolder = "avatar";
		String renameAvatarImage = currentUser;
		boolean result = uploadImage(avatarImage, avatarImageFileName, avatarImageContentType, avatarImageFolder, renameAvatarImage);
		// 返回结果
		if (result) {
			return SUCCESS;
		}
		return ERROR;
	}

	
}
