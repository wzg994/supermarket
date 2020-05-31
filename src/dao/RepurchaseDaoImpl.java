package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Repurchase;
import util.JDBCUtil;

/*
 * �˻������ӿ�ʵ����
 */
public class RepurchaseDaoImpl implements RepurchaseDao {

	// ��ѯ�˻���Ϣ�б�
	@Override
	public List<Repurchase> getRepurchase() {
		List<Repurchase> repurchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			repurchases = new ArrayList<Repurchase>();
			String sql = "SELECT * FROM repurchase";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Repurchase repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));

				repurchases.add(repurchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchases;
	}

	// �����˻�id��ѯ�˻���Ϣ
	@Override
	public Repurchase getRepurchaseById(int id) {
		Repurchase repurchase = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM repurchase WHERE repurid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchase;
	}

	// ��ѯ�˻���Ϣ
	@Override
	public Repurchase selectRepurchase(Repurchase repurchase) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM repurchase WHERE repurid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, repurchase.getRepurid());
			rs = ps.executeQuery();
			while (rs.next()) {
				repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchase;
	}

	// �����˻���Ϣ
	@Override
	public int addRepurchase(Repurchase repurchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO repurchase(purid,shopid,shopname,shopprice,shopnum,purdate,redate,reson,mark) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, repurchase.getPurid());
			ps.setObject(2, repurchase.getShopid());
			ps.setObject(3, repurchase.getShopname());
			ps.setObject(4, repurchase.getShopprice());
			ps.setObject(5, repurchase.getShopnum());
			ps.setObject(6, repurchase.getPurdate());
			ps.setObject(7, repurchase.getRedate());
			ps.setObject(8, repurchase.getReson());
			ps.setObject(9, repurchase.getMark());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �޸��˻���Ϣ
	@Override
	public int updateRepurchase(Repurchase repurchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE repurchase SET purid=?,shopid=?,shopname=?,shopprice=?,shopnum=?,purdate=?,redate=?,reson=?,mark=? WHERE repurid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, repurchase.getPurid());
			ps.setObject(2, repurchase.getShopid());
			ps.setObject(3, repurchase.getShopname());
			ps.setObject(4, repurchase.getShopprice());
			ps.setObject(5, repurchase.getShopnum());
			ps.setObject(6, repurchase.getPurdate());
			ps.setObject(7, repurchase.getRedate());
			ps.setObject(8, repurchase.getReson());
			ps.setObject(9, repurchase.getMark());
			ps.setObject(10, repurchase.getRepurid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ɾ���˻���Ϣ
	@Override
	public int deleRepurchase(Repurchase repurchase) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM repurchase WHERE repurid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, repurchase.getRepurid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ��ҳ��ѯ�˻���Ϣ
	@Override
	public List<Repurchase> getRepurchaseByPage(int begin, int end) {
		List<Repurchase> repurchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			repurchases = new ArrayList<Repurchase>();
			String sql = "SELECT * FROM repurchase LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Repurchase repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));

				repurchases.add(repurchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchases;
	}

	// �����˻���Ʒ����ģ����ѯ�˻���Ϣ
	@Override
	public List<Repurchase> selectRepurchases(Repurchase repurchase) {
		List<Repurchase> repurchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			repurchases = new ArrayList<Repurchase>();
			String sql = "SELECT * FROM repurchase WHERE shopname LIKE '?%'";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, repurchase.getShopname());
			rs = ps.executeQuery();
			while (rs.next()) {
				repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));

				repurchases.add(repurchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchases;
	}

	// �����˻���Ʒ��ѯ�˻���Ϣ
	@Override
	public Repurchase getRepurchaseByName(String shopname) {
		Repurchase repurchase = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM repurchase WHERE shopname=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, shopname);
			rs = ps.executeQuery();
			while (rs.next()) {
				repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchase;
	}

	// �����˻���Ʒ���Ʋ�ѯ�˻���Ϣ
	@Override
	public List<Repurchase> selectRepurchases(String shopname) {
		List<Repurchase> repurchases = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			repurchases = new ArrayList<Repurchase>();
			String sql = "SELECT * FROM repurchase WHERE shopname LIKE ?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, "%" + shopname + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Repurchase repurchase = new Repurchase();
				repurchase.setRepurid(rs.getInt("repurid"));
				repurchase.setPurid(rs.getInt("purid"));
				repurchase.setShopid(rs.getInt("shopid"));
				repurchase.setShopname(rs.getString("shopname"));
				repurchase.setShopprice(rs.getDouble("shopprice"));
				repurchase.setShopnum(rs.getInt("shopnum"));
				repurchase.setPurdate(rs.getDate("purdate"));
				repurchase.setRedate(rs.getDate("redate"));
				repurchase.setReson(rs.getString("reson"));
				repurchase.setMark(rs.getString("mark"));

				repurchases.add(repurchase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return repurchases;
	}

}
