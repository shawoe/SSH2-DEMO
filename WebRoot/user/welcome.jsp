<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>��¼�ɹ�</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<a href="upload.jsp">�ϴ�ͷ��</a><br/>
	<a href="showUser">�鿴�û�����</a><br/>
	<a href="command.jsp">�޸�����</a><br/>
	<a href="../sms/readFirstSMS">�鿴����</a><br/>
	<a href="../sms/readFirstLogger">�鿴��־</a><br/>
	<a href="../sms/write.jsp">д�¶���</a><br/>
	<a href="showAllUsers">�鿴�����û�</a><br/>	
	<s:include value="../nav/footer.jsp" /> 
  </body>
</html>
