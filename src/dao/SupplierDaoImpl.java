package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Supplier;
import util.JDBCUtil;

/*
 * ��Ӧ�̲����ӿ�ʵ����
 */
public class SupplierDaoImpl implements SupplierDao {

	// ��ѯ��Ӧ����Ϣ�б�
	@Override
	public List<Supplier> getSupplier() {
		List<Supplier> suppliers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			suppliers = new ArrayList<Supplier>();
			String sql = "SELECT * FROM supplier";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setSupid(rs.getInt("supid"));
				supplier.setSupname(rs.getString("supname"));
				supplier.setSuptel(rs.getString("suptel"));
				supplier.setPerson(rs.getString("person"));
				supplier.setAddress(rs.getString("address"));
				supplier.setEmail(rs.getString("email"));

				suppliers.add(supplier);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return suppliers;
	}

	// ���ݹ�Ӧ��id��ȡ��Ӧ����Ϣ
	@Override
	public Supplier getSupById(int id) {
		Supplier supplier = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM supplier WHERE supid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				supplier = new Supplier();
				supplier.setSupid(rs.getInt("supid"));
				supplier.setSupname(rs.getString("supname"));
				supplier.setSuptel(rs.getString("suptel"));
				supplier.setPerson(rs.getString("person"));
				supplier.setAddress(rs.getString("address"));
				supplier.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return supplier;
	}

	// ��ѯ��Ӧ����Ϣ
	@Override
	public Supplier selectSupplier(Supplier supplier) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM supplier WHERE supid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, supplier.getSupid());
			rs = ps.executeQuery();
			while (rs.next()) {
				supplier = new Supplier();
				supplier.setSupid(rs.getInt("supid"));
				supplier.setSupname(rs.getString("supname"));
				supplier.setSuptel(rs.getString("suptel"));
				supplier.setPerson(rs.getString("person"));
				supplier.setAddress(rs.getString("address"));
				supplier.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return supplier;
	}

	// ��ӹ�Ӧ��
	@Override
	public int addSupplier(Supplier supplier) {
		int out = 0;
		PreparedStatement ps = null;

		try {
			String sql = "INSERT INTO supplier(supid,supname,suptel,person,address,email) VALUES(?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, supplier.getSupid());
			ps.setObject(2, supplier.getSupname());
			ps.setObject(3, supplier.getSuptel());
			ps.setObject(4, supplier.getPerson());
			ps.setObject(5, supplier.getAddress());
			ps.setObject(6, supplier.getEmail());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ɾ����Ӧ��
	@Override
	public int deleSupplier(Supplier supplier) {
		int out = 0;
		PreparedStatement ps = null;

		try {
			String sql = "DELETE FROM supplier WHERE supid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, supplier.getSupid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �޸Ĺ�Ӧ����Ϣ
	@Override
	public int updateSupplier(Supplier supplier) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE supplier SET supname=?,suptel=?,person=?,address=?,email=? WHERE supid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, supplier.getSupname());
			ps.setObject(2, supplier.getSuptel());
			ps.setObject(3, supplier.getPerson());
			ps.setObject(4, supplier.getAddress());
			ps.setObject(5, supplier.getEmail());
			ps.setObject(6, supplier.getSupid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ��ҳ��ѯ��Ӧ��
	@Override
	public List<Supplier> getSupplierByPage(int begin, int end) {
		List<Supplier> suppliers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			suppliers = new ArrayList<Supplier>();
			String sql = "SELECT * FROM supplier LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setSupid(rs.getInt("supid"));
				supplier.setSupname(rs.getString("supname"));
				supplier.setSuptel(rs.getString("suptel"));
				supplier.setPerson(rs.getString("person"));
				supplier.setAddress(rs.getString("address"));
				supplier.setEmail(rs.getString("email"));

				suppliers.add(supplier);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return suppliers;
	}

	// ���ݹ�Ӧ������ģ����ѯ��Ӧ����Ϣ
	@Override
	public List<Supplier> getSupplier(String suppilername) {
		List<Supplier> suppliers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			suppliers = new ArrayList<Supplier>();
			String sql = "SELECT * FROM supplier WHERE supname LIKE ? ";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, suppilername + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setSupid(rs.getInt("supid"));
				supplier.setSupname(rs.getString("supname"));
				supplier.setSuptel(rs.getString("suptel"));
				supplier.setPerson(rs.getString("person"));
				supplier.setAddress(rs.getString("address"));
				supplier.setEmail(rs.getString("email"));

				suppliers.add(supplier);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return suppliers;
	}

}
