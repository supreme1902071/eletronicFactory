<%@ page language="java" contentType="text/html; charset=utf-8"
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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加员工</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="StaffServlet?flag=2">  
    
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="staffName"value="" data-validate="required:请输入姓名" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>出生日期：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="birthday"value="" data-validate="required:请输入出生日期" />
          <div class="tips"></div>
        </div>
      </div>
       
   
   
    <div class="form-group">
        <div class="label">
          <label>民族：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="nation" value="" data-validate="required:请输入民族"/>
          <div class="tips"></div>
        </div>
      </div>
     
     
     
     <div class="form-group">
        <div class="label">
          <label>身份证号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="idCard" value="" data-validate="required:请输入身份证号"/>
          <div class="tips"></div>
        </div>
      </div>
      
      
       <div class="form-group">
        <div class="label">
          <label>户籍：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="domicile" value="" data-validate="required:请输入户籍"/>
          <div class="tips"></div>
        </div>
      </div>
      
        <div class="form-group">
        <div class="label">
          <label>部门：</label>
        </div>
        <div class="field">
          <!-- <input type="text" class="input w50" name="apartmentName" value="" data-validate="required:请输入部门" /> -->
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
          <label>档案类别：</label>
        </div>
        <div class="field">
          <!-- <input type="text" class="input w50" name="fileType" value="" data-validate="required:请输入档案类别" /> -->
          <select class="input w50" value="" name="fileType">
          
            <c:forEach  items="${fileTypes}" var="filetype" >
               <option value="${filetype.fileType}" >${filetype.fileType}</option>
             </c:forEach>
             
             
             
          </select> 
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <div class="button-group radio">
          
          <label class="button active">
         	  <span class="icon icon-check"></span>             
              <input name="sex" value="男" type="radio" checked="checked">男           
          </label>             
        
          <label class="button active">
              <span class="icon icon-check"></span>             
              <input name="sex" value="女" type="radio" >女  
          </label>  
                 
           </div>       
        </div>
     </div>
      
     
     
     
     
 

        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
      
      
    </form>
  </div>
</div>

</body></html>