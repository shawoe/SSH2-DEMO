<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>д��Ϣ</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>д��Ϣ</h2>
	<%--д��Ϣ��,�ύ��write.action--%>
	<s:form action="sendSms" method="get">
		<s:textfield name="smsReader" label="�ռ���" />
		<s:textfield name="smsContent" label="��Ϣ����" />
		<s:submit value="����" />
		<s:reset value="����" />
		<s:token /><!-- ��ֹ���ظ��ύ -->
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

