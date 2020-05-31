package dao;

import java.util.List;

import beans.StaffAttend;

/*
 * Ա�����ڲ����ӿ�
 */
public interface StaffAttendDao {

	// ��ѯԱ��������Ϣ
	public List<StaffAttend> getStaffattends();

	// ��ҳ��ѯ�����б�
	public List<StaffAttend> getSatffattendByPage(int begin, int end);

	// ����Ա��id��ȡԱ��������Ϣ
	public StaffAttend getStaffattendById(int staffid);

	// ����Ա�����ƻ�ȡԱ��������Ϣ
	public StaffAttend getStaffattendByName(String staffname);

	// ����Ա��id��ѯԱ��������Ϣ
	public List<StaffAttend> selectStaffattend(StaffAttend staffAttend);

	// ��ӿ�����Ϣ
	public int addStaffattend(StaffAttend staffAttend);

	// ���¿�����Ϣ
	public int updateStaffattend(StaffAttend staffAttend);

	// ɾ��������Ϣ
	public int deleteStaffattend(StaffAttend staffAttend);
}
