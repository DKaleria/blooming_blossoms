package dubovikLera.servlet;

import dubovikLera.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@WebServlet("/blocked")
public class BlockedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Blocked user {} attempted to login at {}", req.getRemoteUser(), LocalDateTime.now());
        
        // Отображение страницы с сообщением о блокировке
        req.getRequestDispatcher(JspHelper.getPath("blocked"))
                .forward(req, resp);
    }
}