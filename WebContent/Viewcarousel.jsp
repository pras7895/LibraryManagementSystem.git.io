<%@ page import="com.pack.LibrarianBean" %>
<%@ page import="java.util.List" %>
<%
List<LibrarianBean> LibrarianList=(List<LibrarianBean>) request.getAttribute("LibrarianList");




%>
<div class="container">
  <h2>Librarian list</h2>
              
  <table class="table table-bordered">
    <thead>
      <tr>
       <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
       <th>Mobile</th>
      <th></th>
      <th></th>
      </tr>
    </thead>
    <tbody>
    <% 
    for(LibrarianBean bean : LibrarianList)
    {
    	String editLibrarianAction="EditLibrarianForm?Id="+bean.getId();
    	String deleteLibrarianAction="DeleteLibrarian?Id="+bean.getId();
    	%>
      <tr>
      <td><%=bean.getId()%></td>
        <td><%=bean.getName()%></td>
        <td><%=bean.getEmail()%></td>
        <td><%=bean.getPassword()%></td>
        <td><%=bean.getMobile()%></td>
     <td> <a href="<%=editLibrarianAction%>">edit</a></td>
     <td><a href="<%=deleteLibrarianAction%>">delete</a></td>
      </tr>
      <%
    }
      %>
      
          </tbody>
  </table>
</div>
