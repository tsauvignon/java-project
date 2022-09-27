package classes;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
    }
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public Time add(Time t) {

        int resultHour = getHour() + t.getHour();

        int resultMinute = getMinute() + t.getMinute();

        if(resultMinute >= 60) {
            resultMinute -= 60;
            resultHour++;
        }

        int resultSecond = getSecond() + t.getSecond();

        if(resultSecond >= 60) {
            resultSecond -= 60;
            resultMinute++;
        }

        return new Time(resultHour, resultMinute, resultSecond);
    }
    public Time subtract(Time t) {
        int resultHour = getHour() - t.getHour();

        int resultMinute = getMinute() - t.getMinute();

        if(resultMinute < 0) {
            resultMinute += 60;
            resultHour--;
        }

        int resultSecond = getSecond() - t.getSecond();
        if(resultSecond < 0) {
            resultSecond += 60;
            resultMinute--;
        }

        return new Time(resultHour, resultMinute, resultSecond);
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", getHour(), getMinute(), getSecond());
    }

    public static void main(String[] args) {
        Time t1 = new Time(2, 45, 0);
        Time t2 = new Time(1, 10, 0);
        Time t3 = t1.add(t2);
        System.out.println(t3);

        Time t4 = new Time(4, 10, 0);
        Time t5 = new Time(1, 5, 0);
        Time t6 =  t4.subtract(t5);
        System.out.println(t6);
    }
}
