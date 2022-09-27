package classes;

import classes.Stopwatch;
import classes.Time;
import classes.Timeable;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class TimeableTest {
    private Class<Timeable> timeableClass;

    @BeforeEach
    void setUp() {
        timeableClass = Timeable.class;
    }

    @Test
    void shouldBeAbstract() {
        assertTrue(Modifier.isAbstract(timeableClass.getModifiers()));
    }

    @Test
    void shouldHaveProtectedTimeField() {
        Field time = null;
        try {
            time = timeableClass.getDeclaredField("time");
            assertNotNull(time);
            assertTrue(Modifier.isProtected(time.getModifiers()));
        } catch (NoSuchFieldException e) {
            assertNotNull(time);
        }
    }

    @Test
    void shouldHavePublicGetTimeMethod() {
        Method getTime = null;
        try {
            getTime = timeableClass.getDeclaredMethod("getTime");
            assertNotNull(getTime);

            assertTrue(Modifier.isPublic(getTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(getTime);
        }
    }

    @Test
    void shouldHavePublicSetTimeMethod() {
        Method setTime = null;
        try {
            setTime = timeableClass.getDeclaredMethod("setTime", Time.class);
            assertNotNull(setTime);

            assertTrue(Modifier.isPublic(setTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(setTime);
        }
    }

    @Test
    void shouldHavePublicResetMethod() {
        Method reset = null;
        try {
            reset = timeableClass.getDeclaredMethod("reset");
            assertNotNull(reset);

            assertTrue(Modifier.isPublic(reset.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(reset);
        }
    }

    @Test
    void shouldResetTime() {
        Stopwatch stopwatch = new Stopwatch(new Time(5, 20, 0));
        stopwatch.reset();
        Assertions.assertEquals("0:0:0", stopwatch.getTime().toString());
    }

    @Test
    void shouldHavePublicAllArgsConstructor() {
        Constructor<Timeable> allArgsConstructor = null;
        try {
            allArgsConstructor = timeableClass.getDeclaredConstructor(Time.class);
            assertNotNull(allArgsConstructor);

            assertTrue(Modifier.isPublic(allArgsConstructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(allArgsConstructor);
        }
    }

}