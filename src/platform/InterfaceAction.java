package platform;

public interface InterfaceAction {

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


}