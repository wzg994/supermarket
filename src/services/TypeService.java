package services;

import java.util.List;

import beans.Type;

/*
 * 商品类型业务逻辑层接口
 */
public interface TypeService {
	// 显示类型
	public List<Type> showType();

	// 根据id显示类型
	public Type getTypeById(int id);

	// 分页查询
	public List<Type> getTypeByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 删除类型
	public int deleType(Type type);

	// 修改类型
	public int updateType(Type type);

	// 添加类型
	public int addtYpe(Type type);

}
