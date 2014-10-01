package platform;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BaseDAO<Template> extends HibernateDaoSupport implements InterfaceDAO<Template> {

	// ����������
	@SuppressWarnings("unchecked")
	public List<Template> selectAll(String clazz) {
		String HQL = "from " + clazz + "";
		List<Template> list = (List<Template>) this.getHibernateTemplate().find(HQL);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Template> select(Template object) {
		List<Template> list = (List<Template>) this.getHibernateTemplate().findByExample(object);
		return list;
	}

	// ����������
	public boolean insert(Template object) {
		if (object != null) {
			this.getHibernateTemplate().save(object);
			return true;
		}
		return false;
	}

	// ����������
	public boolean update(Template object) {
		if (object != null) {
			this.getHibernateTemplate().update(object);
			return true;
		}
		return false;
	}

	// ɾ��������
	@SuppressWarnings("unchecked")
	public boolean delete(Template object) {
		List<Template> list = (List<Template>) this.getHibernateTemplate().findByExample(object);
		if (list == null) 
			return false;
		for (int i = 0; i <= list.size(); i++) 
			this.getHibernateTemplate().delete(list.get(i));		
		return true;
	}

}
