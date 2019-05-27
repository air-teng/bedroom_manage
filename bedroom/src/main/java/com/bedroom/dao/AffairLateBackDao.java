package com.bedroom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	List<AffairLateBack> getHistoryList(String userAccount);
	
	/**
	 * 删除某个用户的晚归信息
	 * @param affairId 事务ID
	 */
	void delete(String affairId);
	/**
	 * 宿舍管理员获取所有待审核的晚归事务
	 * @return 事务集合
	 */
	List<AffairLateBack> getAllBackLateToReply(String userAccount);
	/**
	 * 晚归审核
	 * @param affairId	事务ID
	 * @param replyReason	审核意见
	 * @param affairStatus	审核状态
	 */
	void replyBackLate(@Param("affairId")Integer affairId, @Param("replyReason")String replyReason, @Param("affairStatus")String affairStatus);
	
}
