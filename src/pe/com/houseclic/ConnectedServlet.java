package pe.com.houseclic;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ConnectedServlet", urlPatterns = {"/connected", "/demo"})
public class ConnectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = null;
        out = response.getWriter();
        out.println("Hello Servlet Developers!");
        out.println("Request Information");
        String requestInfo =
                "Remote User: "+
                        request.getRemoteUser() == null ? "" :
                        request.getRemoteUser()+ "\n" +
                                "Request URI: "+ request.getRequestURI();
        out.println(requestInfo);
        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx
                    .lookup("jdbc/MySQLDataSource");
            out.println("Data Source: " +
                    dataSource.getConnection().toString());

            ResultSet resultSet = dataSource
                    .getConnection()
                    .createStatement()
                    .executeQuery("SELECT * FROM client");
            out.println("Records Found in Client: " +
                    String.valueOf(resultSet.next() ? "Yes" : "No"));

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
