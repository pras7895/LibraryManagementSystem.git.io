<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.pack.LibrarianBean" %>
    <%@ page import="com.pack.LibrarianDao" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Edit Librarian Page</title>
</head>
<body>
<%
LibrarianBean bean = (LibrarianBean)request.getAttribute("librarianbean");
%>
<form action="EditLibrarian">
  <div class="container">
    <h1>Edit form</h1>
    <hr>
    <label for="Id"><b></b></label>
     <input type="hidden" placeholder="Enter Name" name="Id" value='<%=bean.getId() %>'>
     <label for="Name"><b>Name</b></label>
     <input type="text" placeholder="Enter Name" name="Name" value='<%=bean.getName() %>'>
    <br>
    <br>
    <label for="Email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="Email" value='<%=bean.getEmail()%>'>
    <br>
    <br>
    <label for="Password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="Password" value='<%=bean.getPassword()%>'>
     <br>
     <br>
     <label for="Mobile"><b>Mobile Number</b></label>
    <input type="text" placeholder="Enter Mobile" name="Mobile" value='<%=bean.getMobile()%>'>
    <br>
    <br>
    
    <button type="submit" class="registerbtn">Update</button>
  </div>  
</form>
</body>
</html>
