/**
 * Created by mitchell on 3/23/16.
 */
import java.util.Arrays;


public class MyArrayList implements MyList {

    Object[] oArray;

    public MyArrayList() {
        // default constructor that creates an array of Objects of size 2
        oArray = new Object[2];
    }

    public void growArray(Object[] oArr) {
        Object[] tempArray = new Object[oArray.length * 2];
        for (int i=0; i < oArr.length; i++) {
            if (oArr[i] != null) {
                tempArray[i] = oArr[i];
            }
        }
        oArray = tempArray;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        else {
            int pos = 0; // default location to add something
            int i = oArray.length-1;
            if (oArray[i] == null) {
                while (i > 0 && oArray[i] == null) {
                    if (oArray[i-1] != null) {
                        pos = i;
                    }
                    i--;
                }
            }
            else {
                pos = oArray.length;
                this.growArray(oArray);
            }
            oArray[pos] = o;
            return true;
        }
    }

    public int lastIndex(Object[] a) {
        int end = 0;
        int i = 0;
        while (i < a.length && a[i] != null) {
            end = i;
            i++;
        }
        return end;
    }

    @Override
    public boolean insert(int index, Object o) {
        if((index > this.lastIndex(oArray)) || (index < 0) || (o == null)) { // invalid insertion input
            return false;
        }
        else {
            if (oArray[index] == null) { // if open, just insert ??? is n where the list or the array ends????
                oArray[index] = o;
            }
            else {
                if (oArray[oArray.length-1] == null) { // if there the last spot is null, no need to gow array
                    for(int i=oArray.length-1; i > index; i--) {
                        oArray[i] = oArray[i-1];
                    }
                }
                else { //grow array
                    Object[] tempArray = new Object[oArray.length+1];
                    for (int i=0; i < oArray.length; i++) {
                        if (i >= index) {
                            tempArray[i + 1] = oArray[i];
                        }
                        else {
                            tempArray[i] = oArray[i];
                        }
                    }
                    oArray = tempArray;
                }

            }
                oArray[index] = o;
        }
            return true;
    }



    @Override
    public void clear() {
        Object[] tempArray = new Object[2];
        oArray = tempArray;
    }

    @Override
    public boolean contains(Object o) {
        boolean inList = false;
        for(int i=0; i < oArray.length; i++) {
            if (oArray[i] == o && o != null) {
                inList = true;
            }
        }
        if (inList) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index <= this.lastIndex(oArray)) {
            return oArray[index];
        }
        else {
            return null;
        }
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        int ind = 0;
        boolean found = false;
        while (!found && i <= this.lastIndex(oArray)) {
            if (oArray[i] == o) {
                found = true;
                ind = i;
            }
            i++;
        }
        if (found) {
            return ind;
        }
        else {
            return -1;
        }
    }

    @Override
    public boolean isEmpty() {
        if (oArray[0] == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object remove(int index) {
        Object removed = oArray[index];
        for(int i=index; i < this.lastIndex(oArray); i++) {
            oArray[i] = oArray[i+1];
        }
        oArray[this.lastIndex(oArray)] = null;
        return removed;
    }

    @Override
    public boolean remove(Object o) {
        int i = 0;
        int ind = 0;
        boolean found = false;
        while (!found && i <= this.lastIndex(oArray)) {
            if (oArray[i] == o) {
                found = true;
                this.remove(i);
            }
            i++;
        }
        if (found) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void set(int index, Object o) {
        if (o != null && index >= 0 && index <= this.lastIndex(oArray)) {
            oArray[index] = o;
        }
    }

    @Override
    public int size() {
        if (this.lastIndex(oArray) != 0) {
            return this.lastIndex(oArray) + 1;
        }
        else {
            return 0;
        }
    }

    public void display() {
        System.out.println(Arrays.toString(this.oArray));
    }

    public static void main(String[] args) {
        MyArrayList test = new MyArrayList();
        test.add(1);
        test.add(2);
        test.add(3);

        System.out.println(Arrays.toString(test.oArray));
        //test.clear();
        test.remove(0);
        test.insert(0,3);
        System.out.println(test.indexOf(2));
        test.insert(1,5);

        System.out.println(Arrays.toString(test.oArray));
    }
}
