package servlet.servletV3_5;

import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        //TODO: id null check, student 조회, /student/view.jsp forward
        String id = req.getParameter("id");
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        if (id == null) {
            throw new IllegalArgumentException("The id is null");
        }

        if (studentRepository.existById(id)) {
            req.setAttribute("student", studentRepository.getStudentById(id));
            return "/studentWeb/view.jsp";
        } else {
            throw new IllegalArgumentException("The id is not existed");
        }
    }
}
