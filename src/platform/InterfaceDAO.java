package platform;

import java.util.List;

public interface InterfaceDAO<Template> {
	
	// ������Ϣ
	public abstract List<Template> selectAll(String clazz);
	public abstract List<Template> select(Template object);

	// ������Ϣ
	public abstract boolean insert(Template object);

	// ������Ϣ
	public abstract boolean update(Template object);

	// ɾ����Ϣ
	public abstract boolean delete(Template object);
}
