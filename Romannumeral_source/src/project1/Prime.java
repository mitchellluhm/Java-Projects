package project1;

public class Prime {
  //Part 2: Primes
  //Place your methods in here

    static int x = 0;

    public static boolean isPrime(int p) {
        if (p > 1) {
            boolean check = false; // false = prime | true = not prime
            int c = 2;
            while (c < p && check == false) {
                if (p % c == 0){
                    check = true;
                }
                c ++;
            }
            if (check == true) {
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }


    // this returns the next prime number in order
    public static int getPrime() {
        x ++;

        while (isPrime(x) != true) {
            x ++;
        }

        return x;
    }

    public static void reset() {
        x = 0;
    }

    public static void reset(int n) {
        x = n - 1; // because getPrime starts with x ++ so yeah
    }
    // sum next n primes
    public static int sumPrimes(int n) {
        int sum = 0;
        while (n > 0) {
            n--;
            sum += Prime.getPrime();
        }
        return sum;
    }

    public static void main(String[] args) {
        /*Prime test = new Prime();
        Prime test1 = new Prime();


        System.out.println(test.getPrime());
        System.out.println(Prime.getPrime());
        System.out.println(test1.getPrime());
        System.out.println(test.getPrime());

        test.reset();

        System.out.println(test.sumPrimes(4));
        System.out.println(test.getPrime());*/

    }
}
