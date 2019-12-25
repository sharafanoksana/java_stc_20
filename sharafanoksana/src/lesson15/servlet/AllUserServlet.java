/**
 * @author Sharafan Oksana
 * @date 24.12.2019
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
import java.util.Collection;

@WebServlet(urlPatterns = "/allusers", name = "UserPerson")
    public class AllUserServlet extends HttpServlet {
    @Inject
    private UserPersonDao userPersonDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<UserPerson> userPersonCollection = userPersonDao.getAllUserPerson();
        req.setAttribute("user", userPersonCollection);
        req.getRequestDispatcher("WEB-INF/jsp/allusers.jsp").forward(req,resp);
    }
}
