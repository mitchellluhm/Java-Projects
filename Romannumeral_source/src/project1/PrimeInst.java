package project1;

class PrimeInst {
	//Part 2: Primes Step 3
	// Place your methods in here
    // same as Prime, but not static

    int x = 0;

    public boolean isPrime(int p) {
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
    public int getPrime() {
        x ++;

        while (isPrime(x) != true) {
            x ++;
        }

        return x;
    }

    public void reset() {
        x = 0;
    }

    public void reset(int n) {
        x = n - 1; // because getPrime starts with x ++ so yeah
    }
    // sum next n primes
    public int sumPrimes(int n) {
        int sum = 0;
        while (n > 0) {
            n--;
            sum += Prime.getPrime();
        }
        return sum;
    }
}


