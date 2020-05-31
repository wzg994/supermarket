package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Sale;
import util.JDBCUtil;

/*
 *销售操作接口实现类 
 */
public class SaleDaoImpl implements SaleDao {

	// 查询销售信息列表
	@Override
	public List<Sale> getSales() {
		List<Sale> sales = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sales = new ArrayList<Sale>();
			String sql = "SELECT * FROM sale";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setSaleid(rs.getInt("saleid"));
				sale.setShopid(rs.getInt("shopid"));
				sale.setShopname(rs.getString("shopname"));
				sale.setShopprice(rs.getDouble("shopprice"));
				sale.setShopnum(rs.getInt("shopnum"));
				sale.setTotalprice(rs.getDouble("totalprice"));
				sale.setSaledate(rs.getDate("saledate"));
				sale.setCusname(rs.getString("cusid"));
				sale.setCusid(rs.getString("cusid"));
				sale.setMark(rs.getString("mark"));

				sales.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return sales;
	}

	// 根据销售id查询销售信息
	@Override
	public Sale getSaleById(int id) {
		Sale sale = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM sale WHERE saleid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				sale = new Sale();
				sale.setSaleid(rs.getInt("saleid"));
				sale.setShopid(rs.getInt("shopid"));
				sale.setShopname(rs.getString("shopname"));
				sale.setShopprice(rs.getDouble("shopprice"));
				sale.setShopnum(rs.getInt("shopnum"));
				sale.setTotalprice(rs.getDouble("totalprice"));
				sale.setSaledate(rs.getDate("saledate"));
				sale.setCusname(rs.getString("cusid"));
				sale.setCusid(rs.getString("cusid"));
				sale.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return sale;
	}

	// 根据销售id查询销售信息
	@Override
	public Sale selectSale(Sale sale) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM sale WHERE saleid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, sale.getSaleid());
			rs = ps.executeQuery();
			while (rs.next()) {
				sale.setSaleid(rs.getInt("saleid"));
				sale.setShopid(rs.getInt("shopid"));
				sale.setShopname(rs.getString("shopname"));
				sale.setShopprice(rs.getDouble("shopprice"));
				sale.setShopnum(rs.getInt("shopnum"));
				sale.setTotalprice(rs.getDouble("totalprice"));
				sale.setSaledate(rs.getDate("saledate"));
				sale.setCusname(rs.getString("cusname"));
				sale.setCusid(rs.getString("cusid"));
				sale.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return sale;
	}

	// 新增销售信息
	@Override
	public int addSale(Sale sale) {
		int out = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO sale(saleid,shopid,shopname,shopprice,shopnum,totalprice,saledate,cusname,cusid,mark) VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, sale.getSaleid());
			ps.setObject(2, sale.getShopid());
			ps.setObject(3, sale.getShopname());
			ps.setObject(4, sale.getShopprice());
			ps.setObject(5, sale.getShopnum());
			ps.setObject(6, sale.getTotalprice());
			ps.setObject(7, sale.getSaledate());
			ps.setObject(8, sale.getCusid());
			ps.setObject(9, sale.getCusname());
			ps.setObject(10, sale.getMark());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return out;
	}

	// 修改销售信息
	@Override
	public int updateSale(Sale sale) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE sale SET shopid=?,shopname=?,shopprice=?,shopnum=?,saledate=?,cusid=?,cusname=?,mark=? WHERE saleid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, sale.getShopid());
			ps.setObject(2, sale.getShopname());
			ps.setObject(3, sale.getShopprice());
			ps.setObject(4, sale.getShopnum());
			ps.setObject(5, sale.getSaledate());
			ps.setObject(6, sale.getCusid());
			ps.setObject(7, sale.getCusname());
			ps.setObject(8, sale.getMark());
			ps.setObject(9, sale.getSaleid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 删除销售信息
	@Override
	public int deleSale(Sale sale) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM sale WHERE saleid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, sale.getSaleid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 分页查询销售信息
	@Override
	public List<Sale> getSaleByPage(int begin, int end) {
		List<Sale> sales = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sales = new ArrayList<Sale>();
			String sql = "SELECT * FROM sale LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setSaleid(rs.getInt("saleid"));
				sale.setShopid(rs.getInt("shopid"));
				sale.setShopname(rs.getString("shopname"));
				sale.setShopprice(rs.getDouble("shopprice"));
				sale.setShopnum(rs.getInt("shopnum"));
				sale.setTotalprice(rs.getDouble("totalprice"));
				sale.setSaledate(rs.getDate("saledate"));
				sale.setCusname(rs.getString("cusid"));
				sale.setCusid(rs.getString("cusid"));
				sale.setMark(rs.getString("mark"));

				sales.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return sales;
	}

	// 根据销售id查询销售信息列表
	@Override
	public List<Sale> selectSales(Sale sale) {
		List<Sale> sales = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sales = new ArrayList<Sale>();
			String sql = "SELECT * FROM sale WHERE saleid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, sale.getSaleid());
			rs = ps.executeQuery();
			while (rs.next()) {
				sale.setSaleid(rs.getInt("saleid"));
				sale.setShopid(rs.getInt("shopid"));
				sale.setShopname(rs.getString("shopname"));
				sale.setShopprice(rs.getDouble("shopprice"));
				sale.setShopnum(rs.getInt("shopnum"));
				sale.setTotalprice(rs.getDouble("totalprice"));
				sale.setSaledate(rs.getDate("saledate"));
				sale.setCusname(rs.getString("cusname"));
				sale.setCusid(rs.getString("cusid"));
				sale.setMark(rs.getString("mark"));

				sales.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return sales;
	}

}
