package api;

import java.util.List;

public interface InterfaceDAO<Template> {
	
	// ������Ϣ
	public abstract Template find(Integer id);
	public abstract List<Template> findAll();
	public abstract List<Template> findDataByUserName(String name);

	// ������Ϣ
	public abstract boolean insert(Template object);

	// ������Ϣ
	public abstract boolean update(Template object);

	// ɾ����Ϣ
	public abstract boolean delete(Integer id);
	public abstract boolean deleteDataByUserName(String name);
}
