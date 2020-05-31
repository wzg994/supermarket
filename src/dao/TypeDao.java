package dao;

import java.util.List;

import beans.Type;

/*
 * 商品类别操作接口
 */
public interface TypeDao {
	// 查询商品类别列表
	public List<Type> getTypes();

	// 根据商品类型id查询类别信息
	public Type getTypeById(int id);

	// 分页查询类别列表
	public List<Type> getTypesByPage(int begin, int end);

	// 根据商品类型名称查询
	public Type getTypeByName(String typename);

	// 根据商品类别id查询类别货表
	public List<Type> selectType(Type type);

	// 删除类别
	public int deleType(Type type);

	// 修改类别
	public int updateType(Type type);

	// 增加类别
	public int addType(Type type);
}
