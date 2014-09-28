<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>轻量级Java EE：企业级开发示范</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Shawoe">
	<meta name="description" content="A demonstration of what can be accomplished through Java EE.">
	<meta name="robots" content="all">
</head>
<body id="home-page">	
	<div class="primary">
	<s:if test="%{#session.currentUser == null}">
		<p>您还未登录：</p>
    	<a href="user/login.jsp">现在登录</a>
    	<a href="user/register.jsp">立即注册</a>
	</s:if>
	<s:else>
		<img src="avatars/admin.jpg">
		<p><s:property value="#session.currentUser" />，欢迎光临</p>
    	<a href="user/welcome.jsp">点击出处进入主页</a>
  		<a href="logoutUser">退出登录</a>
  	</s:else>
	</div>
	
	<div class="secondary">
		<p>当前在线用户： </p>
		<s:property value="#session.onlineUser"/>
	</div>
	
</body>
</html>
