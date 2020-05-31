package services;

import java.util.List;

import beans.StaffAttend;
/*
 * ����ҵ���߼���ӿ�
 */
public interface AttendService {
	// ������Ϣ�б�չʾ
	public List<StaffAttend> showAttend();

	// ��ҳ��ѯ������Ϣ
	public List<StaffAttend> getAttendByPage(String nowpage, String pagesize);

	// ��ȡ��ҳ��
	public int getAllpage(String pagesize);

	// ����Ա��������ȡԱ��������Ϣ
	public StaffAttend getAttendByName(String staffname);

	// ��ӿ�����Ϣ
	public int addAttend(StaffAttend staffAttend);

	// ����Ա��id��ȡ��Ʒ
	public StaffAttend getAteendById(int id);

	// �޸Ŀ�����Ϣ
	public int updateAttend(StaffAttend staffAttend);

	// ɾ��������Ϣ
	public int deleAttend(StaffAttend staffAttend);

}
