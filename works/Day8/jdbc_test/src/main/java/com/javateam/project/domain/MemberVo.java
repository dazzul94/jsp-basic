package com.javateam.project.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {

	private String id;
	private String pw;
	private String name;
	private String address;
	private Date joindate;

}
