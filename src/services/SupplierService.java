package services;

import java.util.List;

import beans.Supplier;

/*
 * ��Ӧ��ҵ���߼���ӿ�
 */
public interface SupplierService {
	// ��ʾ��Ӧ��
	public List<Supplier> showSupplier();

	// ����id��ʾ��Ӧ��
	public Supplier getSupplierId(int id);

	// ��ҳ��ѯ
	public List<Supplier> getSupplierByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ɾ����Ӧ��
	public int deleSupplier(Supplier supplier);

	// ��ӹ�Ӧ��
	public int addSupplier(Supplier supplier);

	// �޸Ĺ�Ӧ��
	public int updateSupplier(Supplier supplier);
}
