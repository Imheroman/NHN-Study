package servlet.servletV2;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String[][] addresses = {
            {"/student/list.do", "/student/list"},
            {"/student/delete.do", "/student/delete"},
            {"/student/register.do", "/student/register"},
            {"/student/view.do", "/student/view"},
            {"/student/update.do", "/student/update"}
    };

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //TODO: 공통 처리 - 응답 content-type, character encoding 지정
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html");
        RequestDispatcher rd = null;

        try {
            String servletPath = resolveServlet(req.getServletPath());
            rd = req.getRequestDispatcher(servletPath);
            rd.include(req, res);

            String view = (String) req.getAttribute("view");

            if (view.startsWith(REDIRECT_PREFIX)) {
                log.error("redirect-url: {}", view.substring(REDIRECT_PREFIX.length() + 1));

                //TODO: 'redirect:'로 시작하면 redirect 처리
                res.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                //TODO: redirect 아니면 JSP에거 view 처리를 위임하여 그 결과를 include시킴
                rd = req.getRequestDispatcher(view);
                rd.include(req, res);
            }
        } catch (Exception e) {
            //TODO: 공통 error 처리 - ErrorServlet 참고해서 처리
            log.error("", e);
            req.setAttribute("exception", e);

            //TODO: forward - /error.jsp
            rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, res);
        }
    }

    private String resolveServlet(String servletPath) {
        String processingServletPath = null;

//        for (int i = 0; i < addresses.length; i++) {
//            String path = addresses [i][0];
//
//            if (path.equals(servletPath)) {
//                processingServletPath = addresses[i][1];
//            }
//        }
//
//        return processingServletPath;

        if ("/student/list.do".equals(servletPath)) {
            processingServletPath = "/student/list";
        } else if ("/student/delete.do".equals(servletPath)) {
            processingServletPath = "/student/delete";
        } else if ("/student/register.do".equals(servletPath)) {
            processingServletPath = "/student/register";
        } else if ("/student/view.do".equals(servletPath)) {
            processingServletPath = "/student/view";
        } else if ("/student/update.do".equals(servletPath)) {
            processingServletPath = "/student/update";
        }

        return processingServletPath;
    }
}