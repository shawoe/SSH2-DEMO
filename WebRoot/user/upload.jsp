<%@ page contentType="text/html;charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�ϴ�ͷ��</title>
</head>
<body>
	<s:include value="../nav/header.jsp" />
  	��ǰͷ��<br/>
	<img src="../avatars/admin.jpg"><br/>
	<form action="uploadAvatars" enctype="multipart/form-data" method="post">
          �ϴ�ͷ��:<input type="file" name="avatarsImage" />
    	<input type="submit" value="����ͷ��" />
			<!-- ��ֹ���ظ��ύ -->
			<s:token />
	</form>
	<s:include value="../nav/footer.jsp" /> 
</body>
</html>

