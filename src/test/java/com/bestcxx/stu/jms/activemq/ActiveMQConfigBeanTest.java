package com.bestcxx.stu.jms.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test/applicationContext-activemq.xml"})
//@TransactionConfiguration(transactionManager = "defaultTransactionManager",defaultRollback=false)//事务管理
@Rollback(true)
public class ActiveMQConfigBeanTest {

    @Resource(name="JmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name="activeMQQueue")
    private ActiveMQQueue activeMQQueue;

    @Resource(name="activeMQTopic")
    private ActiveMQTopic activeMQTopic;

    /**发送 queue 类型消息，使用监听器处理消息*/
    @Test
    public void testSend(){
        jmsTemplate.setDefaultDestination(activeMQQueue);
        //jmsTemplate.setSessionTransacted(true);
        //jmsTemplate.setSessionAcknowledgeMode( Session.CLIENT_ACKNOWLEDGE);//默认就是客户端接收就去除消息队列的消息
       // jmsTemplate.convertAndSend("你好");
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println(session.getAcknowledgeMode());
                return  session.createTextMessage("hello");
            }
        });
        try{
         Thread.sleep(5000);
        }catch(Exception e){

        }
    }

    /**常规阻塞方法接收消息*/
    @Test
    public  void testReceive(){
        jmsTemplate.setDefaultDestination(activeMQQueue);
        jmsTemplate.setSessionTransacted(true);
        String str=(String)jmsTemplate.receiveAndConvert();
        System.out.println("str="+str);
    }

    /**发送 topic 类型消息，使用监听器处理消息*/
    @Test
    public void testSendTopic(){
        jmsTemplate.setDefaultDestination(activeMQTopic);
        //jmsTemplate.setSessionTransacted(true);
        //jmsTemplate.setSessionAcknowledgeMode( Session.CLIENT_ACKNOWLEDGE);//默认就是客户端接收就去除消息队列的消息
        // jmsTemplate.convertAndSend("你好");
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println(session.getAcknowledgeMode());
                return  session.createTextMessage("hello topic");
            }
        });
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }
    }

}
