package in.edu.reva.myapplication;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class User {

    public String name;
    public String email;
    public String usn;
    public String pno;
    public String regamount;
    public String ename;
    public String colName;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String email, String usn, String pno, String regamount, String ename, String colName) {
        this.name = name;
        this.email = email;
        this.usn = usn;
        this.pno = pno;
        this.regamount = regamount;
        this.ename = ename;
        this.colName = colName;

    }
}