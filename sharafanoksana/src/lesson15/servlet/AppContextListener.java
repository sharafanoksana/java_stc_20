/**
 * @author Sharafan Oksana
 * @date 27.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import lesson15.dataBaseTables.UserPersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(AppContextListener.class);

    @Inject
    private UserPersonDao userPersonDao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String isDao = servletContext.getInitParameter("isDao");
        if (isDao.equals("true")){
            servletContext.setAttribute("dao", userPersonDao);
            logger.info("Added atribute DAO");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.removeAttribute("dao");
        logger.info("Removed attribute DAO");
    }
}
