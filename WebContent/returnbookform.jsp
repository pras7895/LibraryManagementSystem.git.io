<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Return book page</h2>
<form action="ReturnBookForm">
<label for="Callno"><b>CallNo</b></label>
     <input type="text" placeholder="Enter Callno" name="Callno" required>
    <br>
    <br>
<label for="StudentId"><b>StudentId</b></label>
     <input type="text" placeholder="Enter StudentId" name="StudentId" required>
    <br>
    <br>
<button type="submit" class="registerbtn">Return Book</button>
</form>



</body>
</html>