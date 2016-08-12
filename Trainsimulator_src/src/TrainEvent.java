/**
 * Created by mitchell on 4/14/16.
 */
public class TrainEvent implements Event {

    int time;

    public TrainEvent(Train t) {
        curTrain = t;
        time = 0;

    }

    public void updateStop() {
        if (curTrain.getStop() == 23 && curTrain.getDirection() == 1) {
            curTrain.setStop(22);
            curTrain.setDirection(0);
        }
        else if (curTrain.getStop() == 1 && curTrain.getDirection() == 0) {
            curTrain.setStop(2);
            curTrain.setDirection(1);
        }
        else if (curTrain.getDirection() == 1) {
            curTrain.setStop(curTrain.getStop() + 1);
        }
        else {
            curTrain.setStop(curTrain.getStop() - 1);
        }
    }

    public void getOff() {
        int t = curTrain.getID();
        int timeOff;
        //boolean allOff = false;
        int curCar = 0;
        int[] times = new int[curTrain.getCars()];
        while (curCar < curTrain.getCars()) {

            int c = 0;
            timeOff = 0;
            for (int i = 0; i < 50; i++) { //GreenLineSim.trainWithCars.length before 50 was there


                //Passenger curPas = GreenLineSim.trainWithCars[t - 1][curCar].getPassenger(c);
                //if (curPas != null) {
//                System.out.println(t-1 + " the t");
//                System.out.println(curCar + " the car");
//                System.out.println(GreenLineSim.trainWithCars[t-1][curCar] + "-------------");
////                System.out.println(GreenLineSim.trainWithCars[t-1][curCar].toString());
//                System.out.println(i);
                if (GreenLineSim.trainWithCars[t-1][curCar] != null) {
                    Passenger curPas = GreenLineSim.trainWithCars[t - 1][curCar].getPassenger(i);

                    if (GreenLineSim.trainWithCars[t - 1][curCar].getPassenger(i) != null) {
                        //Passenger curPas = GreenLineSim.trainWithCars[t - 1][curCar].getPassenger(i);
                        //System.out.println(curPas.getDestination() + " pas des");
                        //System.out.println(curTrain.getStop() + " train's stop");
                        if (curPas.getDestination() == curTrain.getStop()) {
                            timeOff += 2;

                            Stats.updateTotalWaitTime(GreenLineSim.trainAgenda.getCurrentTime()-curPas.getArrivalTime());
                            //GreenLineSim.trainWithCars[t - 1][curCar] = null; //
                            GreenLineSim.trainWithCars[t-1][curCar].exit(curPas);
                            // do stat thing here
                        }
                    }
                }
            }

            times[curCar] = timeOff;
            curCar++;
        }
        int max = 0;
        for (int j = 0; j < times.length; j++) {
            if (times[j] > max) {
                max = times[j];
            }
        }
        time += max;
    }

    public void getOn() {
        int curCar = 0;
        int t = curTrain.getID()-1;
        int timeOn = 0;
        Q1 loadingQ;

        if (curTrain.getDirection() == 1) {
            loadingQ = GreenLineSim.stops[t].getEastbound();
        }
        else {
            loadingQ = GreenLineSim.stops[t].getWestbound();
        }

        while (curCar < curTrain.getCars()) {
//            System.out.println(t + " the T");
//            System.out.println(curCar + " the car");
//            System.out.println(GreenLineSim.trainWithCars[t][curCar]);
            if (GreenLineSim.trainWithCars[t][curCar] != null) {
                while (!GreenLineSim.trainWithCars[t][curCar].isFull() && loadingQ.length() > 0) {
                    Passenger nextPas = (Passenger)loadingQ.remove();
                    double waitTimeForTrain = GreenLineSim.trainAgenda.getCurrentTime() - nextPas.getArrivalTime();
                    Stats.updateWaitTime(waitTimeForTrain);
                    //GreenLineSim.trainWithCars[t][curCar].enter((Passenger) loadingQ.remove());
                    GreenLineSim.trainWithCars[t][curCar].enter(nextPas);
                    timeOn += 1;
                }
            }
            curCar++;

        }

        if (curTrain.getDirection() == 1) {
            GreenLineSim.stops[t].setEastbound(loadingQ);
        }
        else {
            GreenLineSim.stops[t].setWestbound(loadingQ);
        }

        time += timeOn;

        //while (!GreenLineSim.trainWithCars[t][curCar].isFull() || GreenLineSim.stops[t].)

        //GreenLineSim.stops[curTrain.getID()-1]

    }
    @Override
    public void run() {

        updateStop();
        if (curTrain.getDirection() == 1)
            Stats.updateAvgPeopleWaiting(GreenLineSim.stops[curTrain.getStop()-1].getEastbound().length());
        else Stats.updateAvgPeopleWaiting(GreenLineSim.stops[curTrain.getStop()-1].getWestbound().length());
        //System.out.println(curTrain.getID() + " train is at " + curTrain.getStop());
        //double startTime = GreenLineSim.trainAgenda.getCurrentTime();
        getOff();
        getOn();
        int addedTime;
        if (time > 15) {
            addedTime = time;
        }
        else {
            addedTime = 15;
        }
        Stats.updateAvgStopTime(addedTime);


        GreenLineSim.trainAgenda.add(new TrainEvent(curTrain), 180 + addedTime);


    }

    private Train curTrain;
    //private static int countPasOff = 0;

}
