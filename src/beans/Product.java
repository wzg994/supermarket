package beans;

import java.util.Date;

import lombok.Data;

/*
 * ��װ���ݿ���Ʒ��
 */
@Data
public class Product {
	private String proid;// ��Ʒid
	private String pname;// ��Ʒ����
	private Double price;// ��Ʒ�۸�
	private int pronum;// ��Ʒ����
	private Date prodate;// ��Ʒ��������
	private String supname;// ��Ӧ������
	private String typename;// ��������
	private Date reledate;// ����ʱ��
	private String unit;// �Ƽ���ʽ

}
