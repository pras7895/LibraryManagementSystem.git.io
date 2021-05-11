<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Book Page</title>
</head>
<body>
<%@ include file="issuebookcarousel.jsp"%>

<%
String successmsg=(String)request.getAttribute("successmsg");
String errormsg=(String)request.getAttribute("errormsg");
%>
<% 
if(successmsg!=null)
{
	%>
	<div class="alert alert-success">
    <strong>Success!</strong>Add Book successfully.
  </div>
  <%
}
  
  if(errormsg!=null){
	
	  %>
	  <div class="alert alert-danger">
	    <strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
	  </div>
	<%
	}
	%>  


</body>
</html>