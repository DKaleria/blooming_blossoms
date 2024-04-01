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

import java.io.IOException;
import java.util.List;

import static dubovikLera.utils.UrlPath.CATALOG;

@WebServlet(CATALOG)
public class ProductsCatalogServlet extends HttpServlet {
    private final ProductsService productsService = ProductsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductsDto> productsDtoList = productsService.getAllProducts();
        req.setAttribute("products", productsDtoList);
        req.getRequestDispatcher(JspHelper.getPath("catalog")).forward(req, resp);

    }
}
