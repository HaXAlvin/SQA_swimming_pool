package main;

import org.junit.jupiter.api.*;
import java.lang.reflect.*;

public class QueryTest {
    @DisplayName("私有建構子")
    @Nested
    class PrivateConstructor {
        @Test
        void testConstructorIsPrivate() throws NoSuchMethodException {
            Constructor<Query> constructor = Query.class.getDeclaredConstructor();
            Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            Assertions.assertThrows(Exception.class,()->{
                constructor.newInstance();
            });
        }
    }
    @DisplayName("Check")
    @Nested
    class CheckTest{
        @Test
        void checkAgeTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

            Assertions.assertEquals(5,Query.checkAge(5));
        }

    }
}
