/**
 * @author Sharafan Oksana
 * @date 24.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import lesson15.dataBaseTables.UserPersonDao;
import lesson15.entities.UserPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private Logger logger = LoggerFactory.getLogger(AllUserServlet.class);

    @Override
    public void init() throws ServletException {
        userPersonDao = (UserPersonDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<UserPerson> userPersonCollection = userPersonDao.getAllUserPerson();
        req.setAttribute("users", userPersonCollection);
        req.setAttribute("PageTitle", "Users");
        req.setAttribute("PageBody", "allUsers.jsp");
        req.getRequestDispatcher("/layout.jsp").forward(req, resp);
    }
}
