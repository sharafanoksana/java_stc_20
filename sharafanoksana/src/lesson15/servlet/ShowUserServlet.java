/**
 * @author Sharafan Oksana
 * @date 25.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import lesson15.dataBaseTables.UserPersonDao;
import lesson15.entities.UserPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showuser")
public class ShowUserServlet extends HttpServlet {
    @Inject
    private UserPersonDao userPersonDao;

    @Override
    public void init() throws ServletException {
        userPersonDao = (UserPersonDao) getServletContext().getAttribute("dao");
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null){
            throw new ServletException("Missing parametr id");
        }
        UserPerson userPerson = userPersonDao.getUserById(Integer.valueOf(userId));
        if (userPerson == null){
            resp.setStatus(404);
            req.getRequestDispatcher("/notfound.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("user", userPerson);
        req.getRequestDispatcher("/showuser.jsp").forward(req, resp);
    }
}
