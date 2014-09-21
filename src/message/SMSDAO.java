package message;


import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





public class SMSDAO extends HibernateDaoSupport implements ISMSDAO {
	
	// ������Ϣ
	@SuppressWarnings("unchecked")
	public List<SMS> findSmsByUserName(String userName) {
		List<SMS> smsList =  this.getHibernateTemplate().find("from Sms sms where sms.smsUserName=?",userName);
		return smsList;
	}     

	public SMS findSmsByID(Integer smsID) {
		SMS sms = (SMS) this.getHibernateTemplate().get(SMS.class,new Integer(smsID));
		return sms;
	}

	// ������Ϣ
	public boolean insertSms(SMS sms) {
		if (sms != null) {
			this.getHibernateTemplate().save(sms);
			return true;
		}
		return false;
	}

	// ������Ϣ
	public boolean updateSms(SMS sms) {
		if (sms != null) {		
			this.getHibernateTemplate().update(sms);
			return true;
		}
		return false;
	}

	// ɾ����Ϣ
	public boolean deleteSms(Integer smsID) {
		SMS sms = getHibernateTemplate().load(SMS.class, new Integer(smsID));
		if (sms != null) {		
			getHibernateTemplate().delete(sms);
			return true;
		}
		return false;
	}

}
