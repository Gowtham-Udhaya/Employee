<html>
<head>
<link rel="stylesheet" href="index.css">
</head>
<body>
<%@page import="java.sql.*"%>
<h2>Employee List</h2>
<%
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDB", "root", "Gowt@1708");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Employee");
            %>
                <table>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Manager</th>
                    <th>Level</th>
                  </tr>
            <%    while (rs.next())
                  {

            %>
                  <form method="post" action="update">
                  <tr>
                    <td><input type="number" name="id" value=<%=rs.getString(1)%> readonly ></td>
                    <td><input type="text" name="name" value=<%=rs.getString(2)%> readonly ></td>
                    <td><input type="text" name="man" value=<%=rs.getString(3)%> readonly ></td>
                    <td><input type="text" name="lvl" value=<%=rs.getString(4)%> readonly ></td>
                    <td><input type="submit" value="Edit"></td>
                  </tr>
                  </form>
            <%    }%>
                </table>
                <br><br>
                <form method="post" action="/Employee">
                  <input class="button" type="submit" value="Back">
                 </form>
<%          st.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
%>

</body>
</html>