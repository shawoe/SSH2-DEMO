<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>页眉</title>
</head>
<body>
	<s:if test="%{#session.currentUser == null}">
		您还未登录：<br/>
    	<a href="../user/login.jsp">现在登录</a><br/>
    	<a href="../user/register.jsp">立即注册</a><br/>
	</s:if>
	<s:else>	
		<img src="../avatar/admin.jpg"><br/>
		<s:property value="#session.currentUser" />，欢迎光临<br/>
    	<a href="../user/welcome.jsp">进入主页</a><br/>
  		<a href="logoutUser">退出登录</a><br/>
	</s:else>
	<hr/>
</body>
</html>
