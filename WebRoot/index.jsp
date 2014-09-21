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

	<header>
		<p>header</p>
	</header>
	
	<nav>
		<p>nav</p>
	</nav>
	
	<div class="primary">
	<s:if test="%{#session.currentUser == null}">
		<ul><p>您还未登录：</p>
    		<li><a href="user/login.jsp">现在登录</a></li>
    		<li><a href="user/register.jsp">立即注册</a></li>
    	</ul>
	</s:if>
	<s:else>
		<ul>
			<spen><img src="avatars/admin.jpg"></spen>
			<spen><s:property value="#session.currentUser" />，欢迎光临<spen>
    		<li><a href="user/welcome.jsp">点击出处进入主页</a></li>
  			<li><a href="logoutUser">退出登录</a></li>
  		</ul>
  	</s:else>
	</div>
	
	<div class="secondary">
		<p>secondary</p>
		<p>当前在线用户： </p>
		<s:property value="#session.onlineUser"/>
	</div>
	
	<footer>
		<p>footer</p>
	</footer>

</body>
</html>
