/**
 * @author Sharafan Oksana
 * @date 28.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import lesson15.dataBaseTables.UserPersonDao;
import lesson15.entities.UserPerson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/showuser")
public class AddUserServlet extends HttpServlet {
    @Inject
    private UserPersonDao userPersonDao;

    @Override
    public void init() throws ServletException {
        userPersonDao = (UserPersonDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("PageTitle", "New User");
        req.setAttribute("PageBody", "form.jsp");
        req.getRequestDispatcher("/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String login= req.getParameter("login");
        String city= req.getParameter("city");
        String email= req.getParameter("email");
        String description= req.getParameter("description");
        UserPerson userPerson = new UserPerson(name, Date.valueOf(birthday), login,city,email,description);
        userPersonDao.addUser(userPerson);
        resp.sendRedirect(req.getContextPath() + "/allusers");
    }
}
