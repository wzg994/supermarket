package beans;

import java.util.Date;

import lombok.Data;

/*
 * ��װ���ݿ�Ա�����ڱ�
 */
@Data
public class StaffAttend {
	private int staffid;// Ա��id
	private String staffname;// Ա������
	private Date stafftime;// Ա������ʱ��
	private int attendtime;// Ա�����ڴ���
	private String mark;// ��ע
}
