<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
String success=response.getAttibute(Successmsg);
String error=response.getAttibute(Errormsg);
if(status==1)
{
out.print(<font color="green">success</font>);
}
else
{
out.print(<font color="red">error</font>);
}
</body>
</html>