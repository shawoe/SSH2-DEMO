<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�û���¼</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<s:if test="%{#session.currentUser == null}">
		<h2>�û���¼</h2>
		<s:form action="loginUser" method="get">
			<s:textfield name="userName" label="�û���" />
			<s:password name="userPassword" label="����" />
			<s:submit value="��½" />
			<s:reset value="����" />
			<!-- ��ֹ���ظ��ύ -->
			<s:token />
		</s:form>
	</s:if>
	<s:else>
		<h2>���ѵ�¼�������ظ���¼</h2>
		���ѵ�¼�������ظ���¼<br/>
	</s:else>
	<s:include value="../nav/footer.jsp" />
</body>

</html>
