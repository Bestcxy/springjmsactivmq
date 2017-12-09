package com.bestcxx.stu.jms.service;

import com.bestcxx.stu.springmybatis.model.User;

/**
 * JMS 消息发送接口
 * @author WuJieJecket
 *
 */
public interface JmsBeanSendService {
	/**
	 * 发送 User 实体的方法
	 * @param user
	 */
	void sendUser(User user);
}
