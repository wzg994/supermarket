package services;

import java.util.List;

import beans.Product;
import dao.ProductDao;
import dao.ProductDaoImpl;

/*
 * ��Ʒҵ���߼�ʵ����
 */
public class ProductSeriveImpl implements ProductSerive {
	// ���ز�Ʒ�����ӿ�
	private ProductDao productDao;
	{
		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> showProduct() {
		return productDao.getProducts();
	}

	// ��Ʒ�б�չʾ
	@Override
	public List<Product> getProductByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return productDao.getProductsByPage(begin, end);
	}

	// ��ҳ��ѯ��Ʒ��Ϣ
	@Override
	public int getAllpage(String pageSize) {
		int total = productDao.getProducts().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// ����id��ȡ��Ʒ
	@Override
	public Product getProductById(int id) {
		Product product = productDao.getProductById(id);
		return product;
	}

	// ɾ����Ʒ
	@Override
	public int deleProduct(Product product) {
		int out = productDao.deleProduct(product);
		return out;

	}

	// ������Ʒ
	@Override
	public int addProduct(Product product) {
		int out = productDao.intProduct(product);
		return out;
	}

	// �޸���Ʒ
	@Override
	public int updateProduct(Product product) {
		int out = productDao.updateProducts(product);
		return out;
	}

	// ������Ʒ����ģ����ѯ��Ʒ�б�չʾ
	@Override
	public List<Product> selectProductByName(String shopname) {
		List<Product> selectProductByName = productDao.selectProductByName(shopname);
		return selectProductByName;
	}

}
