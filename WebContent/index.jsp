<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head> 
    <title>JLC Online Book Shop</title>
  </head>
  <body bgcolor="lightyellow">
    <table width="90%" align="center" height="97%">
    <tr height="5px" valign="top">
     <td align="center"><jsp:include page="/WEB-INF/pages/header.jsp"/></td>
    </tr>
    <tr valign="middle">
     <td align="center"><jsp:include page="/WEB-INF/pages/login.jsp"/></td>
    </tr>
   <tr height="2px" valign="bottom">
     <td align="center"><jsp:include page="/WEB-INF/pages/footer.html"/></td>
   </tr>
    </table>
  </body>
</html>
