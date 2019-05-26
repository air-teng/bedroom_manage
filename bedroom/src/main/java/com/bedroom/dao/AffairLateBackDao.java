package com.bedroom.dao;

import com.bedroom.common.pojo.AffairLateBack;

/**
 * 晚归事务dao层
 * @author Administrator
 */
public interface AffairLateBackDao {
	/**
	 * 晚归申请
	 * @param affairLateBack
	 */
	void apply(AffairLateBack affairLateBack);
	
}
