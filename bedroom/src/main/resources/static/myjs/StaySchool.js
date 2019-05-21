//通过输入的时间获取包含datetime的时间
//Date转为datetimeLocal
function dateToDatetimeLocal(date){
	var now = new Date();
	now.setTime(date);
    var datetime = now.getFullYear() + "-" + fix((now.getMonth() + 1), 2) + "-" + fix(now.getDate(), 2) + "T" + fix(now.getHours(), 2) + ":" + fix(now.getMinutes(), 2);
    return datetime;
}

//datetimeLocal转为Date
function datetimeLocalToDate(datetime){
	//将datetime-local转换为Date
	var date = new Date();
    date.setFullYear(parseInt(datetime.substring(0, 4)));
    date.setMonth(parseInt(datetime.substring(5, 7)) - 1);
    date.setDate(parseInt(datetime.substring(8, 10)));
    date.setHours(parseInt(datetime.substring(11, 13)));
    date.setMinutes(parseInt(datetime.substring(14, 16)));
    return date;
}
/**
 * 页面加载即加载次函数
 * @returns
 */
$(function() {
	//点击提交按钮,获取数据传送后台
	$("#stay-submit").on('click',function(){
		staySchoolProgram();
	});
	
});

/**
 * 提交按钮生成申请方案
 */
function staySchoolProgram(){
	var AAA=confirm("确认提交?");
	if(!AAA){  return ;  };
	//获取前端时间
	var  account=$("#student-account").val();
	var sTime=datetimeLocalToDate($("#stay-start-time").val());
	var eTime=datetimeLocalToDate($("#stay-end-time").val());
	var reason=$("#stay-apply-reason").val();
	//判断前端输入的数据是否正确
	if(sTime==null || eTime==null){
		alert("时间不能为空");
		return ;
	}
	if(sTime > eTime){
		alert("起始时间不能大于终止时间");
		return ;
	}
	if(reason==""){
		alert("原因不能为空");
		return  ;
	}
	//封装数据为对象传给后台
	var param={};
	param.stuAccount=account;
	param.startTime=sTime;
	param.endTime=eTime;
	param.applyReason=reason;
	$.ajax({
		type: "POST",
		url: "/affair/stuApplystaySchool",
		data: param,
		success: function(result){
			if(result.status=="true"){ 
				alert("提交成功");  
			}
			if(result.status=="error"){
				alert(result.msg);  
			}
		},
		error: function(result){
			alert(result.msg);
		}
	});
	
};


