package beans;

import lombok.Data;

/*
 * ��װ���ݿ�ͻ���
 */
@Data
public class Customer {
	private int cusid;// �ͻ�id
	private String cusname;// �ͻ�����
	private String custel;// �ͻ��绰
	private String person;// ������
	private String address;// �ͻ���ַ
	private String email;// �ͻ�����
}
