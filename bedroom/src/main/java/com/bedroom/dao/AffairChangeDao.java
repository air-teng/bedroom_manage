package com.bedroom.dao;

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
}
