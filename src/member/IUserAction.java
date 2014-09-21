package member;


public interface IUserAction {

	// �û���¼
	public abstract String loginUser() throws Exception;

	// �˳���¼
	public abstract String logoutUser() throws Exception;

	// �û�ע��
	public abstract String registerUser() throws Exception;

	// �༭�û�����
	public abstract String editUserData() throws Exception;

	// �޸��û�����
	public abstract String changeUserPassword() throws Exception;

	// �鿴�����û�
	public abstract String showAllUsers() throws Exception;

	// �鿴�û�
	public abstract String showUser() throws Exception;

	// �ϴ�ͷ��
	public abstract String uploadAvatars() throws Exception;

}