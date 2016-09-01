<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="800" align="center">
    	<caption><h1>部门信息表</h1></caption>
    	<tr>
    		<th>编号</th>
    		<th>部门</th>
    		<th>地址</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${pt.pagedata }" var="e">
	    	<tr height="30">
	    		<td>${e.deptno}</td>
	    		<td>${e.dname }</td>
	    		<td>${e.loc }</td>
	    		<td><a href="getDept.action?id=${e.deptno }" style="color:#000;">修改</a>&nbsp;
	    			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='deleteDept.action?id=${e.deptno }'" style="color:#000;">删除</a></td>
	    	</tr> 
    	</c:forEach>
    	<tr height="28">
    		<script type="text/javascript">
	    		function getEmp(){
	    			var no=document.getElementById("no").value;
	    			window.location="deptPage.action?no="+no;
	    		}
	    		function Add(){
	    			window.open ("pages/addDept.jsp",
	    					"newwindow",
	    					"height=500,width=500,top=100,left=500,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no"); 
	    			//脚本运行后，page.html将在新窗体newwindow中打开，宽为500，高为500，距屏顶100象素，屏左500象素，无工具条，无菜单条，无滚动条，不可调整大小，无地址栏，无状态栏。
	    		}
	    	</script> 
    		<td colspan="8" align="right">
    			<input type="button" onclick="javascript:location.href='pages/index.jsp'" value="返回">
    			<input type="button" id="add" value="新增部门" onclick="Add()">
    			<input id="no" size="6"><button onclick="getEmp()">GO</button>
    			<a href="deptPage.action?no=1">首页</a>
    			<a href="deptPage.action?no=${pt.pageno-1 }">上一页</a>
    			<a href="deptPage.action?no=${pt.pageno+1 }">下一页</a>
    			<a href="deptPage.action?no=${py.totalPage}">末页</a>
    			<span>${pt.pageno }页/${pt.totalPage }页</span>
    		</td>
    	</tr>
    </table>
</body>
</html>