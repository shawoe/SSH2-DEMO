package member;

@SuppressWarnings("serial")
public class UserAction extends UserActionBase {

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
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��½");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("�û�������");
			return NONE;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�ɹ���½");
			return SUCCESS;
		}
		this.addActionError("�˳���½ʧ��");
		return ERROR;
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
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�ɹ���½");
			return SUCCESS;
		}
		this.addActionError("ע��ʧ��");
		return ERROR;
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
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("�û�������");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("userPassword", "����������������������");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�޸����ϳɹ�");
			return SUCCESS;
		}
		this.addActionError("�޸�����ʧ��");
		return ERROR;
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
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(NONE)) {
			this.addActionError("�û�������");
			return NONE;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("oldUserPassword", "ԭ����������������������");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�޸�����ɹ�");
			return SUCCESS;
		}
		this.addActionError("�޸�����ʧ��");
		return ERROR;
	}

	// �鿴�����û�
	public String showAllUsers() throws Exception {
		allUsers = userService.getAllUsers();
		if (allUsers != null) {
			this.addActionMessage("�鿴�����û��ɹ�");
			return SUCCESS;
		}
		this.addActionMessage("��ǰû���û�");
		return NONE;
	}

	// �鿴�û�����
	public String showUser() throws Exception {
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
	public String uploadAvatars() throws Exception {
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
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�ϴ�ͷ��ɹ�");
			return SUCCESS;
		}
		this.addActionError("�ϴ�ͷ��ʧ��");
		return ERROR;
	}
}
