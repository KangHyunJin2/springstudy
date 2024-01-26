package com.example.demo.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.mapper.MemberMapper;

@SpringBootTest
public class MemberMapperTest {
		
		@Autowired
		MemberMapper memberMapper;
		
		@Test
		public void 전체조회() {
			String id = "M001";
			MemberVO vo = memberMapper.getMember(id);
			System.out.println(vo);
			assertThat(vo.getMid()).isEqualTo(id);
		}
		
	
}
