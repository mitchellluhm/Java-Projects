/**
 * Created by kuang048 on 2/24/16.
 */
public class Contact {
    private String name;
    private long phone;
    private String address;
    private String comments;

    public Contact(String n, long p, String a, String c) {
        name = n;
        phone = p;
        address = a;
        comments = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (phone != contact.phone) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        return !(comments != null ? !comments.equals(contact.comments) : contact.comments != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (int) (phone ^ (phone >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
//        Contact test = new Contact("Bob", 651111, "123 this street", "no comments");
//        System.out.println(test.toString());
//        Contact test2 = new Contact("Bob", 61111, "123 this street", "no comments");
//        System.out.println(test.equals(test2));
//    }
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
        }
    }
}
