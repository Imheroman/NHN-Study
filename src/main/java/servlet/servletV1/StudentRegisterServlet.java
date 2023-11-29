package servlet.servletV1;//package student2;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student2/register")
//public class StudentRegisterServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) {
//        //TODO: init stduentRepository
//        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        //TODO: /student/register.jsp forward
//        req.setAttribute("studentList", studentRepository.getStudents());
//        RequestDispatcher rd = req.getRequestDispatcher("/studentWeb/register.jsp");
//        rd.forward(req, res);
//    }
//
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { //TODO: null check, save, redirect /student/view?id = student1
//        String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String stringGender = req.getParameter("gender");
//        String stringAge = req.getParameter("age");
//        Gender gender;
//        int age;
//
//        if (id == null || name == null || stringGender == null || stringAge == null) {
//            throw new IllegalArgumentException("Spaces cannot be entered.");
//        }
//
//        try {
//            age = Integer.parseInt(stringAge);
//            gender = stringGender.equals("남") ? Gender.M : Gender.F;
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("The age is not numbers");
//        }
//
//        studentRepository.save(new Student(id, name,gender,age));
//
//        req.setAttribute("studentList", studentRepository.getStudents());
//        res.sendRedirect("/student/view?id=" + id);
////        RequestDispatcher rd = req.getRequestDispatcher("/studentWeb/view.jsp");
////        rd.forward(req, res);
//        //TODO: redirect /student/view?id=student1
//    }
//}
