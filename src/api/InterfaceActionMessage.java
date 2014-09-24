package api;

public interface InterfaceActionMessage {

	// ����Ϣ
	public abstract String read() throws Exception;

	// ����һҳ��Ϣ
	public abstract String readFirst() throws Exception;

	// ����һҳ��Ϣ
	public abstract String readNext() throws Exception;

	// ����һҳ��Ϣ
	public abstract String readLast() throws Exception;

	// �����һҳ��Ϣ
	public abstract String readEnd() throws Exception;

	// ������Ϣ
	public abstract String send() throws Exception;

	// ɾ����Ϣ
	public abstract String delete() throws Exception;

	// �޸���Ϣ
	public abstract String edit() throws Exception;

}