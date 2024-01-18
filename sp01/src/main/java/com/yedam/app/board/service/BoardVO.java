package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title;
	private String contents;
	private String writer;
	// <input type="date"> 이런 경우
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	private Date updatedate; // yyyy/MM/dd 데이터 포맷 사용하지 않을경우 슬러시를 해서 사용
	private String image;
}
