<%@ page import="com.pack.LibrarianBean" %>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">R.d Library Management System</a>
      </div>
      <ul class="nav navbar-nav">
   <li><a href="AddLibrarianServlet">Add Librarian</a></li></ul>
      <ul class="nav navbar-nav">
      <li><a href="ViewLibrarianServlet">View Librarian</a></li>
      </ul>
    <form class="navbar-form navbar-left" action="SearchServlet">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
<ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span><%=session.getAttribute("email")%> Logout</a></li>
    </ul>
    </div>
    </nav>

