/**
 * Created by kuang048 on 3/9/16.
 */
import java.io.Serializable;

public class newContact extends Contact {

    String email;
    String group;
    String quickRef;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getQuickRef() {
        return quickRef;
    }

    public void setQuickRef(String quickRef) {
        this.quickRef = quickRef;
    }

    public newContact(String em, String grp, String qr, String n, long p, String a, String c) {
        super(n, p, a, c);
        email = em;
        group = grp;
        quickRef = qr;
    }

    public String toString() {
        return "Contact{" +
                "name='" + getName() + '\'' +
                ", phone=" + getPhone() +
                ", address='" + getAddress() + '\'' +
                ", comments='" + getComments() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", group='" + getGroup() + '\'' +
                ", quickRef='" + getQuickRef() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof newContact)) return false;
        if (!super.equals(o)) return false;

        newContact that = (newContact) o;

        if (!getEmail().equals(that.getEmail())) return false;
        if (!getGroup().equals(that.getGroup())) return false;
        return getQuickRef().equals(that.getQuickRef());

    }


}
