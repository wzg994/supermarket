package beans;

import java.util.Date;

import lombok.Data;

/*
 * ��װ���ݿ������
 */
@Data
public class Purchase {
	private int purid;// ����id
	private String shopid;// ��Ʒid
	private String shopname;// ��Ʒ����
	private Double shopprice;// ��Ʒ�۸�
	private int shopnum;// ��Ʒ����
	private Date purdate;// ��������
	private String supname;// ��Ӧ������
}
