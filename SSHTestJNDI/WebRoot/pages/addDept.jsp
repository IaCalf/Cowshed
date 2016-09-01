<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.tendent{
			width: 80px;
			text-align:justify;
		    text-align-last:justify;
		    line-height:2;
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
    <form action="addUpdate.action" method="post" >
		<table border="1" cellpadding="0" cellspacing="0" width="400" height="400" align="center">
			<caption><h2>修改部门信息</h2></caption>
			<tr>
				<td class="tendent">部门编号</td>
				<td class="tendentrig"><input type="text" name="dept.deptno"/></td>
			</tr>
			<tr>
				<td class="tendent">部门名称</td>
				<td class="tendentrig"><input type="text" name="dept.dname"/></td>
			</tr>
			<tr>
				<td class="tendent">部门地址</td>
				<td class="tendentrig"><input type="text" name="dept.loc"/></td>
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
