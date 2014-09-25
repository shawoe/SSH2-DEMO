package api;

import java.util.List;

public interface InterfaceServiceMessage<Template> {

	// ������Ϣ
	public abstract String send(String reader, String content);

	// ɾ����Ϣ
	public abstract String delete(Integer id);

	// ��ѯ��Ϣ
	public abstract Template get(Integer id);
	public abstract List<Template> getAll(Integer pageNow, Integer pageSize);
	public abstract List<Template> getMessageByUserName(Integer pageNow, Integer pageSize);

	// ��ȡ��ҳ
	public abstract Integer getPageCount(Integer pageSize);

	// �༭��Ϣ
	public abstract String edit(Integer id, String reader, String content);

}