/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.util;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author bychkov-sy
 */
public class Util {

    public static Integer getCurrentYear() {
        LocalDate date = LocalDate.now();
        return date.getYear();
    }

    public static List<String> numsToStrings(@NotNull Collection<? extends Number> list) {        
        return list.stream().map(String::valueOf).collect(Collectors.toList());
    }
    
    public static String getMonth(Integer num){
        Month m = Month.of(num);
        return m.toString();
    }
        
}
