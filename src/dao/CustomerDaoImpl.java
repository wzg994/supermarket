package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;
import util.JDBCUtil;

/*
 * 客户操作接口实现类
 */
public class CustomerDaoImpl implements CustomerDao {

	// 查询客户列表
	@Override
	public List<Customer> getCustomer() {
		List<Customer> customers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			customers = new ArrayList<Customer>();
			String sql = "SELECT * FROM customer";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCusid(rs.getInt("cusid"));
				customer.setCusname(rs.getString("cusname"));
				customer.setCustel(rs.getString("custel"));
				customer.setPerson(rs.getString("person"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));

				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return customers;
	}

	// 添加客户
	@Override
	public int addCustomer(Customer customer) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO customer(cusid,cusname,custel,person,address,email) VALUES(?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, customer.getCusid());
			ps.setObject(2, customer.getCusname());
			ps.setObject(3, customer.getCustel());
			ps.setObject(4, customer.getPerson());
			ps.setObject(5, customer.getAddress());
			ps.setObject(6, customer.getEmail());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 删除客户
	@Override
	public int deleCustomer(Customer customer) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM customer WHERE cusid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, customer.getCusid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 分页添加客户信息
	@Override
	public List<Customer> getCustomerByPage(int begin, int end) {
		List<Customer> customers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			customers = new ArrayList<Customer>();
			String sql = "SELECT * FROM customer LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCusid(rs.getInt("cusid"));
				customer.setCusname(rs.getString("cusname"));
				customer.setCustel(rs.getString("custel"));
				customer.setPerson(rs.getString("person"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));

				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return customers;
	}

	// 修改客户
	@Override
	public int updateCustomr(Customer customer) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE customer SET cusname=?,custel=?,person=?,address=?,email=? WHERE cusid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, customer.getCusname());
			ps.setObject(2, customer.getCustel());
			ps.setObject(3, customer.getPerson());
			ps.setObject(4, customer.getAddress());
			ps.setObject(5, customer.getEmail());
			ps.setObject(6, customer.getCusid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 根据客户id查询客户信息
	@Override
	public Customer getCustomerById(int id) {
		Customer customer = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM customer WHERE cusid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCusid(rs.getInt("cusid"));
				customer.setCusname(rs.getString("cusname"));
				customer.setCustel(rs.getString("custel"));
				customer.setPerson(rs.getString("person"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return customer;
	}

	// 查询客户信息
	@Override
	public List<Customer> selectCustomer(Customer customer) {
		List<Customer> customers = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			customers = new ArrayList<Customer>();
			String sql = "SELECT * FROM customer WHERE cusid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, customer.getCusid());
			rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCusid(rs.getInt("cusid"));
				customer.setCusname(rs.getString("cusname"));
				customer.setCustel(rs.getString("custel"));
				customer.setPerson(rs.getString("person"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));

				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return customers;
	}

}
