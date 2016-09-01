<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tendent{
	width: 80px;
	text-align:justify;
     text-align-last:justify;
     line-height:0;
     height:44px;
	background-color: #ddd;
	padding: 0 5px;
	}
.tendentrig{
	padding-left: 10px;
}
table{
border-color: #ddd;
}
</style>
</head>
<body>
	<form  action="addTeacher.action" method="post" >
		<table border="1" cellpadding="0" cellspacing="0" width="400" height="400" align="center">
			<caption><h2>增加员工信息</h2></caption>
			<tr>
				<td class="tendent">姓 名</td>
				<td class="tendentrig"><input type="text" name="teacher.tname" /></td>
			</tr>
			<tr>
				<td class="tendent">身份证号</td>
				<td class="tendentrig"><input type="text" name="teacher.tid" /></td>
			</tr>
			<tr>
				<td class="tendent">性 别</td>
				<td class="tendentrig"><input name="teacher.gender" type="radio" value="男" checked="checked" />男
             		<input name="teacher.gender" type="radio" value="女" />女</td>
			</tr>
			<tr>
				<td class="tendent">出生日期</td>
				<td class="tendentrig">
					<select name="birthyear" size="1">
						<c:forEach  var="birthyearNum" begin="1970" end="2016" step="1">
							<option value="${ birthyearNum}">${ birthyearNum}</option>
	                    </c:forEach>
	                </select>年
	                <select name="birthmonth" size="1">
						<c:forEach  var="birthmonthNum" begin="1" end="12" step="1">
							<option value="${ birthmonthNum}">${ birthmonthNum}</option>
	                    </c:forEach>
	                </select>月
	                <select name="birthday" size="1">
						<c:forEach  var="birthdayNum" begin="1" end="31" step="1">
							<option value="${ birthdayNum}">${ birthdayNum}</option>
	                    </c:forEach>
	                </select>日
	            </td>
			</tr>
			<tr>
				<td class="tendent">职 务</td>
				<td class="tendentrig"><input type="text" name="job" /></td>
			</tr>
			<tr>
				<td class="tendent">入职日期</td>
				<td class="tendentrig"><select name="hireyear" size="1">
					<c:forEach  var="hireyearNum" begin="1970" end="2016" step="1">
					<option value="${ hireyearNum}">${ hireyearNum}</option>
                    </c:forEach>
                </select>年
                <select name="hiremonth" size="1">
					<c:forEach  var="hiremonthNum" begin="1" end="12" step="1">
					<option value="${ hiremonthNum}">${ hiremonthNum}</option>
                    </c:forEach>
                </select>月
                <select name="hireday" size="1">
					<c:forEach  var="hiredayNum" begin="1" end="31" step="1">
					<option value="${ hiredayNum}">${ hiredayNum}</option>
                    </c:forEach>
                </select>日</td>
			</tr>
			<tr>
				<td class="tendent">薪 水</td>
				<td class="tendentrig"><input type="text" name="sal" /></td>
			</tr>
			<tr>
				<td class="tendent">部 门</td>
				<td class="tendentrig">
					<select name="deptno" size="1">
							<c:forEach begin="10" end="100" step="10" var="dept" >
								<option value="${ dept}">${ dept}</option>
		                    </c:forEach>
	                </select>
                </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" />
					<input type="button" onclick="javascript:if(confirm('确认关闭吗？')) window.close()" value="关闭" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>