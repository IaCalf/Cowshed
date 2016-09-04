<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div  style="margin: 0 auto;width: 800px;">
		<h1 align="center">图书借阅系统--后台管理</h1>
	<p>
		<script type="text/javascript">
		//将cookie里面的值读入搜索框中
		window.onload=function(){
			if(getCookie("cookieName")!="\"\""){
				document.getElementById("cookie").value=getCookie("cookieName");
			}
			
			/**
			进入首页加载数据
			if(${pt==null}){
				window.onload=function(){
					window.location="getBookInfo.action?cname";
				}
			} */
		}
		/**
		//document.cookie = "cookieName=" + escape("要写入的内容");//cookieName为要写入的Cookie的名称  
		  
		//读Cookie，返回值为相应Cookie的内容
		function getCookie(cookieName){  
		    var cookieContent = '';  
		    var cookieAry = document.cookie.split("; ");//得到Cookie数组  
		    for(var i=0;i<cookieAry.length;i++){  
		        var temp = cookieAry[i].split("=");  
		        if(temp[0] == cookieName){  
		             cookieContent = decodeURIComponent(temp[1]); 
		        }  
		    }  
		    return cookieContent;  
		} */
		function getCookie(name) {
            var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
            if (arr != null) return decodeURIComponent(arr[2]); return null;
        };
        
		</script>
		<div align="center">
			<form action="getNameBook.action" method="post">
				图书名称:<input type="text" id="cookie" name="cname" value="">
						<input type="submit" value="查询">
			</form>
		</div>
	</p>
	<input type="button" id="add" value="新增员工" onclick="Add()">
	<table border="1" cellpadding="0" cellspacing="0" width="800" align="center">
    	<tr>
    		<th>图书编号</th>
    		<th>图书类型</th>
    		<th>图书名称</th>
    		<th>作者</th>
    		<th>出版社</th>
    		<th>入库时间</th>
    		<th>是否借阅</th>
    		<th>操作</th>
    	</tr>
    	<c:if test="${pt.pagedata.size()==0}">
    		<tr><td colspan="8"><h3 align="center">没有匹配项</h3></td></tr>
    	</c:if>
    	<c:forEach items="${pt.pagedata }" var="t" varStatus="i">
	    	<tr height="30" <c:if test="${i.index%2==0 }">style="background-color:#DDD"</c:if>>
	    		<td>${t.bookCode}</td>
	    		<td>${t.bookType.getTypeName() }</td>
	    		<td>${t.bookName }</td>
	    		<td>${t.bookAuthor }</td>
	    		<td>${t.publishPress }</td>
	    		<td><fmt:formatDate value="${t.creationTime}"/> </td>
	    		<td>${t.isBorrow==0?"未借阅":"已借阅" }</td>
	    		<td>
	    			<a href="lookBookInfo.action?id=${t.bookId }" style="color:#000;">查看</a>&nbsp;
	    			<a href="upBook.action?id=${t.bookId }" style="color:#000;">修改</a>&nbsp;
	    			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='deleteBook.action?id=${t.bookId }'" style="color:#000;">删除</a>
	    		</td>
    	</c:forEach>
    	<tr height="28">
    		<script type="text/javascript">
	    		function getEmp(){
	    			var no=document.getElementById("no").value;
	    			window.location="getBookInfoPage.action?no="+no;
	    		}
	    		function Add(){
	    			window.open ("goAddBook.action",
	    					"newwindow",
	    					"height=500,width=500,top=100,left=500,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no"); 
	    			//脚本运行后，page.html将在新窗体newwindow中打开，宽为500，高为500，距屏顶100象素，屏左500象素，无工具条，无菜单条，无滚动条，不可调整大小，无地址栏，无状态栏。
	    			
	    		}
	    		function up(){
	    			window.location="goupBook.action";
	            }
	    	</script>
    		<td colspan="8" align="right">
    			<input type="button" onclick="javascript:location.href='getBookInfo.action?cname'" value="返回">
    			
    			<input id="no" size="6"><button onclick="getEmp()">GO</button>
    			<a href="getBookInfoPage.action?no=1">首页</a>
    			<a href="getBookInfoPage.action?no=${pt.pageno-1 }">上一页</a>
    			<a href="getBookInfoPage.action?no=${pt.pageno+1 }">下一页</a>
    			<a href="getBookInfoPage.action?no=${pt.totalPage}">末页</a>
    			<span>${pt.pageno }页/${pt.totalPage }页</span>
    		</td>
    	</tr>
    </table>
	</div>
</body>
</html>