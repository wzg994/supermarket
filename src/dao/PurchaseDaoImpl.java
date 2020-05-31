package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Purchase;
import util.JDBCUtil;

/*
 * ���������ӿ�ʵ����
 */
public class PurchaseDaoImpl implements PurchaseDao {

	// ��ѯ�˻��б�
	@Override
	public List<Purchase> getPurchases() {
		List<Purchase> purchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			purchases = new ArrayList<Purchase>();
			String sql = "SELECT * FROM purchase";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurid(rs.getInt("purid"));
				purchase.setShopid(rs.getString("shopid"));
				purchase.setShopname(rs.getString("shopname"));
				purchase.setShopprice(rs.getDouble("shopprice"));
				purchase.setShopnum(rs.getInt("shopnum"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setSupname(rs.getString("supname"));

				purchases.add(purchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return purchases;
	}

	// ��ҳ��ѯ������Ϣ
	@Override
	public List<Purchase> getPurchaseByPage(int bengin, int end) {
		List<Purchase> purchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			purchases = new ArrayList<Purchase>();
			String sql = "SELECT * FROM purchase LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, bengin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurid(rs.getInt("purid"));
				purchase.setShopid(rs.getString("shopid"));
				purchase.setShopname(rs.getString("shopname"));
				purchase.setShopprice(rs.getDouble("shopprice"));
				purchase.setShopnum(rs.getInt("shopnum"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setSupname(rs.getString("supname"));

				purchases.add(purchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return purchases;
	}

	// �����˻�id��ѯ������Ϣ
	@Override
	public Purchase getPurchaseById(int id) {
		Purchase purchase = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM purchase WHERE purid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				purchase = new Purchase();
				purchase.setPurid(rs.getInt("purid"));
				purchase.setShopid(rs.getString("shopid"));
				purchase.setShopname(rs.getString("shopname"));
				purchase.setShopprice(rs.getDouble("shopprice"));
				purchase.setShopnum(rs.getInt("shopnum"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setSupname(rs.getString("supname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return purchase;
	}

	// ����������Ϣ
	@Override
	public int addPurchase(Purchase purchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO purchase(purid,shopid,shopname,shopprice,shopnum,purdate,supname) VALUES(?,?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, purchase.getPurid());
			ps.setObject(2, purchase.getShopid());
			ps.setObject(3, purchase.getShopname());
			ps.setObject(4, purchase.getShopprice());
			ps.setObject(5, purchase.getShopnum());
			ps.setObject(6, purchase.getPurdate());
			ps.setObject(7, purchase.getSupname());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �޸Ľ�����Ϣ
	@Override
	public int updatePurchase(Purchase purchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE purchase SET shopid=?,shopname=?,shopprice=?,shopnum=?,purdate=?,supname=? WHERE purid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, purchase.getShopid());
			ps.setObject(2, purchase.getShopname());
			ps.setObject(3, purchase.getShopprice());
			ps.setObject(4, purchase.getShopnum());
			ps.setObject(5, purchase.getPurdate());
			ps.setObject(6, purchase.getSupname());
			ps.setObject(7, purchase.getPurid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ɾ��������Ϣ
	@Override
	public int delePurchase(Purchase purchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM purchase where purid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, purchase.getPurid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ���ݽ���id��ѯ������Ϣ
	@Override
	public List<Purchase> selectPurchase(Purchase purchase) {
		List<Purchase> purchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			purchases = new ArrayList<Purchase>();
			String sql = "SELECT * FROM purchase WHERE purid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, purchase.getPurid());
			rs = ps.executeQuery();
			while (rs.next()) {
				purchase = new Purchase();
				purchase.setPurid(rs.getInt("purid"));
				purchase.setShopid(rs.getString("shopid"));
				purchase.setShopname(rs.getString("shopname"));
				purchase.setShopprice(rs.getDouble("shopprice"));
				purchase.setShopnum(rs.getInt("shopnum"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setSupname(rs.getString("supname"));

				purchases.add(purchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return purchases;
	}

	// ������Ʒ����ģ����ѯ������Ϣ
	@Override
	public List<Purchase> selectPurchaseByName(String shopname) {
		List<Purchase> purchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			purchases = new ArrayList<Purchase>();
			String sql = "SELECT * FROM purchase WHERE shopname LIKE ?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, "%" + shopname + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Purchase purchase = new Purchase();
				purchase.setPurid(rs.getInt("purid"));
				purchase.setShopid(rs.getString("shopid"));
				purchase.setShopname(rs.getString("shopname"));
				purchase.setShopprice(rs.getDouble("shopprice"));
				purchase.setShopnum(rs.getInt("shopnum"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setSupname(rs.getString("supname"));

				purchases.add(purchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return purchases;
	}

}
