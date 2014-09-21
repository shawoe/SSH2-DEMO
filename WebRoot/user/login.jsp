<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>用户登录</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<s:if test="%{#session.currentUser == null}">
		<h2>用户登录</h2>
		<s:form action="loginUser" method="get">
			<s:textfield name="userName" label="用户名" />
			<s:password name="userPassword" label="密码" />
			<s:submit value="登陆" />
			<s:reset value="重置" />
			<!-- 防止表单重复提交 -->
			<s:token />
		</s:form>
	</s:if>
	<s:else>
		<h2>您已登录，请勿重复登录</h2>
		您已登录，请勿重复登录<br/>
	</s:else>
	<s:include value="../nav/footer.jsp" />
</body>

</html>
