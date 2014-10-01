package member;

import java.io.File;
import platform.InterfaceService;

public interface IUserService extends InterfaceService<User> {

	// �û���¼
	public abstract String login(String userName, String userPassword);

	// ִ���˳���¼
	public abstract String logout();

	// ע�����û�
	public abstract String register(String userName, String userPassword, String userSex, String userBirth, String userEmail);

	// �༭�û�
	public abstract String edit(String userPassword, String userSex, String userBirth, String userEmail);

	// �޸��û�����
	public abstract String changePassword(String oldUserPassword, String newUserPassword);

	// �ϴ�ͷ��
	public abstract String uploadAvatar(File avatarImage, String avatarImageFileName, String avatarImageContentType);


}