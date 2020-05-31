package dao;

import java.util.List;

import beans.Repurchase;

/*
 * 退货信息操作接口
 */
public interface RepurchaseDao {
	// 查询退货信息列表
	public List<Repurchase> getRepurchase();

	// 根据商品id查询退货信息
	public Repurchase getRepurchaseById(int id);

	// 分页查询退货信息
	public List<Repurchase> getRepurchaseByPage(int begin, int end);

	// 查询退货信息
	public Repurchase selectRepurchase(Repurchase repurchase);

	// 添加退货信息
	public int addRepurchase(Repurchase repurchase);

	// 修改退货信息
	public int updateRepurchase(Repurchase repurchase);

	// 删除退货信息
	public int deleRepurchase(Repurchase repurchase);

	// 根据退货商品名称查询退货信息列表
	public List<Repurchase> selectRepurchases(Repurchase repurchase);

	// 根据商品名字查询退货信息
	public Repurchase getRepurchaseByName(String shopname);

	// 根据退货商品名称模糊查询退货信息列表
	public List<Repurchase> selectRepurchases(String shopname);

}
