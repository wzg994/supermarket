package dao;

import java.util.List;

import beans.Product;

/*
 * 商品操作接口
 */
public interface ProductDao {
	// 查询商品列表
	public List<Product> getProducts();

	// 分页查询商品列表
	public List<Product> getProductsByPage(int begin, int end);

	// 根据商品id获取商品
	public Product getProductById(int id);

	// 根据订单编号查询货物列表
	public List<Product> selectProduct(Product product);

	// 新增商品
	public int intProduct(Product product);

	// 修改商品
	public int updateProducts(Product product);

	// 更新商品数量
	public int updateProduct(Product product);

	// 删除商品
	public int deleProduct(Product product);

	// 根据商品名称模糊查询商品列表
	public List<Product> selectProductByName(String shopname);
}
