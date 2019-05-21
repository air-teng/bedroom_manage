package com.bedroom.dao;
/**
 * {@link AffairStayOrLeaveDao} {@link Mapper#} mapper.xml接口层
 * @author Administrator
 */


import java.util.List;

import com.bedroom.common.pojo.AffairStayOrLeave;

public interface AffairStayOrLeaveDao {
	/**#申请离校申请,插入数据*/
	void  stuApplyLeaveSchool(AffairStayOrLeave affairSL);
	/**#申请留校申请,插入数据*/
	void  stuApplyStaySchool(AffairStayOrLeave affairSL);
	/**#查看自己申请的离校信息(未被审核)*/
	List<AffairStayOrLeave>  showApplyLeaveInfo(String stuAccount);
	/** #删除自己申请的离校申请*/
	void removeApplyLeaveSchool(Integer  affairId);
	/**#查看自己留校信息 */
	List<AffairStayOrLeave> showApplyStayInfo(String stuAccount);
	
}
