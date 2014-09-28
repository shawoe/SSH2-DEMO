package member;

import java.io.File;
import java.util.List;

import platform.BaseAction;

@SuppressWarnings("serial")
public class UserAction extends BaseAction {
	
	// ��������
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
	
	protected File avatarsImage; 				//�ϴ���ͷ���ļ�
	protected String avatarsImageFileName; 		//ͷ���ļ�����
	protected String avatarsImageContentType; 	//ͷ���ļ�����
	

	// �û���¼
	public String login() throws Exception {
		// ��������
		if (userName == null || userName.trim().length() == 0) {
			this.addFieldError("userName", "�û�������Ϊ��");
			return INPUT;
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "���벻��Ϊ��");
			return INPUT;
		}
		// �û���¼
		String result = userService.login(userName, userPassword);
		if (result.equals(NONE)) {
			this.addFieldError("userName", "�û�������");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "����������������������");
			return LOGIN;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�ɹ���½");
			return SUCCESS;
		}
		this.addActionError("��½ʧ��");
		return ERROR;
	}

	// �˳���¼
	public String logout() throws Exception {
		String result = userService.logout();
		return returnAction(result);
	}

	// �û�ע��
	public String register() throws Exception {
		// ��������
		if (userName == null || userName.trim().length() == 0) {
			this.addFieldError("userName", "�û�������Ϊ��");
			return INPUT;
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "���벻��Ϊ��");
			return INPUT;
		}
		if (passwordConfirm == null || passwordConfirm.trim().length() == 0) {
			this.addFieldError("passwordConfirm", "���벻��Ϊ��");
			return INPUT;
		}
		if (!userPassword.equals(passwordConfirm)) {
			this.addFieldError("userPassword", "������д��һ��");
			this.addFieldError("passwordConfirm", "������д��һ��");
			return INPUT;
		}
		if (userSex == null || userSex.trim().length() == 0) {
			this.addFieldError("userSex", "�Ա���Ϊ��");
			return INPUT;
		}
		if (userBirth == null || userBirth.trim().length() == 0) {
			this.addFieldError("userBirth", "���ղ���Ϊ��");
			return INPUT;
		}
		if (userEmail == null || userEmail.trim().length() == 0) {
			this.addFieldError("userEmail", "���䲻��Ϊ��");
			return INPUT;
		}
		// �û�ע��
		String result = userService.register(userName, userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userName", "�û��Ѵ���");
			return INPUT;
		}
		return returnAction(result);
	}

	// �༭�û�����
	public String edit() throws Exception {
		// ��������
		if (userPassword == null || userPassword.trim().length() == 0) {
			this.addFieldError("userPassword", "ԭ���벻��Ϊ��");
			return INPUT;
		}
		if (userSex == null || userSex.trim().length() == 0) {
			this.addFieldError("userSex", "�Ա���Ϊ��");
			return INPUT;
		}
		if (userBirth == null || userBirth.trim().length() == 0) {
			this.addFieldError("userBirth", "���ղ���Ϊ��");
			return INPUT;
		}
		if (userEmail == null || userEmail.trim().length() == 0) {
			this.addFieldError("userEmail", "���䲻��Ϊ��");
			return INPUT;
		}
		// �༭�û�����
		String result = userService.editData(userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "����������������������");
			return INPUT;
		}
		return returnAction(result);
	}

	// �޸��û�����
	public String changePassword() throws Exception {
		if (oldUserPassword == null || oldUserPassword.trim().length() == 0) {
			this.addFieldError("oldUserPassword", "ԭ���벻��Ϊ��");
			return INPUT;
		}
		if (newUserPassword == null || newUserPassword.trim().length() == 0) {
			this.addFieldError("newUserPassword", "�����벻��Ϊ��");
			return INPUT;
		}
		if (passwordConfirm == null || passwordConfirm.trim().length() == 0) {
			this.addFieldError("passwordConfirm", "�����벻��Ϊ��");
			return INPUT;
		}
		if (!newUserPassword.equals(passwordConfirm)) {
			this.addFieldError("newUserPassword", "������д��һ��");
			this.addFieldError("passwordConfirm", "������д��һ��");
			return INPUT;
		}
		// �޸��û�����
		String result = userService.changePassword(oldUserPassword, newUserPassword);
		if (result.equals(INPUT)) {
			this.addFieldError("oldUserPassword", "ԭ����������������������");
			return INPUT;
		}
		return returnAction(result);
	}

	// �鿴�����û�
	public String showAll() throws Exception {
		allUsers = userService.getAllUsers();
		if (allUsers != null) {
			this.addActionMessage("�鿴�����û��ɹ�");
			return SUCCESS;
		}
		this.addActionMessage("��ǰû���û�");
		return NONE;
	}

	// �鿴�û�����
	public String show() throws Exception {
		user = userService.getCurrentUserData();
		if (user != null) {
			userName = user.getUserName();
			userSex = user.getUserSex() ? "man" : "woman";
			userBirth = user.getUserBirth();
			userEmail = user.getUserEmail();
			this.addActionMessage("�鿴�û����ϳɹ�");
			return SUCCESS;
		}
		this.addActionError("����δ��¼�������µ�¼");
		return LOGIN;
	}

	// �ϴ�ͷ��
	public String uploadAvatar() throws Exception {
		// ��������
		if (avatarsImage == null) {
			this.addFieldError("avatarsImage", "ͼƬ�ļ�����Ϊ��");
			return INPUT;
		}
		if (avatarsImageFileName == null
				|| avatarsImageFileName.trim().length() == 0) {
			this.addFieldError("avatarsImageFileName", "ͼƬ���Ʋ���Ϊ��");
			return INPUT;
		}
		if (avatarsImageContentType == null
				|| avatarsImageContentType.trim().length() == 0) {
			this.addFieldError("avatarsImageContentType", "ͼƬ���Ͳ���Ϊ��");
			return INPUT;
		}
		// �ϴ�ͷ��
		String result = userService.uploadAvatars(avatarsImage,avatarsImageFileName, avatarsImageContentType);
		return returnAction(result);
	}
	

	// Ĭ������Getter/Setter
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
