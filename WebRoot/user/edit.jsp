<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�޸��û�����</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<h2>�޸��û�����</h2>
	<s:form action="../user/editUser" method="get">
		<s:textfield name="userName" label="�û���" />
		<s:password name="userPassword" label="����" />
		<s:radio name="userSex" list="#{'man':'��', 'woman':'Ů'}" label="�Ա�" />	
		<s:textfield name="userBirth" label="����"/>	
		<s:textfield name="userEmail" label="����" />
		<s:submit value="�޸�" />
		<!-- ��ֹ���ظ��ύ -->		
		<s:token />
	</s:form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

