<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�û�ע��</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />	
	<s:if test="%{#session.currentUser == null}">
		<h2>�û�ע��</h2>
		<s:form action="registerUser" method="get">
			<s:textfield name="userName" label="�û���" />
			<s:password name="userPassword" label="����" />
			<s:password name="passwordConfirm" label="ȷ������" />
			<s:radio name="userSex" list='#{"man":"��", "woman":"Ů"}' label="�Ա�" />	
			<s:textfield name="userBirth" label="����"/>	
			<s:textfield name="userEmail" label="����" />
			<s:submit value="ע��" />
			<s:reset value="����" />
			<!-- ��ֹ���ظ��ύ -->
			<s:token />
		</s:form>
	</s:if>
	<s:else>
		<h2>���ѵ�¼�������ظ�ע��</h2>
		���ѵ�¼�������ظ�ע��<br/>
	</s:else>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

