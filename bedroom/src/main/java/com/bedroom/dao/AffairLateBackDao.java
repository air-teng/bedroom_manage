package com.bedroom.dao;

import java.util.List;

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
	/**
	 * 查询某个用户之前的晚归申请
	 * @param stuAccount 用户账号
	 * @return 晚归申请列表
	 */
	List<AffairLateBack> getHistoryList(String stuAccount);
	
	/**
	 * 删除某个用户的晚归信息
	 * @param affairId 事务ID
	 */
	void delete(String affairId);
	
}
