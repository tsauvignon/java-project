package classes;

import classes.Stopwatch;
import classes.Time;
import classes.Timeable;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class StopwatchTest {
    private Class<Stopwatch> stopwatchClass;

    @BeforeEach
    void setUp() {
        stopwatchClass = Stopwatch.class;
    }

    @Test
    void shouldInheritFromTimeable() {
        assertEquals(Timeable.class.toString(), stopwatchClass.getSuperclass().toString());
    }

    @Test
    void shouldHaveGetTimeMethod() {
        Method getTime = null;
        try {
            getTime = stopwatchClass.getMethod("getTime");
            assertNotNull(getTime);
        } catch (NoSuchMethodException e) {
            assertNotNull(getTime);
        }
    }

    @Test
    void shouldHavePublicSetTimeMethod() {
        Method setTime = null;
        try {
            setTime = stopwatchClass.getMethod("setTime", Time.class);
            assertNotNull(setTime);

            assertTrue(Modifier.isPublic(setTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(setTime);
        }
    }

    @Test
    void shouldHavePublicAllArgsConstructor() {
        Constructor<Stopwatch> allArgsConstructor = null;
        try {
            allArgsConstructor = stopwatchClass.getDeclaredConstructor(Time.class);
            assertNotNull(allArgsConstructor);

            assertTrue(Modifier.isPublic(allArgsConstructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(allArgsConstructor);
        }
    }

    @Test
    void shouldHavePublicCountUpMethod() {
        Method countUp = null;
        try {

            countUp = stopwatchClass.getMethod("countUp");
            assertNotNull(countUp);

            assertTrue(Modifier.isPublic(countUp.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(countUp);
        }
    }
}