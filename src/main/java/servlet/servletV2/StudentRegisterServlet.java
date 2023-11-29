package servlet.servletV2;

import student.Gender;
import student.MapStudentRepository;
import student.Student;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    private MapStudentRepository mapStudentRepository;

    @Override
    public void init(ServletConfig config) {
        //TODO: init stduentRepository
        mapStudentRepository = (MapStudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: view attribute 설정 - /student/register.jsp
        req.setAttribute("view", "/studentWeb/register.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { //TODO: null check, save, redirect /student/view?id = student1
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
        mapStudentRepository.save(new Student(id, name, gender, age));

        //TODO: redirect view attribute 설정
        req.setAttribute("view", "redirect/studentWeb/view?id=" + id);
    }
}
