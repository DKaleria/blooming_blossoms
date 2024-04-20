package dubovikLera.servlet;

import dubovikLera.dto.CategoriesDto;
import dubovikLera.entity.Categories;
import dubovikLera.service.CategoriesService;
import dubovikLera.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

import static dubovikLera.utils.UrlPath.CATEGORIES;
@Slf4j
@WebServlet(CATEGORIES)
public class CategoriesServlet extends HttpServlet {
    private CategoriesService categoriesService = CategoriesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("User '{}' accessed the categories page",request.getParameter("email"));
        List<Categories> categories = categoriesService.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher(JspHelper.getPath("categories")).forward(request, response);
    }
}