package domain;
import java.time.LocalDate;
public class Patient extends Person{
    String disease, status, dateOfAdmission;
    int patientID;
    public Patient(){}
    public Patient(String fname, String Lname, String Address, int cnic, int phoneNo, String dob,
                   Gender gender, String disease, String status, String dateOfAdmission){
        super(fname, Lname, Address, cnic, phoneNo, dob, gender);
        this.disease = disease;
        this.status = status;
        this.dateOfAdmission = dateOfAdmission;
    }
    public void setDisease(String disease){ this.disease = disease; }
    public void setStatus(String status){ this.status = status; }
    public void setDateOfAdmission(String dateOfAdmission){ this.dateOfAdmission = dateOfAdmission; }
    public void setPatientID(int patientID){ this.patientID = patientID; }
    public String getDisease(){ return this.disease; }
    public String getStatus(){ return this.status; }
    public int getPatientID(){ return this.patientID; }
    public String getDateOfAdmission(){ return this.dateOfAdmission; }
}
