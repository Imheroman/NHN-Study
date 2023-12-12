package servlet.servletV3_5;

import student.Gender;
import student.Student;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

//@WebServlet(name = "studentRegisterController", urlPatterns = "/student/register")
public class StudentRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String stringGender = req.getParameter("gender");
        String stringAge = req.getParameter("age");
        Gender gender;
        int age;

        if (Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(stringGender) || Objects.isNull(stringAge)) {
            throw new IllegalArgumentException("Spaces cannot be entered.");
        }

        try {
            age = Integer.parseInt(stringAge);
            gender = stringGender.equals("남") ? Gender.M : Gender.F;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The age is not numbers");
        }
        studentRepository.save(new Student(id, name, gender, age));

//        return "redirect:/studentWeb/view?id=" + id;
//        return "redirect:/studentWeb/view?id=" + id;
//        return "redirect:/student/view?id=" + id;
        return "redirect:/student/list.do";
    }
}
