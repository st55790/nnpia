package cs.fei.upce.nnpia.cv02.servletnnpia;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user");
        String password = request.getParameter("password");

        if(name.equals("admin") && password.equals("admin")){
            response.sendRedirect("adminLogin.jsp");
        }else if(name.equals("user") && password.equals("user")){
            response.sendRedirect("userLogin.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
