package servlet.servletV3;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("status_code", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        req.setAttribute("exception_type", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
        req.setAttribute("message", req.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        req.setAttribute("exception", req.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        req.setAttribute("request_uri", req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));

        return "/error.jsp";
    }
}
