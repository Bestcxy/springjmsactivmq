package com.bestcxx.stu.jms.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ErrorHandler;

import com.bestcxx.stu.jms.service.JmsBeanReceiveService;
import com.bestcxx.stu.springmybatis.model.User;

public class JmsBeanMessageHandler implements ErrorHandler{
	/*@Autowired
	JmsBeanReceiveService jmsBeanReceiveService;*/

	public void beanMessageHandler(User user){
		/*jmsBeanReceiveService.receiveUser();*/
		System.out.println("来喽");
		System.out.println("来喽");
		System.out.println("来喽");
		System.out.println(user);
	}

	@Override
	public void handleError(Throwable arg0) {
		// TODO Auto-generated method stub
		System.out.println("异常："+arg0);
	}
}
