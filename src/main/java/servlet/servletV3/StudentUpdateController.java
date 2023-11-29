package servlet.servletV3;

import student.Gender;
import student.Student;
import student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        //TODO: null check, student 저장
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
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
//        return "redirect:/studentWeb/view?id=" + id;
        return "redirect:/student/list";
    }
}
