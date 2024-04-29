package dubovikLera.servlet;

import dubovikLera.dto.CreateUserDto;
import dubovikLera.entity.enums.Gender;
import dubovikLera.entity.PersonalInfo;
import dubovikLera.entity.enums.Role;
import dubovikLera.exception.ValidationException;
import dubovikLera.service.UserService;
import dubovikLera.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;

import static dubovikLera.utils.UrlPath.REGISTRATION;

@Slf4j
@WebServlet(REGISTRATION)
public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger("error.logger");
    private final UserService userService = UserService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User accessed registration page");
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userDto = CreateUserDto.builder()
                .personalInfo(PersonalInfo.builder()
                        .name(req.getParameter("name"))
                        .birthday(LocalDate.parse(req.getParameter("birthday")))
                        .password(req.getParameter("pwd"))
                        .build())
                .email(req.getParameter("email"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();

        try {
            log.info("Attempting to create new user: " + userDto.getEmail());

            userService.create(userDto);

            log.info("New user created: " + userDto.getEmail());
            resp.sendRedirect("/login");
        } catch (ValidationException e) {
            logger.error("Validation errors occurred while creating new user: " + e.getErrors());
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }


    }
}
