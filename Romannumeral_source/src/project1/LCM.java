package project1;

public class LCM {
	//Part 3: Number with LCM
	//Note: As per the instructions, make sure this class is instantiable

    private int num;

    public LCM(int num) {
        this.num = num;
    }

    public int getLCM(int n) {
        int[] storeNums1 = new int[num + n]; //arrays are num + n so they are always long enough
        int[] storeNums2 = new int[num + n];
        int mult = 0;
        int ind = 0;
        int m = 1;
        boolean inList = false;
        while (inList == false) {
            storeNums1[ind] = num * m;
            storeNums2[ind] = n * m;
            ind ++;
            m ++;
            for (int i = 0; i < storeNums1.length; i++) {
                for (int i2 = 0; i2 < storeNums2.length; i2++) {
                    if (storeNums1[i] == storeNums2[i2] && storeNums1[i] != 0 ) { //&& != 0 because there are 0's in the empty array space
                        inList = true;
                        mult = storeNums1[i];
                    }
                }
            }
        }
        return mult;
    }

    public int getGCD (int n) {
        int d =1;
        int biggest = 0;
        int ind1 = 0;
        int ind2 = 0;
        int[] storeNums1 = new int[num + n];
        int[] storeNums2 = new int[num + n];
        while (d < num + n) {
            if (n % d == 0) {
                storeNums1[ind1] = d;
                ind1 ++;
            }
            if (num % d == 0) {
                storeNums2[ind2] = d;
                ind2 ++;
            }
            d ++;
            for (int i = 0; i < storeNums1.length; i++) {
                for (int i2 = 0; i2 < storeNums2.length; i2++) {
                    if (storeNums1[i] == storeNums2[i2] && storeNums1[i] > biggest) {
                        biggest = storeNums1[i];
                    }
                }
            }
        }
        return biggest;
    }

    public int getRatio(int n) {
        return this.getLCM(n) / this.getGCD(n);
    }

    public static void main(String[] args) {
        LCM t = new LCM(6);
        System.out.println(t.getRatio(4));
    }
}
