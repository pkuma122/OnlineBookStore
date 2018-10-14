<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/indexstyle.css">
</head>
  <body>
   <form action="changePassword.jlc">
   <center>
    <table class="textStyle">
     <tr bgcolor="orange">
     <td align="center" colspan="7"><font size="5"><b>Change User Password</b></font></td>
     </tr>
     <tr bgcolor="lightyellow">
     <td align="center" colspan="3"><font size="4" color="red"><b><jlc:error property="changePasswordError"/> </b></font></td>
     </tr>
     <tr><td><br/></td></tr>
     <core:if test="${CHANGED_PASSWORD ne 'OK'}">
     <tr>
      <td align="center" height=""><font size="5"><b>Current Password</b></font></td>
      <td><input type="password" name="currpass" size="35" style="color: black;background-color: #b4e0d2; font-size: 20"/> </td>
      <td><font size="4" color="red"><b><jlc:error property="currpass"/></b></font></td>
      </tr>
      <tr>
      <td><font size="5"><b>New Password</b></font></td>
      <td><input type="password" name="newpass" size="35" style="color: black;background-color: #b4e0d2; font-size: 20"/> </td>
      <td><font size="4" color="red"><b><jlc:error property="newpass"/></b></font></td>
      </tr>
      <tr>
      <td align="center"><font size="5"><b>Confirm Password</b></font></td>
      <td><input type="password" name="confpass" size="35" style="color: black;background-color: #b4e0d2; font-size: 20"/> </td>
      <td><font size="4" color="red"><b><jlc:error property="confpass"/></b></font></td>
      </tr>
      <tr>
      <td align="center" colspan="3"><br/>
      <input type="submit" value="Change Pasword" style="color: white;background-color: maroon;font-size: 17"/></td>
      </tr> 
     </core:if>     
    </table>
   </center>
   </form>
  </body>
</html>
