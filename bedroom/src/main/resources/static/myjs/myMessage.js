
$(function(){
	
	// 从button按钮找到---function中的click函数---模态框弹出编辑页面
	$("#update-modal").on("click",function(){//会执行,但是只是绑定点击事件
		$("#my-modal-update").modal("show");
	});
	
	//修改个人信息;
	$("#update-userinfo-modalbuttom").on('click',function(){
		//封装数据为用户实体类
		var param={};
		param.userName=$("#name").val();
		param.userPassword=$("#pwd").val();
		param.userNickname=$("#nickname").val();
		param.userSex=$("#sex").val();
		param.userAge=$("#age").val();
		param.userPhone=$("#phone").val();
		param.userCollegeName=$("#college").val();
		//判断修改值是否合法
		if(param.userPassword=="" || param.userPassword==null){
			alert("密码不能为空");
			return false;
		}
		if(param.userSex!="男" && param.userSex!="女"){
			alert("性别输入只能为男或女");
			return false;
		}
		$.ajax({
			type: "POST",
			url: "/user/updateUserInfo",
			data: param,
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
		
	});
	
});


