package services;

import java.util.List;

import beans.Type;
import dao.TypeDao;
import dao.TypeDaoImpl;

/*
 * 商品类别业务逻辑实现类
 */
public class TypeServiceImpl implements TypeService {
	// 加载商品类型操作接口
	private TypeDao typeDao;
	{
		typeDao = new TypeDaoImpl();
	}

	// 显示类型
	@Override
	public List<Type> showType() {
		return typeDao.getTypes();
	}

	// 根据id显示类型
	@Override
	public Type getTypeById(int id) {
		Type type = null;
		type = typeDao.getTypeById(id);
		return type;
	}

	// 删除类型
	@Override
	public int deleType(Type type) {
		int out = typeDao.deleType(type);
		return out;
	}

	// 修改类型
	@Override
	public int updateType(Type type) {
		int out = typeDao.updateType(type);
		return out;
	}

	// 添加类型
	@Override
	public int addtYpe(Type type) {
		int out = typeDao.addType(type);
		return out;
	}

	// 分页查询
	@Override
	public List<Type> getTypeByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return typeDao.getTypesByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = typeDao.getTypes().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
