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
    <div class="panel-head"><strong class="icon-reorder"> 部门列表</strong> </div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="ApartmentAdd.jsp"> 添加部门</a> </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">部门ID</th>
        <th width="40%">部门名称</th>
        
       <!--  <th width="10%">更新时间</th> -->
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
          <c:forEach items="${list}" var="apartment" varStatus="status">
		<tr <c:if test="${status.index %2 == 0}"> style="background-color:#b5cfd9;"</c:if>>
		    <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
              ${apartment.id}</td>
			<td>${apartment.apartmentName}</td>
			
	
            <td><div class="button-group"> <a class="button border-main" href="ApartmentServlet?flag=4&id=${apartment.id}"><span class="icon-edit"></span> 修改</a>
             <a class="button border-red" href="javascript:void(0)" onclick="return del(${apartment.id})"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
	</c:forEach>
        
      
    </table>
  </div>
</form>
<script type="text/javascript">

function searchbyageisparty(){
	 var searchage=$("#searchage").val();
	 var searchisparty=$("#searchisparty").val();
	/*  console.log(searchage);
	 console.log(searchisparty); */
	 location.href="TeacherListServlet?flag=11&age="+searchage+"&isparty="+searchisparty;
	// console.log("TeacherListServlet?flag=2&age="+searchage+"&isparty="+searchisparty);
}


//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		location.href="ApartmentServlet?flag=5&id="+id;
	}
}

</script>
</body>
</html>