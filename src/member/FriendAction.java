package member;

import java.util.List;
import platform.BaseAction;

@SuppressWarnings("serial")
public class FriendAction extends BaseAction {
	
	// ��������
	protected String friendName;
	protected FriendService friendService;
	protected List<Friend> allFriends;

	// ��Ӻ���
	public String addFriend() throws Exception {
		// ��������
		if (friendName == null || friendName.trim().length() == 0) {
			this.addFieldError("friendName", "��ѡ�����");
			return INPUT;
		}
		// ��Ӻ���
		String result = friendService.addFriend(friendName);
		if (result.equals(INPUT)) {
			this.addFieldError("friendName", "�����Ѵ���");
			return INPUT;
		}
		return returnAction(result);
	}

	// �鿴���к���
	public String showAllFriends() throws Exception {
		allFriends = friendService.getAllFriends();
		if (allFriends != null) {
			this.addActionMessage("�鿴���к��ѳɹ�");
			return SUCCESS;
		}
		this.addActionMessage("��ǰû�к���");
		return NONE;
	}

	
	// Ĭ������Getter/Setter
	public String getFriendName() {
		return friendName;
	}

	public FriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public List<Friend> getAllFriends() {
		return allFriends;
	}

	public void setAllFriends(List<Friend> allFriends) {
		this.allFriends = allFriends;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
}
