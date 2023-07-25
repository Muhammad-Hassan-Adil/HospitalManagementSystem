package domain;

import java.time.LocalDate;

public class Admin extends Person{
    private String username, password;
    public Admin(){}
    public Admin(String fname, String Lname, String Address, int cnic, int phoneNo,
                 LocalDate dob, Gender gender, String username, String password){
        super(fname, Lname, Address, cnic, phoneNo, dob, gender);
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }
    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }
}
