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
    <div class="panel-head"><strong class="icon-reorder"> 员工列表</strong> <a href="" style="float:right; display:none;">添加员工</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="StaffServlet?flag=9"> 添加员工</a> </li>
       
        <li >
 
          
          <input type="text" placeholder="请输入搜索名字" id="staffNameId" name="staffName" class="input" style="width:250px; line-height:17px;display:inline-block" />
            <a href="javascript:void(0)" onclick="changesearch()" class="button border-main icon-search">搜索</a>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th>选择</th>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="10%">姓名</th>
          <th>性别</th>
        
        <th>生日</th>
        <th>民族</th>
        <th>身份证号</th>
        <th>户籍</th>
        <th>所属部门</th>
        <th>档案类别</th>
      
      
       <!--  <th width="10%">更新时间</th> -->
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
          <c:forEach items="${staffs}" var="staff" varStatus="status">
		<tr <c:if test="${status.index %2 == 0}"> 
		
		  style="background-color:#b5cfd9;"</c:if>>
		    
		    <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
            <td>${staff.id}</td>
			<td>${staff.staffName}</td>
			
			<td>
			<c:if test="${ staff.sex==true}">
			男</c:if>
				<c:if test="${staff.sex==false}">
			女</c:if>
			</td>
			<td>${staff.birthday}</td>
			<td>${staff.nation}</td>
			<td>${staff.idCard}</td>
			<td>${staff.domicile}</td>
			<td>${staff.apartmentName}</td>
			<td>${staff.fileType}</td>
	
            <td><div class="button-group"> <a class="button border-main" href="StaffServlet?flag=7&id=${staff.id}"><span class="icon-edit"></span> 修改</a>
             <a class="button border-red" href="javascript:void(0)" onclick="return del(${staff.id})"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
	</c:forEach>
        
      <tr>
        <td colspan="8">
	        <div class="pagelist"> 
	        	<a href="StaffServlet?flag=6&page=1">首页</a> <a href="StaffServlet?flag=6&page=${page-1}">上一页</a> <a href="StaffServlet?flag=6&page=${page+1}">下一页</a><a href="StaffServlet?flag=6&page=${totalPage}">尾页</a> </div></td>
	       	</div>
        </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">
function changesearch(){
   
    var staffName=$("#staffNameId").val();
    location.href="StaffServlet?flag=5&staffName="+staffName;
}

<%--function searchbyageisparty(){
	 var searchage=$("#searchage").val();
	 var searchisparty=$("#searchisparty").val();
	/*  console.log(searchage);
	 console.log(searchisparty); */
	 location.href="TeacherListServlet?flag=2&age="+searchage+"&isparty="+searchisparty;
	// console.log("TeacherListServlet?flag=2&age="+searchage+"&isparty="+searchisparty);
}--%>

<%--function changesearch(){
 
    var age=$("#ageId").val();
    location.href="TeacherListServlet?flag=6&age="+age;
}--%>



//单个删除
function del(id){
	if(confirm("您确定要删除吗?")){
		location.href="StaffServlet?flag=4&id="+id;
	}
}

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