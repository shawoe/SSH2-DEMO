package member;

import java.util.List;

import platform.BaseService;

public class FansService extends BaseService<Fans> {

	// 依赖注入属性
	protected FansDAO fansDAO;
	
	// 增加好友
	public String addFans(String fansName) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		Fans fans = fansDAO.selectUserData(currentUser,fansName);
		if (fans != null)
			return INPUT;
		// 增加好友
		fans = new Fans();
		fans.setFansFollwer(currentUser);
		fans.setFansStar(fansName);
		fans.setFansTime(referCurrentDate());
		// 查询相互好友
		Fans fansMutual = fansDAO.selectUserData(fansName,currentUser);
		if (fansMutual != null) {
			fans.setFansMutual(true);
			fansMutual.setFansMutual(true);
		} else {
			fans.setFansMutual(false);
		}
		// 更新数据库
		if (fansMutual!=null && !fansDAO.update(fansMutual))
			return ERROR;
		// 存至数据库
		if (fansDAO.insert(fans))
			return SUCCESS;
		return ERROR;
	}

	// 删除指定好友
	public String deleteFansByID(Integer fansID) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取指定好友
		Fans fans = fansDAO.select(fansID);
		if (fans == null)
			return INPUT;
		if (fans.getFansFollwer().equals(currentUser))
			return NONE;
		// 查询相互好友
		Fans fansMutual;
		if (fans.getFansMutual().equals("是")) {
			fansMutual = fansDAO.selectUserData(fans.getFansFollwer(), currentUser);
			fansMutual.setFansMutual(false);
		}
		// 更新数据库
		//if (fansMutual!=null && !fansDAO.update(fansMutual))
		//	return ERROR;
		if (fansDAO.delete(fansID))
			return SUCCESS;
		return ERROR;
	}

	// 删除好友
	public String deleteFansByName(String fansName) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return LOGIN;
		// 获取好友
		Fans fans = fansDAO.selectUserData(currentUser, fansName);
		if (fans == null)
			return INPUT;
		// 查询相互好友
		Fans fansMutual;
		if (fans.getFansMutual().equals("是")) {
			fansMutual = fansDAO.selectUserData(fans.getFansFollwer(), currentUser);
			fansMutual.setFansMutual(false);
		}
		// 更新数据库
		//if (fansMutual!=null && !fansDAO.update(fansMutual))
		//	return ERROR;
		if (fansDAO.deleteUserData(currentUser, fansName))
			return SUCCESS;
		return ERROR;
	}

	// 查询指定好友
	public Fans findFansByID(Integer fansID) {
		return fansDAO.select(fansID);
	}

	// 查询好友
	public Fans findFansByName(String fansName) {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询好友
		return fansDAO.selectUserData(currentUser, fansName);
	}

	// 查询所有好友
	public List<Fans> findAll() {
		// 验证用户登录
		if (currentUser == null || currentUser.trim().length() == 0)
			return null;
		// 查询所有好友
		return fansDAO.selectAll(currentUser);
	}

	// 默认属性Getter/Setter
	public FansDAO getFansDAO() {
		return fansDAO;
	}

	public void setFansDAO(FansDAO fansDAO) {
		this.fansDAO = fansDAO;
	}

}
