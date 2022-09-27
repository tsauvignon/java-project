package classes;

import classes.Time;
import classes.Timeable;

public class Timer extends Timeable {
    public Timer(Time time) {
        super(time);
    }
    public void countDown() {
        throw new UnsupportedOperationException();
    }
}
