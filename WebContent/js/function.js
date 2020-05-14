
var flag=true;


function change(img){
	img.src="getCode?"+new Date().getTime();
}


function FocusItem(obj){
	
	if($(obj).attr('name')=='verycode'){
		$(obj).next().next().html('').removeClass('error');
	}
	else
	{$(obj).next('span').html('').removeClass('error');}
	
}
function CheckItem(obj){
	var msgBox=$(obj).next('span');
	
	switch($(obj).attr('name')){
		case "username":
			if(obj.value==""){
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				//"true" "false"
				$.get(url,function(data){
					if(data=="false"){
						msgBox.html('用户名已存在，不能使用');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}
				});
			}
			
			break;
		case "name":
			if(obj.value==""){
				msgBox.html('用户姓名不能为空');
				msgBox.addClass('error');
				flag=false;
				
			}
			
			break;
		case "password":
			if(obj.value==""){
				msgBox.html('密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				
				flag=true;
			}
			break;
		case "repassword":
			if(obj.value==""){
				msgBox.html('确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}
			else if($(obj).val() !=$('input[name="password"]').val()){
				msgBox.html('两次输入的密码不一致');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
			
		case "email":
			var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
			if (reg.test(obj.value)) {
				
			flag=true;
			} else {
				msgBox.html("邮箱格式不正确");
			flag=false;
			}
			break;
		case "verycode":
			
			var numshow=$(obj).next().next();
			if(obj.value==""){
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag=false;
				
			}else{
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
	
				$.get(url,function(data){
			    	if(data=='false'){
			    		numshow.html('验证码输入有误');
			    		numshow.addClass('error');
			    		flag=false;
			    	}else{
			    		numshow.html().removeClass('error');
			    		flag=true;
			    	}
			    });
			}
			break;
			
	}
	
}


function checkFrom(frm){
	var els=frm.getElementsByTagName('input');
	//onblur 才需验证
	
	 for(var i=0;i<els.length;i++){
		 if(els[i]!=null){
			 if(els[i].getAttribute("onblur")){
				 CheckItem(els[i]);
			 }
		 }
	 }
	 return flag;
	
}