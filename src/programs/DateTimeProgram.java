package programs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeProgram {

    static void main() {
        LocalDate localDate = LocalDate.of(2018, 4, 19);
        LocalTime localTime = LocalTime.of(8,27, 15);
        System.out.println();
        System.out.println(LocalDate.of(2018, 4, 19));
        System.out.println(LocalTime.of(8,27, 15));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("H:mm")));
        System.out.println();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM,dd,yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("EEE MMMM, dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("EEEE MMMM, dd, yyyy")));
        System.out.println();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("M/dd/yy")));
    }
}
