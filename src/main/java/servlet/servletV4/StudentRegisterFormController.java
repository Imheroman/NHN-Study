package servlet.servletV4;

import student.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/register.do", method = RequestMapping.Method.GET)
public class StudentRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        return "redirect:/studentWeb/register.jsp";
    }
}
