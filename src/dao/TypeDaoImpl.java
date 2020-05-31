package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Type;
import util.JDBCUtil;

/*
 * ��Ʒ�������ӿ�ʵ����
 */
public class TypeDaoImpl implements TypeDao {

	// ��ѯ��Ʒ�����Ϣ�б�
	@Override
	public List<Type> getTypes() {
		List<Type> types = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			types = new ArrayList<Type>();
			String sql = "SELECT * FROM type";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setTypeid(rs.getInt("typeid"));
				type.setTypename(rs.getString("typename"));

				types.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return types;
	}

	// �������id��ѯ��Ʒ�����Ϣ
	@Override
	public Type getTypeById(int id) {
		Type type = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM type WHERE typeid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				type = new Type();
				type.setTypeid(rs.getInt("typeid"));
				type.setTypename(rs.getString("typename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return type;
	}

	// ɾ�����
	@Override
	public int deleType(Type type) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM type WHERE typeid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, type.getTypeid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �������
	@Override
	public int updateType(Type type) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE type SET typename=? WHERE typeid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, type.getTypename());
			ps.setObject(2, type.getTypeid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �������
	@Override
	public int addType(Type type) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO type(typeid,typename) VALUES(?,?)";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, type.getTypeid());
			ps.setObject(2, type.getTypename());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ��ҳ��ѯ���
	@Override
	public List<Type> getTypesByPage(int begin, int end) {
		List<Type> types = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			types = new ArrayList<Type>();
			String sql = "SELECT * FROM type LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setTypeid(rs.getInt("typeid"));
				type.setTypename(rs.getString("typename"));

				types.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return types;
	}

	// ����������Ʋ�ѯ���
	@Override
	public Type getTypeByName(String typename) {
		Type type = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM type WHERE typename=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, typename);
			rs = ps.executeQuery();
			while (rs.next()) {
				type = new Type();
				type.setTypeid(rs.getInt("typeid"));
				type.setTypename(rs.getString("typename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return type;
	}

	// ��������ѯ�����Ϣ�б�
	@Override
	public List<Type> selectType(Type type) {
		List<Type> types = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			types = new ArrayList<Type>();
			String sql = "SELECT * FROM type WHERE typeid=? or typename=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, type.getTypeid());
			ps.setObject(2, type.getTypename());
			rs = ps.executeQuery();
			while (rs.next()) {
				type.setTypeid(rs.getInt("typeid"));
				type.setTypename(rs.getString("typename"));

				types.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return types;
	}

}
