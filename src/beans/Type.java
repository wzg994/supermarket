package beans;

import lombok.Data;

/*
 * 封装数据库商品类型表
 */
@Data
public class Type {
	private int typeid;//商品类型id
	private String typename;//商品类型名字
}
