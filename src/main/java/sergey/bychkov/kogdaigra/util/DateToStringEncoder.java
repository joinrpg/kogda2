package sergey.bychkov.kogdaigra.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.vaadin.flow.templatemodel.ModelEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Converts between DateTime-objects and their String-representations
 *
 */
public class DateToStringEncoder
        implements ModelEncoder<Date, String> {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public Date decode(String presentationValue) {
        Date result = null;
        try {
            result = DATE_FORMAT.parse(presentationValue);
        } catch (ParseException ex) {
            Logger.getLogger(DateToStringEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public String encode(Date modelValue) {
        return modelValue == null ? null : DATE_FORMAT.format(modelValue);
    }

}
