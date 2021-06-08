package main;

import org.junit.jupiter.api.*;
import java.lang.reflect.*;

public class QueryTest {
    @DisplayName("私有建構子")
    @Nested
    class PrivateConstructor {
        @Test
        void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Constructor<Query> constructor = Query.class.getDeclaredConstructor();
            Assertions.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            Assertions.assertThrows(Exception.class,()->{
                constructor.newInstance();
            });
        }
    }
}
