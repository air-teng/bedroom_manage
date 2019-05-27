package com.bedroom.dao;

import java.util.List;

import com.bedroom.common.pojo.AffairChange;

/**
 * 寝室交换dao层
 * @author Administrator
 */
public interface AffairChangeDao {
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
	List<AffairChange> getHistoryList(String stuAccount);
	
	/**
	 * 删除事务
	 * @param affairId 事务ID
	 */
	void delete(String affairId);
}
