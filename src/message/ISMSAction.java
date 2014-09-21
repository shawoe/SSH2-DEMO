package message;


public interface ISMSAction {

	// ����һҳ����Ϣ
	public abstract String readFirstSms() throws Exception;

	// ������Ϣ
	public abstract String readSms() throws Exception;

	// ����һҳ����Ϣ
	public abstract String readNextSms() throws Exception;

	// ����һҳ����Ϣ
	public abstract String readLastSms() throws Exception;

	// �����һҳ����Ϣ
	public abstract String readEndSms() throws Exception;

	// ���Ͷ���Ϣ
	public abstract String sendSms() throws Exception;

	// ɾ������Ϣ
	public abstract String deleteSms() throws Exception;

	// �޸Ķ���Ϣ
	public abstract String editSms() throws Exception;

}