package servlet.servletV2;

import lombok.extern.slf4j.Slf4j;
import student.StudentRepository;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        //TODO: init studentRepository
        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");

        if (this.studentRepository == null) {
            throw new NullPointerException("This repository is null");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //TODO: get parameter  : id , id가 존재하지 않을경우 throw new RuntimeException("...")
        String id = req.getParameter("id");
        if (id == null) {
            throw new RuntimeException("Delete fails because the id is null");
        }

        if (studentRepository.existById(id)) {
            log.error("id:{}", id);
            studentRepository.deleteById(id);
        } else {
            log.error("There is no id");
        }

        //TODO: redirect:/student/list.do 적용
        req.setAttribute("view", "redirect:/student/list.do");
//        res.sendRedirect("redirect:/student/list.do");
    }
}
