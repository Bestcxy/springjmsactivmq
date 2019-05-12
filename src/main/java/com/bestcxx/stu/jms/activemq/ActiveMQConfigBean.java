package com.bestcxx.stu.jms.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;


/**
 * ActiveMQ 相关 Spring Bean 声明
 */
@Configuration
public class ActiveMQConfigBean {
    /**连接工厂*/
    @Bean(name="activeMQConnectionFactory")
    public ActiveMQConnectionFactory getActiveMQConnectionFactory(){
        ActiveMQConnectionFactory a=new ActiveMQConnectionFactory();
        a.setBrokerURL("tcp://localhost:61616");//我本地已启动 ActiveMQ
        a.setTrustAllPackages(true);
        return a;
    }
    /**连接工厂池*/
    @Bean(name="pooledConnectionFactory")
    public PooledConnectionFactory getPooledConnectionFactory(){
        PooledConnectionFactory p=new PooledConnectionFactory();
        p.setConnectionFactory(getActiveMQConnectionFactory());
        p.setMaxConnections(1);//设置最大连接数
        //其他更多配置略
        return p;
    }

    /**Spring JmsTemplate*/
    @Bean(name="JmsTemplate")
    public JmsTemplate getJmsTemplateTopic(){
        JmsTemplate j=new JmsTemplate();
        j.setConnectionFactory(getPooledConnectionFactory());//连接工厂
        return j;
    }

    /**ActiveMQ Queue*/
    @Bean(name="activeMQQueue")
    public ActiveMQQueue getActiveMQQueue(){
        ActiveMQQueue a=new ActiveMQQueue("queue_test");//构造方法同时确定来主题消息的名字
        return a;
    }

    /**ActiveMQ Topic*/
    @Bean(name="activeMQTopic")
    public ActiveMQTopic getActiveMQTopic(){
        ActiveMQTopic a=new ActiveMQTopic("topic_test");
        return a;
    }

    /**自定义消息监听器bean*/
    @Bean(name="myMessageListener")
    public MyMessageListener getMyMessageListener(){
        MyMessageListener m=new MyMessageListener();
        return m;
    }

    /**
     * 注册监听器容器-监听 queue 类型的bean
     * DefaultMessageListenerContainer只是其中一种,支持事务
     * 另外还有 不支持事务的 SimpleMessageListenerContainer
     * 和 支持事务和动态会话管理的 ListertenerContainer
     * */
    @Bean(name="defaultMessageListenerContainer")
    public DefaultMessageListenerContainer getDefaultMessageListenerContainer(){
        DefaultMessageListenerContainer d=new DefaultMessageListenerContainer();
        d.setConnectionFactory(getPooledConnectionFactory());
        d.setDestination(getActiveMQQueue());
        d.setMessageListener(getMyMessageListener());
        return d;
    }

    /**
     * 注册监听器容器-监听 TOPIC 类型的bean
     * DefaultMessageListenerContainer只是其中一种,支持事务
     * 另外还有 不支持事务的 SimpleMessageListenerContainer
     * 和 支持事务和动态会话管理的 ListertenerContainer
     * */
    @Bean(name="defaultMessageListenerContainerTopic")
    public DefaultMessageListenerContainer getDefaultMessageListenerContainerTopic(){
        DefaultMessageListenerContainer d=new DefaultMessageListenerContainer();
        d.setConnectionFactory(getPooledConnectionFactory());
        d.setDestination(getActiveMQTopic());
        d.setMessageListener(getMyMessageListener());
        return d;
    }

}
