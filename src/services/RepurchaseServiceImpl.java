package services;

import java.util.List;

import beans.Repurchase;
import dao.RepurchaseDao;
import dao.RepurchaseDaoImpl;

/*
 * 退货业务逻辑实现类
 */
public class RepurchaseServiceImpl implements RepurchaseService {
	// 加载退货操作接口
	private RepurchaseDao repurchaseDao;
	{
		repurchaseDao = new RepurchaseDaoImpl();
	}

	// 显示退货信息列表
	@Override
	public List<Repurchase> showRepurchase() {
		return repurchaseDao.getRepurchase();
	}

	// 根据订单id显示退货信息
	@Override
	public Repurchase getRepurchaseById(int id) {
		Repurchase repurchase = repurchaseDao.getRepurchaseById(id);
		return repurchase;
	}

	// 删除退货信息
	@Override
	public int deleRepurcahse(Repurchase repurchase) {
		int out = repurchaseDao.deleRepurchase(repurchase);
		return out;
	}

	// 新增退货信息
	@Override
	public int addRepurchase(Repurchase repurchase) {
		int out = repurchaseDao.addRepurchase(repurchase);
		return out;
	}

	// 修改退货信息
	@Override
	public int updateRechase(Repurchase repurchase) {
		int out = repurchaseDao.updateRepurchase(repurchase);
		return out;
	}

	// 分页查询
	@Override
	public List<Repurchase> getRepurchaseByPage(String nowpage, String pageSize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return repurchaseDao.getRepurchaseByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = repurchaseDao.getRepurchase().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 根据退货商品模糊查询退货信息列表
	@Override
	public List<Repurchase> selectPepurchaseByName(String shopname) {
		List<Repurchase> selectRepurchases = repurchaseDao.selectRepurchases(shopname);
		return selectRepurchases;
	}

}
