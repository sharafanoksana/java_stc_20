/**
 * @author Sharafan Oksana
 * @date 28.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/errorHandler")
public class AppErrorHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    private void processError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String servletName = (String) req.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) req.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        if (statusCode != 500){
            req.setAttribute("statuscode", statusCode);
            req.setAttribute("requestUri", requestUri);
        }else {
            req.setAttribute("statusCode", statusCode);
            req.setAttribute("requestUri", requestUri);
            req.setAttribute("servletName", servletName);
            req.setAttribute("throwableName", throwable.getClass().getName());
            req.setAttribute("throwableMessage", throwable.getMessage());
        }
        req.getRequestDispatcher("/error.jsp").forward(req,resp);
    }
}
