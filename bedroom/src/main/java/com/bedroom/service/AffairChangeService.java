package com.bedroom.service;

import java.util.List;
import java.util.Map;

import com.bedroom.common.pojo.AffairChange;

public interface AffairChangeService {
	
	/**
	 * 寝室交换申请
	 * @param affairChange
	 */
	void apply(AffairChange affairChange);
	
	/**
	 * 获取某个学生的寝室交换历史申请
	 * @param stuAccount 学生账号
	 * @return 申请历史列表
	 */
	List<Map<String,String>> getHistoryList(String stuAccount);
	
	/**
	 * 删除事务
	 * @param affairId 事务ID
	 */
	void delete(String affairId);
	
	/**
	 * 公寓管理员获取所有待审核的寝室交换事务
	 * @param userAccount 宿舍管理员的
	 * @return 寝室交换事务
	 */
	List<Map<String, String>> getAllChangeToReply(String userAccount);
	
	/**
	 * 根据affairId更改审核原因和审核状态
	 * @param affairId	事务ID
	 * @param replyReason 审核原因
	 * @param affairStatus 审核状态
	 */
	void replyChange(Integer affairId, String replyReason, String affairStatus);
}
