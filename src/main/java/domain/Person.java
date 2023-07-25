package domain;
import java.time.LocalDate;

public class Person {
    private String Fname, Lname, address, DoB;
    private int cnic, phoneNo;
    private Gender gender;
    public Person(){}
    public Person(String fname, String Lname, String Address, int cnic, int phoneNo, String date, Gender gender){
        this.Fname = fname;
        this.Lname = Lname;
        this.address = Address;
        this.cnic = cnic;
        this.phoneNo = phoneNo;
        this.DoB = date;
        this.gender = gender;
    }

    public void setFname(String fname){ this.Fname = fname; }
    public void setLname(String lname){ this.Lname = lname; }
    public void setAddress(String address){ this.address = address; }
    public void setCnic(int cnic){ this.cnic = cnic; }
    public void setPhoneNo(int phoneNo){ this.phoneNo = phoneNo; }
    public void setDoB(String DoB){ this.DoB = DoB; }
    public void setGender(String gender){ this.gender = Gender.valueOf(gender);}
    public String getFname(){ return this.Fname; }
    public String getLname(){ return this.Lname; }
    public String getAddress(){ return this.address; }
    public int getCnic(){ return this.cnic; }
    public int getPhoneNo(){ return this.phoneNo; }
    public String getDoB(){ return this.DoB; }
    public String getGender(){ return this.gender.toString(); }

}

enum Gender{
    Male,
    Female,
    Other
}
