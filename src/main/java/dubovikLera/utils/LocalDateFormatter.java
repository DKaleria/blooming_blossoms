package dubovikLera.utils;

import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@UtilityClass
public class LocalDateFormatter {

    public @NotNull(message = "Order_date must not be null") Timestamp format(String date) {
        return Timestamp.valueOf(LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
    public boolean isValid(String date){
        try{
            return Optional.ofNullable(date)
                    .map(LocalDateFormatter::format)
                    .isPresent();
        }catch (DateTimeParseException exception){
            return false;
        }
    }
}
