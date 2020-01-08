/**
 * @author Sharafan Oksana
 * @date 30.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet2")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "MANAGER"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "MANAGER")
})
public class SecuredServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp
                .getWriter()
                .write("<h1>Secured Servlet2</h1>");
    }
}
