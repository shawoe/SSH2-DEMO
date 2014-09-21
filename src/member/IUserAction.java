package member;


public interface IUserAction {

	// 用户登录
	public abstract String loginUser() throws Exception;

	// 退出登录
	public abstract String logoutUser() throws Exception;

	// 用户注册
	public abstract String registerUser() throws Exception;

	// 编辑用户资料
	public abstract String editUserData() throws Exception;

	// 修改用户密码
	public abstract String changeUserPassword() throws Exception;

	// 查看所有用户
	public abstract String showAllUsers() throws Exception;

	// 查看用户
	public abstract String showUser() throws Exception;

	// 上传头像
	public abstract String uploadAvatars() throws Exception;

}