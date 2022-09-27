package classes;

import classes.Time;
import org.junit.jupiter.api.*;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    private Class<Time> timeClass;

    @BeforeEach
    public void setUp() {
        timeClass = Time.class;
    }

    @Test
    void shouldHaveNecessaryFields() {
        Field hour = null;
        Field minute = null;
        Field second = null;
        try {
            hour = timeClass.getDeclaredField("hour");
            assertNotNull(hour);

            minute = timeClass.getDeclaredField("minute");
            assertNotNull(minute);

            second = timeClass.getDeclaredField("second");
            assertNotNull(second);
        } catch (NoSuchFieldException e) {
            assertNotNull(hour);
            assertNotNull(minute);
            assertNotNull(second);
        }
    }

    @Test
    void shouldHaveNoArgsAndAllArgsConstructor() {
        Constructor<Time> noArgsConstructor = null;
        Constructor<Time> allArgsConstructor = null;
        try {
            noArgsConstructor = timeClass.getConstructor();
            assertNotNull(noArgsConstructor);

            allArgsConstructor = timeClass.getConstructor(int.class, int.class, int.class);
            assertNotNull(allArgsConstructor);

        } catch (NoSuchMethodException e) {
            assertNotNull(noArgsConstructor);
            assertNotNull(allArgsConstructor);
        }
    }

    @Test
    void shouldHaveGetterMethods() {
        Method getHour = null;
        Method getMinute = null;
        Method getSecond = null;

        try {
            getHour = timeClass.getMethod("getHour");
            assertNotNull(getHour);

            getMinute = timeClass.getMethod("getMinute");
            assertNotNull(getMinute);

            getSecond = timeClass.getMethod("getSecond");
            assertNotNull(getSecond);
        } catch (NoSuchMethodException e) {
            assertNotNull(getHour);
            assertNotNull(getMinute);
            assertNotNull(getSecond);
        }
    }

    @Test
    void shouldHaveSetterMethods() {
        Method setHour = null;
        Method setMinute = null;
        Method setSecond = null;

        try {
            setHour = timeClass.getMethod("setHour", int.class);
            assertNotNull(setHour);

            setMinute = timeClass.getMethod("setMinute", int.class);
            assertNotNull(setMinute);

            setSecond = timeClass.getMethod("setSecond", int.class);
            assertNotNull(setSecond);
        } catch (NoSuchMethodException e) {
            assertNotNull(setHour);
            assertNotNull(setMinute);
            assertNotNull(setSecond);
        }
    }

    @Test
    void shouldHaveAddMethod() {
        Method add = null;
        try {
            add = timeClass.getMethod("add", Time.class);
            assertNotNull(add);
        } catch (NoSuchMethodException e) {
            assertNotNull(add);
        }
    }

    @Test
    void shouldHaveSubtractMethod() {
        Method subtract = null;
        try {
            subtract = timeClass.getMethod("subtract", Time.class);
            assertNotNull(subtract);
        } catch (NoSuchMethodException e) {
            assertNotNull(subtract);
        }
    }

    @Test
    void shouldHaveToStringMethod() {
        Method toString = null;
        try {
            toString = timeClass.getDeclaredMethod("toString");
            assertNotNull(toString);
        } catch (NoSuchMethodException e) {
            assertNotNull(toString);
        }
    }

    @Test
    void add() {
        Time t1 = new Time(0, 0, 55);
        Time t2 = new Time(0, 0, 22);
        Assertions.assertEquals(t1.add(t2).toString(), "0:1:17");

        Time t3 = new Time(0, 57, 55);
        Time t4 = new Time(0, 30, 45);
        Assertions.assertEquals("1:28:40", t3.add(t4).toString());

        Time t5 = new Time(1, 0, 0);
        Time t6 = new Time(5, 0, 0);
        Assertions.assertEquals("6:0:0", t5.add(t6).toString());

        Time t7 = new Time(0, 55, 0);
        Time t8 = new Time(0, 5, 0);
        Assertions.assertEquals("1:0:0", t7.add(t8).toString());

        Time t9 = new Time(5, 0, 50);
        Time t10 = new Time(5, 0, 55);
        Assertions.assertEquals("10:1:45", t9.add(t10).toString());

        Time t11 = new Time(2, 20, 55);
        Time t12 = new Time(10, 5, 59);
        Assertions.assertEquals("12:26:54", t11.add(t12).toString());

        Time t13 = new Time(0, 0, 0);
        Time t14 = new Time(0, 0, 0);
        Assertions.assertEquals("0:0:0", t13.add(t14).toString());
    }

    @Test
    void subtract() {
        Time t1 = new Time(0, 0, 55);
        Time t2 = new Time(0, 0, 22);
        Assertions.assertEquals("0:0:33", t1.subtract(t2).toString());

        Time t3 = new Time(0, 57, 55);
        Time t4 = new Time(0, 30, 45);
        Assertions.assertEquals("0:27:10", t3.subtract(t4).toString());

        Time t5 = new Time(5, 0, 0);
        Time t6 = new Time(1, 0, 0);
        Assertions.assertEquals("4:0:0", t5.subtract(t6).toString());

        Time t7 = new Time(0, 55, 0);
        Time t8 = new Time(0, 5, 0);
        Assertions.assertEquals("0:50:0", t7.subtract(t8).toString());

        Time t9 = new Time(0, 0, 0);
        Time t10 = new Time(0, 0, 0);
        Assertions.assertEquals("0:0:0", t9.subtract(t10).toString());

        Time t11 = new Time(20, 0, 20);
        Time t12 = new Time(12, 0, 15);
        Assertions.assertEquals("8:0:5", t11.subtract(t12).toString());
    }
}