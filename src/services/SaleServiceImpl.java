package services;

import java.util.List;

import beans.Sale;
import dao.SaleDao;
import dao.SaleDaoImpl;

/*
 * ����ҵ���߼�ʵ�ֽӿ�
 */
public class SaleServiceImpl implements SaleService {
	// �������۲����ӿ�
	private SaleDao saleDao;
	{
		saleDao = new SaleDaoImpl();
	}

	// ��ʾ������Ϣ�б�
	@Override
	public List<Sale> showSales() {
		return saleDao.getSales();
	}

	// ����id��ʾ������Ϣ
	@Override
	public Sale getSaleId(int id) {
		Sale sale = null;
		sale = saleDao.getSaleById(id);
		return sale;
	}

	// ɾ��������Ϣ
	@Override
	public int deleSale(Sale sale) {
		int out = 0;
		out = saleDao.deleSale(sale);
		return out;
	}

	// ���������Ϣ
	@Override
	public int addSale(Sale sale) {
		int out = 0;
		out = saleDao.addSale(sale);
		return out;
	}

	// �޸�������Ϣ
	@Override
	public int updateSale(Sale sale) {
		int out = 0;
		out = saleDao.updateSale(sale);
		return out;
	}

	// ��ҳ��ѯ
	@Override
	public List<Sale> getSaleByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return saleDao.getSaleByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = saleDao.getSales().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
