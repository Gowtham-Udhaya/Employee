<html>
<head>
<link rel="stylesheet" href="index.css">
</head>
<body>
<%@page import="java.lang.*"%>
<h2>Employee Updation form</h2>
<%
String name = request.getParameter("name");
String man = request.getParameter("man");
String level = request.getParameter("lvl");
int id = Integer.parseInt(request.getParameter("id"));
%>
<form method="post" action="Update">
  ID      :<br><input type="number" name="id" value=<%=id%> readonly ><br>
  Name    :<br><input type="text" name="name" value=<%=name%> ><br>
  Manager :<br><input type="text" name="man" value=<%=man%> ><br>
  Level   :<br><input type="text" name="lvl" value=<%=level%> ><br><br>
  <input type="submit" value="update"> <input type="submit" formaction="Delete" value="delete">
 </form>
</body>
</html>