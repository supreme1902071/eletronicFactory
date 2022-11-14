<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加档案借阅</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="LendServlet?flag=2">   
   <!--  <input type="hidden" name="flag" value="2"/>   --> 
      <div class="form-group">
        <div class="label">
          <label>档案编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="number" data-validate="required:请输入老师姓名" />
          <div class="tips"></div>
        </div>
      </div>
       
   
   
    <div class="form-group">
        <div class="label">
          <label>年度：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="year" data-validate="required:请输入老师年度" />
          <div class="tips"></div>
        </div>
      </div>
   
     <div class="form-group">
        <div class="label">
          <label>档案名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="fileName" data-validate="required:请输入档案名称" />
          <div class="tips"></div>
        </div>
      </div>
      
     
      <div class="form-group">
        <div class="label">
          <label>所属部门：</label>
        </div>
        <div class="field">
          <!-- <input type="text" class="input w50" value="" name="apartmentName" data-validate="required:请输入所属部门" /> -->
         
           <select class="input w50" value="" name="apartmentName">
          
            <c:forEach  items="${apartments}" var="apartment" >
               <option value="${apartment.apartmentName}" >${apartment.apartmentName}</option>
             </c:forEach>
             
             
             
          </select> 
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
       <div class="label">
          <label>借阅人：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="lender" data-validate="required:请输入借阅人" />
          <div class="tips"></div>
        </div>
      </div>

        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
    
      
      
    </form>
  </div>
</div>
</body></html>