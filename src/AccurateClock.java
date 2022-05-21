public class AccurateClock extends Clock {

    private final int MAX_SECONDS = 60;


    public AccurateClock(int hours, int minutes, int seconds) {
        super(hours,minutes);
        this.seconds = (seconds >= MAX_SECONDS || seconds < 0) ? 0 : seconds;

    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AccurateClock))
            return false;
        AccurateClock ac=(AccurateClock)other;
        return this.hours == ac.getHours() && this.minutes == ac.getMinutes() && this.seconds == ac.getSeconds();
    }
    @Override
    public int hashCode()
    {
        return super.hashCode()+this.seconds+MINUTES_A_DAY+this.seconds*MINUTES_A_DAY;
    }
    @Override
    public String toString()
    {
        String AccurateClockString = super.toString();
        AccurateClockString += (this.seconds<10)? ":0"+this.seconds:":"+this.seconds;
        return AccurateClockString;
    }
}
