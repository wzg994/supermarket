package services;

import java.util.List;

import beans.Type;
import dao.TypeDao;
import dao.TypeDaoImpl;

/*
 * ��Ʒ���ҵ���߼�ʵ����
 */
public class TypeServiceImpl implements TypeService {
	// ������Ʒ���Ͳ����ӿ�
	private TypeDao typeDao;
	{
		typeDao = new TypeDaoImpl();
	}

	// ��ʾ����
	@Override
	public List<Type> showType() {
		return typeDao.getTypes();
	}

	// ����id��ʾ����
	@Override
	public Type getTypeById(int id) {
		Type type = null;
		type = typeDao.getTypeById(id);
		return type;
	}

	// ɾ������
	@Override
	public int deleType(Type type) {
		int out = typeDao.deleType(type);
		return out;
	}

	// �޸�����
	@Override
	public int updateType(Type type) {
		int out = typeDao.updateType(type);
		return out;
	}

	// �������
	@Override
	public int addtYpe(Type type) {
		int out = typeDao.addType(type);
		return out;
	}

	// ��ҳ��ѯ
	@Override
	public List<Type> getTypeByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return typeDao.getTypesByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = typeDao.getTypes().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
