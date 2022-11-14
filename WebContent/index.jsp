<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>档案管理系统</title>
    <meta name="keywords" content="简单,实用,网站后台,后台管理,管理系统,网站模板" />
    <meta name="description" content="简单实用网站后台管理系统网站模板下载。" /> 
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">


<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />档案管理系统</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="index.jsp" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
 <!--  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="info.html" target="right"><span class="icon-caret-right"></span>网站设置</a></li>
    <li><a href="pass.html" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    <li><a href="page.html" target="right"><span class="icon-caret-right"></span>单页管理</a></li>     
    <li><a href="column.html" target="right"><span class="icon-caret-right"></span>栏目管理</a></li>
  </ul> -->   
  <h2><span class="icon-pencil-square-o"></span>档案管理</h2>
  <ul>
    <li><a href="servlet/FilesAllServlet?flag=8&page=1" target="right"><span class="icon-caret-right">档案信息</span></a></li>
        
  </ul> 
  
  <h2><span class="icon-pencil-square-o"></span>员工管理</h2>
  <ul><li><a href="servlet/StaffServlet?flag=6&page=1" target="right"><span class="icon-caret-right">员工信息</span></a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>借阅管理</h2> 
    <ul>
    <li><a href="servlet/LendServlet?flag=7&page=1" target="right"><span class="icon-caret-right"></span>档案借阅</a></li>
    </ul>
  <h2><span class="icon-pencil-square-o"></span>部门管理</h2>
    <ul>
     <li><a href="servlet/ApartmentServlet?flag=1" target="right"><span class="icon-caret-right"></span>部门查看</a></li>
    </ul>
  <!-- <h2><span class="icon-pencil-square-o"></span>班级管理</h2> 
    <ul style="display:block">
      <li><a href="servlet/ClassRoomAllServlet?flag=4" target="right"><span class="icon-caret-right"></span>查询所有教室</a></li>
       <li><a href="servlet/TeacherAllServlet?flag=9&page=1" target="right"><span class="icon-caret-right"></span>老师班级管理多表</a></li>
    <li><a href="servlet/ClassRoomAllServlet?flag=7&page=1" target="right"><span class="icon-caret-right"></span>班级管理</a></li>
    </ul> -->
    <h2><span class="icon-pencil-square-o"></span>日志管理</h2>
    <ul>
      <li><a href="servlet/VisitServlet?flag=1" target="right"><span class="icon-caret-right"></span>查看访问记录</a></li> 
    </ul>
    <h2><span class="icon-pencil-square-o"></span>文件上传</h2>
    <ul>
       <li><a href="servlet/UploadListServlet?flag=1" target="right"><span class="icon-caret-right"></span>查看上传</a></li>  
    </ul>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
 <ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  <!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> --> 
  </li>
</ul> 
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>