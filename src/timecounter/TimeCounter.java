package timecounter;

public class TimeCounter {
    private long maxTime = 0;
    private long minTime = 0;
    private long lapTimeStamp;
    private long startTime;
    private long totalTime;
    public int nbLaps;

    public void start() {
        startTime = System.nanoTime();
        lapTimeStamp = System.nanoTime();
        nbLaps = 0;
    }
    
    public void stop() {
        totalTime = (System.nanoTime() - startTime);
    }
    
    public void lap() {
        long court = (System.nanoTime() - lapTimeStamp);
        if (maxTime == 0 && minTime == 0) {
            maxTime = court;
            minTime = court;
        }
        
        if (court > maxTime) {
            maxTime = court;
        }
         if (court < minTime) {
             minTime = court;
         }
         nbLaps++;
         lapTimeStamp = System.nanoTime();
    }
    
    public long getAverageTime() {
        return totalTime / nbLaps;
    }

    public long getTotalTime() {
        return totalTime;
    }
    
    public long getMaxTime() {
        return maxTime;
    }

    public long getMinTime() {
        return minTime;
    }
    
    public String toString() {
        String value = "Performance diagnosis: " + "\n" +
        "duration = " + getTotalTime() + "\n" +
        "number of laps = " + nbLaps + "\n" +
        "average lap duration = " + getAverageTime() + "\n" +
        "fastest lap = " + getMinTime() + "\n" +
        "slowest lap = " + getMaxTime();
        return value;
    }
}
