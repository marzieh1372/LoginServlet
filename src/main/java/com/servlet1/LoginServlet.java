package com.servlet1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
        description = "Login Servlet",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "marzieh"),
                @WebInitParam(name = "password", value = "123456")
        })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public void init() throws ServletException {
        System.out.println("Init method ................");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("do posttttttttt");
        //get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        //logging example
        log("User=" + user + "::password=" + pwd);

        if (userID.equals(user) && password.equals(pwd)) {
            response.sendRedirect("/jsp/LoginSuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do gettttttttt");
    }


}
