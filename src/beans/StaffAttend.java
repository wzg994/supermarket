package beans;

import java.util.Date;

import lombok.Data;

/*
 * 封装数据库员工考勤表
 */
@Data
public class StaffAttend {
	private int staffid;// 员工id
	private String staffname;// 员工姓名
	private Date stafftime;// 员工出勤时间
	private int attendtime;// 员工出勤次数
	private String mark;// 备注
}
