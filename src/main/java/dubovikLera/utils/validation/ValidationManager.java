package dubovikLera.utils.validation;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationManager<T> {

    public void validate(T t) {
        ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validationFactory.getValidator();
        Set<ConstraintViolation<T>> validationResult = validator.validate(t);

        if (!validationResult.isEmpty()) {
            throw new ConstraintViolationException(validationResult);
        }
    }
}