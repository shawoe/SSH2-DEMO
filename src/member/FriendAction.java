package member;

@SuppressWarnings("serial")
public class FriendAction extends FriendActionBase {

	// ��Ӻ���
	public String addFriend() throws Exception {
		// ��������
		if (friendName == null || friendName.trim().length() == 0) {
			this.addFieldError("friendName", "��ѡ�����");
			return INPUT;
		}
		// ��Ӻ���
		String result = friendService.addFriend(friendName);
		if (result.equals(LOGIN)) {
			this.addActionError("����δ��¼�������µ�¼");
			return LOGIN;
		}
		if (result.equals(INPUT)) {
			this.addFieldError("friendName", "�����Ѵ���");
			return INPUT;
		}
		if (result.equals(SUCCESS)) {
			this.addActionMessage("�ɹ���Ӻ���");
			return SUCCESS;
		}
		this.addActionError("��Ӻ���ʧ��");
		return ERROR;
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

}
