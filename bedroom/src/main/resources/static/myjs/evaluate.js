$(function(){
	initApplyPage();
})
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
