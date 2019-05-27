/**
 * 辅导员审批留校
 * @param date
 * @returns
 */



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
	//展示学生离校申请信息
	showApprovalApplyStayInfo();
	
	//展示学生离校审批结果信息
	showApprovalResultStaySchool();
	
});

/**
 * 展示离校申请信息
 * @returns
 */
function showApprovalApplyStayInfo(){
	$("#approval-apply-stay").DataTable(
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
	                url: "/counselor/showApprovalStayInfo",//修改路径即可
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
			        {"data":'applyTime',
			        	render : function(data){
			        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
			        	}
			        },
			        {"data":'affairId',
			        	render:function(data){
			        		return '<input type="button" value="同意" onclick="agreeStaySchool('+data+')"></input>'+
			        		'&nbsp;&nbsp;<input type="button" value="拒绝" onclick="refuseStaySchool('+data+')"></input>';
			        	}
			        }
			        
			    ]
		});
};

/**
 * 辅导员同意申请;  操作为同意
 */
function agreeStaySchool(data){
	var AAA=confirm("确认提交?");
	if(!AAA){  return ;  };
	//ajax请求,执行操作
	$.ajax({
		type: "POST",
		url: "/counselor/counselorAgreeStaySchool",
		data: {"affairId" : parseInt(data) },
		success: function(result){
			if(result.status=="true"){ 
				alert("操作成功"); 
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
 * 辅导员同意申请;  操作为同意
 */
function refuseStaySchool(data){
	var AAA=confirm("确认提交?");
	if(!AAA){  return ;  };
	//ajax请求,执行操作
	$.ajax({
		type: "POST",
		url: "/counselor/counselorRefuseStaySchool",
		data: {"affairId" : parseInt(data) },
		success: function(result){
			if(result.status=="true"){ 
				alert("操作成功"); 
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
 * 展示离校申请审批结果信息
 * @returns
 */
function showApprovalResultStaySchool(){
	$("#show-approval-result-stay").DataTable(
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
	                url: "/counselor/showApprovalResultStaySchool",//修改路径即可
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
			        {"data":'applyTime',
			        	render : function(data){
			        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
			        	}
			        },
			        {"data":'replyReason'},
			        {"data":'replyTime',
			        	render : function(data){
			        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
			        	}
			        },
			        
			    ]
		});
};




