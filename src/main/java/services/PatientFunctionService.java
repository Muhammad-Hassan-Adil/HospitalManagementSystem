package services;
import domain.Patient;
import domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientFunctionService {
    public static void addPatient(Patient patient) throws ClassNotFoundException {
        try {
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Patient (PatientID, disease, Status, admissionDate, CNIC) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, patient.getPatientID());
            preparedStatement.setString(2, patient.getDisease());
            preparedStatement.setString(3, patient.getStatus());
            preparedStatement.setDate(4, java.sql.Date.valueOf(patient.getDateOfAdmission()));
            preparedStatement.setInt(5, patient.getCnic());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Person (CNIC, fname, lname, address, phoneNo, Date of Birth, Gender) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, patient.getCnic());
            preparedStatement.setString(2, patient.getFname());
            preparedStatement.setString(3, patient.getLname());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setInt(5, patient.getPhoneNo());
            preparedStatement.setDate(6, java.sql.Date.valueOf(patient.getDoB()));
            preparedStatement.setString(7, patient.getGender());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Patient getPatientByID(int ID) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Patient WHERE PatientID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            Patient patient = new Patient();
            while (resultSet.next()){
                patient.setPatientID(resultSet.getInt("PatientID"));
                patient.setDisease(resultSet.getString("disease"));
                patient.setStatus(resultSet.getString("Status"));
                patient.setDateOfAdmission(resultSet.getDate("admissionDate").toLocalDate());
                patient.setCnic(resultSet.getInt("CNIC"));
            }
            Person person = PersonFunctionService.getPersonByCNIC(patient.getCnic());
            patient.setDoB(person.getDoB());
            patient.setAddress(person.getAddress());
            patient.setFname(person.getFname());
            patient.setLname(person.getLname());
            patient.setPhoneNo(person.getPhoneNo());
            patient.setGender(person.getGender());
            connection.close();
            return patient;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static Patient getPatientByCNIC(int CNIC) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Patient WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            ResultSet resultSet = preparedStatement.executeQuery();
            Patient patient = new Patient();
            while (resultSet.next()){
                patient.setPatientID(resultSet.getInt("PatientID"));
                patient.setDisease(resultSet.getString("disease"));
                patient.setStatus(resultSet.getString("Status"));
                patient.setDateOfAdmission(resultSet.getDate("admissionDate").toLocalDate());
                patient.setCnic(resultSet.getInt("CNIC"));
            }
            Person person = PersonFunctionService.getPersonByCNIC(CNIC);
            patient.setDoB(person.getDoB());
            patient.setAddress(person.getAddress());
            patient.setFname(person.getFname());
            patient.setLname(person.getLname());
            patient.setPhoneNo(person.getPhoneNo());
            patient.setGender(person.getGender());
            connection.close();
            return patient;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void updatePatient(Patient patient) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Patient SET disease = ?, Status = ?, admissionDate = ? WHERE PatientID = ?");
            preparedStatement.setString(1, patient.getDisease());
            preparedStatement.setString(2, patient.getStatus());
            preparedStatement.setDate(3, java.sql.Date.valueOf(patient.getDateOfAdmission()));
            preparedStatement.setInt(4, patient.getPatientID());
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void deletePatient(int CNIC) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Patient WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static List<Patient> getAllPatients() throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Patient");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()){
                Patient patient = new Patient();
                patient.setPatientID(resultSet.getInt("PatientID"));
                patient.setDisease(resultSet.getString("disease"));
                patient.setStatus(resultSet.getString("Status"));
                patient.setDateOfAdmission(resultSet.getDate("admissionDate").toLocalDate());
                patient.setCnic(resultSet.getInt("CNIC"));
                patient.setDoB(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getDoB());
                patient.setAddress(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getAddress());
                patient.setFname(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getFname());
                patient.setLname(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getLname());
                patient.setPhoneNo(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getPhoneNo());
                patient.setGender(PersonFunctionService.getPersonByCNIC(resultSet.getInt("CNIC")).getGender());
                patients.add(patient);
            }
            connection.close();
            return patients;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}