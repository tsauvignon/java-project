package classes;

import classes.Time;

public abstract class Timeable {
    protected Time time;
    public Timeable(Time time) {
        this.time = time;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time t) {
        time = t;
    }
    public void reset() {
        time.setHour(0);
        time.setMinute(0);
        time.setSecond(0);
    }
}
