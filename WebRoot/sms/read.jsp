<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>��ʾ��Ϣ</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>�û�</th><th>������</th><th>ʱ��</th><th>�Ѷ�</th></tr>
	<s:iterator value="#request.allSMS" id="everySMS">
	<tr><td><s:property value="#everySMS.smsID"/></td>
		<td><s:property value="#everySMS.smsUserName"/></td>
		<td><s:property value="#everySMS.smsSender"/></td>
		<td><s:property value="#everySMS.smsSendTime"/></td>
		<td><s:property value="#everySMS.smsIsRead"/></td>
	</tr>
	<tr><td colspan="5"><s:property value="#everySMS.smsContent"/></td></tr>
	</s:iterator>		
	</table>
	<a href="readFirstSMS">��ҳ</a>
	<a href="readLastSMS">��һҳ</a>
	<a href="readNextSMS">��һҳ</a>
	<a href="readEndSMS">���һҳ</a>
	<s:form action="../sms/readSMS" method="get">
		<s:textfield name="smsPageNow" label="��ǰҳ" />
		<s:textfield name="smsPageCount" label="��ҳ��" />
		<s:textfield name="smsPageSize" label="��ʾ��" />
		<s:submit value="����" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
