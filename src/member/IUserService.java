package member;


import java.io.File;
import java.util.List;



public interface IUserService {
	
	// �û���¼
	public abstract String loginUser(String userName, String userPassword);

	// ִ���˳���¼
	public abstract String logoutUser();

	// ע�����û�
	public abstract String registerUser(String userName, String userPassword, String userSex, String userBirth, String userEmail);

	// ɾ��ָ���û�
	public abstract String deleteUserByID(Integer userID);

	// ɾ���û�
	public abstract String deleteUserByName(String userName);

	// ��ѯָ���û�
	public abstract User getUserByID(Integer userID);

	// ��ѯ�û�
	public abstract User getUserByName(String userName);

	// ��ѯ��ǰ�û�
	public abstract User getCurrentUserData();

	// ��ѯ�����û�
	public abstract List<User> getAllUsers();

	// �༭�û�
	public abstract String editUserData(String userPassword, String userSex, String userBirth, String userEmail);

	// �޸��û�����
	public abstract String changeUserPassword(String oldUserPassword, String newUserPassword);

	// �ϴ�ͷ��
	public abstract String uploadAvatars(File avatarsImage, String avatarsImageFileName, String avatarsImageContentType);

}