package member;


import java.util.List;



public interface IUserDAO {

	// ����û�
	public abstract boolean insertUser(User user);

	// ɾ��ָ���û�
	public abstract boolean deleteUserByID(Integer userID);

	// ɾ���û�
	public abstract boolean deleteUserByName(String userName);

	// ��ѯָ���û�
	public abstract User findUserByID(Integer userID);

	// ��ѯ�û�
	public abstract User findUserByName(String userName);

	// ��ѯ�����û�
	public abstract List<User> findAllUsers();

	// �����û�
	public abstract boolean updateUser(User user);

}