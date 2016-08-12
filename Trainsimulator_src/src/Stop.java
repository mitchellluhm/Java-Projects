/**
 * Created by mitchell on 4/14/16.
 */
public class Stop {

    static int stopNumber = 0;
    private int stopID;

    private Q1 westbound = new Q1();
    private Q1 eastbound = new Q1();

    public Stop() {
        stopNumber++;
        stopID = stopNumber; //stop's id number (1 is target field then to 23)
    }

    public void enter(Passenger p) { // maybe static?
        if (p.getDirection() == 0) {
            westbound.add(p);
        } // 0 is westbound 1 is eastbound
        else {
            eastbound.add(p);
        }
    }

    public Q1 getWestbound() {
        return westbound;
    }

    public Q1 getEastbound() {
        return eastbound;
    }

    public void setWestbound(Q1 q) {
        westbound = q;
    }

    public void setEastbound(Q1 q) {
        eastbound = q;
    }
}
