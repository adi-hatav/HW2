/**
 * Represents a clock that has only hours and minutes.
 */
public class Clock {


    protected int hours, minutes;
    protected final int MAX_HOUR = 23;
    protected final int MAX_MINUTES = 60;
    protected final int MINUTES_A_DAY = 1440;

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }


    /**
     * clock constructor, if a parameter is invalid it places 0 instead.
     *
     * @param hours   the clock's hour
     * @param minutes the clock's minutes
     */
    public Clock(int hours, int minutes) {
        this.hours = (hours > MAX_HOUR || hours < 0) ? 0 : hours;
        this.minutes = (minutes >= MAX_MINUTES || minutes < 0) ? 0 : minutes;

    }

    /**
     * Checks if other object is equal to current clock.
     *
     * @param other object to be compared to
     * @return true if the other object has the same hour and minute and false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if ((!(other instanceof Clock)) || other.hashCode() >= MINUTES_A_DAY)
            return false;
        Clock c = (Clock) other;
        return this.hours == c.getHours() && this.minutes == c.getMinutes();
    }

    /**
     * Returns hash code that represent this clock.
     */
    @Override
    public int hashCode() {
        return MAX_MINUTES * this.hours + this.minutes;
    }

    /**
     * @return string of the clock in this format - HH:MM
     */
    @Override
    public String toString() {
        String clockString = (this.hours < 10) ? "0" + this.hours : "" + this.hours;
        clockString += (this.minutes < 10) ? ":0" + this.minutes : ":" + this.minutes;
        return clockString;
    }
}
