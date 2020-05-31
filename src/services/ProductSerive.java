package services;

import java.util.List;

import beans.Product;

/*
 * ��Ʒҵ���߼���ӿ�
 */
public interface ProductSerive {
	// ��Ʒ�б�չʾ
	public List<Product> showProduct();

	// ��ҳ��ѯ��Ʒ��Ϣ
	public List<Product> getProductByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ����id��ȡ��Ʒ
	public Product getProductById(int id);

	// ɾ����Ʒ
	public int deleProduct(Product product);

	// �����Ʒ
	public int addProduct(Product product);

	// �޸���Ʒ
	public int updateProduct(Product product);

	// ������Ʒ����ģ����ѯ��Ʒ�б�չʾ
	public List<Product> selectProductByName(String shopname);

}
