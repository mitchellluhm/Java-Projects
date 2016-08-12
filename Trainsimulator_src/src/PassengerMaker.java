import java.util.Random;

/**
 * Created by mitchell on 4/14/16.
 */
public class PassengerMaker implements Event {

    public PassengerMaker(int p) {
        pos = p;
    }

    // randomally determine when the next passeneger will be generated
    public double randomInterval() {

        if (pos <= 5 || pos >= 19) { //downtown stop
            arrivalRate = 20;
        }
        else if (pos >= 6 && pos<=8) { //campus stop
            arrivalRate = 25;
        }
        else {
            arrivalRate = 30;
        }

        double r = Math.random();

        if (r <= 0.1) {arrivalRate = arrivalRate + (.75 * arrivalRate);}
        else if (r <= 0.25) {arrivalRate = arrivalRate + (.50 * arrivalRate);}
        else if (r <= 0.45) {arrivalRate = arrivalRate + (.20 * arrivalRate);}
        else if (r <= 0.55) {arrivalRate = arrivalRate;}
        else if (r <= 0.75) {arrivalRate = arrivalRate - (.20 * arrivalRate);}
        else if (r <= 0.90) {arrivalRate = arrivalRate - (.50 * arrivalRate);}
        else { arrivalRate = arrivalRate - (.75 * arrivalRate);}

        return arrivalRate;
    }

    // generate a destination that is different from position
    public int generateDestination() {

        int d = -1;
        while (d != pos) {
            double typeOfStop = Math.random();
            if (typeOfStop <= 0.724637681) { //50/69
                double mplsOrSP = Math.random(); // 50/50 chance of being mpls or sp
                if (mplsOrSP > 0.5) {
                    d = rn.nextInt(5 - 1 + 1) + 1; // mpls
                } else {
                    d = rn.nextInt(23 - 19 + 1) + 19; // sp
                }
            } else if (typeOfStop <= (0.130434783 + 0.724637681)) {
                d = rn.nextInt(8 - 6 + 1) + 6;
            } else {
                d = rn.nextInt(18 - 9 + 1) + 9;
            }
        }

        return d;
    }

    // generate a direction based on position and destination
    public int generateDirection(int destination) {
        if (destination > pos) {
            dir = 1; //east
        }
        else {
            dir = 0; //west
        }
        return dir;
    }
    @Override
    public void run() {
        dest = generateDestination();
        dir = generateDirection(dest);
        double ran = randomInterval();
        GreenLineSim.trainAgenda.add(new PassengerMaker(pos), ran);
        Passenger newPassenger = new Passenger(GreenLineSim.trainAgenda.getCurrentTime(), dest, dir, pos);
    }

    double interval;
    double arrivalRate;
    private int dest;
    private int dir;
    private int pos;
    Random rn = new Random();

}
