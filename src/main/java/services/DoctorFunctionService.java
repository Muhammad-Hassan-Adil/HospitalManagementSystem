package services;
import domain.Doctor;
import domain.Person;
import java.sql.*;
public class DoctorFunctionService {
    public static void addDoctor(Doctor doctor) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Doctor (speciality, qualification, department, shift, status, username, password, experience, dateOfJoining, CNIC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, doctor.getSpeciality());
            preparedStatement.setString(2, doctor.getQualification());
            preparedStatement.setString(3, doctor.getDepartment());
            preparedStatement.setString(4, doctor.getShift());
            preparedStatement.setString(5, doctor.getStatus());
            preparedStatement.setString(6, doctor.getUsername());
            preparedStatement.setString(7, doctor.getPassword());
            preparedStatement.setInt(8, doctor.getExperience());
            preparedStatement.setDate(9, java.sql.Date.valueOf(doctor.getDateOfJoining()));
            preparedStatement.setInt(10, doctor.getCnic());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Person (CNIC, fname, lname, address, phoneNo, Date of Birth, Gender) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, doctor.getCnic());
            preparedStatement.setString(2, doctor.getFname());
            preparedStatement.setString(3, doctor.getLname());
            preparedStatement.setString(4, doctor.getAddress());
            preparedStatement.setInt(5, doctor.getPhoneNo());
            preparedStatement.setDate(6, java.sql.Date.valueOf(doctor.getDoB()));
            preparedStatement.setString(7, doctor.getGender());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Doctor getDoctorByID(int ID) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctor WHERE DoctorID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            Doctor doctor = new Doctor();
            while (resultSet.next()){
                doctor.setDoctorID(resultSet.getInt("DoctorID"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setDepartment(resultSet.getString("department"));
                doctor.setShift(resultSet.getString("shift"));
                doctor.setStatus(resultSet.getString("status"));
                doctor.setUsername(resultSet.getString("username"));
                doctor.setPassword(resultSet.getString("password"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setDateOfJoining(resultSet.getString("dateOfJoining"));
                doctor.setCnic(resultSet.getInt("CNIC"));
            }
            Person person = PersonFunctionService.getPersonByCNIC(doctor.getCnic());
            doctor.setDoB(person.getDoB());
            doctor.setAddress(person.getAddress());
            doctor.setFname(person.getFname());
            doctor.setLname(person.getLname());
            doctor.setPhoneNo(person.getPhoneNo());
            doctor.setGender(person.getGender());
            connection.close();
            return doctor;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Doctor getDoctorByCNIC(int CNIC) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctor WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            ResultSet resultSet = preparedStatement.executeQuery();
            Doctor doctor = new Doctor();
            while (resultSet.next()){
                doctor.setDoctorID(resultSet.getInt("DoctorID"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setDepartment(resultSet.getString("department"));
                doctor.setShift(resultSet.getString("shift"));
                doctor.setStatus(resultSet.getString("status"));
                doctor.setUsername(resultSet.getString("username"));
                doctor.setPassword(resultSet.getString("password"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setDateOfJoining(resultSet.getString("dateOfJoining"));
                doctor.setCnic(resultSet.getInt("CNIC"));
            }
            Person person = PersonFunctionService.getPersonByCNIC(CNIC);
            doctor.setDoB(person.getDoB());
            doctor.setAddress(person.getAddress());
            doctor.setFname(person.getFname());
            doctor.setLname(person.getLname());
            doctor.setPhoneNo(person.getPhoneNo());
            doctor.setGender(person.getGender());
            connection.close();
            return doctor;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Doctor getDoctorByUsername(String username) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Doctor WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            Doctor doctor = new Doctor();
            while (resultSet.next()){
                doctor.setDoctorID(resultSet.getInt("DoctorID"));
                doctor.setSpeciality(resultSet.getString("speciality"));
                doctor.setQualification(resultSet.getString("qualification"));
                doctor.setDepartment(resultSet.getString("department"));
                doctor.setShift(resultSet.getString("shift"));
                doctor.setStatus(resultSet.getString("status"));
                doctor.setUsername(resultSet.getString("username"));
                doctor.setPassword(resultSet.getString("password"));
                doctor.setExperience(resultSet.getInt("experience"));
                doctor.setDateOfJoining(resultSet.getString("dateOfJoining"));
                doctor.setCnic(resultSet.getInt("CNIC"));
            }
            Person person = PersonFunctionService.getPersonByCNIC(doctor.getCnic());
            doctor.setDoB(person.getDoB());
            doctor.setAddress(person.getAddress());
            doctor.setFname(person.getFname());
            doctor.setLname(person.getLname());
            doctor.setPhoneNo(person.getPhoneNo());
            doctor.setGender(person.getGender());
            connection.close();
            return doctor;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void updateDoctorByCNIC(Doctor doctor) throws ClassNotFoundException{
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Doctor SET speciality = ?, qualification = ?, department = ?, shift = ?, status = ?, username = ?, password = ?, experience = ?, dateOfJoining = ? WHERE CNIC = ?");
            preparedStatement.setString(1, doctor.getSpeciality());
            preparedStatement.setString(2, doctor.getQualification());
            preparedStatement.setString(3, doctor.getDepartment());
            preparedStatement.setString(4, doctor.getShift());
            preparedStatement.setString(5, doctor.getStatus());
            preparedStatement.setString(6, doctor.getUsername());
            preparedStatement.setString(7, doctor.getPassword());
            preparedStatement.setInt(8, doctor.getExperience());
            preparedStatement.setDate(9, java.sql.Date.valueOf(doctor.getDateOfJoining()));
            preparedStatement.setInt(10, doctor.getCnic());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Person (CNIC, fname, lname, address, phoneNo, Date of Birth, Gender) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, doctor.getCnic());
            preparedStatement.setString(2, doctor.getFname());
            preparedStatement.setString(3, doctor.getLname());
            preparedStatement.setString(4, doctor.getAddress());
            preparedStatement.setInt(5, doctor.getPhoneNo());
            preparedStatement.setDate(6, java.sql.Date.valueOf(doctor.getDoB()));
            preparedStatement.setString(7, doctor.getGender());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteDoctorByCnic(int CNIC) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Doctor WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
