package member;


import java.io.File;
import java.util.List;



public interface IUserService {
	
	// 用户登录
	public abstract String loginUser(String userName, String userPassword);

	// 执行退出登录
	public abstract String logoutUser();

	// 注册新用户
	public abstract String registerUser(String userName, String userPassword, String userSex, String userBirth, String userEmail);

	// 删除指定用户
	public abstract String deleteUserByID(Integer userID);

	// 删除用户
	public abstract String deleteUserByName(String userName);

	// 查询指定用户
	public abstract User getUserByID(Integer userID);

	// 查询用户
	public abstract User getUserByName(String userName);

	// 查询当前用户
	public abstract User getCurrentUserData();

	// 查询所有用户
	public abstract List<User> getAllUsers();

	// 编辑用户
	public abstract String editUserData(String userPassword, String userSex, String userBirth, String userEmail);

	// 修改用户密码
	public abstract String changeUserPassword(String oldUserPassword, String newUserPassword);

	// 上传头像
	public abstract String uploadAvatars(File avatarsImage, String avatarsImageFileName, String avatarsImageContentType);

}