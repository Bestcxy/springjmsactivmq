package com.bestcxx.stu.jms.service;

/**
 * JMS 消息读取接口
 * @author WuJieJecket
 *
 */
public interface JmsStringReceiveService {
	
	/**
	 * 从JMS 获取 消息 String 类型
	 * @return
	 */
	String receiveString();
}
