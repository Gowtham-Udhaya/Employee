package Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String man = request.getParameter("man");
        String level = request.getParameter("lvl");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDB", "root", "Gowt@1708");
            Statement st = con.createStatement();
            int rowsAffected = st.executeUpdate("insert into Employee (Name,Manager,level) values ('"+name+"','"+man+"','"+level+"')");
            st.close();
            con.close();
            System.out.println(rowsAffected);
            System.out.println("Update succefully");
            response.sendRedirect("/Employee");
        }
        catch (Exception e)
        {
            out.println(e);
        }
    }
    }
