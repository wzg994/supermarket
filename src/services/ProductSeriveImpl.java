package services;

import java.util.List;

import beans.Product;
import dao.ProductDao;
import dao.ProductDaoImpl;

/*
 * 商品业务逻辑实现类
 */
public class ProductSeriveImpl implements ProductSerive {
	// 加载产品操作接口
	private ProductDao productDao;
	{
		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> showProduct() {
		return productDao.getProducts();
	}

	// 商品列表展示
	@Override
	public List<Product> getProductByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return productDao.getProductsByPage(begin, end);
	}

	// 分页查询商品信息
	@Override
	public int getAllpage(String pageSize) {
		int total = productDao.getProducts().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 根据id获取商品
	@Override
	public Product getProductById(int id) {
		Product product = productDao.getProductById(id);
		return product;
	}

	// 删除商品
	@Override
	public int deleProduct(Product product) {
		int out = productDao.deleProduct(product);
		return out;

	}

	// 新增商品
	@Override
	public int addProduct(Product product) {
		int out = productDao.intProduct(product);
		return out;
	}

	// 修改商品
	@Override
	public int updateProduct(Product product) {
		int out = productDao.updateProducts(product);
		return out;
	}

	// 根据商品名称模糊查询商品列表展示
	@Override
	public List<Product> selectProductByName(String shopname) {
		List<Product> selectProductByName = productDao.selectProductByName(shopname);
		return selectProductByName;
	}

}
