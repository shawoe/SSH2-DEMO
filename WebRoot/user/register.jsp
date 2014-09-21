<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>用户注册</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />	
	<s:if test="%{#session.currentUser == null}">
		<h2>用户注册</h2>
		<s:form action="registerUser" method="get">
			<s:textfield name="userName" label="用户名" />
			<s:password name="userPassword" label="密码" />
			<s:password name="passwordConfirm" label="确认密码" />
			<s:radio name="userSex" list='#{"man":"男", "woman":"女"}' label="性别" />	
			<s:textfield name="userBirth" label="生日"/>	
			<s:textfield name="userEmail" label="邮箱" />
			<s:submit value="注册" />
			<s:reset value="重置" />
			<!-- 防止表单重复提交 -->
			<s:token />
		</s:form>
	</s:if>
	<s:else>
		<h2>您已登录，请勿重复注册</h2>
		您已登录，请勿重复注册<br/>
	</s:else>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

