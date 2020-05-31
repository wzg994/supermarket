package services;

import java.util.List;

import beans.Staff;
import dao.StaffDao;
import dao.StaffDaoImpl;

/*
 * Ա��ҵ���߼�ʵ����
 */
public class StaffServiceImpl implements StaffService {
	// ����Ա�������ӿ�
	private StaffDao staffDao;
	{
		staffDao = new StaffDaoImpl();
	}

	// Ա����Ϣչʾ
	@Override
	public List<Staff> showStaffs() {
		return staffDao.getStaff();
	}

	// Ա����Ϣɾ��
	@Override
	public int deleStaff(Staff staff) {
		int out = staffDao.deleStaff(staff);
		return out;
	}

	// Ա��ע��
	@Override
	public int regstaff(Staff staff) {
		int out = 0;
		// ��ѯԱ������
		String staffname = staffDao.selectStaffName(staff.getStaffname());
		// �ж�Ա�������Ƿ���ڣ����Ա�����ƴ����򷵻�0���������򴴽���Ա��
		if (staffname != null) {
			out = 0;
		} else {
			out = staffDao.addStaff(staff);
		}
		return out;
	}

	// Ա����¼
	@Override
	public Staff logstaff(String staffname, String staffpassword) {
		Staff staff = staffDao.selectStaff(staffname, staffpassword);
		return staff;
	}

	// ��ҳ��ѯ
	@Override
	public List<Staff> getStaffByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return staffDao.getStaffByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = staffDao.getStaff().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// ����Ա��
	@Override
	public int addStaff(Staff staff) {
		int out = staffDao.addStaff(staff);
		return out;
	}

	// �޸�Ա������
	@Override
	public int updatePassword(Staff staff) {
		int out = staffDao.updateStaff(staff);
		return out;
	}

	// ��֤�˺�
	@Override
	public boolean existName(String staffname) {
		Staff staff = staffDao.getStaffByName(staffname);
		if (staff != null)
			return true;
		return false;
	}

	// ����Ա��������ѯԱ��
	@Override
	public List<Staff> selectStaffByName(String staffname) {
		List<Staff> selectStaffByName = staffDao.selectStaffByName(staffname);
		return selectStaffByName;
	}

	// �޸�Ա����Ϣ
	@Override
	public int updateStaff(Staff staff) {
		int out = staffDao.updateStaff(staff);
		return out;
	}

	// ����Ա��id��ѯԱ����Ϣ
	@Override
	public Staff getStaffById(String staffid) {
		Staff staffById = staffDao.getStaffById(staffid);
		return staffById;
	}

	// ����Ա������ģ����ѯԱ��
	@Override
	public Staff getStaffByName(String staffname) {
		Staff staffByName = staffDao.getStaffByName(staffname);
		return staffByName;
	}

}
