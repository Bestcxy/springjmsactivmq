package com.bestcxx.stu.jms.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestcxx.stu.springmybatis.model.User;

@DirtiesContext  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理    
@Rollback(true)  
public class JmsBeanSendServiceTest
{

	@Autowired
	private JmsBeanSendService jmsSendService;
	
	@Test
	public void testSendUser(){
		User user=new User();
		user.setId(Integer.valueOf((int) new Date().getTime()));
		user.setComment("Spring JMS ActiveMQ Test");
		
		jmsSendService.sendUser(user);
	}
}
