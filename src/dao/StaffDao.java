package dao;

import java.util.List;

import beans.Staff;

/*
 * Ա�������ӿ�
 */
public interface StaffDao {

	// ��ѯԱ���б�
	public List<Staff> getStaff();

	// ��ѯԱ��
	public Staff selectStaff(String staffname, String password);

	// ����Ա��id��ѯԱ����Ϣ
	public Staff getStaffById(String staffid);

	// ��ҳ��ѯԱ����Ϣ
	public List<Staff> getStaffByPage(int begin, int end);

	// ����Ա��id��ѯԱ����Ϣ�б�
	public List<Staff> selcetStaff(Staff staff);

	// ��ѯԱ����
	public String selectStaffName(String staffname);

	// ���Ա��
	public int addStaff(Staff staff);

	// �޸�Ա��
	public int updateStaff(Staff staff);

	// ɾ��Ա��
	public int deleStaff(Staff staff);

	// ����Ա�����ֲ�ѯԱ��
	public Staff getStaffByName(String staffname);

	// ����Ա������ģ����ѯԱ���б�
	public List<Staff> selectStaffByName(String staffname);

}
