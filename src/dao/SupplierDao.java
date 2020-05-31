package dao;

import java.util.List;

import beans.Supplier;

/*
 * ��Ӧ�̲����ӿ�
 */
public interface SupplierDao {

	// ��ѯ��Ӧ���б�
	public List<Supplier> getSupplier();

	// ���ݹ�Ӧ��id��ȡ��Ӧ����Ϣ
	public Supplier getSupById(int id);

	// ��ѯ��Ӧ��
	public Supplier selectSupplier(Supplier supplier);

	// ��ҳ��ѯ��Ӧ����Ϣ
	public List<Supplier> getSupplierByPage(int begin, int end);

	// ��ӹ�Ӧ��
	public int addSupplier(Supplier supplier);

	// �޸Ĺ�Ӧ����Ϣ
	public int updateSupplier(Supplier supplier);

	// ɾ����Ӧ��
	public int deleSupplier(Supplier supplier);

	// ���ݹ�Ӧ�����Ʋ�ѯ��Ϣ
	public List<Supplier> getSupplier(String suppilername);
}
