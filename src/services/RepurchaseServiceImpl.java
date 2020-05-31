package services;

import java.util.List;

import beans.Repurchase;
import dao.RepurchaseDao;
import dao.RepurchaseDaoImpl;

/*
 * �˻�ҵ���߼�ʵ����
 */
public class RepurchaseServiceImpl implements RepurchaseService {
	// �����˻������ӿ�
	private RepurchaseDao repurchaseDao;
	{
		repurchaseDao = new RepurchaseDaoImpl();
	}

	// ��ʾ�˻���Ϣ�б�
	@Override
	public List<Repurchase> showRepurchase() {
		return repurchaseDao.getRepurchase();
	}

	// ���ݶ���id��ʾ�˻���Ϣ
	@Override
	public Repurchase getRepurchaseById(int id) {
		Repurchase repurchase = repurchaseDao.getRepurchaseById(id);
		return repurchase;
	}

	// ɾ���˻���Ϣ
	@Override
	public int deleRepurcahse(Repurchase repurchase) {
		int out = repurchaseDao.deleRepurchase(repurchase);
		return out;
	}

	// �����˻���Ϣ
	@Override
	public int addRepurchase(Repurchase repurchase) {
		int out = repurchaseDao.addRepurchase(repurchase);
		return out;
	}

	// �޸��˻���Ϣ
	@Override
	public int updateRechase(Repurchase repurchase) {
		int out = repurchaseDao.updateRepurchase(repurchase);
		return out;
	}

	// ��ҳ��ѯ
	@Override
	public List<Repurchase> getRepurchaseByPage(String nowpage, String pageSize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return repurchaseDao.getRepurchaseByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = repurchaseDao.getRepurchase().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// �����˻���Ʒģ����ѯ�˻���Ϣ�б�
	@Override
	public List<Repurchase> selectPepurchaseByName(String shopname) {
		List<Repurchase> selectRepurchases = repurchaseDao.selectRepurchases(shopname);
		return selectRepurchases;
	}

}
