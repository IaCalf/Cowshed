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
		<table border="1" cellpadding="0" cellspacing="0" width="400" height="400" align="center">
			<caption><h2>查看图书信息</h2></caption>
			<tr>
				<td class="tendent">图书编号</td>
				<td class="tendentrig"><input type="text" value="${b.bookCode }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td class="tendent">图书名称</td>
				<td class="tendentrig"><input type="text" value="${b.bookName }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td class="tendent">图书类型</td>
				<td class="tendentrig">
					<input type="text" value="${b.bookType.getTypeName() }" readonly="readonly"/>
             	</td>
			</tr>
			<tr>
				<td class="tendent">作 者</td>
				<td class="tendentrig">
					<input type="text" value="${b.bookAuthor }" readonly="readonly"/>
                </td>
			</tr>
			<tr>
				<td class="tendent">出版社</td>
				<td class="tendentrig"><input type="text" value="${b.publishPress }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td class="tendent">是否借阅</td>
				<td class="tendentrig">
					<select name="birthmonth" size="1">
							<option value="">${b.isBorrow==0?'未借阅':'已借阅'}</option>
	                </select>
                </td>
			</tr>
			<tr>
				<td class="tendent">入库人</td>
				<td class="tendentrig"><input type="text" value="${b.createdby }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td class="tendent">入库时间</td>
				<td class="tendentrig">
					<input type="text" value="${b.creationTime }" readonly="readonly"/>
                </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" align="middle" onclick="javascript:location.href='getBookInfo.action'" value="返回" />
				</td>
			</tr>
		</table>
</body>
</html>