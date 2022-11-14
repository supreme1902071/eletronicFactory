<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
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
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 档案表列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="FilesAllServlet?flag=9"> 添加档案表</a> </li>
        <li> <a class="button border-main icon-plus-square-o" href="FilesAllServlet?flag=1"> 显示所有档案表</a> </li>
        <li>
          <input id="positionId" type="text" placeholder="请输入档案存放位置进行搜索" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch2()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
       <tr>
        <th width="100" style="text-align:left; padding-left:20px;">id</th>
        <th>年度</th>
        <th>档案编号</th>
        <th>名称</th>
         <th>登记人</th>
        <th>档案存放位置</th>
        <th>所属部门</th>
        <th>档案类别</th>
        <th>保密等级</th>
        <th>保管人</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
        <tr>
	
	     <c:forEach items="${filesVos}"  var="filesVo" varStatus="status">
		   		<tr
		   		 <c:if test="${status.index % 2 == 0 }">
		   		  style="background-color:rgb(219,241,212);"
		   		 </c:if>
		   		 >
		   		 
		  			<td>
		   				${filesVo.id}
		   			</td>
		   			
		   			<td>
		   				${filesVo.year}
		   			</td>
		   			
		   			<td>
		   				${filesVo.number}
		   			</td>
		   				
		   			<td>
		   				${filesVo.fileName}
		   			</td>
		   			<td>
		   				${filesVo.register}
		   			</td>
		   			
		   			<td>
		   				${filesVo.position}
		   			</td>
		   			
		   			<td>
		   				${filesVo.apartmentName}
		   			</td>
		   			
		   			<td>
		   				${filesVo.filetypeName}
		   			</td>
		   			<td>
		   				${filesVo.securitylevelName}
		   			</td>
		   			
		   			<td>
		   				${filesVo.keeperName}
		   			</td>
		   			
		   			 <td>
		   			 <div class="button-group">
		   			  <a class="button border-main" href="FilesAllServlet?flag=5&id=${filesVo.id}">
		   			 <span class="icon-edit"></span> 修改
		   			 </a>
		   			  <a class="button border-red" href="javascript:void(0)" onclick="return del(${filesVo.id})">
		   			 <span class="icon-trash-o"></span> 删除
		   			 </a>
		   			  </div>
		   			  </td>
		   		</tr> 
		  </c:forEach>  			
         </tr>
      <tr>
         <td colspan="8"><div class="pagelist"><a href="FilesAllServlet?flag=8&page=1">首页</a> <a href="FilesAllServlet?flag=8&page=${page-1}">上一页</a> <a href="FilesAllServlet?flag=8&page=${page+1}">下一页</a><a href="FilesAllServlet?flag=8&page=${totalPage}">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">



//根据档案存放位置进行搜索
function changesearch2(){	
	var position =  $("#positionId").val();
	location.href  = "FilesAllServlet?flag=7&position="+position;
	
}


//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		 location.href = "FilesAllServlet?flag=4&id="+id;
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
</body>
</html>