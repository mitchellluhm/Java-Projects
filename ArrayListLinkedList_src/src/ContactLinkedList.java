/**
 * Created by mitchell on 3/30/16.
 */
public class ContactLinkedList {
    MyNodeList conList;

    public ContactLinkedList() {
        conList = new MyNodeList();
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
            } else {
                i++;
            }
        }
        ptr = i;
        return (Contact) conList.get(i);
    }

    public Contact remove() {
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
        } else {
            ptr++;
            return (Contact) conList.get(ptr);
        }
    }

    public Contact previous() {
        if (ptr == 0) {
            ptr = conList.size() - 1;
            return (Contact) conList.get(ptr);
        } else {
            ptr--;
            return (Contact) conList.get(ptr);
        }
    }

    public void sort() {
        Contact cTemp;
        int i = 0;

        int changes = 0;
        boolean notMakeChange = false;
        int size = conList.size();

        while (!notMakeChange) {
            changes = 0;

            for (i = 0; i < size - 1; i++) {
                Contact c = (Contact) conList.get(i);
                Contact c2 = (Contact) conList.get(i + 1);
                if ((c != null && c2 != null && c.getName().compareTo(c2.getName()) > 0)) {
                    cTemp = c2;
                    conList.set(i + 1, c);
                    conList.set(i, cTemp);
                    changes++;
                }

            }

            if (changes == 0) {
                notMakeChange = true;
            }
        }
        conList.display();
    }

    public boolean addInOrder(Contact c) {
        boolean r = conList.add(c);
        this.sort();
        return r;
    }


    public static void main(String[] args) {
        ContactLinkedList test = new ContactLinkedList();
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
