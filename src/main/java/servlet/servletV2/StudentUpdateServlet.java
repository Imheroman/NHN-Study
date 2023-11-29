package servlet.servletV2;

import student.Gender;
import student.MapStudentRepository;
import student.Student;
import student.StudentRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        this.studentRepository = (MapStudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: 학생 조회
        String id = req.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        //TODO: view attribute 설정 - /student/register.jsp
        req.setAttribute("view", "/studentWeb/register.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //TODO: null check, student 저장
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String stringGender = req.getParameter("gender");
        String stringAge = req.getParameter("age");
        int age;
        Gender gender;

        if (id == null || name == null || stringGender == null || stringAge == null) {
            throw new IllegalArgumentException("The update infomation includes null");
        }

        try {
            age = Integer.parseInt(stringAge);
            gender = stringGender.equals("남") ? Gender.M : Gender.F;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The age is not number");
        }
        studentRepository.update(new Student(id, name, gender, age));

        //TODO: view attribute 설정 -  redirect
        req.setAttribute("view", "redirect:/studentWeb/view?id=" + id);
    }
}