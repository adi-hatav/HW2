/**
 * Represents an accurate clock that has hours, minutes and seconds.
 */
public class AccurateClock extends Clock {

    private final int MAX_SECONDS = 60;

    /**
     * accurate clock constructor, sets ita hours and minutes using super class.
     * sets its seconds.
     * if a parameter is invalid it places 0 instead.
     *
     * @param hours   the clock's hour
     * @param minutes the clock's minutes
     * @param seconds the clock's seconds
     */
    public AccurateClock(int hours, int minutes, int seconds) {
        super(hours, minutes);
        this.seconds = (seconds >= MAX_SECONDS || seconds < 0) ? 0 : seconds;

    }

    /**
     * Checks if other object is equal to current accurate clock.
     *
     * @param other object to be compared to
     * @return true if the other object has the same hour, minute and seconds and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AccurateClock))
            return false;
        AccurateClock ac = (AccurateClock) other;
        return this.hours == ac.getHours() && this.minutes == ac.getMinutes() && this.seconds == ac.getSeconds();
    }

    /**
     * Returns hash code that represent this clock.
     */
    @Override
    public int hashCode() {
        return super.hashCode() + this.seconds + MINUTES_A_DAY + this.seconds * MINUTES_A_DAY;
    }

    /**
     * @return string of the clock in this format - HH:MM:SS
     */
    @Override
    public String toString() {
        String AccurateClockString = super.toString();
        AccurateClockString += (this.seconds < 10) ? ":0" + this.seconds : ":" + this.seconds;
        return AccurateClockString;
    }
}
