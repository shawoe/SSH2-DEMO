package message;


import java.util.List;




public interface ISMSDAO {

	// ������Ϣ
	public abstract List<SMS> findSmsByUserName(String userName);

	public abstract SMS findSmsByID(Integer smsID);

	// ������Ϣ
	public abstract boolean insertSms(SMS sms);

	// ������Ϣ
	public abstract boolean updateSms(SMS sms);

	// ɾ����Ϣ
	public abstract boolean deleteSms(Integer smsID);

}