package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO { // VO 클래스는 용도에따라 위에 어노테이션이 필요하다 
	// 언더바 안써도됨 mybatis 설정해서
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
	private Date birthday;
	
}
