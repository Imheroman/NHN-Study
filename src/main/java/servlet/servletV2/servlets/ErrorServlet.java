package servlet.servletV2.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "errorServlet", urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("status_code", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        req.setAttribute("exception_type", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
        req.setAttribute("message", req.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        req.setAttribute("exception", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        req.setAttribute("request_uri", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        PrintWriter writer = res.getWriter();

        RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
        rd.forward(req, res);
    }
}
