/**
 * Created by mitchell on 4/14/16.
 */
public class Passenger {
    //arriveTime, destination, direction
    public Passenger(double time, int dest, int dir, int initalPos) {
        arrivalTime = time;
        destination = dest;
        direction = dir;
        position = initalPos;
        pNum++;
        //System.out.println(pNum);
        GreenLineSim.stops[position-1].enter(this);
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public int getDestination() {
        return destination;
    }

    public int getDirection() {
        return direction;
    }

    public int getPosition() {
        return position;
    }

    private double arrivalTime;
    private int destination;
    private int direction;
    private int position;
    private static int pNum = 0;

}
