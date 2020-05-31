package services;

import java.util.List;

import beans.Type;

/*
 * ��Ʒ����ҵ���߼���ӿ�
 */
public interface TypeService {
	// ��ʾ����
	public List<Type> showType();

	// ����id��ʾ����
	public Type getTypeById(int id);

	// ��ҳ��ѯ
	public List<Type> getTypeByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ɾ������
	public int deleType(Type type);

	// �޸�����
	public int updateType(Type type);

	// �������
	public int addtYpe(Type type);

}
