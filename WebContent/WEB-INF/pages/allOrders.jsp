<%@taglib prefix="jlc" uri="/WEB-INF/tlds/jlcindia.tld"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.jlc.book.shop.to.*" %>
<html>
  <head>
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jlcindia.css">
  </head>
  <body>
   <center><br/>
    <table align="center" width="80%" class="textStyle" cellspacing="0">
    <core:if test="${ORDER_FOUND eq null}">
     <tr bgcolor="orange">
      <td align="center"><font color="black" size="5"><b>Not Order Information Found</b></font></td>
     </tr>
    </core:if>
    <core:if test="${ORDER_FOUND ne null}">
     <tr bgcolor="orange">
      <td align="center" colspan="7"><font color="black" size="5"><b>Order Information </b></font></td>
     </tr>
     <tr bgcolor="black">
      <td align="center"><font size="4" color="yellow"><b>Order Id</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>Order Date</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>User Id</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>total Item</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>Total Amount</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>Status</b></font></td>
      <td align="center"><font size="4" color="yellow"><b>Update Status</b></font></td>
     </tr>
      <%int x=-1;     String color="#fdeaff";%>
      <core:forEach var="oto" items="${ORDER_FOUND}">
      <%
        x++;
        if(x==3)	x=0;
        if(x==0)	color="#fdeaff";
        else if(x==1)	color="#dee1fe";
        else if(x==2)	color="#e1ffde";
       %>
       <tr bgcolor="<%=color%>">
        <td align="center">
         <form action="showorderinfo.jlc" method="post">
          <input type="hidden" value="${oto.orderId}" name="orderId"/>
          <input type="hidden" value="allOrdersDef.jsp" name="page"/>
          <input type="submit" value="${oto.orderId}" class="tableButton"/>
         </form>
        </td>
        <td align="center">
         <font size="3"><b>${oto.orderDate}</b></font>
        </td>
        <td align="center">
         <form action="showuserinfo.jlc" method="post">
          <input type="hidden" value="${oto.userId}" name="userId"/>
          <input type="submit" value="${oto.userId}" class="tableButton"/>
         </form>
        </td>
        <td align="center">
         <font size="3"><b>${oto.totalItem}</b></font>
        </td>
        <td align="center">
         <font size="3" face="Rupee Foradian"></font><font size="3"><b>${oto.totalAmount}/-</b></font>
        </td>
        <td align="center">
         <font size="3"><b>${oto.status}</b></font>
        </td>
         <core:if test="${oto.status ne 'Delivered'}">
          <td align="center">
           <form action="updatestatus.jlc" method="post">
            <input type="hidden" value="${oto.orderId}" name="orderId"/>
            <input type="hidden" value="Delivered" name="status"/>
            <input type="submit" value="Delivered" class="tableButton"/>
           </form>
           <form action="updatestatus.jlc" method="post">
            <input type="hidden" value="${oto.orderId}" name="orderId"/>
            <input type="hidden" value="Not Delivered" name="status"/>
            <input type="submit" value="Not Delivered" class="tableButton"/>
           </form>
          </td>         
         </core:if>
       </tr>
      </core:forEach>    
    </core:if>
    </table><br/>
   <core:if test="${ORDER_TO ne null}">
   <table width="95%" class="textStyle" cellspacing="0">
   <tr bgcolor="maroon">
    <td align="center" colspan="7"><font color="yellow" size="4">
     <b>Information about the order with id <font color="white">${ORDER_TO.orderId}</font> </b></font>
    </td>
   </tr>
   <tr bgcolor="black">
    <td align="center" colspan="2"><font size="4" color="yellow"><b>Address</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Street</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>City</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>State</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>zip</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Order Date</b></font></td>
   </tr>
   <tr>
    <td align="center" colspan="2">
     <font size="3"><b>${ORDER_TO.address}</b></font>
    </td>
    <td align="center">
     <font size="3"><b>${ORDER_TO.street}</b></font>
    </td>
    <td align="center">
     <font size="3"><b>${ORDER_TO.city}</b></font>
    </td>
    <td align="center">
     <font size="3"><b>${ORDER_TO.state}</b></font>
    </td>
    <td align="center">
     <font size="3"><b>${ORDER_TO.zip}</b></font>
    </td>
    <td align="center">
     <font size="3"><b>${ORDER_TO.orderDate}</b></font>
    </td>
   </tr> 
   <tr bgcolor="black">
    <td align="center"><font size="4" color="yellow"><b>Book Name</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Author</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Edition</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Publication</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Cost</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Quantity</b></font></td>
    <td align="center"><font size="4" color="yellow"><b>Amount</b></font></td>
   </tr>
   <%int i=0;    int x=-1;      String color="#fdeaff";%>
      <core:forEach var="bto" items="${ORDER_TO.orderItemList}">
      <%
        i++;	x++;
        if(x==3)	    x=0;
        if(x==0)	    color="#fdeaff";
        else if(x==1)	color="#dee1fe";
        else if(x==2)	color="#e1ffde";
       %>
       <tr bgcolor="<%=color%>">
        <td align="center"><font size="3"><b>${bto.bookName}</b></font></td>
        <td align="center"><font size="3"><b>${bto.author}</b></font></td>
        <td align="center"><font size="3"><b>${bto.edition}</b></font></td>
        <td align="center"><font size="3"><b>${bto.publication}</b></font></td>
        <td align="center"><font size="3" face="Rupee Foradian"></font><font size="3"><b>${bto.cost}/-</b></font></td>
        <td align="center"><font size="3"><b>${bto.selectedNumberOfBook}</b></font></td>
        <td align="right"><font size="4" face="Rupee Foradian"></font><font size="4">
          <jlc:displayBookTotalAmount value="${bto.cost * bto.selectedNumberOfBook}" 
          quantity="${bto.selectedNumberOfBook}"/> /- </font>
        </td>
       </tr> 
      </core:forEach>            
   </table>
   </core:if>
   <core:if test="${USER_INFO ne null}">
    <table width="50%" class="textStyle" cellspacing="0">
     <tr bgcolor="maroon">
       <td align="center" colspan="3"><font color="yellow" size="5">
        <b>User Information for id <font color="white">${USER_INFO.userId}</font> </b></font>
       </td>
     </tr>
     <tr bgcolor="#fdeaff">
      <td><font size="4"><b>Name</b></font></td>
      <td colspan="2"><font size="4"><b>${USER_INFO.firstName} ${USER_INFO.middleName} ${USER_INFO.lastName}</b></font></td>
     </tr>
     <tr bgcolor="#dee1fe">
      <td><font size="4"><b>Email</b></font></td>
      <td><font size="4"><b>${USER_INFO.email}</b></font></td>
     </tr>
     <tr bgcolor="#e1ffde">
      <td><font size="4"><b>Phone</b></font></td>
      <td><font size="4"><b>${USER_INFO.phone}</b></font></td>
     </tr>
   </table>
   </core:if> 
   </center>  
  </body>
</html>
