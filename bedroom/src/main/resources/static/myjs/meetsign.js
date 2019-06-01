$(function(){
	initAllToReplyTable();
})
function initAllToReplyTable(){
	$("#all-to-reply-table").DataTable({
		 	"aaSorting": [[5,'asc']],
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
                url: "/affair/getAllBackLateToReply",//修改路径即可
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
	            {"data": "stuName"},
	            {"data": "backTime",
	            	render : function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		/*return data;*/
		        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
		        	}
	            },
	            {"data": "applyTime",
	            	render : function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		/*return data;*/
		        		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
		        	}
	            },
	            {"data": "replyTime",
	            	render:function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		/*return data;*/
	            		return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];
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
	            			var jsonRow = JSON.stringify(row);
	            			return "<a style='color:#08c;cursor:pointer;' onclick='replyAffairModal("+jsonRow+")'>审核</a>";
	            		}else{
	            			return "<span style='color:green;'>已审核</span>";
	            		}
	            	}
	            }
	        ]
	});
}
function replyAffairModal(row){
	$("input[name='affairId']").val(row.affairId);
	$("input[name='name']").val(row.stuName);
	$("input[name='stuAccount']").val(row.stuAccount);
	/*$("input[name='backTime']").val(dateToDatetimeLocal(row.backTime));*/
	$("input[name='applyTime']").val(row.applyTime.split("T")[0]+" "+row.applyTime.split("T")[1].split(".")[0]);
	$("input[name='backTime']").val(row.backTime.split("T")[0]+" "+row.backTime.split("T")[1].split(".")[0]);
	$("textarea[name='applyReason']").val(row.applyReason);
	$("textarea[name='replyReason']").val(row.replyReason);
	
	var optionArr = $("select[name='affairStatus']").find("option");
	for(var i = 0;i<optionArr.length;i++){
		$("select[name='affairStatus']").find("option").attr("selected",false);
	}
	$("select[name='affairStatus']").find("option[value='"+row.affairStatus+"']").attr("selected",true);
	$("#myModal").modal("show");
}
function replyAffairSubmit(){
	var param ={
		"affairId":$("input[name='affairId']").val(),
		"replyReason":$("textarea[name='replyReason']").val(),
		"affairStatus":$("select[name='affairStatus']").find("option:selected").val()
	}
	$.ajax({
		url: "/affair/backLateAffairReply",
		type: "POST",
		data: param,
		success: function(data){
			if(data.status == "true"){  
				alert("审核成功!");
				window.location.reload();
			};
			if(data.status == "error"){  
				alert(data.msg);
			};
		},
		error: function(data){
			alert(data.msg);
		}
	}) ;
}