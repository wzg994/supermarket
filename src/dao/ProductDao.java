package dao;

import java.util.List;

import beans.Product;

/*
 * ��Ʒ�����ӿ�
 */
public interface ProductDao {
	// ��ѯ��Ʒ�б�
	public List<Product> getProducts();

	// ��ҳ��ѯ��Ʒ�б�
	public List<Product> getProductsByPage(int begin, int end);

	// ������Ʒid��ȡ��Ʒ
	public Product getProductById(int id);

	// ���ݶ�����Ų�ѯ�����б�
	public List<Product> selectProduct(Product product);

	// ������Ʒ
	public int intProduct(Product product);

	// �޸���Ʒ
	public int updateProducts(Product product);

	// ������Ʒ����
	public int updateProduct(Product product);

	// ɾ����Ʒ
	public int deleProduct(Product product);

	// ������Ʒ����ģ����ѯ��Ʒ�б�
	public List<Product> selectProductByName(String shopname);
}
