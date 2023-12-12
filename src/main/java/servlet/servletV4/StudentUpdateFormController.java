package servlet.servletV4;

import student.RequestMapping;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.GET)
public class StudentUpdateFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        req.setAttribute("student", studentRepository.getStudentById(id));

        //TODO: view attribute 설정 - /student/register.jsp
        return "/studentWeb/register.jsp";
    }
}
