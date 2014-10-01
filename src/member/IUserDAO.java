package member;

import java.util.List;
import platform.InterfaceDAO;

public interface IUserDAO extends InterfaceDAO<User> {

	// ɾ��ָ���û�
	public abstract boolean delete(Integer userID);

	// ɾ���û�
	public abstract boolean deleteName(String userName);

	// ��ѯָ���û�
	public abstract User select(Integer userID);

	// ��ѯ�û�
	public abstract User selectName(String userName);

	// ��ѯ�����û�
	public abstract List<User> findAll();

}