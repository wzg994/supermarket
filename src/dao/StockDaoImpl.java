package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Stock;
import util.JDBCUtil;

/*
 * 商品库存操作接口实现类
 */
public class StockDaoImpl implements StockDao {

	// 查询库存信息列表
	@Override
	public List<Stock> getStocks() {
		List<Stock> stocks = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			stocks = new ArrayList<Stock>();
			String sql = "SELECT * FROM stock";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

				stocks.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stocks;
	}

	// 根据商品id查询库存信息
	@Override
	public Stock getStockById(int id) {
		Stock stock = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM stock WHERE shopid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				stock = new Stock();
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stock;
	}

	// 根据商品id查询库存信息列表
	@Override
	public List<Stock> selectSale(Stock stock) {
		List<Stock> stocks1 = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			stocks1=new ArrayList<Stock>();
			String sql = "SELECT * FROM stock WHERE shopid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, stock.getShopid());
			rs = ps.executeQuery();
			while (rs.next()) {
				stock = new Stock();
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

				stocks1.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stocks1;
	}

	// 新增库存信息
	@Override
	public int addSale(Stock stock) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO stock(shopid,shopname,shopnum,mark) VALUES(?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, stock.getShopid());
			ps.setObject(2, stock.getShopname());
			ps.setObject(3, stock.getShopnum());
			ps.setObject(4, stock.getMark());
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 修改库存信息
	@Override
	public int updateSale(Stock stock) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE stock SET shopname=?,shopnum=?,mark=? WHERE shopid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, stock.getShopname());
			ps.setObject(2, stock.getShopnum());
			ps.setObject(3, stock.getMark());
			ps.setObject(4, stock.getShopid());

			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 删除库存信息
	@Override
	public int deleSale(Stock stock) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM stock WHERE shopid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, stock.getShopid());
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 分页查询库存信息
	@Override
	public List<Stock> getStockByPage(int begin, int end) {
		List<Stock> stocks = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			stocks = new ArrayList<Stock>();
			String sql = "SELECT * FROM stock LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

				stocks.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stocks;
	}

	// 根据商品id查询库存信息列表
	@Override
	public List<Stock> selectStock(Stock stock) {
		List<Stock> stocks = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			stocks = new ArrayList<Stock>();
			String sql = "SELECT * FROM stock WHERE shopid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, stock.getShopid());
			rs = ps.executeQuery();
			while (rs.next()) {
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

				stocks.add(stock);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stocks;
	}

	// 根据商品名称模糊查询库存信息
	@Override
	public Stock getStockByName(String shopname) {
		Stock stock = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM stock WHERE shopname LIKE ?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, shopname + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				stock = new Stock();
				stock.setShopid(rs.getInt("shopid"));
				stock.setShopname(rs.getString("shopname"));
				stock.setShopnum(rs.getInt("shopnum"));
				stock.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return stock;
	}

}
