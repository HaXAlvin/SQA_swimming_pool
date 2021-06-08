package main;
import org.junit.jupiter.api.*;

import java.lang.reflect.*;

public class InputNormalizationTest {
    @DisplayName("時間解析測試")
    @Nested
    class TimeExtractTest {
        @Test
        void extractHourTest() {
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals(14, InputNormalization.extractHour(dateTime));
        }

        @Test
        void extractMinTest() {
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals(30, InputNormalization.extractMin(dateTime));
        }

        @Test
        void extractWeekTest() {
            String dateTime = "2021-05-26 週三 14:30:00";
            Assertions.assertEquals("週三", InputNormalization.extractWeek(dateTime));
        }
    }

    @DisplayName("私有建構子")
    @Nested
    class PrivateConstructor {
        @Test
        void testConstructorIsPrivate() throws NoSuchMethodException {
            Constructor<InputNormalization> constructor = InputNormalization.class.getDeclaredConstructor();
            Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            Assertions.assertThrows(Exception.class,()->{
                constructor.newInstance();
            });
        }
    }
    @DisplayName("Getter And Setter")
    @Nested
    class GetterAndSetter{
        @Test
        void boolTrueTest(){
            InputNormalization.setBool(true);
            Assertions.assertTrue(InputNormalization.getBool());
        }
        @Test
        void boolFalseTest(){
            InputNormalization.setBool(false);
            Assertions.assertFalse(InputNormalization.getBool());
        }
        @Test
        void digitalTest(){
            InputNormalization.setDigital(10);
            Assertions.assertEquals(10,InputNormalization.getDigital());
            InputNormalization.setDigital(1);
            Assertions.assertEquals(1,InputNormalization.getDigital());
        }
    }
}
