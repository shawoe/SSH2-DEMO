package member;

import java.util.List;
import platform.InterfaceDAO;

public interface IUserDAO extends InterfaceDAO<User> {

	// 删除指定用户
	public abstract boolean delete(Integer userID);

	// 删除用户
	public abstract boolean deleteName(String userName);

	// 查询指定用户
	public abstract User select(Integer userID);

	// 查询用户
	public abstract User selectName(String userName);

	// 查询所有用户
	public abstract List<User> findAll();

}