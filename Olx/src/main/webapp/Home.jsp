
<!DOCTYPE html>
<%@page import="Dto.Customerdto"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
<h1>Welcome to OLX</h1>
<%
Customerdto dto=(Customerdto) session.getAttribute("dto");
if(dto==null){
 %>
<a href="Login.html"><button>Login</button></a>
<a href="Signup.html"><button>Signup</button></a><br>
<%
}
%>
<a href="Buy"><button>Buy</button></a><a href="Sell"><button>Sell</button></a><br>

<% if(dto!=null)
{ %>
<a href="Logout"><button style="text-align: center;">Logout</button></a>
<% } %>


</body>
</html>