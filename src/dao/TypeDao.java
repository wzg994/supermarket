package dao;

import java.util.List;

import beans.Type;

/*
 * ��Ʒ�������ӿ�
 */
public interface TypeDao {
	// ��ѯ��Ʒ����б�
	public List<Type> getTypes();

	// ������Ʒ����id��ѯ�����Ϣ
	public Type getTypeById(int id);

	// ��ҳ��ѯ����б�
	public List<Type> getTypesByPage(int begin, int end);

	// ������Ʒ�������Ʋ�ѯ
	public Type getTypeByName(String typename);

	// ������Ʒ���id��ѯ������
	public List<Type> selectType(Type type);

	// ɾ�����
	public int deleType(Type type);

	// �޸����
	public int updateType(Type type);

	// �������
	public int addType(Type type);
}
