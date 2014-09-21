package member;


import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;




public class UserService extends UserServiceBase implements IUserService {

	// �û���¼
	public String loginUser(String userName, String userPassword) {
		// ��ȡ�û�
		user = userDAO.findUserByName(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// �û���¼
		if (!sessionUtil.setOnlineUser(userName))
			return ERROR;
		if (!sessionUtil.setSessionUser(userName))
			return ERROR;
		// �������ݿ�
		user.setUserOnline(true);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// ִ���˳���¼
	public String logoutUser() {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		// ִ���˳���¼
		if (!sessionUtil.removeOnlineUser())
			return ERROR;
		if (!sessionUtil.removeSessionUser())
			return ERROR;
		// �������ݿ�
		user.setUserOnline(false);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// ע�����û�
	public String registerUser(String userName, String userPassword, String userSex, String userBirth, String userEmail) {
		// ��ȡ�û�
		user = userDAO.findUserByName(userName);
		if (user != null)
			return INPUT;
		// ע�����û�
		user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		user.setUserOnline(false);
		user.setUserAvatars("../avatars/default-avatars.jsp");
		// �������ݿ�
		if (userDAO.insertUser(user))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ���û�
	public String deleteUserByID(Integer userID) {
		if (userDAO.findUserByID(userID) == null)
			return INPUT;
		if (userDAO.deleteUserByID(userID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ���û�
	public String deleteUserByName(String userName) {
		if (userDAO.findUserByName(userName) == null)
			return INPUT;
		if (userDAO.deleteUserByName(userName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ���û�
	public User getUserByID(Integer userID) {
		return userDAO.findUserByID(userID);
	}

	// ��ѯ�û�
	public User getUserByName(String userName) {
		return userDAO.findUserByName(userName);
	}

	// ��ȡ��ǰ�û�����
	public User getCurrentUserData() {
		currentUser = sessionUtil.getSessionUser();
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.findUserByName(currentUser);
		return null;
	}

	// ��ѯ�����û�
	public List<User> getAllUsers() {
		return userDAO.findAllUsers();
	}

	// �༭�û�
	public String editUserData(String userPassword, String userSex, String userBirth, String userEmail) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(userPassword)) 
			return INPUT;
		// �༭�û�
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		// �������ݿ�
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// �޸��û�����
	public String changeUserPassword(String oldUserPassword, String newUserPassword) {
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		user = userDAO.findUserByName(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(oldUserPassword))
			return INPUT;
		// �޸��û�����
		user.setUserPassword(newUserPassword);
		if (userDAO.updateUser(user))
			return SUCCESS;
		return ERROR;
	}

	// �ϴ�ͷ��
	public String uploadAvatars(File avatarsImage, String avatarsImageFileName,String avatarsImageContentType) {
		// ��ȡ·��
		String realPath = ServletActionContext.getServletContext().getRealPath("/avatars");
		// ��ȡͼƬ����
		String imageType = avatarsImageFileName.substring(avatarsImageFileName.lastIndexOf(".") + 1, avatarsImageFileName.length());
		// ��ȡ��ǰ�û�
		currentUser = sessionUtil.getSessionUser();
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ����ͼƬ
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
