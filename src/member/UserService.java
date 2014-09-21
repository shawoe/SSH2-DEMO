package member;


import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;




public class UserService extends UserServiceBase implements IUserService {

	// 用户登录
	public String loginUser(String userName, String userPassword) {
		// 获取用户
		user = userDAO.findUserByName(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// 用户登录
		if (!sessionUtil.setOnlineUser(userName))
			return ERROR;
		if (!sessionUtil.setSessionUser(userName))
			return ERROR;
		// 存至数据库
		user.setUserOnline(true);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// 执行退出登录
	public String logoutUser() {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		// 执行退出登录
		if (!sessionUtil.removeOnlineUser())
			return ERROR;
		if (!sessionUtil.removeSessionUser())
			return ERROR;
		// 存至数据库
		user.setUserOnline(false);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// 注册新用户
	public String registerUser(String userName, String userPassword, String userSex, String userBirth, String userEmail) {
		// 获取用户
		user = userDAO.findUserByName(userName);
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
		user.setUserAvatars("../avatars/default-avatars.jsp");
		// 存至数据库
		if (userDAO.insertUser(user))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定用户
	public String deleteUserByID(Integer userID) {
		if (userDAO.findUserByID(userID) == null)
			return INPUT;
		if (userDAO.deleteUserByID(userID))
			return SUCCESS;
		return ERROR;
	}

	// 删除用户
	public String deleteUserByName(String userName) {
		if (userDAO.findUserByName(userName) == null)
			return INPUT;
		if (userDAO.deleteUserByName(userName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定用户
	public User getUserByID(Integer userID) {
		return userDAO.findUserByID(userID);
	}

	// 查询用户
	public User getUserByName(String userName) {
		return userDAO.findUserByName(userName);
	}

	// 获取当前用户资料
	public User getCurrentUserData() {
		currentUser = sessionUtil.getSessionUser();
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.findUserByName(currentUser);
		return null;
	}

	// 查询所有用户
	public List<User> getAllUsers() {
		return userDAO.findAllUsers();
	}

	// 编辑用户
	public String editUserData(String userPassword, String userSex, String userBirth, String userEmail) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(userPassword)) 
			return INPUT;
		// 编辑用户
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		// 存至数据库
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// 修改用户密码
	public String changeUserPassword(String oldUserPassword, String newUserPassword) {
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(oldUserPassword))
			return INPUT;
		// 修改用户密码
		user.setUserPassword(newUserPassword);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// 上传头像
	public String uploadAvatars(File avatarsImage, String avatarsImageFileName,String avatarsImageContentType) {
		// 获取路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/avatars");
		// 获取图片类型
		String imageType = avatarsImageFileName.substring(avatarsImageFileName.lastIndexOf(".") + 1, avatarsImageFileName.length());
		// 获取当前用户
		currentUser = sessionUtil.getSessionUser();
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
}
