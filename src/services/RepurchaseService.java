package services;

import java.util.List;

import beans.Repurchase;

/*
 * �˻�ҵ���߼���ӿ�
 */
public interface RepurchaseService {
	// ��ʾ�˻���Ϣ�б�
	public List<Repurchase> showRepurchase();

	// ���ݶ���id��ʾ�˻���Ϣ
	public Repurchase getRepurchaseById(int id);

	// ��ҳ��ѯ
	public List<Repurchase> getRepurchaseByPage(String nowpage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ɾ���˻���Ϣ
	public int deleRepurcahse(Repurchase repurchase);

	// ����˻���Ϣ
	public int addRepurchase(Repurchase repurchase);

	// �޸��˻���Ϣ
	public int updateRechase(Repurchase repurchase);

	// �����˻���Ʒģ����ѯ�˻���Ϣ�б�
	public List<Repurchase> selectPepurchaseByName(String shopname);
}
