<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�޸�����</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>�޸�����</h2>
	<s:form action="changeUserPassword" method="get">
		<s:password name="oldUserPassword" label="ԭ����" />
		<s:password name="newUserPassword" label="����" />
		<s:password name="passwordConfirm" label="ȷ������" />
		<s:submit value="�޸�" />
		<s:token /><!-- ��ֹ���ظ��ύ -->
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

