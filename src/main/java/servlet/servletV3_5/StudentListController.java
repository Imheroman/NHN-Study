package servlet.servletV3_5;

import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext()
                .getAttribute("studentRepository");
        req.setAttribute("studentList", studentRepository.getStudents());

        //TODO: view attribute - /student/list.jsp
        return "/studentWeb/list.jsp";
    }
}
