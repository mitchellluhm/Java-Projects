package project1;

public class RomanNumeral {
    //Part 1: Roman Numeral
    //place your methods in here
    int iVal, permVal;
    static String UNDEFINED = "-100";

    public RomanNumeral(int integerValue) {
        permVal = integerValue;
        iVal = permVal;

    }

    public String toString() {
        String r = "";
        if (iVal > 0 && iVal <=2500) {
            int z = 0;
            //THOUSANDS
            if (iVal >= 1000) {
                z = iVal / 1000;
                iVal = iVal % 1000;
            }
            while (z > 0) {
                z--;
                r += "M";
            }

            // HUNDREDS

            if (iVal >= 100 && iVal <= 999) {
                if (iVal < 400) {
                    z = iVal / 100;
                }
                else if (iVal < 900) {
                    if (iVal < 500) {
                        r += "CD";
                    }
                    else {
                        r += "D";
                        z = (iVal - 500) / 100;
                    }
                }
                else if (iVal >= 900 && iVal <= 999) {
                    r += "CM";
                }
                iVal = iVal % 100;
            }
            while (z > 0) {
                z--;
                r += "C";
            }

            // TENS
            if (iVal < 40) {
                z = iVal / 10;
            }
            else if (iVal >= 40 && iVal < 90) {
                if (iVal < 50) {
                    r += "XL";
                }
                else {
                    r += "L";
                    z = (iVal - 50) / 10;
                }
            }
            else if (iVal >= 90 && iVal <= 99) {
                //int h = iVal % 100;
                r += "XC";
            }
            while (z > 0) {
                z--;
                r += "X";
            }

            //ONES

            int c = iVal % 10;

            iVal = iVal % 10;

            if (iVal <= 3 && iVal > 0) {
                r += "I";
                while (c > 1) {
                    r += "I";
                    c--;
                }
            }
            else if (iVal > 4 && iVal <9) {
                r += "V";
                while (c > 5) {
                    r += "I";
                    c--;
                }
            }
            else if (iVal == 4) {
                r += "IV";
            }
            else if (iVal == 9) {
                r += "IX";
            }
            return r;
        }
        else {
            return UNDEFINED;
        }
    }

    public int toInt() {
        return permVal;
    }

    public int compareTo(RomanNumeral r) {
        // -1 less | 0 same | 1 more
        if (r.toInt() > this.toInt()) {
            return -1;
        }
        else if (r.toInt() == this.toInt()) {
            return 0;
        }
        else {
            return 1;
        }
    }


    public static void main(String[] args) {
        RomanNumeral r1 = new RomanNumeral(2400);
        System.out.println(r1.toString());
        System.out.println(r1.toInt());
        RomanNumeral r2 = new RomanNumeral(250);
        System.out.println(r1.compareTo(r2));
    }


}
