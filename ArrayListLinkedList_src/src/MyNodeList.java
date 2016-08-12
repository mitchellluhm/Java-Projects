/**
 * Created by mitchell on 3/26/16.
 */
public class MyNodeList implements MyList {

    Node first;

    public MyNodeList() {
        // creates empty list with just header
        first = null;
    }
    @Override
    public boolean add(Object o) {
        if (o == null) {
            return false;
        }
        else {
            Node item = new Node(o);
            item.setNext(first);
            first = item;
            return true;
        }
    }

    @Override
    public boolean insert(int index, Object o) {
        if (index < 0 || index >= this.size() || o == null) {
            return false;
        }
        else {
            Node current = first;
            this.add(first.getData());
            int j = this.size() - 2;
            while (j > index) {
                this.set(j, current.getNext().getData());
                current = current.getNext();
                j--;
            }
            current.setData(o);
            return true;
        }
    }

    @Override
    public void clear() {
        first.setData(null);
    }

    @Override
    public boolean contains(Object o) {
        boolean inList = false;
        Node current = first;
        int j = this.size()-1;
        while (j >= 0 && !inList) {
            if (current.getData() == o) {
                inList = true;
            }
            current = current.getNext();
            j--;
        }
        if (o == null || !inList) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= this.size() || index < 0){
            return null;
        }
        else {
            Node current = first;
            int j = this.size() - 1;
            while (j > index) {
                current = current.getNext();
                j--;
            }
            return current.getData();
        }
    }

    @Override
    public int indexOf(Object o) {
        boolean found = false;
        Node current = first;
        int j = this.size() - 1;
        while (j >= 0 && !found) {
            if (current.getData() == o) {
                found = true;
            }
            current = current.getNext();
            j--;
        }
        if (o == null || !found) {
            return -1;
        }
        else {
            return j+1;
        }
    }

    @Override
    public boolean isEmpty() {
        if (first.getData() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object remove(int index) {
        Node current = first;
        int j =  this.size() -1;
        if (index == j) {

            Object top = first.getData(); //

            first = first.getNext();

            return top;
        }
        else {
            while (j > index + 1) {
                current = current.getNext();
                j--;
            }
            Node temp = current.getNext();
            current.setNext(current.getNext().getNext());
            return temp.getData();
        }
    }

    @Override
    public boolean remove(Object o) {
        boolean found = false;
        Node current = first;
        int j = this.size() - 1;
        while (j >= 0 && !found) {
            if (current.getData() == o) {
                found = true;
            }
            else {
                current = current.getNext();
                j--;
            }
        }
        if (found) {
            this.remove(j);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void set(int index, Object o) {
        Node current = first;
        int c = this.size()-1;

        while (c > index) {
            current = current.getNext();
            c--;
        }

        while (index >= 0) {
            current.setData(o);
            if (index != 0) {
                o = current.getNext().getData();

                current = current.getNext();
            }
            index--;
        }

    }

    @Override
    public int size() {
        int c = 0;
        Node current = first;

        while (current != null) {
            current = current.getNext();
            c++;
        }

        return c;
    }

    public void display() {
        Node current = first;
        if (current.getData() != null) {
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }

    public static void main(String[] args) {
        MyNodeList test = new MyNodeList();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.insert(2,7);
        test.display();
        test.remove(1);
        test.remove((Object) 4);
        System.out.println(test.size() + ": size");
        System.out.println(test.get(1));
        test.display();
        //test.clear();
        System.out.println(test.size());


//        MyNodeList temp = test;
//        temp.display();

    }
}
