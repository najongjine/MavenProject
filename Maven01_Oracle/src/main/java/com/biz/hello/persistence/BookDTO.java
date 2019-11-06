package com.biz.hello.persistence;

import lombok.ToString;

@ToString
public class BookDTO {
	private String b_code	;//VARCHAR2(5 BYTE)
	private String b_name	;//NVARCHAR2(50 CHAR)
	private String b_comp	;//NVARCHAR2(50 CHAR)
	private String b_writer	;//NVARCHAR2(20 CHAR)
	private int b_price	;//NUMBER
}
