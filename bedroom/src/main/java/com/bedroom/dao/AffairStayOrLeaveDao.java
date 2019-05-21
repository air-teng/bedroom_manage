package com.bedroom.dao;
/**
 * {@link AffairStayOrLeaveDao} {@link Mapper#} mapper.xml接口层
 * @author Administrator
 */


import com.bedroom.common.pojo.AffairStayOrLeave;

public interface AffairStayOrLeaveDao {
	/**#申请离校申请,插入数据*/
	void  stuApplyLeaveSchool(AffairStayOrLeave affairSL);
	/**#申请留校申请,插入数据*/
	void  stuApplyStaySchool(AffairStayOrLeave affairSL);
}
