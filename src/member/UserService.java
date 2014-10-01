package member;

import java.io.File;
import java.util.List;
import platform.BaseService;

public class UserService extends BaseService<User> implements IUserService {
	
	// �û���¼
	public String login(String userName, String userPassword) {
		// ��ȡ�û�
		User user = userDAO.selectName(userName);
		if (user == null)
			return NONE;
		if (!userPassword.equals(user.getUserPassword()))
			return INPUT;
		// �û���¼
		if (!this.recordCurrentUser(userName))
			return ERROR;
		// �������ݿ�
		user.setUserOnline(true);
		if (userDAO.update(user))
			return SUCCESS;
		return ERROR;
	}

	// ִ���˳���¼
	public String logout() {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
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
		User user = userDAO.selectName(userName);
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
	public String remove(Integer userID) {
		if (userDAO.select(userID) == null)
			return INPUT;
		if (userDAO.delete(userID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ���û�
	public String removeName(String userName) {
		if (userDAO.selectName(userName) == null)
			return INPUT;
		if (userDAO.deleteName(userName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ���û�
	public User find(Integer userID) {
		return userDAO.select(userID);
	}

	// ��ѯ�û�
	public User findName(String userName) {
		return userDAO.selectName(userName);
	}

	// ��ȡ��ǰ�û�����
	public User findCurrentUser() {
		if (currentUser != null || currentUser.trim().length() > 0) 
			return userDAO.selectName(currentUser);
		return null;
	}

	// ��ѯ�����û�
	public List<User> findAll() {
		return userDAO.findAll();
	}

	// �༭�û�
	public String edit(String userPassword, String userSex, String userBirth, String userEmail) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
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
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		User user = userDAO.selectName(currentUser);
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
	public String uploadAvatar(File avatarImage, String avatarImageFileName, String avatarImageContentType) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ����ͼƬ
		String avatarImageFolder = "avatar";
		String renameAvatarImage = currentUser;
		boolean result = uploadImage(avatarImage, avatarImageFileName, avatarImageContentType, avatarImageFolder, renameAvatarImage);
		// ���ؽ��
		if (result) {
			return SUCCESS;
		}
		return ERROR;
	}

	
}
