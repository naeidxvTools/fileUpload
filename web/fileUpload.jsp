<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="fileUploadResult.jsp" method="post" enctype="multipart/form-data">--%>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
    username: <input type="text" name="username"/> <br>
    file: <input type="file" name="file"/> <br>
    <input type="submit" value="submit"/>
</form>


</body>
</html>
