package message;


import java.util.List;



public interface ISMSService {

	// ���Ͷ���Ϣ
	public abstract String sendSms(String smsReader, String smsContent);

	// ɾ��ָ������Ϣ
	public abstract String deleteSmsByID(Integer smsID);

	// ��ѯ�û�����Ϣ
	public abstract List<SMS> getSmsByCurrentUser(Integer pageNow, Integer pageSize);

	// ��ѯ��ҳ����
	public abstract Integer getSmsPageCount(Integer pageSize);

	// ��ѯָ������Ϣ
	public abstract SMS getSmsByID(Integer smsID);

	// �༭����Ϣ
	public abstract String editSms(Integer smsID, String smsReader, String smsContent);

}