package dubovikLera.servlet;

import dubovikLera.service.UserService;
import dubovikLera.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static dubovikLera.utils.UrlPath.LOGIN;

@Slf4j
@WebServlet(LOGIN)
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User {} accessed login page at {}", req.getRemoteUser(), LocalDateTime.now());
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User {} attempted to login at {}", req.getParameter("email"), LocalDateTime.now());
        userService.login(req.getParameter("email"), req.getParameter("password"))
                .ifPresentOrElse(userDto -> onLoginSuccess(userDto, req, resp),() -> onLoginFail(req, resp));
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        log.warn("Login failed for user {} at {}", req.getParameter("email"), LocalDateTime.now());
        resp.sendRedirect("/login?error&email="+ req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(Object userDto, HttpServletRequest req, HttpServletResponse resp) {
        log.info("User {} logged in successfully at {}", req.getRemoteUser(), LocalDateTime.now());
        req.getSession().setAttribute("user", userDto);
        resp.sendRedirect("/redirect");
    }
}
