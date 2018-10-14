<%@taglib prefix="jlc" uri="http://jlcindia.com/tags"%>
<html>
  <head>
    <title>JLC Online Book Shop</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/indexstyle.css">
   </head>
  <body bgcolor="lightgray">
  <jlc:validateSession/>
    <table width="90%" align="center" height="97%">
    <tr height="5px" valign="top">
    <td align="center">
    <jsp:include page="/WEB-INF/pages/header.jsp"/></td>
    </tr>
    <tr valign="top" bgcolor="maroon" height="3px">
    <td align="center">
    <jsp:include page="/WEB-INF/pages/userMenu.jsp"/></td>
    </tr>
    <tr valign="top">
    <td align="center">
    <jsp:include page="/WEB-INF/pages/searchBook.jsp"/></td>
    </tr>
    <tr valign="bottom" height="2px">
    <td align="center">
    <jsp:include page="/WEB-INF/pages/footer.html"/></td>
    </tr>
    </table>
  </body>
</html>
