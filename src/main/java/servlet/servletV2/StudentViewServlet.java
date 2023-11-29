package servlet.servletV2;

import lombok.extern.slf4j.Slf4j;
import student.MapStudentRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private MapStudentRepository mapStudentRepository;

    @Override
    public void init(ServletConfig config) {
        this.mapStudentRepository = (MapStudentRepository) config
                .getServletContext().getAttribute("studentRepository");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: id null check, student 조회, /student/view.jsp forward
        String id = req.getParameter("id");

        if (id == null) {
            throw new IllegalArgumentException("The id is null");
        }

        if (mapStudentRepository.existById(id)) {
            req.setAttribute("student", mapStudentRepository.getStudentById(id));

            //TODO: view attribute 설정 - /student/view.jsp
            req.setAttribute("view", "/studentWeb/view.jsp");
        } else {
            throw new IllegalArgumentException("The id is not existed");
        }
    }
}
