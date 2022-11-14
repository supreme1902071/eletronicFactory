<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>上传文件</strong></div>
  <div class="body-content">

<form name="fromupload" method="post" action="UploadServlet" enctype="multipart/form-data" class="form-x">
	<!-- <div class="form-group">
        <div class="label">
          <label>选择一个文件：</label>
        </div>
        <div class="field">
          <input type="file" class="input w50" value="" name="uploadFile" />
          <div class="tips"></div>
        </div>
    </div> -->
    
    <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="text" id="img1" name="img1" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="button1" value="+ 浏览上传"  style="float:left;"  onclick="searchFile()">
          <input type="file" class="button bg-blue margin-left" value="" name="uploadFile" id="uploadFile" style="display:none"/>
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>  
    
	<div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" value="上传"></button>
        </div>
     </div>
     <div class="form-group"><b>${message}</b></div>

</form>
 </div>
</div>
</body>
<script>
function searchFile(){
	$("#uploadFile").click();
	
	$("#uploadFile").change(function(e){
		var file=e.target.files[0];
		$("#img1").val(file.name);
		console.log(file.name);
		console.log(e);
		
	});
	
	/* $("#fileupload").change(function(e){
		 var file = e.target.files[0];		//e.target.files[0];得到的是第一张input选择的图片的一些参数  
		  $("#img1").val(file.name);
		  console.log(file.name);
		  console.log(e);
	 }	 
	 );  */
	
}


</script>
</html>