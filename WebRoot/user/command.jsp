<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>修改密码</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>修改密码</h2>
	<s:form action="changeUserPassword" method="get">
		<s:password name="oldUserPassword" label="原密码" />
		<s:password name="newUserPassword" label="密码" />
		<s:password name="passwordConfirm" label="确认密码" />
		<s:submit value="修改" />
		<s:token /><!-- 防止表单重复提交 -->
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

