package dubovikLera.service;

import dubovikLera.dao.CustomersDao;
import dubovikLera.dto.CreateCustomersDto;
import dubovikLera.entity.Customers;
import dubovikLera.entity.Products;
import dubovikLera.mapper.CreateCustomersMapper;
import dubovikLera.utils.validation.ValidationManager;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
@NoArgsConstructor(access = PRIVATE)
public class CustomersService {

    @Getter
    private static final CustomersService INSTANCE = new CustomersService();
    private final CustomersDao customersDao = CustomersDao.getINSTANCE();
    private  final CreateCustomersMapper customersMapper = new CreateCustomersMapper();

    private final ValidationManager<CreateCustomersDto> validationManager = new ValidationManager();

    public Customers create(CreateCustomersDto createCustomersDto) {
        validationManager.validate(createCustomersDto);

        var customersEntity = customersMapper.mapFrom(createCustomersDto);
        return customersDao.save(customersEntity);
    }



}
