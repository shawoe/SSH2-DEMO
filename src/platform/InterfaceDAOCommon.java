package platform;

import java.util.List;

public interface InterfaceDAOCommon<Template> {
	
	// ������Ϣ
	public abstract Template find(Class<Template> clazz, Integer id);
	public abstract List<Template> findAll(Class<Template> clazz);
	public abstract List<Template> findData(Template object);

	// ������Ϣ
	public abstract boolean insert(Template object);

	// ������Ϣ
	public abstract boolean update(Template object);

	// ɾ����Ϣ
	public abstract boolean delete(Class<Template> clazz, Integer id);
	public abstract boolean deleteData(Template object);
}
