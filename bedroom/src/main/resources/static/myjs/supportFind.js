$(function(){
	initApplyPage();
	$("#apply_submit_div").on("change",'select[name="building_code_target"]',function(){
		initUint($("#apply_submit_div").find("select[name='building_code_target']").val());
	})
	$("#apply_submit_div").on("change",'select[name="unit_target"]',function(){
		initBedroomCode($("#apply_submit_div").find("select[name='building_code_target']").val(),$("#apply_submit_div").find("select[name='unit_target']").val());
	})
})
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