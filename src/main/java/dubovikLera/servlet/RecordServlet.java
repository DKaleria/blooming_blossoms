package dubovikLera.servlet;

import dubovikLera.dto.CreateCustomersDto;
import dubovikLera.dto.CreateOrdersDto;
import dubovikLera.entity.Customers;
import dubovikLera.entity.enums.StatusDelivery;
import dubovikLera.entity.enums.StatusPayment;
import dubovikLera.exception.ValidationException;
import dubovikLera.service.CustomersService;
import dubovikLera.service.OrdersService;
import dubovikLera.utils.LocalDateFormatter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/record")
public class RecordServlet extends HttpServlet {
    private final OrdersService ordersService = OrdersService.getINSTANCE();
    private final CustomersService customersService = CustomersService.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            var customerDto = CreateCustomersDto.builder()
                    .first_name(request.getParameter("first_name"))
                    .last_name(request.getParameter("last_name"))
                    .delivery_address(request.getParameter("address_delivery"))
                    .contact_details(request.getParameter("phone_number"))
                    .build();

            var customer = customersService.create(customerDto);

            var ordersDto = CreateOrdersDto.builder()
                    .order_date(LocalDateFormatter.format(request.getParameter("order_date")))
                    .status_payment(StatusPayment.EXPOSED)
                    .status_delivery(StatusDelivery.СОБРАН)
                    .customer_id(customer)
                    .build();

            ordersService.create(ordersDto);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("Заказ успешно создан!");
        } catch (ValidationException e) {
            request.setAttribute("errors", e.getErrors());
            doGet(request, response);
        }
    }
}