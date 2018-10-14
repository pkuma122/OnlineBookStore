<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
  </head>
  <body>
  <center>
  <table class="textStyle">
  <tr>
  <jstl:if test="${USER_TO.role eq 'Admin'}">
  <td align="center" colspan="3"><font size="7"><b></b>Admin Home</font></td>
  </jstl:if>
  <jstl:if test="${USER_TO.role ne 'Admin'}">
  <td align="center" colspan="3"><font size="7"><b></b>User Home</font></td>
  </jstl:if>
  </tr>
  </table> 
  </center>
  </body>
</html>
