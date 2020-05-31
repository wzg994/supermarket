package services;

import java.util.List;

import beans.Staff;

/*
 * Ա��ҵ���߼���ӿ�
 */
public interface StaffService {

	// Ա����Ϣչʾ
	public List<Staff> showStaffs();

	// ����Ա��id��ѯԱ����Ϣ
	public Staff getStaffById(String staffid);

	// ��ҳ��ѯ
	public List<Staff> getStaffByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// Ա����Ϣɾ��
	public int deleStaff(Staff staff);

	// Ա����Ϣɾ��
	public int updateStaff(Staff staff);

	// ����Ա��
	public int addStaff(Staff staff);

	// Ա��ע��
	public int regstaff(Staff staff);

	// Ա����¼
	public Staff logstaff(String staffname, String staffpassword);

	// �޸�Ա������
	public int updatePassword(Staff staff);

	// ��֤�˺�
	public boolean existName(String staffname);

	// ����Ա��������ѯԱ��
	public Staff getStaffByName(String staffname);

	// ����Ա������ģ����ѯԱ��
	public List<Staff> selectStaffByName(String staffname);
}
