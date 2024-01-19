package com.yedam.app.aop.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	@Insert("INSERT INTO aaa VALUES (#{num})") // @Insert 는 쓰지마라 이건 그냥 테스트용
	public void insertAaa(String num);
}
