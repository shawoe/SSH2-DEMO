package member;

import java.io.File;
import java.util.List;

import platform.BaseAction;

@SuppressWarnings("serial")
public class UserAction extends BaseAction implements IUserAction {
	
	// ��������
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
	
	protected File avatarImage; 				//�ϴ���ͷ���ļ�
	protected String avatarImageFileName; 		//ͷ���ļ�����
	protected String avatarImageContentType; 	//ͷ���ļ�����
	

	// �û���¼
	public String login() throws Exception {
		// ��������
		String[] paramName = {"�û���","����"};
		String[] paramField = {"userName","userPassword"};
		if (check(paramName, paramField, userName, userPassword)) 
			return INPUT;
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
		return returnAction(result);
	}

	// �˳���¼
	public String logout() throws Exception {
		String result = userService.logout();
		return returnAction(result);
	}

	// �û�ע��
	public String register() throws Exception {
		// ��������
		String[] paramName = {"�û���","����","ȷ������","�Ա�","����","����"};
		String[] paramField = {"userName","userPassword","passwordConfirm","userSex","userBirth","userEmail"};
		if (check(paramName, paramField, userName, userPassword, passwordConfirm, userSex, userBirth, userEmail)) 
			return INPUT;
		if (!userPassword.equals(passwordConfirm)) {
			this.addFieldError("userPassword", "������д��һ��");
			this.addFieldError("passwordConfirm", "������д��һ��");
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
		String[] paramName = {"ԭ����","�Ա�","����","����"};
		String[] paramField = {"userPassword","userSex","userBirth","userEmail"};
		if (check(paramName, paramField, userPassword, userSex, userBirth, userEmail)) 
			return INPUT;
		// �༭�û�����
		String result = userService.edit(userPassword, userSex, userBirth, userEmail);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "����������������������");
			return INPUT;
		}
		return returnAction(result);
	}

	// �޸��û�����
	public String changePassword() throws Exception {
		// ��������
		String[] paramName = {"ԭ����","������","ȷ��������"};
		String[] paramField = {"userPassword","newPassword","passwordConfirm"};
		if (check(paramName, paramField, userPassword, newPassword, passwordConfirm)) 
			return INPUT;
		if (!newPassword.equals(passwordConfirm)) {
			this.addFieldError("newPassword", "������д��һ��");
			this.addFieldError("passwordConfirm", "������д��һ��");
			return INPUT;
		}
		// �޸��û�����
		String result = userService.changePassword(userPassword, newPassword);
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "ԭ����������������������");
			return INPUT;
		}
		return returnAction(result);
	}

	// �鿴�����û�
	public String showAll() throws Exception {
		allUsers = userService.findAll();
		if (allUsers != null) {
			this.addActionMessage("�鿴�����û��ɹ�");
			return SUCCESS;
		}
		this.addActionMessage("��ǰû���û�");
		return NONE;
	}

	// �鿴�û�����
	public String show() throws Exception {
		user = userService.findCurrentUser();
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
		if (avatarImage == null) {
			this.addFieldError("avatarImage", "ͼƬ�ļ�����Ϊ��");
			return INPUT;
		}
		String[] paramName = {"ͼƬ����","ͼƬ����"};
		String[] paramField = {"avatarImageFileName","avatarImageContentType"};
		if (check(paramName, paramField, avatarImageFileName, avatarImageContentType)) 
			return INPUT;
		// �ϴ�ͷ��
		String result = userService.uploadAvatar(avatarImage,avatarImageFileName, avatarImageContentType);
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
