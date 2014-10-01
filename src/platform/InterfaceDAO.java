package platform;

import java.util.List;

public interface InterfaceDAO<Template> {
	
	// 查找信息
	public abstract List<Template> selectAll(String clazz);
	public abstract List<Template> select(Template object);

	// 增加信息
	public abstract boolean insert(Template object);

	// 更新信息
	public abstract boolean update(Template object);

	// 删除信息
	public abstract boolean delete(Template object);
}
