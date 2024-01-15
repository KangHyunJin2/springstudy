package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	
	@Autowired
	Speaker speaker;
	
	//생성자방식 > Autowired
	
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	
	//setter 방식
	SamsungTV(){}
	/* 만약  SamsungTV(Speaker speaker){ this.speaker = speaker; }
	 * 이것만 있으면 기본 생성자가 생성 안됨 > setter 사용 안됨  */
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on();
	}
}