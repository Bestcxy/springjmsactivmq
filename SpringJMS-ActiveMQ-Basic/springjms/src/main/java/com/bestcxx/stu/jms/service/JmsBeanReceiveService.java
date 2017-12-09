package com.bestcxx.stu.jms.service;

import com.bestcxx.stu.springmybatis.model.User;

/**
 * JMS 消息读取接口
 * @author WuJieJecket
 *
 */
public interface JmsBeanReceiveService {
	/**
	 * 从JMS 获取消息 User　实体类型
	 * @return
	 */
	User receiveUser();
}
