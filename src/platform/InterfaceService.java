package platform;

import java.util.List;

public interface InterfaceService<Template> {

	// ����ֵ����
	public static final String NONE = "none";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login";

	// ���õ�ǰ�û�
	public abstract boolean recordCurrentUser(String userName);

	// �Ƴ���ǰ�û�
	public abstract boolean removeCurrentUser();

	// ���ϵͳʱ��
	public abstract String referCurrentDate();

	// ��ҳ����
	public abstract List<Template> paging(List<Template> list, Integer pageNow, Integer pageSize);

	// ҳ�����ݼ���
	public abstract Integer count(List<Template> list, Integer pageSize);

}