package api;

import java.util.List;

public interface InterfaceDAO<Template> {
	
	// 查找信息
	public abstract Template find(Integer id);
	public abstract List<Template> findAll();
	public abstract List<Template> findDataByUserName(String name);

	// 增加信息
	public abstract boolean insert(Template object);

	// 更新信息
	public abstract boolean update(Template object);

	// 删除信息
	public abstract boolean delete(Integer id);
	public abstract boolean deleteDataByUserName(String name);
}
