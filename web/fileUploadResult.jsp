<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result</h1>
<%
    request.setCharacterEncoding("utf-8");
%>
<%--<%=request.getParameter("username")%> <br>--%>
<%--<%=request.getParameter("file")%> <br>--%>
<%--<%--%>
<%--    InputStream is = request.getInputStream();--%>
<%--    BufferedReader br = new BufferedReader(new InputStreamReader(is));--%>
<%--    String buffer = null;--%>
<%--    while (null != (buffer = br.readLine()))--%>
<%--    {--%>
<%--        out.print(buffer + "<br>");--%>
<%--    }--%>
<%--    br.close();--%>
<%--    is.close();--%>
<%--%>--%>

username------>: ${requestScope.username} <br>
file----->: ${requestScope.file} <br>

</body>
</html>
