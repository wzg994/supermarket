package services;

import java.util.List;

import beans.StaffAttend;
import dao.StaffAttendDao;
import dao.StaffAttendDaoImpl;

/*
 * ����ҵ���߼�ʵ����
 */
public class AttendServiceImpl implements AttendService {
	// ���ؿ��ڲ����ӿ�
	private StaffAttendDao staffattendDao;
	{
		staffattendDao = new StaffAttendDaoImpl();
	}

	// ������Ϣ�б�չʾ
	@Override
	public List<StaffAttend> showAttend() {
		return staffattendDao.getStaffattends();
	}

	// ��ҳ��ѯ������Ϣ
	@Override
	public List<StaffAttend> getAttendByPage(String nowpage, String pagesize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pagesize));
		int end = Integer.parseInt(pagesize);

		return staffattendDao.getSatffattendByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pagesize) {
		int total = staffattendDao.getStaffattends().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pagesize)));
		return allpage;
	}

	// ����Ա��id��ȡԱ��������Ϣ
	@Override
	public StaffAttend getAteendById(int id) {
		StaffAttend staffAttend = staffattendDao.getStaffattendById(id);
		return staffAttend;
	}

	// ����Ա��������Ϣ
	@Override
	public int updateAttend(StaffAttend staffAttend) {
		int out = staffattendDao.updateStaffattend(staffAttend);
		return out;
	}

	// ɾ��Ա��������Ϣ
	@Override
	public int deleAttend(StaffAttend staffAttend) {
		int out = staffattendDao.deleteStaffattend(staffAttend);
		return out;
	}

	// ����������Ϣ
	@Override
	public int addAttend(StaffAttend staffAttend) {
		int out = staffattendDao.addStaffattend(staffAttend);
		return out;
	}

	// ����Ա��������ѯԱ����Ϣ
	@Override
	public StaffAttend getAttendByName(String staffname) {
		StaffAttend staffAttend = staffattendDao.getStaffattendByName(staffname);
		return staffAttend;
	}

}
