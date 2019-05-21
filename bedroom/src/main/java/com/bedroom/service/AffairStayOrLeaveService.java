package com.bedroom.service;
/**
 * AffairStayOrLeaveService 接口层
 */
import com.bedroom.common.pojo.AffairStayOrLeave;

public interface AffairStayOrLeaveService {
	/**#申请离校申请,插入数据*/
	void  stuApplyLeaveSchool(AffairStayOrLeave affairSL);
	/**#申请留校申请,插入数据*/
	void  stuApplyStaySchool(AffairStayOrLeave affairSL);
}
