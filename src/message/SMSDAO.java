package message;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import api.InterfaceDAO;

public class SMSDAO extends HibernateDaoSupport implements InterfaceDAO<SMS> {
	
	// 查找信息
	@SuppressWarnings("unchecked")
	public List<SMS> findDataByUserName(String userName) {
		List<SMS> smsList =  this.getHibernateTemplate().find("from Sms sms where sms.smsUserName=?",userName);
		return smsList;
	}     

	public SMS find(Integer smsID) {
		SMS sms = (SMS) this.getHibernateTemplate().get(SMS.class, new Integer(smsID));
		return sms;
	}

	// 增加信息
	public boolean insert(SMS sms) {
		if (sms != null) {
			this.getHibernateTemplate().save(sms);
			return true;
		}
		return false;
	}

	// 更新信息
	public boolean update(SMS sms) {
		if (sms != null) {		
			this.getHibernateTemplate().update(sms);
			return true;
		}
		return false;
	}

	// 删除信息
	public boolean delete(Integer smsID) {
		SMS sms = getHibernateTemplate().load(SMS.class, new Integer(smsID));
		if (sms != null) {		
			getHibernateTemplate().delete(sms);
			return true;
		}
		return false;
	}

	public boolean deleteDataByUserName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<SMS> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
