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
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改档案表</strong></div>
  <div class="body-content">
  
    <form method="post" class="form-x" action="FilesAllServlet?flag=3">  
        <input type="hidden" name="id" value="${filesVo.id }"/>
    	<!-- <input type="hidden" name="flag" value="3"/> -->
    
    
      <div class="form-group">
        <div class="label">
          <label>年度：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${filesVo.year }" name="year" data-validate="required:请输入年度" />
          <div class="tips"></div>
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label>档案编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${filesVo.number }" name="number" data-validate="required:请输入档案编号" />
          <div class="tips"></div>
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label>名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${filesVo.fileName}" name="fileName" data-validate="required:请输入名称" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>登记人：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${filesVo.register}" name="register" data-validate="required:请输入登记人" />
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>档案存放位置：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${filesVo.position}" name="position" data-validate="required:请输入档案存放位置" />
          <div class="tips"></div>
        </div>
      </div>
    
    <div class="form-group">
        <div class="label">
          <label>所属部门：</label>
        </div>
        <div class="field">
          <%-- <input type="text" class="input w50" value="${filesVo.apartmentName}" name="apartmentName" data-validate="required:请输入所属部门" /> --%>
         <select class="input w50" value="${filesVo.apartmentName}" name="apartmentName">
          
            <c:forEach  items="${apartments}" var="apartment" >
               <option value="${apartment.apartmentName}" >${apartment.apartmentName}</option>
             </c:forEach>
             
             
             
          </select> 
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>档案类别：</label>
        </div>
        <div class="field">
         <%--  <input type="text" class="input w50" value="${filesVo.filetypeName}" name="filetypeName" data-validate="required:请输入档案类别" /> --%>
         <select class="input w50" value="${filesVo.filetypeName}" name="filetypeName">
          
            <c:forEach  items="${fileTypes}" var="filetype" >
               <option value="${filetype.fileType}" >${filetype.fileType}</option>
             </c:forEach>
             
             
             
          </select> 
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>保密等级：</label>
        </div>
        <div class="field">
          <%-- <input type="text" class="input w50" value="${filesVo.securitylevelName}" name="securitylevelName" data-validate="required:请输入保密等级" /> --%>
          <select class="input w50" value="${filesVo.securitylevelName}" name="securitylevelName">
          
            <c:forEach  items="${securityLevels}" var="securitylevel" >
               <option value="${securitylevel.securityLevel}" >${securitylevel.securityLevel}</option>
             </c:forEach>
             
             
             
          </select>
          <div class="tips"></div>
        </div>
      </div>
      
  
      
       <div class="form-group">
        <div class="label">
          <label>保管人：</label>
        </div>
        <div class="field">
        <%--   <input type="text" class="input w50" value="${filesVo.keeperName}" name="keeperName" data-validate="required:请输入保管人" /> --%>
          
          <select class="input w50" value="${filesVo.keeperName}" name="keeperName">
          
            <c:forEach  items="${keepers}" var="keeper" >
               <option value="${keeper.keeperName}" >${keeper.keeperName}</option>
             </c:forEach>
             
             
             
          </select>
           <div class="tips"></div>
        </div>
      </div>
  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交修改</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>