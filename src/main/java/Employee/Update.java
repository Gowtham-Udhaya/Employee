package Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String man = request.getParameter("man");
        String level = request.getParameter("lvl");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDB", "root", "");
            Statement st = con.createStatement();
            int rowsAffected = st.executeUpdate("update Employee set Name='"+name+"',Manager='"+man+"',level='"+level+"' where ID="+id+"");
            st.close();
            con.close();
            System.out.println(rowsAffected);
            System.out.println("Update done...");
            response.sendRedirect("List");

        }
        catch (Exception e)
        {
            out.println(e);
        }
    }
}
