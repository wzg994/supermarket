package services;

import java.util.List;

import beans.Product;

/*
 * 商品业务逻辑层接口
 */
public interface ProductSerive {
	// 商品列表展示
	public List<Product> showProduct();

	// 分页查询商品信息
	public List<Product> getProductByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 根据id获取商品
	public Product getProductById(int id);

	// 删除商品
	public int deleProduct(Product product);

	// 添加商品
	public int addProduct(Product product);

	// 修改商品
	public int updateProduct(Product product);

	// 根据商品名称模糊查询商品列表展示
	public List<Product> selectProductByName(String shopname);

}
