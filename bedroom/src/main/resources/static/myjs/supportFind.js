$(function(){
	initApplyPage();
	$("#apply_submit_div").on("change",'select[name="building_code_target"]',function(){
		initUint($("#apply_submit_div").find("select[name='building_code_target']").val());
	})
	$("#apply_submit_div").on("change",'select[name="unit_target"]',function(){
		initBedroomCode($("#apply_submit_div").find("select[name='building_code_target']").val(),$("#apply_submit_div").find("select[name='unit_target']").val());
	})
	initHistoryApplyTable();
})
function initHistoryApplyTable(){
	$("#apply_div_table_tb").DataTable({
		 	"aaSorting": [[4,'desc'],[5,'desc']],
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
                url: "/affair/getHistoryList",//修改路径即可
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
	            {"data": "curBedroomName"},
	            {"data": "targetBedroomName"},
	            {"data": "applyTime",
	            	render : function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		return data;
		        		/*return data.split("T")[0]+" "+data.split("T")[1].split(".")[0];*/
		        	}
	            },
	            {"data": "replyTime",
	            	render:function(data){
	            		if(data==null || data==""){
	            			return "-";
	            		}
	            		return data;
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
		url:"/affair/deleteChangeAffair",
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
/*初始化页面信息*/
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
				$("#apply_submit_div").find("input[name='cur_bedroom_id']").val(userPermission.bedroomId);
			}else{
				alert(res.msg);
			}
			
		},
		error:function(res){
			alert(res);
		}
	});
	
	$.ajax({
		url:"bedroom/getAllBedroom",
		data:{"type":0},
		success:function(res){
			$("#apply_submit_div").find("select[name='building_code_target']").html('');
			if(res.status="true"){
				for(var i=0;i<res.object.length;i++){
					if(i==0){
						initUint(res.object[i]);
					}
					$("#apply_submit_div").find("select[name='building_code_target']").append(
							'<option value="'+res.object[i]+'">'+res.object[i]+'</option>'
					);
				}
				
			}else{
				alert(res.msg);
			}
			
		},
		error:function(res){
			alert(res);
		}
	});
}
function initUint(buildingCode){
	$.ajax({
		url:"bedroom/getAllBedroom",
		data:{"type":1,"buildingCode":buildingCode},
		success:function(res){
			if(res.status="true"){
				$("#apply_submit_div").find("select[name='unit_target']").html('');
				for(var i=0;i<res.object.length;i++){
					if(i==0){
						initBedroomCode(buildingCode,res.object[i]);
					}
					$("#apply_submit_div").find("select[name='unit_target']").append(
							'<option value="'+res.object[i]+'">'+res.object[i]+'</option>'
					);
				}
			}else{
				alert(res.msg);
			}
			
		},
		error:function(res){
			alert(res);
		}
	});
}
function initBedroomCode(buildingCode,unit){
	$.ajax({
		url:"bedroom/getAllBedroom",
		data:{"type":2,"buildingCode":buildingCode,"unit":unit},
		success:function(res){
			if(res.status="true"){
				$("#apply_submit_div").find("select[name='bedroom_code_target']").html('');
				for(var i=0;i<res.object.length;i++){
					$("#apply_submit_div").find("select[name='bedroom_code_target']").append(
							'<option value="'+res.object[i]+'">'+res.object[i]+'</option>'
					);
				}
				setTargetBedroomId();//初始化targetBedroomId
			}else{
				alert(res.msg);
			}
			
		},
		error:function(res){
			alert(res);
		}
	});
}
function submitChange(){
	if($("#apply_submit_div").find("input[name='cur_bedroom_id']").val() == $("#apply_submit_div").find("input[name='target_bedroom_id']").val()){
		alert("转入寝室不能与原来寝室相同");
		return;
	}
	var stu_name = $("#apply_submit_div").find("input[name='stu_name']").val();
	var stu_account = $("#apply_submit_div").find("input[name='stu_account']").val();
	var cur_bedroom_id = $("#apply_submit_div").find("input[name='cur_bedroom_id']").val();
	var target_bedroom_id = $("#apply_submit_div").find("input[name='target_bedroom_id']").val();
	var apply_reason = $("#apply_submit_div").find("textarea[name='apply_reason']").val();
	if(stu_name.trim() == ""
			||stu_account.trim() == ""||cur_bedroom_id.trim() == ""
			||target_bedroom_id.trim() == ""||apply_reason.trim() == ""
	){
		alert("请将申请信息填写完整");
		return ;
	}
	var param = {
		"stuName":stu_name,
		"stuAccount":stu_account,
		"applyReason":apply_reason,
		"curBedroomId":cur_bedroom_id,
		"targetBedroomId":target_bedroom_id,
	}
	$.ajax({
		url:"/affair/changeApply",
		data:param,
		type:"POST",
		success:function(res){
			if(res.status=="true"){
				alert("申请成功");
				window.location.reload();//刷新页面
			}else{
				alert(res.msg);
			}
		},error:function(res){
			alert(res.msg);
		}
	})
}
function setTargetBedroomId(){
	var building_code_target = $("#apply_submit_div").find("select[name='building_code_target']").val();
	var unit_target = $("#apply_submit_div").find("select[name='unit_target']").val();
	var bedroom_code_target = $("#apply_submit_div").find("select[name='bedroom_code_target']").val();
	if(building_code_target.trim() == ""||unit_target.trim() == ""||bedroom_code_target.trim() == ""){
		return ;
	}
	var param = {
			"buildingCodeTarget":building_code_target,
			"unitTarget":unit_target,
			"bedroomCodeTarget":bedroom_code_target
	}
	$.ajax({
		url:"/bedroom/getBedroomId",
		data:param,
		type:"POST",
		success:function(res){
			if(res.status=="true"){
				$("#apply_submit_div").find("input[name='target_bedroom_id']").val(res.object);
			}else{
				alert(res.msg);
			}
		},error:function(res){
			alert(res.msg);
		}
	})
}