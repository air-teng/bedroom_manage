$(function(){
		$("#login-button").on('click',function(){
			var param={};
			param.userName=$("#inputName").val();
			param.userPassword=$("#inputPassword").val();
			if(param.userName=="" || param.userPassword==""){
				alert("账户或密码不能为空!");
				return ;
			}
			
			$.ajax({
				type: "POST",
				url: "/user/login",
				data: param,
				success: function(data){
					if(data.status == "true"){  
						alert("恭喜登录成功!");
						window.location.href="index2.html";
					};
					if(data.status == "error"){  
						alert(data.msg);
					};
				},
				error: function(data){
					alert(data.msg);
				}
			}) ;
			
			
		});
		
	});