package platform;

import java.util.List;

public interface InterfaceDAOCommon<Template> {
	
	// 查找信息
	public abstract Template find(Class<Template> clazz, Integer id);
	public abstract List<Template> findAll(Class<Template> clazz);
	public abstract List<Template> findData(Template object);

	// 增加信息
	public abstract boolean insert(Template object);

	// 更新信息
	public abstract boolean update(Template object);

	// 删除信息
	public abstract boolean delete(Class<Template> clazz, Integer id);
	public abstract boolean deleteData(Template object);
}
