package com.bedroom.common;

/**
 * ajax返回类型
 */
public class AjaxResult {
	/**状态码,默认操作成功true;失败设置为error*/
	private String status = "true";
	/**返回信息,返回前端操作的文字结果*/
    private String msg = "操作成功";
    /**操作成功与否,默认为成功*/
    private Boolean success = true;
    /**返回的结果集,返回后台的对象*/
    private Object object;
    //构造函数
    public AjaxResult(String status) {
    	super();
    	this.status = status;
    }
    public AjaxResult(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public AjaxResult(String status, Object object) {
		super();
		this.status = status;
		this.object = object;
	}
	public AjaxResult() {
    	super();
    }
	//返回的信息集合函数
    public static AjaxResult oK() {
    	return new AjaxResult("true");
    }
    public static AjaxResult oK(Object object) {
    	return new AjaxResult("true",object);
    }
    public static AjaxResult error() {
    	return new AjaxResult("error");
    }
    public static AjaxResult error(String msg) {
    	return new AjaxResult("error",msg);
    }
    //get和set方法
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
