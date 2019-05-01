package com.bestcxx.stu.jms.service;

/**
 * JMS 消息发送接口
 * @author WuJieJecket
 *
 */
public interface JmsStringSendService {
	
	/**
	 * 发送字符串
	 * @param message
	 */
	void sendString(String message);
}
