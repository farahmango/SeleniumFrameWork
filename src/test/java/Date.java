import org.testng.annotations.Test;
import utils.DateUtils;
import java.time.LocalDate;
import java.time.LocalTime;

public class Date {

    @Test
    public void getTheCurrentDate() {
        LocalDate date = DateUtils.getTheCurrentDate();
        System.out.println(date);
    }
    @Test
    public void getTheCurrentTime() {
        LocalTime date = DateUtils.getTheCurrentTime();
        System.out.println(date);
    }
    @Test
    public void dateFormatter() {
      LocalDate date = DateUtils.getTheCurrentDate();
       String dateFormat =  DateUtils.dateFormatter(date,"dd-MMM-YYY");
       System.out.println(dateFormat);
    }

    @Test
    public void timeFormatter() {
        LocalTime time = DateUtils.getTheCurrentTime();
        String dateFormat =  DateUtils.timeFormatter(time,"hh:mm:a");
        System.out.println(dateFormat);
    }


    @Test
    public void getSpecificDate() {
        LocalDate date = DateUtils.getSpecificDate(2025,04,05);
        String dateFormat =  DateUtils.dateFormatter(date,"dd MMM YYYY");
        System.out.println(dateFormat);
    }

    @Test
    public void getTheSpecificTime() {
        LocalTime time = DateUtils.getTheSpecificTime(17, 30, 45);
        String dateFormat =  DateUtils.timeFormatter(time,"hh:mm a");
        System.out.println(dateFormat);
    }

    @Test
    public void isTheYearLeap() {
        boolean leapYear = DateUtils.isTheYearLeap();
        System.out.println(leapYear);
    }
}
