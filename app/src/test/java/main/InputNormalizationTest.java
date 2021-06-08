package main;
import org.junit.jupiter.api.*;
public class InputNormalizationTest {
    @DisplayName("時間解析測試")
    @Nested
    class TimeExtractTest{
        @Test
         void extractHourTest(){
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals(14,InputNormalization.extractHour(dateTime));
        }
        @Test
         void extractMinTest(){
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals(30,InputNormalization.extractMin(dateTime));
        }
        @Test
         void extractWeekTest(){
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals("週三",InputNormalization.extractWeek(dateTime));
        }
    }
}
