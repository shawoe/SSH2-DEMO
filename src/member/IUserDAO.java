package member;


import java.util.List;



public interface IUserDAO {

	// 填加用户
	public abstract boolean insertUser(User user);

	// 删除指定用户
	public abstract boolean deleteUserByID(Integer userID);

	// 删除用户
	public abstract boolean deleteUserByName(String userName);

	// 查询指定用户
	public abstract User findUserByID(Integer userID);

	// 查询用户
	public abstract User findUserByName(String userName);

	// 查询所有用户
	public abstract List<User> findAllUsers();

	// 更新用户
	public abstract boolean updateUser(User user);

}