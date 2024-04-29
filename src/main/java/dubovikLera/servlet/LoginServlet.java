package dubovikLera.servlet;

import dubovikLera.dto.UserDto;
import dubovikLera.entity.User;
import dubovikLera.entity.enums.Role;
import dubovikLera.mapper.UserMapper;
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
                .ifPresentOrElse(userDto -> {
                    try {
                        onLoginSuccess(userDto, req, resp);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }, () -> onLoginFail(req, resp));
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        log.warn("Login failed for user {} at {}", req.getParameter("email"), LocalDateTime.now());
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(Object userDto, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("User {} logged in successfully at {}", req.getRemoteUser(), LocalDateTime.now());
        req.getSession().setAttribute("user", userDto);

        if (userDto instanceof UserDto) {
            UserDto mappedUserDto = (UserDto) userDto;
            if (mappedUserDto.getRole() == Role.ADMIN) {
                 if (mappedUserDto.isActive() == false) {
                    resp.sendRedirect("/blocked");
                    return;
                } else if (mappedUserDto.isActive() == true) {
                    resp.sendRedirect("/admin");
                    return;
                }


            } else if (mappedUserDto.isActive() == false) {
                resp.sendRedirect("/blocked");
                return;
            } else if (mappedUserDto.isActive() == true) resp.sendRedirect("/redirect");
        }


    }
}