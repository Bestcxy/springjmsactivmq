package com.bestcxx.stu.springmybatis.model;

import java.io.Serializable;

/**
 * 测试表 实体
 * @author WuJieJecket
 *
 */
/**
 * @author WuJieJecket
 *
 */
public class User implements Serializable{
  
	private static final long serialVersionUID = -2377088764016197551L;

	private Integer id;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User["
				+ "id="+id+
				",comment="+comment+
				"]";
	}
    
    
}