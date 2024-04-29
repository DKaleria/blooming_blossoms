package dubovikLera.servlet;


import dubovikLera.entity.enums.Role;
import dubovikLera.service.UserService;
import dubovikLera.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/admin")
@Slf4j
public class AdminServlet extends HttpServlet {
    private final UserService userService = UserService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        request.setAttribute("roles", Role.values());
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ban":
                    banUser(request, response);
                    break;
                case "unlock":
                    unlockUser(request, response);
                    break;
                case "edit":
                    changeUserRole(request, response);
                    break;
                case "info":
                    findOutUserInfo(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                    break;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing");
        }
    }

    private void findOutUserInfo(HttpServletRequest request, HttpServletResponse response) {

    }

    private void unlockUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdParam = request.getParameter("id");
        if (userIdParam != null) {
            try {
                int userId = Integer.parseInt(userIdParam);
                userService.unlockUser(userId);
                response.sendRedirect(request.getContextPath() + "/admin");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User ID parameter is missing");
        }
    }

    private void banUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdParam = request.getParameter("id");
        if (userIdParam != null) {
            try {
                int userId = Integer.parseInt(userIdParam);
                userService.banUser(userId);
                response.sendRedirect(request.getContextPath() + "/admin");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User ID parameter is missing");
        }

    }

    private void changeUserRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userIdParam = request.getParameter("id");
        String roleParam = request.getParameter("role");

        if (userIdParam != null && roleParam != null) {
            try {
                int userId = Integer.parseInt(userIdParam);
                userService.changeUserRole(userId, Role.valueOf(roleParam));
                response.sendRedirect(request.getContextPath() + "/admin");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User ID or role parameter is missing");
        }

    }
}
