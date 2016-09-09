<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">
<head>
<%
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>宿舍管理系统登录</title>
<link href="${pageContext.request.contextPath}/jsp/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/jsp/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/jsp/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/jsp/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	
window.onload=function(){
 	//读取cookie的值
	var arr = document.cookie.match(new RegExp("(^| )" + "userInfo" + "=([^;]*)(;|$)"));
    if (arr != null) {
    	var userInfos = decodeURIComponent(arr[2]).split(",");//将获取的cooking以逗号分成数字
    	var userTypes = document.getElementsByName("userType");
    	document.getElementById("userName").value = userInfos[1];
    	document.getElementById("password").value = userInfos[2];
    	//遍历单选
    	for(var i=0;i<userTypes.length;i++) {
			if(userTypes[i].value==userInfos[0]) {
				userTypes[i].checked = "checked";
				break;
			}
		}
    }
}
	
	function checkForm() {
		var userName = document.getElementById("userName").value;
		var password = document.getElementById("password").value;
		if (userName == null || userName == "") {
			document.getElementById("error").innerHTML = "用户名不能为空";
			return false;
		}
		if (password == null || password == "") {
			document.getElementById("error").innerHTML = "密码不能为空";
			return false;
		}
		if (userType == null || userType == "") {
			document.getElementById("error").innerHTML = "请选择用户类型";
			return false;
		}
		return true;
	}
</script>

<style type="text/css">
	  body {
        padding-top: 200px;
        padding-bottom: 40px;
        background-image: url('${pageContext.request.contextPath}/jsp/images/bg.jpg');
        background-position: center;
		background-repeat: no-repeat;
		background-attachment: fixed;
      }
      
      .radio {
      	padding-top: 10px;
       	padding-bottom:10px;
      }
      
      .form-signin-heading{
      	text-align: center;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
</style>

</head>
<body>
<div class="container">
      <form name="myForm" class="form-signin" action="loginResult" method="post" onsubmit="return checkForm()">
        <h2 class="form-signin-heading"><font color="gray">宿舍管理系统</font></h2>
        <input id="userName" name="userName"  type="text" class="input-block-level" placeholder="用户名...">
        <input id="password" name="password"  type="password" class="input-block-level" placeholder="密码..." >
        <label class="radio inline">
      	  	<input id="admin" type="radio" name="userType" value="admin"  checked/> 系统管理员
		</label>
		<label class="radio inline">
			<input id="dormManager" type="radio" name="userType" value="dormManager"/> 宿舍管理员
		</label>
		<label class="radio inline">
			<input id="student" type="radio" name="userType" value="student" /> 学生
		</label>
        <label class="checkbox">
          <input id="remember" name="remember" type="checkbox" value="remember-me" >记住我 &nbsp;&nbsp;&nbsp;&nbsp; <font id="error" color="red">${error }</font>  
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-primary" type="button" >重置</button>

      </form>
</div>
</body>
</html>