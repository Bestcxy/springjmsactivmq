package com.bestcxx.stu.jms.service.impl;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.bestcxx.stu.jms.service.JmsStringSendService;

@Service
public class JmsStringSendServiceImpl implements JmsStringSendService {
	
	@Resource(name="jmsStringTemplate")
	JmsTemplate jmsTemplate;

	@Override
	public void sendString(final String message) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(message);//本句代码可以取代下面被注释的代码
		
		/*jmsTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(message);
			}
		});*/
		
	}

}
