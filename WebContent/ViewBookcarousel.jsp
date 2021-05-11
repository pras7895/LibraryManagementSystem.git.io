<%@ page import="com.pack.BookBean" %>
<%@ page import="java.util.List" %>
<%
List<BookBean> BookBean=(List<BookBean>) request.getAttribute("BookList");
%>
<div class="container">
  <h2>Book list</h2>
              
  <table class="table table-bordered">
    <thead>
      <tr>
       <th>CallNo</th>
        <th>Name</th>
        <th>PublisherName</th>
        <th>AuthorName</th>
       <th>Quantity</th>
      <th>Issued</th>
      
      </tr>
    </thead>
    <tbody>
    <% 
    for(BookBean bean : BookBean)
    {
    	%>
      <tr>
      <td><%=bean.getCallno()%></td>
        <td><%=bean.getName()%></td>
        <td><%=bean.getPublisher()%></td>
        <td><%=bean.getAuthor()%></td>
        <td><%=bean.getQuantity()%></td>
        <td><%=bean.getIssued()%></td>
      </tr>
      <%
    }
      %>
          </tbody>
  </table>
</div>
