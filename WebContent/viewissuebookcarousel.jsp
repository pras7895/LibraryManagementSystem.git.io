<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<%@ page import="com.pack.*" %>
<%@ page import="java.util.List" %>

<%
List<IssuedBean> IssuedBookList=(List<IssuedBean>)request.getAttribute("IssuedBookList");
%>
<div class="container">
<h2>Issue Book list</h2>
            
<table class="table table-bordered">
  <thead>
    <tr>
     <th>CallNo</th>
      <th>StudentName</th>
      <th>StudentId</th>
      <th>Mobile</th>
     <th>Return status</th>
    <th>Issued Date</th>
    
    </tr>
  </thead>
  <tbody>
  <% 
  for(IssuedBean bean : IssuedBookList)
  {
  	%>
    <tr>
    <td><%=bean.getCallNo()%></td>
      <td><%=bean.getStudentName()%></td>
      <td><%=bean.getStudentId()%></td>
      <td><%=bean.getMobile()%></td>
      <td><%=bean.getReturnstatus()%></td>
      <td><%=bean.getDate()%></td>
    </tr>
    <%
  }
    %>
        </tbody>
</table>
</div>
