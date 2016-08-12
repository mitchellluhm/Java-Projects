/**
 * Created by mitchell on 4/14/16.
 */
public class Train {

    //This is an instantiable class for each train on the green line.
    //Each train will have a few train cars associated with it, a direction, and a current stop

    static int trainNumber = 0;
    private int cars;
    private int direction;
    private int stop;
    private int trainID;


    public Train (int cars, int initDirection, int initStop) {
        trainNumber++;
        trainID = trainNumber;
        this.cars = cars;
        this.direction = initDirection;
        this.stop = initStop;

        int c = cars;
        while(c > 0) {
           TrainCar test = new TrainCar();
            c--;
        }
    }

    public int getID() {
        return trainID;
    }

    public int getCars() {
        return cars;
    }

    public int getStop() {
        return stop;
    }

    public int getDirection() {
        return direction;
    }

    public void setStop(int s) {
        stop = s;
    }

    public void setDirection(int d) {
        direction = d;
    }
}
