package message;

import java.util.List;

import platform.InterfaceService;

public interface ISMSService extends InterfaceService<SMS> {

	// ���Ͷ���Ϣ
	public abstract String send(String SMSReader, String SMSContent);

	// ɾ��ָ������Ϣ
	public abstract String remove(Integer SMSID);

	// ��ѯ�û�����Ϣ
	public abstract List<SMS> findCurrentUser(Integer pageNow, Integer pageSize);

	// ��ѯ��ҳ����
	public abstract Integer reterPageCount(Integer pageSize);

	// ��ѯָ������Ϣ
	public abstract SMS find(Integer SMSID);

	// �༭����Ϣ
	public abstract String edit(Integer SMSID, String SMSReader, String SMSContent);

}