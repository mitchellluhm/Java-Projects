/**
 * Created by mitchell on 4/14/16.
 */
public class TrainCar {

    Passenger[] ridersInCar;

    public TrainCar() {
        ridersInCar = new Passenger[50];
    }

    public Passenger getPassenger(int ind) {
        if (ridersInCar[ind] == null) {
            return null;
        }
        else {
            return ridersInCar[ind];
        }

    }

    public boolean isFull() {
        boolean nullInArray = false;
        for (int i=0; i < ridersInCar.length; i++) {
            if (ridersInCar[i] == null) {
                nullInArray = true;
            }
        }
        if (nullInArray) {
            return false;
        }
        else {
            return true;
        }
    }

    public void enter(Passenger p) {
        int c = 0;
        boolean foundNull = false;
        while (!foundNull && c < ridersInCar.length) {
            if (ridersInCar[c] == null){
                foundNull = true;
                ridersInCar[c] = p;
            }
            else {
                c++;
            }
        }
    }

    public void exit(Passenger p) {
        int c = 0;
        int l = 0;
        boolean foundPas = false;
        while (!foundPas) {
            if (p.equals(ridersInCar[c])){
                l = c;
            foundPas = true;
            }
            c++;
        }
        ridersInCar[l] = null;
    }

    public int totalPassengersIn() {
        int c = 0;
        int p = 0;
        while(c < ridersInCar.length) {
            if (ridersInCar[c] != null)
                p++;
            c++;
        }
        return p;
    }


}
