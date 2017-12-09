package com.bestcxx.stu.jms.service.impl;

import javax.annotation.Resource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bestcxx.stu.jms.service.JmsBeanSendService;
import com.bestcxx.stu.springmybatis.model.User;

@Service
public class JmsBeanSendServiceImpl implements JmsBeanSendService {
	
	@Resource(name="jmsBeanTemplate")
	JmsTemplate jmsTemplate;

	@Override
	public void sendUser(final User user) {
		jmsTemplate.convertAndSend(user);//本句代码和下面注释的代码同意
		
		/*jmsTemplate.send(new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(user);
			}
		});*/
	}

}
