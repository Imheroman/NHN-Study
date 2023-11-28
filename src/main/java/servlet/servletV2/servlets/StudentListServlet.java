package servlet.servletV2.servlets;

import lombok.extern.slf4j.Slf4j;
import student.Student;
import student.StudentRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "studentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    private StudentRepository mapStudentRepository;

    @Override
    public void init(ServletConfig config) {
        this.mapStudentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Student> studentList = this.mapStudentRepository.getStudents();
        req.setAttribute("studentList", studentList);

        //TODO: view attribute - /student/list.jsp
        req.setAttribute("view", "redirect:/studentWeb/list.jsp");
//        RequestDispatcher rd = req.getRequestDispatcher("/studentWeb/list.jsp");
//        rd.forward(req, res);
    }
}
