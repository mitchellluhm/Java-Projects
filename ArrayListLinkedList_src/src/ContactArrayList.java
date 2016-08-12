/**
 * Created by mitchell on 3/30/16.
 */
public class ContactArrayList {

    MyArrayList conList;

    public ContactArrayList() {
        conList = new MyArrayList();
    }

    int ptr = -1;

    public boolean add(Contact c) {
        ptr = conList.size();
        return conList.add(c);

    }

    public Contact find(String name) {
        int i = 0;
        boolean found = false;
        while (i < conList.size() && !found) {
            Contact c = (Contact) conList.get(i);
            if (c.getName().contains(name)) {
                found = true;
            }
            else {
                i++;
            }
        }
        ptr = i;
        return (Contact) conList.get(i);
    }

    public Contact remove(){
        Contact c = (Contact) conList.get(ptr);
        conList.remove(c);
        ptr--;
        return c;
    }

    public Contact getCurrent() {
        return (Contact) conList.get(ptr);
    }

    public Contact get(int i) {

        return (Contact) conList.get(i);
    }

    public Contact next() {
        if (ptr == conList.size() - 1) {
            ptr = 0;
            return (Contact) conList.get(ptr);
        }
        else {
            ptr++;
            return (Contact) conList.get(ptr);
        }
    }

    public Contact previous() {
        if (ptr == 0) {
            ptr = conList.size() - 1;
            return (Contact) conList.get(ptr);
        }
        else {
            ptr--;
            return (Contact) conList.get(ptr);
        }
    }

    public void sort() {
        Contact n;

        int i = 1;
        while(i < conList.size()){
            int j = i - 1;
            n = (Contact) conList.get(i);
            while(j >=0 && (n.getName().compareTo(((Contact) conList.get(j)).getName()) < 0)){
                conList.set(j + 1, conList.get(j));
                conList.set(j, n);
                j --;
            }
            i ++;
        }
        this.conList.display();
    }

    public boolean addInOrder(Contact c) {
        boolean r = conList.add(c);
        this.sort();
        return r;
    }



    public static void main(String[] args) {
        ContactArrayList test = new ContactArrayList();
        Contact test2 = new Contact("Bob", 651111, "123 this street", "no comments");
        Contact test3 = new Contact("Mitchell", 651366, "sanford", "hello");
        Contact test4 = new Contact("Cory", 651111, "123 this street", "no comments");
        Contact test5 = new Contact("Dillian", 651111, "123 this street", "no comments");
        Contact test6 = new Contact("Edgar", 651111, "123 this street", "no comments");

        test.add(test2);
        test.add(test3);
        test.add(test4);
        test.add(test5);
        //test.add(test6);
        System.out.println(test.find("Bob") + " found bob");
        System.out.println(test.find("Mitch") + " found mitchell");
        System.out.println(test.getCurrent() + " got current");
        System.out.println(test.next() + " is next");
        System.out.println(test.previous() + " is previous");
        System.out.println(test.remove() + " was removed");

        test.sort();

        test.addInOrder(test6);
    }
}
