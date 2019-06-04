package com.bedroom.common.pojo;

import java.util.Date;

/**学院信息实体类
	college_id	int
	college_name	varchar
	create_time	datetime
	introduction	varchar
 * @author Administrator
 *
 */
public class College {
	private Integer collegeId;
	private String collegeName;
	private Date createTime;
	private String introduction;
	//
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	//
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", createTime=" + createTime
				+ ", introduction=" + introduction + "]";
	}
	
}
