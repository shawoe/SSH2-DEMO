package message;


import java.util.List;




public interface ISMSDAO {

	// 查找信息
	public abstract List<SMS> findSmsByUserName(String userName);

	public abstract SMS findSmsByID(Integer smsID);

	// 增加信息
	public abstract boolean insertSms(SMS sms);

	// 更新信息
	public abstract boolean updateSms(SMS sms);

	// 删除信息
	public abstract boolean deleteSms(Integer smsID);

}