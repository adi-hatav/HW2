public class Clock {


    protected int hours, minutes,seconds;
    protected final int MAX_HOUR = 23;
    protected final int MAX_MINUTES = 60;
    protected final int MINUTES_A_DAY = 1440;
    protected final int DOESNT_HAVE_SECONDS = -1;

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public Clock(int hours, int minutes) {
        this.hours = (hours > MAX_HOUR || hours < 0) ? 0 : hours;
        this.minutes = (minutes >= MAX_MINUTES || minutes < 0) ? 0 : minutes;
        this.seconds=DOESNT_HAVE_SECONDS;

    }

    @Override
    public boolean equals(Object other) {
        if ((!(other instanceof Clock))||(((Clock) other).getSeconds()!=DOESNT_HAVE_SECONDS))
            return false;
        Clock c=(Clock)other;
        return this.hours == c.getHours() && this.minutes == c.getMinutes();
    }
    @Override
    public int hashCode()
    {
        return MAX_MINUTES*this.hours+this.minutes;
    }
    @Override
    public String toString()
    {
        String clockString = (this.hours<10)? "0"+this.hours:""+this.hours;
        clockString += (this.minutes<10)? ":0"+this.minutes:":"+this.minutes;
        return clockString;
    }
}
