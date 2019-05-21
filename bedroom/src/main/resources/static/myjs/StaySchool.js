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
	//展示留校申请信息
	showApplyLeaveInfo();
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
			// 成功后刷新页面
            window.location.reload();
		},
		error: function(result){
			alert(result.msg);
		}
	});
	
};

/**
 * 展示留校申请信息
 * @returns
 */
function showApplyLeaveInfo(){
	$("#show-apply-stay").DataTable(
			{
				"aLengthMenu": [ 5, 10,20],//设置显示条数
//				"scrollX":true,
				"responsive": false,
		        "bAutoWidth": true, //自动计算列宽
	    		"ordering": true, //排序
			    "pageLength": 5,　//初始化显示几条数据
			    "pagingType": "full_numbers",
			    "bFilter":false,  //去掉自定义搜索框
			    "language": {　　// 这是修改语言的显示
			        "paginate": {
			            first: "首条",
			            previous: "前一页",
			            next: "下一页",
			            last: "末页"
			        },
			        "info": "第_PAGE_页,共_PAGES_页",
			        "infoEmpty": "未找到相关数据",
			        "search": "关键字",
			        "zeroRecords": "未找到相关数据",
			        "decimal": ".",
			        "thousands": ","
			    },
			    
			    //ajax实现数据的传递的再现
			    ajax:{
	                url: "/affair/showApplyStayInfo",//修改路径即可
	                type: 'POST',
	                //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
	                dataSrc: function (myJson) {
	                    if (myJson.timeout) {
	                        return "";
	                    }
	                    return myJson;
	                }
			    },
			    columns: [　//这个是显示到界面上的个数据　格式为 {data:'显示的字段名'}
			        {"data":'stuAccount'},
			        {"data":'startTime',
			        	render : function(data){
			        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
			        	}
			        },
			        {"data":'endTime',
			        	render : function(data){
			        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
			        	}
			        },
			        {"data":'applyReason'},
			        {"data":'affairId',
			        	render:function(data){
			        		return '<input type="button" value="删除" onclick="deleteAppliLeaveSchool('+data+')"></input>';
			        	}
			        }
			        
			    ]
		});
};

/**
 * 删除离校申请
 * @returns
 */
function deleteAppliLeaveSchool(data){
	var AAA=confirm("确认删除?");
	if(!AAA){  return  ;   };
	//
	$.ajax({
		type: "POST",
		url: "/affair/removeApplyLeaveSchool",
		data: {"affairId":parseInt(data)} ,
		success: function(result){
			if(result.status=="true"){ 
				alert("提交成功"); 
			}
			if(result.status=="error"){
				alert(result.msg);
			}
			// 成功后刷新页面
            window.location.reload();
		},
		error: function(result){
			alert(result.msg);
		}
	});
	
};



