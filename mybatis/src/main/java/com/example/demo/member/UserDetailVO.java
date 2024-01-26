package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class UserDetailVO implements UserDetails{
	
	private MemberVO memberVO;
//	final MemberVO memberVO;
	
	
	
	public UserDetailVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(memberVO.getResponsbility()));
		return list;
	}


	public String getPassword() {
		return memberVO.getPass();
	}


	public String getUsername() {
		return memberVO.getMid();
	}

	
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override // false로넘기면 로그인 안된다
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
