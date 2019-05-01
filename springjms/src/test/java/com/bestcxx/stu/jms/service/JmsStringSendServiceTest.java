package com.bestcxx.stu.jms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理    
@Rollback(true)  
public class JmsStringSendServiceTest
//extends AbstractTransactionalJUnit4SpringContextTests //没有事务配置，暂时注释本行
{

	@Autowired
	private JmsStringSendService jmsStringSendService;
	
	@Autowired
	private JmsStringReceiveService jmsStringReceiveService;

	
	@Test
	public void testSendString(){
		String message="Spring JMS ActiveMQ Test";
		jmsStringSendService.sendString(message);
	}
}
