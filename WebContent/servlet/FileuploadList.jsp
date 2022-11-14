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
    <div class="panel-head"><strong class="icon-reorder"> 上传列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="Fileupload.jsp"> 添加上传文件</a> </li>
       
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="10%">文件名</th>
        <th>上传用户名</th>
        <th>上传时间</th>
    <th>操作</th>
       <!--  <th width="10%">更新时间</th> -->
      </tr>
      <volist name="list" id="vo">
          <c:forEach items="${list}" var="upload" varStatus="status">
		<tr <c:if test="${status.index %2 == 0}"> style="background-color:#b5cfd9;"</c:if>>
		    <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
              ${upload.id}</td>
			<%-- <td>${upload.filename}</td> --%>
			
			<td><a href="DownloadServlet?name=${upload.filename }">${upload.filename }</a></td>
			<%-- <a href="DownloadServlet?name=../${fileLoad.fileName }">${fileLoad.fileName }</a> --%>
			<td>${upload.username}</td>
			<td>${upload.uploadtime}</td>
	
           <td>
		   			 <div class="button-group">
		   			  
		   			  <a class="button border-red" href="javascript:void(0)" onclick="return del(${upload.id})">
		   			 <span class="icon-trash-o"></span> 删除
		   			 </a>
		   			  </div>
		   			  </td>
        </tr>
	</c:forEach>
        
      <%-- <tr>
        <td colspan="8">
	        <div class="pagelist"> 
	        	<a href="TeacherListServlet?flag=12&page=1">首页</a> 
	        	<a href="TeacherListServlet?flag=12&page=${page-1}">上一页</a> 
	       		<a href="TeacherListServlet?flag=12&page=${page+1}">下一页</a>
	       		<a href="TeacherListServlet?flag=12&page=${total}">尾页</a> 
	       	</div>
        </td>
      </tr> --%>
    </table>
  </div>
</form>
<script type="text/javascript">
//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		 location.href = "UploadListServlet?flag=2&id="+id;
	}
}
</script>
</body>
</html>