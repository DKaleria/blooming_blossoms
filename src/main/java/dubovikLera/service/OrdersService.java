package dubovikLera.service;

import dubovikLera.dao.OrdersDao;
import dubovikLera.dto.CreateOrdersDto;
import dubovikLera.mapper.CreateOrdersMapper;
import dubovikLera.utils.validation.ValidationManager;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OrdersService {
    @Getter
    private static final OrdersService INSTANCE = new OrdersService();
    private final OrdersDao ordersDao = OrdersDao.getINSTANCE();
    private  final CreateOrdersMapper ordersMapper = new CreateOrdersMapper();

    private final ValidationManager<CreateOrdersDto> validationManager = new ValidationManager();

    public Integer create(CreateOrdersDto createOrdersDto) {
        validationManager.validate(createOrdersDto);

        var ordersEntity = ordersMapper.mapFrom(createOrdersDto);
        return ordersDao.save(ordersEntity).getId();
    }
}
