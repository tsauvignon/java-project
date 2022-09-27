package classes;


import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Class<Timer> timerClass;

    @BeforeEach
    void setUp() {
        timerClass = Timer.class;
    }

    @Test
    void shouldInheritFromTimeable() {
        assertEquals(Timeable.class.toString(), timerClass.getSuperclass().toString());
    }

    @Test
    void shouldHavePublicGetTimeMethod() {
        Method getTime = null;
        try {
            getTime = timerClass.getMethod("getTime");
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
            setTime = timerClass.getMethod("setTime", Time.class);
            assertNotNull(setTime);

            assertTrue(Modifier.isPublic(setTime.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(setTime);
        }
    }

    @Test
    void shouldHavePublicAllArgsConstructor() {
        Constructor<Timer> allArgsConstructor = null;
        try {
            allArgsConstructor = timerClass.getDeclaredConstructor(Time.class);
            assertNotNull(allArgsConstructor);

            assertTrue(Modifier.isPublic(allArgsConstructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(allArgsConstructor);
        }
    }

    @Test
    void shouldHavePublicCountDownMethod() {
        Method countDown = null;
        try {
            countDown = timerClass.getMethod("countDown");
            assertNotNull(countDown);

            assertTrue(Modifier.isPublic(countDown.getModifiers()));
        } catch (NoSuchMethodException e) {
            assertNotNull(countDown);
        }
    }

}