/**
 * Created by mitchell on 4/25/16.
 */
public class Stats {

    public static void updateTotalWaitTime (double time) {
        totalTime += time;
        totalPassengers++;
    }

    public static void updateWaitTime(double time) {
        totalTimeWait += time;
        totalPassengersWait++;

        if (time > maxWaitTime)
            maxWaitTime = time;
    }

    public static void updateAvgStopTime(double time) {
        totalStopTime += time;
        totalStops++;

        if (time > maxStopTime)
            maxStopTime = time;
    }

    public static void updateAvgPeopleWaiting(double people) {
        peopleAtStop += people;
        pasStops++;

        if (people > maxPeople)
            maxPeople = people;
    }

    public static double getMaxPeople() {
        return maxPeople;
    }
    public static double getAvgPeopleWaiting() {
        return peopleAtStop / pasStops;
    }

    public static double getMaxStopTime() {
        return maxStopTime;
    }

    public static double getAvgStopTime() {
        return totalStopTime / totalStops;
    }

    public static double getMaxWaitTime() {
        return maxWaitTime;
    }

    public static double getAvgWaitTime() {
        return totalTimeWait / totalPassengersWait;
    }

    public static double getAvgTotalWaitTime() {
        System.out.println(totalPassengers + " total passengers that have reached their destination");
        return totalTime / totalPassengers;
    }

    private static double totalPassengers = 0;
    private static double totalTime = 0;
    private static double maxWaitTime = 0;
    private static double totalPassengersWait = 0;
    private static double totalTimeWait = 0;
    private static double totalStopTime = 0;
    private static double totalStops = 0;
    private static double maxStopTime = 0;
    private static double peopleAtStop = 0;
    private static double pasStops = 0;
    private static double maxPeople = 0;
}
