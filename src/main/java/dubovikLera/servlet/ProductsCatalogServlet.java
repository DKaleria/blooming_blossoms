package dubovikLera.servlet;

import dubovikLera.dto.ProductsDto;
import dubovikLera.entity.Products;
import dubovikLera.service.ProductsService;
import dubovikLera.utils.JspHelper;
import dubovikLera.utils.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static dubovikLera.utils.UrlPath.CATALOG;

@Slf4j@WebServlet(CATALOG)
public class ProductsCatalogServlet extends HttpServlet {
    private final ProductsService productsService = ProductsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("User '{}' accessed the catalog page", req.getParameter("email"));

        // Получение выбранной категории из параметров запроса
        String categoryId = req.getParameter("category_id");

        // Получение всех продуктов или фильтрация по категории
        List<Products> products = productsService.getProductsByCategory(Integer.parseInt(categoryId));
        req.setAttribute("products", products);
        req.getRequestDispatcher(JspHelper.getPath("catalog")).forward(req, resp);
    }

}