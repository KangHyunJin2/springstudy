package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TV tv = (TV)ctx.getBean(SamsungTV.class);
		//TV tv = (TV)ctx.getBean(TV.class); ����ϰ����ϴ� Ŭ������ �������̽� ������� ��ϵǾ��ִ� �������̽� �ҷ����� ���
		tv.on();
	}
}