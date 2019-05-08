package com.bestcxx.stu.jms.service.impl;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import com.bestcxx.stu.jms.service.JmsBeanReceiveService;
import com.bestcxx.stu.springmybatis.model.User;

@Service
public class JmsBeanReceiveServiceImpl implements JmsBeanReceiveService {
	
	@Resource(name="jmsBeanTemplate")
	JmsTemplate jmsTemplate;
	
	@Override
	public User receiveUser() {
		return (User) jmsTemplate.receiveAndConvert();//本句代码可以取代下面被注释的代码
		
		/*ObjectMessage receiveMessage=(ObjectMessage) jmsTemplate.receive();
		try {
			return (User) receiveMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			throw JmsUtils.convertJmsAccessException(e);//抛出转化后的异常
		}*/

	}

}
