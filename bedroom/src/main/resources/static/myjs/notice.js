function detailForbedroom(){
	$("#bedrooms-list").css({"display":"none"});
	$("#bedroom-detail-div").css({"display":"block"});
}
//报修
function applyFixSubmit(){
	var param = {
		bedroomCode : $("#apply-body-div").find('input[name="applyClassroom"]').val(),
		reportName : $("#apply-body-div").find('input[name="name"]').val(),
		reportAccount : $("#apply-body-div").find('input[name="stuAccount"]').val(),
		reportObject : $("#apply-body-div").find('input[name="applyFixObject"]').val(),
		reportDetail : $("#apply-body-div").find('textarea[name="applyDetail"]').val()
	}
	if(param.reportObject == '' || param.applyDetail == ''){
		alert("请将报修物件和报修详情填写完整");
		return ;
	}
	$.ajax({
		url:"repair/reportRepair",
		type:"post",
		data:param,
		success:function(res){
			if(res.status == "true"){
				alert("提交报修申请成功!");
				window.location.reload();
			}else{
				alert(res.msg);
			}
		},error:function(res){
			alert("提交报修申请失败!");
		}
	})
}
$(function(){
	//报修
	$("body").on("click","[id='submit-to-fix']",function(){
		$("#myModal").modal("show");
	})
	$("#bedrooms-tb").dataTable({
		"aLengthMenu": [ 5, 10,20],//设置显示条数
//		"scrollX":true,
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
	    }
	});
	if(userPermission.userLevel == 0){
		$("#bedroom-detail-div").css({"display":"block"});
	}else{
		$("#bedrooms-list").css({"display":"block"});
	}
})