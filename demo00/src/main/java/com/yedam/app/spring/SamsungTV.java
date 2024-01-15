package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	
	@Autowired
	Speaker speaker;
	
	//생성자 방식
	
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	
	//setter 방식
	SamsungTV(){}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on();
	}
}
