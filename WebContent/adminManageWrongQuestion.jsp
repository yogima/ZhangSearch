<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
							<li><a href="adminManageWrongQuestion.jsp" style="font-size:20px">用户反馈</a></li>
							<li><a href="adminManageUser.jsp" style="font-size:20px">用户管理</a></li>
							<li><a href="adminHome.jsp" style="font-size:20px">返回首页</a></li>
							<li><a href="login.jsp" style="font-size:20px">退出登录</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
<form action="adminSuccess.jsp" method="post" enctype="multipart/form-data">
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
			<h2 class="title-agile text-center" style="font-size:20px;margin-top:15px;color:#696969">题目：<textarea rows="10" name="question" style="width:500px;height:200px;font-size:18px;margin-top:15px;color:#000000" readonly="readonly">udp双向通信的问题假如我要使用udp通信，则必须建立两个“通道”;而tcp只需要建立一个“通道</textarea></h2><br>
			<h2 class="title-agile text-center" style="font-size:20px;margin-top:15px;color:#696969">错误答案：<textarea rows="10" name="question" style="width:500px;height:200px;font-size:18px;margin-top:15px;color:#000000">首先，UDP和TCP均指通信协议，那么，既然代表通信协议，UDP和TCP都是建立一个“通道”就可以进行服务端/客户端间的数据收发。 它们的区别主要在于： UDP协议是面向非连接（不可靠）的传输协议，也就是不需要与服务端建立连接，就直接将数据发送给服务端，同时，无机制保证这条数据已成功发送给服务端。 TCP协议是面向连接（可靠）的传输协议，在客户端向服务器端传输数据之前，客户端必须与服务器端通过“三次握手”来完成连接的建立，在之后的数据传输过程中，为了可靠传输，接受方还会发送ACK包来使发送方获知该数据包已经成功发送，否则，发送端将重新发送数据包直至超时或发送成功。 因此，无论UDP协议还是TCP协议，均要有一个服务端先行监听某端口才能服务。 例如：服务端监听9090端口，客户端使用3456（随机分配）端口，与服务器建立连接，那么通道只有一条，即：A:9090</textarea></h2><br>
			<input type="submit" value="修改" id="submit" class="buttom" style="margin-top:20px;">
		</center>
		</div>	
	</div>
</form>
</body>
</html>