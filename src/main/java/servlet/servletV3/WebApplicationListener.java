package servlet.servletV3;

import student.Gender;
import student.MapStudentRepository;
import student.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener { // WebApplicationListener -> Container 실행 초기설정을 위함
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        MapStudentRepository studentRepository = new MapStudentRepository();
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
//            String id = String.valueOf(i);
            String id = "student" + i;
            String name = "Academy" + i;
            int age = rand.nextInt(11) + 20;

            if (i % 2 == 0) {
                studentRepository.save(new Student(id, name, Gender.M, age));
            } else {
                studentRepository.save(new Student(id, name, Gender.F, age));
            }
        }
        context.setAttribute("studentRepository", studentRepository);
    }

}
