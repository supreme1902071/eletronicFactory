<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
<title>Insert title here</title>
</head>
<body>

<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 访问记录列表</strong> <a href="" style="float:right; display:none;">添加教师</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <!-- <li> <a class="button border-main icon-plus-square-o" href="SchoolclassAdd.jsp"> 添加班级</a> </li>
         <li> <a class="button border-main icon-plus-square-o" href="SchoolclassServlet?flag=1"> 显示所有班级</a> </li> -->
        <!-- <li ><b>搜索：</b> 
          
          <input type="text" placeholder="请输入搜索位置" id="searchlocation" name="location" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" onclick="return searchbylocation()" class="button border-main icon-search">搜索</a>
        </li> -->
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="10%">IP</th>
        <th>用户名</th>
        <th>访问时间</th>
        <th>访问的servlet</th>
        <th>参数</th>
       <!--  <th width="10%">更新时间</th> -->
    
      </tr>
      <volist name="list" id="vo">
          <c:forEach items="${list}" var="visit" varStatus="status">
		<tr <c:if test="${status.index %2 == 0}"> style="background-color:#b5cfd9;"</c:if>>
		    <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
              ${visit.id}</td>
			<td>${visit.ip}</td>
			<td>${visit.userName}</td>
			<td>${visit.visitTime}</td>
			<td>${visit.visitServlet}</td>
			<td>${visit.parameter}</td>
	
            
        </tr>
	</c:forEach>
        
      <%-- <tr>
        <td colspan="8">
	        <div class="pagelist"> 
	        	<a href="visitServlet?flag=1&page=1">首页</a> 
	        	<a href="SchoolclassServlet?flag=7&page=${page-1}">上一页</a> 
	       		<a href="SchoolclassServlet?flag=7&page=${page+1}">下一页</a>
	       		<a href="SchoolclassServlet?flag=7&page=${total}">尾页</a> 
	       	</div>
        </td>
      </tr> --%>
    </table>
  </div>
</form>
<script type="text/javascript">

function searchbylocation(){
	 var searchlocation=$("#searchlocation").val();
	 location.href="SchoolclassServlet?flag=6&location="+searchlocation;
	 console.log("SchoolclassServlet?flag=6&location="+searchlocation);
}


//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		location.href="SchoolclassServlet?flag=5&id="+id;
		console.log("SchoolclassServlet?flag=5&id="+id);
	}
}

</script>
</body>
</html>