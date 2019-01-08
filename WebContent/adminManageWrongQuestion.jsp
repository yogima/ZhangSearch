<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>欢迎您，管理员</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="Border sign in Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
	<style>    
		.buttom
		{
			width:80px;
			height:35px;
			color:#000000;
			font-family:微软雅黑;
		}
		.buttom:hover 
		{
    		background: #606060;
		}
		.img-area
		{
			width:80px;
			height:auto;
			position:relative;
		}
		.img-area img
		{
			width:100%;
			height:100%;
		}
		.img-area input
		{
			position:absolute;
			left:0;
			top:0;
			width:100%;
			height:100%;
			opacity:0;
		}
	</style>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style2.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="all">
    <link rel="stylesheet" href="css/header.css" type="text/css" media="all">
	<link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Pacifico&amp;subset=cyrillic,latin-ext,vietnamese" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Amaranth:400,400i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
	<div class="header-w3l">
		<!-- navigation -->
		<div class="nav-agile">
			<nav class="navbar navbar-default">
			<div class="navbar-header logo-w3layouts">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- logo -->
					<h1>
						<a href="homePageUser.jsp">老張搜题</a>
					</h1>
					<!-- //logo -->
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<div class="w3l-navtop">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="adminHome.jsp" style="font-size:20px">返回首页</a></li>
							<li><a href="login.jsp" style="font-size:20px">退出登录</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<form action="UpdateFeedback" method="post" enctype="multipart/form-data">
	<!-- <div>
		<center>
			<input type="text" name="question" style="width:400px;height:35px;font-size:28px;">
			<input type="submit" value="搜索" id="submit" class="buttom">
		</center>
	</div> -->
	<div class="content-w3ls">			
		<div class="wthree-field">
		<center>
			<h2 class="title-agile text-center">以下是用户反馈的错题</h2>
			<h2 class="title-agile text-center" style="font-size:20px;margin-top:15px;color:#696969">题目：<textarea rows="10" name="question.question" style="width:500px;height:200px;font-size:18px;margin-top:15px;color:#000000" readonly="readonly">${ques.getQuestion() }</textarea></h2><br>
			<h2 class="title-agile text-center" style="font-size:20px;margin-top:15px;color:#696969">错误答案：<textarea rows="10" name="question.answer" style="width:500px;height:200px;font-size:18px;margin-top:15px;color:#000000">${ques.getAnswer() }</textarea></h2><br>
			<input type="hidden" value="${ques.getQuestionId()}"  name="question.questionId">
			<input type="submit" value="修改" id="submit" class="buttom" style="margin-top:20px;">
		</center>
		</div>	
	</div>
	</form>
</body>
</html>