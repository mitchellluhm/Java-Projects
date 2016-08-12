/**
 * Created by mitchell on 4/21/16.
 */

// Mitchell Luhm luhmx009
// Chang-Hsin, Wu wuxx1057
public class GreenLineSim {


    // make 2d array for train and cars
    static PQ trainAgenda = new PQ();
    public static Stop[] stops = new Stop[23];
    private static int trainAmount;
    private static int carsPerTrain;
    static TrainCar[][] trainWithCars;
    static Train[] trains;

    public static void generateStops() {
        int c = 0;
        while (c < 23) {
            stops[c] = new Stop();
            trainAgenda.add(new PassengerMaker(c+1),0);
            c++;

        }
    }

    public static void generateTrainCars(int trns, int cars) {
        int t = trns;
        int c = cars;
        int totalCars = t * c;
        int a = 0;
        while (a < t) {
            int b = 0;
            while (b < cars) {
                trainWithCars[a][b] = new TrainCar();
                b++;
            }
            a++;
        }
    }

    public static void generateTrains(int trns) {
        int c = 0;
        int stop = 1;
        int stopInc = 46 / trns;
        int dir = 1;
        trains = new Train[trns];
        while (c < trns) {
            trains[c] = new Train(carsPerTrain, dir, stop);

            trainAgenda.add(new TrainEvent(trains[c]), 180);
            c++;
            if ((stop + stopInc) > 23 && dir == 1) { //wrap around
                int a = 23 - stop;
                int b = stopInc - a;
                int d = 23 - b;
                stop = d;
                dir = 0;
            }
            else if (dir == 1) {
                stop += stopInc;
            }
            else {
                stop -= stopInc;
            }
        }
    }

    // create each stop with a passenger maker
    public static void main(String[] args) {
        generateStops(); //generate passengermaker with the stops
        trainAmount = 23;
        carsPerTrain = 3;
        generateTrains(trainAmount);
        trainWithCars = new TrainCar[trainAmount][carsPerTrain];
        generateTrainCars(trainAmount, carsPerTrain);

        while (trainAgenda.getCurrentTime() <= 15000) {
            trainAgenda.remove().run();
        }

        System.out.println("Number of Trains: " + trainAmount);
        System.out.println("Number of Cars per Train: " + carsPerTrain);
        System.out.println("Average Total Wait Time: " + Stats.getAvgTotalWaitTime()/60 + " minutes");
        System.out.println("Average Wait Time: " + Stats.getAvgWaitTime()/60 + " minutes");
        //System.out.println("Max Wait time: " + Stats.getMaxWaitTime()/60 + " minutes");
        //System.out.println("Avg Stop Time: " + Stats.getAvgStopTime() + " seconds");
        //System.out.println("Max Stop Time: " + Stats.getMaxStopTime() + " seconds");
        System.out.println("Avg People At Stop: " + Stats.getAvgPeopleWaiting() + " people");
        System.out.println("Max People Waiting: " + Stats.getMaxPeople() + " people");
//        int c = 1;
//        while (c <= 23) {
//            for (int j = 1; j <= 3; j++) {
//                generateStops(); //generate passengermaker with the stops
//                trainAmount = c;
//                carsPerTrain = j;
//                generateTrains(trainAmount);
//                trainWithCars = new TrainCar[trainAmount][carsPerTrain];
//                generateTrainCars(trainAmount, carsPerTrain);
//
//                //trainAgenda.add(new PassengerMaker(),0);
////        while (trainAgenda.getCurrentTime() <= 15000)
////            //System.out.println(trainAgenda.remove());
////            System.out.println(trainAgenda.getCurrentTime());
////            trainAgenda.remove().run();
//                while (trainAgenda.getCurrentTime() <= 12000) {
//                    //System.out.println(trainAgenda.getCurrentTime());
//                    trainAgenda.remove().run();
//
//                }
//
//                System.out.println("Number of Trains: " + trainAmount);
//                System.out.println("Number of Cars per Train: " + carsPerTrain);
//                System.out.println("Average Total Wait Time: " + Stats.getAvgTotalWaitTime()/60 + " minutes");
//                System.out.println("Average Wait Time: " + Stats.getAvgWaitTime()/60 + " minutes");
//                System.out.println("Max Wait time: " + Stats.getMaxWaitTime()/60 + " minutes");
//                System.out.println("Avg Stop Time: " + Stats.getAvgStopTime() + " seconds");
//                System.out.println("Max Stop Time: " + Stats.getMaxStopTime() + " seconds");
//                System.out.println("Avg People At Stop: " + Stats.getAvgPeopleWaiting() + " people");
//                System.out.println("Max People Waiting: " + Stats.getMaxPeople() + " people");
//                System.out.println("-------------------------------------------------------------\n");
//            }
//            c++;
//        }
    }
}
