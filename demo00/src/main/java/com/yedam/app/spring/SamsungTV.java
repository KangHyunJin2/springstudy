package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	
	@Autowired
	Speaker speaker;
	
	//�����ڹ�� > Autowired
	
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	
	//setter ���
	SamsungTV(){}
	/* ����  SamsungTV(Speaker speaker){ this.speaker = speaker; }
	 * �̰͸� ������ �⺻ �����ڰ� ���� �ȵ� > setter ��� �ȵ�  */
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void on() {
		System.out.println("�Ｚ TV�� �׽��ϴ�.");
		speaker.on();
	}
}