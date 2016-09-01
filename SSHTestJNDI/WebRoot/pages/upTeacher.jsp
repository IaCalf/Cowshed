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
	<form  action="upTeacher.action" method="post" >
		<table border="1" cellpadding="0" cellspacing="0" width="400" height="400" align="center">
			<caption><h2>增加员工信息</h2></caption>
			<tr>
				<td class="tendent">姓 名</td>
				<td class="tendentrig"><input type="text" name="teacher.tname"  value="${t.tname }" /></td>
			</tr>
			<tr>
				<td class="tendent">身份证号</td>
				<td class="tendentrig"><input type="text" name="teacher.tid" value="${t.tid }"/></td>
			</tr>
			<tr>
				<td class="tendent">性 别</td>
				<td class="tendentrig">
					<input name="teacher.gender" type="radio" value="男" <c:if test="${'男'==t.gender }">checked="checked"</c:if> />男
             		<input name="teacher.gender" type="radio" value="女" <c:if test="${'女'==t.gender }">checked="checked"</c:if> />女
             	</td>
			</tr>
			<tr>
				<td class="tendent">出生日期</td>
				<td class="tendentrig">
					<input type="text" name="teacher.birthdate" value="${t.birthdate }"/>
                </td>
			</tr>
			<tr>
				<td class="tendent">职 务</td>
				<td class="tendentrig"><input type="text" name="teacher.job" value="${t.job }"/></td>
			</tr>
			<tr>
				<td class="tendent">入职日期</td>
				<td class="tendentrig">
                	<input type="text" name="teacher.hiredate" value="${t.hiredate }"/>
                </td>
			</tr>
			<tr>
				<td class="tendent">薪 水</td>
				<td class="tendentrig"><input type="text" name="teacher.sal" value="${t.sal }"/></td>
			</tr>
			<tr>
				<td class="tendent">部 门</td>
				<td class="tendentrig">
					<%-- <input type="text" name="teacher.dept" 
						<c:if test="${empty dept }"> 
							value="${t.dept.dname }"
						</c:if>
					/> --%>
                </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden"  name="teacher.tno" value="${t.tno}" />
					<input type="submit" value="提交" />
					<input type="button" onclick="javascript:location.href='index.jsp'" value="返回" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>