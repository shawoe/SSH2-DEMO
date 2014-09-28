<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>修改用户资料</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>修改用户资料</h2>
	<s:form action="../user/editUser" method="get">
		<s:textfield name="userName" label="用户名" />
		<s:password name="userPassword" label="密码" />
		<s:radio name="userSex" list="#{'man':'男', 'woman':'女'}" label="性别" />	
		<s:textfield name="userBirth" label="生日"/>	
		<s:textfield name="userEmail" label="邮箱" />
		<s:submit value="修改" />
		<!-- 防止表单重复提交 -->		
		<s:token />
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

