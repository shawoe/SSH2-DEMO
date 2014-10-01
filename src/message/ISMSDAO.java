package message;

import java.util.List;
import platform.InterfaceDAO;

public interface ISMSDAO extends InterfaceDAO<SMS> {

	// ������Ϣ
	public abstract List<SMS> selectAll();
	public abstract List<SMS> selectReader(String SMSReader);
	public abstract List<SMS> selectSender(String SMSSender);
	public abstract SMS select(Integer SMSID);

	// ɾ����Ϣ
	public abstract boolean delete(Integer SMSID);
	public abstract boolean deleteReader(String SMSReader);
	public abstract boolean deleteSender(String SMSSender);

}