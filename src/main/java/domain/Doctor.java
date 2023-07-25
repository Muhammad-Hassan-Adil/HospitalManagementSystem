package domain;

public class Doctor extends Person{
    private String speciality, qualification, department, shift, status, username, password, dateOfJoining;
    private int experience, DoctorID;
    public Doctor(){}
    public Doctor(String fname, String Lname, String Address, int cnic, int phoneNo, String dob,
                  Gender gender, String speciality, int experience, String qualification,
                  String department, String shift, String status, String username, String password, String dateOfJoining){
        super(fname, Lname, Address, cnic, phoneNo, dob, gender);
        this.speciality = speciality;
        this.experience = experience;
        this.qualification = qualification;
        this.department = department;
        this.shift = shift;
        this.status = status;
        this.username = username;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
    }

    public void setSpeciality(String speciality){ this.speciality = speciality; }
    public void setExperience(int experience){ this.experience = experience; }
    public void setQualification(String qualification){ this.qualification = qualification; }
    public void setDepartment(String department){ this.department = department; }
    public void setShift(String shift){ this.shift = shift; }
    public void setStatus(String status){ this.status = status; }
    public void setUsername(String username){ this.username = username; }
    public void setPassword(String password){ this.password = password; }
    public void setDateOfJoining(String dateOfJoining){ this.dateOfJoining = dateOfJoining; }
    public void setDoctorID(int DoctorID){ this.DoctorID = DoctorID; }
    public String getSpeciality(){ return this.speciality; }
    public int getExperience(){ return this.experience; }
    public String getQualification(){ return this.qualification; }
    public String getDepartment(){ return this.department; }
    public String getShift(){ return this.shift; }
    public String getStatus(){ return this.status; }
    public int getDoctorID(){ return this.DoctorID; }
    public String getUsername(){ return this.username; }
    public String getPassword(){ return this.password; }
    public String getDateOfJoining(){ return this.dateOfJoining; }
}
