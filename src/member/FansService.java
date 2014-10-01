package member;

import java.util.List;

import platform.BaseService;

public class FansService extends BaseService<Fans> {

	// ����ע������
	protected FansDAO fansDAO;
	
	// ���Ӻ���
	public String addFans(String fansName) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		Fans fans = fansDAO.selectUserData(currentUser,fansName);
		if (fans != null)
			return INPUT;
		// ���Ӻ���
		fans = new Fans();
		fans.setFansFollwer(currentUser);
		fans.setFansStar(fansName);
		fans.setFansTime(referCurrentDate());
		// ��ѯ�໥����
		Fans fansMutual = fansDAO.selectUserData(fansName,currentUser);
		if (fansMutual != null) {
			fans.setFansMutual(true);
			fansMutual.setFansMutual(true);
		} else {
			fans.setFansMutual(false);
		}
		// �������ݿ�
		if (fansMutual!=null && !fansDAO.update(fansMutual))
			return ERROR;
		// �������ݿ�
		if (fansDAO.insert(fans))
			return SUCCESS;
		return ERROR;
	}

	// ɾ��ָ������
	public String deleteFansByID(Integer fansID) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡָ������
		Fans fans = fansDAO.select(fansID);
		if (fans == null)
			return INPUT;
		if (fans.getFansFollwer().equals(currentUser))
			return NONE;
		// ��ѯ�໥����
		Fans fansMutual;
		if (fans.getFansMutual().equals("��")) {
			fansMutual = fansDAO.selectUserData(fans.getFansFollwer(), currentUser);
			fansMutual.setFansMutual(false);
		}
		// �������ݿ�
		//if (fansMutual!=null && !fansDAO.update(fansMutual))
		//	return ERROR;
		if (fansDAO.delete(fansID))
			return SUCCESS;
		return ERROR;
	}

	// ɾ������
	public String deleteFansByName(String fansName) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// ��ȡ����
		Fans fans = fansDAO.selectUserData(currentUser, fansName);
		if (fans == null)
			return INPUT;
		// ��ѯ�໥����
		Fans fansMutual;
		if (fans.getFansMutual().equals("��")) {
			fansMutual = fansDAO.selectUserData(fans.getFansFollwer(), currentUser);
			fansMutual.setFansMutual(false);
		}
		// �������ݿ�
		//if (fansMutual!=null && !fansDAO.update(fansMutual))
		//	return ERROR;
		if (fansDAO.deleteUserData(currentUser, fansName))
			return SUCCESS;
		return ERROR;
	}

	// ��ѯָ������
	public Fans findFansByID(Integer fansID) {
		return fansDAO.select(fansID);
	}

	// ��ѯ����
	public Fans findFansByName(String fansName) {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ����
		return fansDAO.selectUserData(currentUser, fansName);
	}

	// ��ѯ���к���
	public List<Fans> findAll() {
		// ��֤�û���¼
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// ��ѯ���к���
		return fansDAO.selectAll(currentUser);
	}

	// Ĭ������Getter/Setter
	public FansDAO getFansDAO() {
		return fansDAO;
	}

	public void setFansDAO(FansDAO fansDAO) {
		this.fansDAO = fansDAO;
	}

}
