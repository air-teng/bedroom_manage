$(function(){
	initApplyPage();
	initHistoryApplyTable();
})
function initHistoryApplyTable(){
		$("#apply_div_table_tb").DataTable({
		 	"aaSorting": [[3,'desc'],[4,'desc']],
	        "aLengthMenu": [ 5, 10,20],//设置显示条数
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
		        "lengthMenu": "每页 _MENU_ 条结果",
		        "info": "第_PAGE_页/共_PAGES_页",
		        "infoEmpty": "未找到相关数据",
		        "search": "关键字",
		        "zeroRecords": "未找到相关数据",
		        "decimal": ".",
		        "thousands": ","
		    },
	        
	        ajax:{
	            url: "/affair/getLateBackHistoryApply",//修改路径即可
	            type: 'GET',
	            //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
	            dataSrc: function (myJson) {
	                if (myJson.timeout) {
	                    return "";
	                }
	                return myJson;
	            }
		    },
		    columns: [
	            {"data": "affairId"},
	            {"data": "stuAccount"},
	            {"data": "backTime",
	            	render : function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		return data.split("T")[0]+" "+data.split("T")[1].split("+")[0].split(".")[0];
		        	}
	            },
	            {"data": "applyTime",
	            	render : function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		return data.split("T")[0]+" "+data.split("T")[1].split("+")[0].split(".")[0];
		        	}
	            },
	            {"data": "replyTime",
	            	render:function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		return data.split("T")[0]+" "+data.split("T")[1].split("+")[0].split(".")[0];
	            	}
	            },
	            {"data": "replyReason",
	            	render:function(data){
	            		if(data == null || data == ""){
	            			return "待定";
	            		}else{
	            			return data;
	            		}
	            	}
	            },
	            {"data": "affairStatus",
	            	render:function(data){
	            		if(data == 0){
	            			return "待审核";
	            		}else if(data == 1){
	            			return "审核通过";
	            		}else if(data == 2){
	            			return "审核拒绝";
	            		}else{
	            			return "未知状态";
	            		}
	            	}
	            },{"data":"affairId",
	            	render:function(data,type,row,meta){
	            		if(row.affairStatus == 0){
	            			return "<a style='color:#08c;cursor:pointer;' onclick='deleteAffair(\""+data+"\")'>删除</a>"
	            		}else{
	            			return "<span style='color:red;'>不可修改</span>";
	            		}
	            	}
	            }
	        ]
	});
}
function deleteAffair(affairId){
	$.ajax({
		url:"/affair/deleteLateBack",
		type:"POST",
		data:{"affairId":affairId},
		success:function(res){
			if(res.status == "true"){
				alert("删除成功");
				window.location.reload();
			}else{
				alert(res.msg);
			}
		},error:function(res){
			alert(res.msg);
		}
	})
}
function initApplyPage(){
	$("#apply_submit_div").find("input[name='stu_name']").val(userPermission.userName);
	$("#apply_submit_div").find("input[name='stu_account']").val(userPermission.userAccount);
	$.ajax({
		url:"bedroom/getCurBedroom",
		data:{"stuAccount":userPermission.userAccount},
		success:function(res){
			if(res.status="true"){
				$("#apply_submit_div").find("select[name='building_code']").html(
						'<option value="'+res.object.buildingCode+'">'+res.object.buildingCode+'</option>'
				);
				$("#apply_submit_div").find("select[name='unit']").html(
						'<option value="'+res.object.unit+'">'+res.object.unit+'</option>'
				);
				$("#apply_submit_div").find("select[name='bedroom_code']").html(
						'<option value="'+res.object.bedroomCode+'">'+res.object.bedroomCode+'</option>'
				);
			}else{
				alert(res.msg);
			}
			
		},
		error:function(res){
			alert(res);
		}
	});

}
function applyLateBack(){
	var back_time = $("#apply_submit_div").find("input[name='late_back_time']").val();
	var apply_reason = $("#apply_submit_div").find("textarea[name='apply_reason']").val();
	var stu_account = $("#apply_submit_div").find("input[name='stu_account']").val();
	
	if(back_time == ""){
		alert("请填写晚归时间");
		return;
	}
	if(stu_account == ""){
		alert("登录已失效，请重新登录");
		return ;
	}
	if(apply_reason == ""){
		alert("请填写晚归原因");
		return ;
	}
	var param ={
		"stuAccount":stu_account,
		"backTime":datetimeLocalToDate(back_time),
		"applyReason":apply_reason
	}
	
	$.ajax({
		url:"affair/lateBackApply",
		data:param,
		type:"POST",
		success:function(res){
			if(res.status="true"){
				alert("申请成功");
				window.location.reload();
			}else{
				alert(res.msg);
			}
		},
		error:function(res){
			alert(res);
		}
	});
}
