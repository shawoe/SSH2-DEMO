<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>写信息</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>写信息</h2>
	<%--写信息表单,提交到write.action--%>
	<s:form action="sendSms" method="get">
		<s:textfield name="smsReader" label="收件人" />
		<s:textfield name="smsContent" label="信息内容" />
		<s:submit value="发送" />
		<s:reset value="重置" />
		<s:token /><!-- 防止表单重复提交 -->
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

