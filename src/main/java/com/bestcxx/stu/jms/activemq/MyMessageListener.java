package com.bestcxx.stu.jms.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message){
        try{
            System.out.println("type="+message.getJMSType());
            TextMessage m=(TextMessage) message;
            System.out.println("msg="+m.getText());
        }catch(Exception e){
            System.out.println(e);

        }

    }
}
