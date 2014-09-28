package member;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import platform.BaseService;

public class UserService extends BaseService<User> {

	// 依赖注入属性
	protected UserDAO userDAO;
	
	// 用户登录
	public String login(String userName, String userPassword) {
		// 获取用户
		User user = userDAO.findUser(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// 用户登录
		if (!this.setCurrentUser(userName))
			return ERROR;
		// 存至数据库
		user.setUserOnline(true);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// 执行退出登录
	public String logout() {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
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
		User user = userDAO.findUser(userName);
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
	public String delete(Integer userID) {
		if (userDAO.find(userID) == null)
			return INPUT;
		if (userDAO.delete(userID))
			return SUCCESS;
		return ERROR;
	}

	// 删除用户
	public String deleteUserByName(String userName) {
		if (userDAO.findUser(userName) == null)
			return INPUT;
		if (userDAO.deleteUserData(userName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定用户
	public User get(Integer userID) {
		return userDAO.find(userID);
	}

	// 查询用户
	public User getUserByName(String userName) {
		return userDAO.findUser(userName);
	}

	// 获取当前用户资料
	public User getCurrentUserData() {
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.findUser(currentUser);
		return null;
	}

	// 查询所有用户
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	// 编辑用户
	public String editData(String userPassword, String userSex, String userBirth, String userEmail) {
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
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
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
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
	public String uploadAvatars(File avatarsImage, String avatarsImageFileName,String avatarsImageContentType) {
		// 获取路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/avatar");
		// 获取图片类型
		String imageType = avatarsImageFileName.substring(avatarsImageFileName.lastIndexOf(".") + 1, avatarsImageFileName.length());
		// 获取当前用户
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 保存图片
		File saveFile = new File(new File(realPath), currentUser + "."+ imageType);
		if (!saveFile.getParentFile().exists())
			saveFile.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(avatarsImage, saveFile);
			return SUCCESS;
		} catch (IOException e) {
			return ERROR;
		}
	}

	// 默认属性Getter/Setter
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
