<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>��ʾ��־</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>������</th><th>ʱ��</th><th>�����ɹ�</th><th>������Ϣ</th></tr>
	<s:iterator value="#request.allLogger" id="everyLogger">
	<tr><td><s:property value="#everyLogger.loggerID"/></td>
		<td><s:property value="#everyLogger.loggerUser"/></td>
		<td><s:property value="#everyLogger.loggerTime"/></td>
		<td><s:property value="#everyLogger.loggerSuccess"/></td>
		<td><s:property value="#everyLogger.loggerError"/></td>
	</tr>
	<tr><td colspan="5"><s:property value="#everyLogger.loggerAction"/></td></tr>
	</s:iterator>		
	</table>
	<a href="readFirstLogger">��ҳ</a>
	<a href="readLastLogger">��һҳ</a>
	<a href="readNextLogger">��һҳ</a>
	<a href="readEndLogger">���һҳ</a>
	<s:form action="../logger/readLogger" method="get">
		<s:textfield name="loggerPageNow" label="��ǰҳ" />
		<s:textfield name="loggerPageCount" label="��ҳ��" />
		<s:textfield name="loggerPageSize" label="��ʾ��" />
		<s:submit value="����" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
