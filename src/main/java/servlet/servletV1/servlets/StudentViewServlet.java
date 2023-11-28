package servlet.servletV1.servlets;//package student2;
//
//import lombok.extern.slf4j.Slf4j;
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
//@Slf4j
//@WebServlet(name = "studentViewServlet", urlPatterns = "/student2/view")
//public class StudentViewServlet extends HttpServlet {
//    private StudentRepository studentRepository;
//
//    @Override
//    public void init(ServletConfig config) {
//        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        //TODO: id null check, student 조회, /student/view.jsp forward
//        String id = req.getParameter("id");
//
//        if (id == null) {
//            throw new IllegalArgumentException("The id is null");
//        }
//
//        if (studentRepository.existById(id)) {
//            req.setAttribute("student", studentRepository.getStudentById(id));
//            RequestDispatcher rd = req.getRequestDispatcher("/studentWeb/view.jsp");
//            rd.forward(req, res);
//        } else {
//            throw new IllegalArgumentException("The id is not existed");
//        }
//    }
//}
