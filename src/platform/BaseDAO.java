package platform;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseDAO<Template> extends HibernateDaoSupport implements InterfaceDAOCommon<Template> {

	// 查找数据项
	@SuppressWarnings("unchecked")
	public List<Template> findAll(Class<Template> clazz) {
		String HQL = "from" + clazz.getName() + "";
		List<Template> list = (List<Template>) this.getHibernateTemplate().find(HQL);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Template> findData(Template object) {
		List<Template> list = (List<Template>) this.getHibernateTemplate().findByExample(object);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Template find(Class<Template> clazz, Integer id) {
		Template object = (Template) this.getHibernateTemplate().get(clazz.getClass(), new Integer(id));
		return object;
	}

	// 增加数据项
	public boolean insert(Template object) {
		if (object != null) {
			this.getHibernateTemplate().save(object);
			return true;
		}
		return false;
	}

	// 更新数据项
	public boolean update(Template object) {
		if (object != null) {
			this.getHibernateTemplate().update(object);
			return true;
		}
		return false;
	}

	// 删除数据项
	@SuppressWarnings("unchecked")
	public boolean delete(Class<Template> clazz, Integer id) {
		Template object = (Template) this.getHibernateTemplate().load(clazz.getClass(), new Integer(id));
		if (object != null) {
			this.getHibernateTemplate().delete(object);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteData(Template object) {
		List<Template> list = (List<Template>) this.getHibernateTemplate().findByExample(object);
		if (list == null) 
			return false;
		for (int i = 0; i <= list.size(); i++) 
			this.getHibernateTemplate().delete(list.get(i));		
		return true;
	}

}
