package servlet.servletV4;

import student.RequestMapping;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
        {"/student/delete.do", "POST"},
        {"/student/register.do", "GET"},
        {"/student/register.do", "POST"},
        {"/student/view.do", "GET"},
        {"/student/update.do", "GET"},
        {"/student/update.do", "POST"}
*/

@RequestMapping(value = "/student/list.do", method = RequestMapping.Method.GET)
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
