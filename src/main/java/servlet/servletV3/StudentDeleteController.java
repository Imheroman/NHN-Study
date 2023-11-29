package servlet.servletV3;

import lombok.extern.slf4j.Slf4j;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
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
