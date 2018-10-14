<%@page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
  </head>
  <body bgcolor="#eeeeee">
    <center>
    <form action="register.jlc" method="post">
    <table class="textStyle">
      <tr>
        <td align="center" colspan="3">
         <font size="7"><b>Register New User</b></font>
        </td>
      </tr>
      <tr>
      <td align="center" colspan="3"><font size="4" color="red"><b> <jlc:error property="registrationError"/> </b></font>
       </td>
      </tr>
      <jstl:if test="${REGISTERED ne 'OK'}">
      <tr>
      <td><font size="5"><b>First Name</b></font></td>
      <td><input type="text" name="fname" id="fname" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="fname"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Middle Name</b></font></td>
      <td><input type="text" name="mname" id="mname" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="mname"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Last Name</b></font></td>
      <td><input type="text" name="lname" id="lname" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="lname"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Email</b></font></td>
      <td><input type="text" name="email" id="email" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="email"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Phone</b></font></td>
      <td><input type="text" name="phone" id="phone" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="phone"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Gender</b></font></td>
      <td><input type="radio" value="Male" name="gender"><font size="5"><b>Male</b></font> 
           <input type="radio" value="Female" name="gender"><font size="5"><b>Female</b></font></td>
      <td><b><font size="4" color="red"><jlc:error property="gender"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Username</b></font></td>
      <td><input type="text" name="uname" id="uname" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="uname"/></font></b></td>
      </tr>
      <tr>
      <td><font size="5"><b>Password</b></font></td>
      <td><input type="password" name="pass" id="pass" style="color: black;background-color: #b4e0d2; font-size: 25"/> </td>
      <td><b><font size="4" color="red"><jlc:error property="pass"/></font></b></td>
      </tr>
      <tr>
      <td align="center" colspan="3"><br/>
      <input type="submit" value="Register Me" style="color: white;background-color: maroon;font-size: 17"/></td>
      </tr>
      </jstl:if>
      <tr>
      <td align="center" colspan="3">
      <b><font size="5">Login</font>&nbsp;<a href="index.jsp"><font size="5">Click Here</font></a></b>
      </td>
      </tr>
           
     </table>
    </form>
    </center>
  </body>
</html>
