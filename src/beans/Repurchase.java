package beans;

import java.util.Date;

import lombok.Data;

/*
 * ��װ���ݿ��˻���
 */
@Data
public class Repurchase {
	private int repurid;// �������
	private int purid;// �������
	private int shopid;// ��Ʒid
	private String shopname;// ��Ʒ����
	private double shopprice;// ��Ʒ����
	private int shopnum;// ��Ʒ����
	private Date purdate;// ��������
	private Date redate;// �˻�����
	private String reson;// �˻�ԭ��
	private String mark;// �˻���ע
}
