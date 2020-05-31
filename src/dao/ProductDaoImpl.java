package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import util.JDBCUtil;

/*
 * ��Ʒ�����ӿ�ʵ����
 */
public class ProductDaoImpl implements ProductDao {

	// ��ѯ��Ʒ�б�
	@Override
	public List<Product> getProducts() {
		List<Product> products = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			products = new ArrayList<Product>();
			String sql = "SELECT * FROM product ";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				Product product = new Product();
				product.setProid(rs.getString("proid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setPronum(rs.getInt("pronum"));
				product.setProdate(rs.getDate("prodate"));
				product.setSupname(rs.getString("supname"));
				product.setTypename(rs.getString("typename"));
				product.setReledate(rs.getDate("reledate"));
				product.setUnit(rs.getString("unit"));

				// ��product������뵽���ϵ���
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return products;
	}

	// ��ҳ��ѯ��Ʒ��Ϣ
	@Override
	public List<Product> getProductsByPage(int begin, int end) {
		List<Product> products = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			products = new ArrayList<Product>();
			String sql = "SELECT * FROM product LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, begin);
			ps.setObject(2, end);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				Product product = new Product();
				product.setProid(rs.getString("proid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setPronum(rs.getInt("pronum"));
				product.setProdate(rs.getDate("prodate"));
				product.setSupname(rs.getString("supname"));
				product.setTypename(rs.getString("typename"));
				product.setReledate(rs.getDate("reledate"));
				product.setUnit(rs.getString("unit"));

				// ��product������뵽���ϵ���
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return products;
	}

	// ������Ʒid��ѯ��Ʒ��Ϣ
	@Override
	public Product getProductById(int id) {
		Product product = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM product WHERE proid=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, id);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				product = new Product();
				product.setProid(rs.getString("proid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setPronum(rs.getInt("pronum"));
				product.setProdate(rs.getDate("prodate"));
				product.setSupname(rs.getString("supname"));
				product.setTypename(rs.getString("typename"));
				product.setReledate(rs.getDate("reledate"));
				product.setUnit(rs.getString("unit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return product;
	}

	// �޸���Ʒ��Ϣ(����)
	@Override
	public int updateProduct(Product product) {
		int out = 0;
		PreparedStatement ps = null;

		try {
			String sql = "UPDATE product set pronum=? WHERE proid=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, product.getPronum());
			ps.setObject(2, product.getProid());
			// ִ�в�ѯ
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ������Ʒ��Ϣ
	@Override
	public int intProduct(Product product) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO product(proid,pname,price,pronum,prodate,supname,typename,reledate,unit) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, product.getProid());
			ps.setObject(2, product.getPname());
			ps.setObject(3, product.getPrice());
			ps.setObject(4, product.getPronum());
			ps.setObject(5, product.getProdate());
			ps.setObject(6, product.getSupname());
			ps.setObject(7, product.getTypename());
			ps.setObject(8, product.getReledate());
			ps.setObject(9, product.getUnit());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �޸���Ʒ��Ϣ
	@Override
	public int updateProducts(Product product) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE product set pname=?,price=?,pronum=?,prodate=?,supname=?,typename=?,reledate=?,unit=? WHERE proid=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, product.getPname());
			ps.setObject(2, product.getPrice());
			ps.setObject(3, product.getPronum());
			ps.setObject(4, product.getProdate());
			ps.setObject(5, product.getSupname());
			ps.setObject(6, product.getTypename());
			ps.setObject(7, product.getReledate());
			ps.setObject(8, product.getUnit());
			ps.setObject(9, product.getProid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ɾ����Ʒ��Ϣ
	@Override
	public int deleProduct(Product product) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM product where proid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, product.getProid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	// ������Ʒid������Ʒ���Ʋ�ѯ��Ʒ��Ϣ
	@Override
	public List<Product> selectProduct(Product product) {
		List<Product> products = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			products = new ArrayList<Product>();
			String sql = "SELECT * FROM product WHERE proid=? OR pname=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, product.getProid());
			ps.setObject(2, product.getPname());
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				product = new Product();
				product.setProid(rs.getString("proid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setPronum(rs.getInt("pronum"));
				product.setProdate(rs.getDate("prodate"));
				product.setSupname(rs.getString("supname"));
				product.setTypename(rs.getString("typename"));
				product.setReledate(rs.getDate("reledate"));
				product.setUnit(rs.getString("unit"));

				// ��product������뵽���ϵ���
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return products;
	}

	// ������Ʒ����ģ����ѯ��Ʒ��Ϣ
	@Override
	public List<Product> selectProductByName(String shopname) {
		List<Product> products = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			products = new ArrayList<Product>();
			String sql = "SELECT * FROM product WHERE pname LIKE ?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, "%" + shopname + "%");
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				Product product = new Product();
				product.setProid(rs.getString("proid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				product.setPronum(rs.getInt("pronum"));
				product.setProdate(rs.getDate("prodate"));
				product.setSupname(rs.getString("supname"));
				product.setTypename(rs.getString("typename"));
				product.setReledate(rs.getDate("reledate"));
				product.setUnit(rs.getString("unit"));

				// ��product������뵽���ϵ���
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return products;
	}

}
