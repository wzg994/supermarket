package beans;

import java.util.Date;

import lombok.Data;

/*
 * ��װ���ݿ����۱�
 */
@Data
public class Sale {
	private int saleid;// ����id
	private int shopid;// ��Ʒid
	private String shopname;// ��Ʒ����
	private double shopprice;// ��Ʒ�۸�
	private int shopnum;// ��Ʒ����
	private double totalprice;// ��Ʒ�ܼ�
	private Date saledate;// ��������
	private String cusname;// �ͻ�����
	private String cusid;// �ͻ�id
	private String mark;// ��ע
}
