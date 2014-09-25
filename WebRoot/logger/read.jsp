<%@page contentType="text/html;charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>显示日志</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
	<table border="2px">
	<tr><th>ID</th><th>操作人</th><th>时间</th><th>操作成功</th><th>错误信息</th></tr>
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
	<a href="readFirstLogger">首页</a>
	<a href="readLastLogger">上一页</a>
	<a href="readNextLogger">下一页</a>
	<a href="readEndLogger">最后一页</a>
	<s:form action="../logger/readLogger" method="get">
		<s:textfield name="loggerPageNow" label="当前页" />
		<s:textfield name="loggerPageCount" label="总页数" />
		<s:textfield name="loggerPageSize" label="显示量" />
		<s:submit value="跳至" />
	</s:form>	
	<s:include value="../nav/footer.jsp" /> 
 </body>
</html>
