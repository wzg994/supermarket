package services;

import java.util.List;

import beans.Supplier;
import dao.SupplierDao;
import dao.SupplierDaoImpl;

/*
 * ��Ӧ��ҵ���߼�ʵ����
 */
public class SupplierServiceImpl implements SupplierService {
	// ���ع�Ӧ�̲����ӿ�
	private SupplierDao supplierDao;
	{
		supplierDao = new SupplierDaoImpl();
	}

	// ��ʾ��Ӧ��
	@Override
	public List<Supplier> showSupplier() {
		return supplierDao.getSupplier();
	}

	// ɾ����Ӧ��
	@Override
	public int deleSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.deleSupplier(supplier);
		return out;
	}

	// ��ӹ�Ӧ��
	@Override
	public int addSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.addSupplier(supplier);
		return out;
	}

	// �޸Ĺ�Ӧ����Ϣ
	@Override
	public int updateSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.updateSupplier(supplier);
		return out;
	}

	// ���ݹ�Ӧ��id��ȡ��Ӧ����Ϣ
	@Override
	public Supplier getSupplierId(int id) {
		Supplier supplier;
		supplier = supplierDao.getSupById(id);
		return supplier;
	}

	// ��ҳ��ѯ
	@Override
	public List<Supplier> getSupplierByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return supplierDao.getSupplierByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = supplierDao.getSupplier().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
