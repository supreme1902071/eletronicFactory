<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>档案借阅</title>
<link rel="stylesheet" href="../css/pintuer.css">
<link rel="stylesheet" href="../css/admin.css">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="LendServlet?flag=8"> 添加内容</a> </li>
        <li> <a class="button border-main icon-plus-square-o" href="LendServlet?flag=1"> 显示所有</a> </li>
           <li>
           <select id="apartmentName"  name="apartmentName" class="input" style="width:60px; line-height:17px">
              <option value="">部门</option>  
                 <c:forEach  items="${apartments}" var="apartment" >
                     <option value="${apartment.apartmentName}" >${apartment.apartmentName}</option>
                </c:forEach>
          </select> 
        
        </li>
       
        <li>
          <input type="text" placeholder="请输入搜索年度" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" id="yearId" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">id</th>
        <th width="10%">档案编号</th>
        <th>年度</th>
        <th>档案名称</th>
        <th width="10%">借阅日期</th>
        <th width="10%">归还日期</th>
        <th>是否归还</th>
        <th>部门</th>
        <th>借阅人</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
        <tr>
          
          	<!-- 循环输出商品信息 -->
	     <c:forEach items="${lendVos}"  var="lendVo" varStatus="status">
	   			
		   	   <!-- 如果是偶数行，为该行换背景颜色 -->
		   		<tr
		   		 <c:if test="${status.index % 2 == 0 }">
		   		  style="background-color:rgb(219,241,212);"
		   		 </c:if>
		   		> 	
		   		
		   			<td>
		   				${lendVo.id }
		   			</td>
		   			
		   			<td>
		   				${lendVo.number }
		   			</td>
		   			<td>
		   				${lendVo.year }
		   			</td>
		   			<td>
		   				${lendVo.fileName }
		   			</td>
		   			
		   			<td>
		   				${lendVo.lendTime }
		   			</td>
		   			
		   			<td>
		   				${lendVo.returnTime }
		   			</td>
		   			
		   			
		   			<td>
		   				${lendVo.flag }
		   			</td>
		   			
		   			
		   			<td>
		   				${lendVo.apartmentName }
		   			</td>
		   			
		   			
		   			<td>
		   				${lendVo.lender }
		   			</td>
		   			
		   			
		   			
		   			 <td><div class="button-group"> <a class="button border-main" href="LendServlet?flag=5&id=${lendVo.id }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(${lendVo.id })"><span class="icon-trash-o"></span> 删除</a> </div></td>
		   		</tr> 
		   		
		   		
	   		</c:forEach>  	
          
                 </tr>
   		</volist>
        
      <tr>
      
      
        
      
        <td colspan="8"><div class="pagelist"><a href="LendServlet?flag=7&page=1">首页</a><a href="LendServlet?flag=7&page=${page-1}">上一页</a> <span class="current">1</span><a href="LendServlet?flag=7&page=2">2</a><a href="LendServlet?flag=7&page=3">3</a><a href="LendServlet?flag=7&page=${page+1}">下一页</a><a href="LendServlet?flag=7&page=${totalPage}">尾页</a></div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

//搜索
function changesearch(){	
		var apartmentName=$("#apartmentName").val();
		var year=$("#yearId").val();
		location.href="LendServlet?flag=6&apartmentName="+apartmentName+"&year="+year;
}

//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		location.href="LendServlet?flag=4&id="+id;
	}
}
</script>
</body>
</html>