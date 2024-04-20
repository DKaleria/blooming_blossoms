package dubovikLera.servlet;

import dubovikLera.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        if("categories".equals(page)){
            log.info("User '{}' logged in", req.getParameter("email"));
            resp.sendRedirect("/categories");
        } else if ("catalog".equals(page)) {
            log.info("User '{}' accessed the catalog page", req.getParameter("email"));
            resp.sendRedirect("/catalog");

        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("redirect")).forward(req, resp);
    }
}
