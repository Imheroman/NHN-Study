package servlet.servletV4;

import lombok.extern.slf4j.Slf4j;
import student.RequestMapping;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/*
        {"/student/register.do", "GET"},
        {"/student/register.do", "POST"},
        {"/student/view.do", "GET"},
        {"/student/update.do", "GET"},
        {"/student/update.do", "POST"}
*/

@Slf4j
@RequestMapping(value = "/student/delete.do", method = RequestMapping.Method.POST)
public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext()
                .getAttribute("studentRepository");

        if (Objects.isNull(studentRepository)) {
            throw new NullPointerException("This student repository is null");
        }

        String id = req.getParameter("id");
        if (studentRepository.existById(id)) {
            studentRepository.deleteById(id);

            return "redirect:/student/list.do";
        }

        throw new RuntimeException("There is no id in student repository");
    }

}


