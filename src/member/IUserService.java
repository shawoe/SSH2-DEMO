package member;

import java.io.File;
import platform.InterfaceService;

public interface IUserService extends InterfaceService<User> {

	// 用户登录
	public abstract String login(String userName, String userPassword);

	// 执行退出登录
	public abstract String logout();

	// 注册新用户
	public abstract String register(String userName, String userPassword, String userSex, String userBirth, String userEmail);

	// 编辑用户
	public abstract String edit(String userPassword, String userSex, String userBirth, String userEmail);

	// 修改用户密码
	public abstract String changePassword(String oldUserPassword, String newUserPassword);

	// 上传头像
	public abstract String uploadAvatar(File avatarImage, String avatarImageFileName, String avatarImageContentType);


}