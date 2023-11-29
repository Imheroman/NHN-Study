package servlet.servletV1;//package student2;
//
//import lombok.extern.slf4j.Slf4j;
//import student2.MapStudentRepository;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@WebServlet(name = "studentListServlet", urlPatterns = "/student2/list")
//public class StudentListServlet extends HttpServlet {
//    private MapStudentRepository mapStudentRepository;
//
//    @Override
//    public void init(ServletConfig config) {
//        mapStudentRepository = (MapStudentRepository)config.getServletContext().getAttribute("studentRepository");
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        List<Student> studentList = this.mapStudentRepository.getStudents();
//        req.setAttribute("studentList", studentList);
//        RequestDispatcher rd = req.getRequestDispatcher("/studentWeb/list.jsp");
//        rd.forward(req, res);
//    }
//}
