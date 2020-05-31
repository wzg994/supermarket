package dao;

import java.util.List;

import beans.Repurchase;

/*
 * �˻���Ϣ�����ӿ�
 */
public interface RepurchaseDao {
	// ��ѯ�˻���Ϣ�б�
	public List<Repurchase> getRepurchase();

	// ������Ʒid��ѯ�˻���Ϣ
	public Repurchase getRepurchaseById(int id);

	// ��ҳ��ѯ�˻���Ϣ
	public List<Repurchase> getRepurchaseByPage(int begin, int end);

	// ��ѯ�˻���Ϣ
	public Repurchase selectRepurchase(Repurchase repurchase);

	// ����˻���Ϣ
	public int addRepurchase(Repurchase repurchase);

	// �޸��˻���Ϣ
	public int updateRepurchase(Repurchase repurchase);

	// ɾ���˻���Ϣ
	public int deleRepurchase(Repurchase repurchase);

	// �����˻���Ʒ���Ʋ�ѯ�˻���Ϣ�б�
	public List<Repurchase> selectRepurchases(Repurchase repurchase);

	// ������Ʒ���ֲ�ѯ�˻���Ϣ
	public Repurchase getRepurchaseByName(String shopname);

	// �����˻���Ʒ����ģ����ѯ�˻���Ϣ�б�
	public List<Repurchase> selectRepurchases(String shopname);

}
