function submitChange(){
	var stu_name = $("#apply_submit_div").find("input[name='stu_name']").val();
	var stu_account = $("#apply_submit_div").find("input[name='stu_account']").val();
	var cur_bedroom_id = $("#apply_submit_div").find("input[name='cur_bedroom_id']").val();
	var target_bedroom_id = $("#apply_submit_div").find("input[name='target_bedroom_id']").val();
	var apply_reason = $("#apply_submit_div").find("textarea[name='apply_reason']").val();
	if(stu_name.trim().equals("")
			||stu_account.trim().equals("")||cur_bedroom_id.trim().equals("")
			||target_bedroom_id.trim().equals("")||apply_reason.trim().equals("")
	){
		alert("请将申请信息填写完整");
		return ;
	}
	var param = {
		"stuName":stu_name,
		"stuAccount":stu_account,
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