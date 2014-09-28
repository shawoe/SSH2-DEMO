package member;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import platform.BaseService;

public class UserService extends BaseService<User> {

	// ����ע������
	protected UserDAO userDAO;
	
	// �û���¼
	public String login(String userName, String userPassword) {
		// ��ȡ�û�
		User user = userDAO.findUser(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// �û���¼
		if (!this.setCurrentUser(userName))
			return ERROR;
		// �������ݿ�
		user.setUserOnline(true);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// ִ���˳���¼
	public String logout() {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
		if (user == null)
			return NONE;
		// ִ���˳���¼
		if (!this.removeCurrentUser())
			return ERROR;
		// �������ݿ�
		user.setUserOnline(false);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// ע�����û�
	public String register(String userName, String userPassword, String userSex, String userBirth, String userEmail) {
		// ��ȡ�û�
		User user = userDAO.findUser(userName);
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
		user.setUserAvatar("../avatar/default-avatar.jsp");
		// �������ݿ�
		if (userDAO.insert(user))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ���û�
	public String delete(Integer userID) {
		if (userDAO.find(userID) == null)
			return INPUT;
		if (userDAO.delete(userID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ���û�
	public String deleteUserByName(String userName) {
		if (userDAO.findUser(userName) == null)
			return INPUT;
		if (userDAO.deleteUserData(userName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ���û�
	public User get(Integer userID) {
		return userDAO.find(userID);
	}

	// ��ѯ�û�
	public User getUserByName(String userName) {
		return userDAO.findUser(userName);
	}

	// ��ȡ��ǰ�û�����
	public User getCurrentUserData() {
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.findUser(currentUser);
		return null;
	}

	// ��ѯ�����û�
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

	// �༭�û�
	public String editData(String userPassword, String userSex, String userBirth, String userEmail) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(userPassword)) 
			return INPUT;
		// �༭�û�
		user.setUserSex(userSex.equals("man") ? true : false);
		user.setUserBirth(userBirth);
		user.setUserEmail(userEmail);
		// �������ݿ�
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// �޸��û�����
	public String changePassword(String oldUserPassword, String newUserPassword) {
		// ��ȡ��ǰ�û�
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.findUser(currentUser);
		if (user == null)
			return NONE;
		if (!user.getUserPassword().equals(oldUserPassword))
			return INPUT;
		// �޸��û�����
		user.setUserPassword(newUserPassword);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// �ϴ�ͷ��
	public String uploadAvatars(File avatarsImage, String avatarsImageFileName,String avatarsImageContentType) {
		// ��ȡ·��
		String realPath = ServletActionContext.getServletContext().getRealPath("/avatar");
		// ��ȡͼƬ����
		String imageType = avatarsImageFileName.substring(avatarsImageFileName.lastIndexOf(".") + 1, avatarsImageFileName.length());
		// ��ȡ��ǰ�û�
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

	// Ĭ������Getter/Setter
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
