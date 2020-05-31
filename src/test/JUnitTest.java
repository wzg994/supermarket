package test;
/*
 * 单元测试
 */

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
//import com.sun.org.apache.bcel.internal.generic.NEW;


import beans.Product;

import beans.Supadmin;
import beans.User;

import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.SupadminDao;
import dao.SupadminDaoImpl;

import services.SupadminService;
import services.SupadminServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import util.JDBCUtil;

public class JUnitTest {

	
//	@Test
//	public void test1() {
//		UserService userService=new UserServiceImpl();
//		
////		User user = userService.login("admin", "123");
////		System.out.println(user);
//		
//		User user = new User();
//		user.setUsername("root");
//		user.setPassword("123");
//		int register = userService.register(user);
//		if (register == 0) {
//			System.out.println("存在");
//		}else {
//			System.out.println("插入成功");
//		}
//		
//	}
	
//	@Test
//	public void test2() {
//		ShopSercice sercice=new ShopServiceImpl();
//		List<Shop> showShops = sercice.showShops();
//		
//		for (Shop shop : showShops) {
//			System.out.println(shop);		
//		}
//	}
//	
//	@Test
//	public void test3() {
//		System.out.println("分页");
//		ShopDao shopDao=new ShopDaoImpl();
//		List<Shop> shopsByPage = shopDao.getShopsByPage(2, 3);
//		for (Shop shop : shopsByPage) {
//			System.out.println(shop);
//		}
//	}
//	
//	@Test
//	public void test4() {
//		CarService carService=new CarServiceImpl();
//		List message = carService.getMessage(1);
//		System.out.println(new Gson().toJson(message));
//	}
//	
//
//	@Test
//	public void Test4() {
//		System.out.println("***************");
//		OrderBigDao bigDao=new OrderBigDaoImpl();
//		OrderBig big=new OrderBig();
//		big.setAdduser("admin");
//		big.setId("1100");
//		big.setPhone("186555122");
//		big.setUser("root");
//		big.setTotal_price(12.52);
//		bigDao.addOrderBig(big, JDBCUtil.getConn());
//		
//	}
	
//	@Test
//	public void Test5() {
////		ShopDao dao=new ShopDaoImpl();
////		Shop shop=new Shop();
//		
//		ShopDao shopDao=new ShopDaoImpl();
//		int shopsByPage = shopDao.saleShop1(60, 8);
//		System.out.println(shopsByPage);
////		int saleShop1 = dao.saleShop1(3, 5);
////		System.out.println(dao);
//	}
	
//	@Test
//	public void Test6() {
//		ProductDao productDao=new  ProductDaoImpl();
//		
//		Product product=new Product();
//		product.setPname("奶茶");
//		product.setPrice(15.2);
//		product.setProid("1");
//		productDao.updateProducts(product);
//		System.out.println("商品设计"+product);
//		System.out.println("价格为："+product.getPrice());
//		
//		
//	}
	
//	@Test
//	public void Test7() {
//		SupadminDao supadminDao=new  SupadminDaoImpl();
//		Supadmin selectSupadmin = supadminDao.selectSupadmin("0000", "0000");
//		System.out.println("测试"+selectSupadmin);
//	}
	
	@Test
	public void Test8() {
		SupadminService supadminDao=new SupadminServiceImpl();
		Supadmin login = supadminDao.login("0000", "0000");
		//Supadmin selectSupadmin = supadminDao.selectSupadmin("0000", "0000");
		System.out.println("测试11:"+login);
	}
	
}
