package services;
import java.sql.*;

public class DBTablesService {
    public static boolean createDocTable() throws ClassNotFoundException {
        Connection connection = DBConnectionService.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Doctor (" +
                    "DoctorID INT AUTO_INCREMENT PRIMARY KEY," +
                    "speciality VARCHAR(50)," +
                    "qualification VARCHAR(100)," +
                    "department VARCHAR(50)," +
                    "shift VARCHAR(20)," +
                    "status VARCHAR(20)," +
                    "username VARCHAR(50)," +
                    "password VARCHAR(50)," +
                    "experience INT," +
                    "dateOfJoining VARCHAR(10)," +
                    "CNIC INT," +
                    "FOREIGN KEY (CNIC) REFERENCES PERSON(CNIC)" +
                    ")");
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createPatientTable() throws ClassNotFoundException {
        Connection connection = DBConnectionService.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Patient (" +
                    "PatientID INT AUTO_INCREMENT PRIMARY KEY," +
                    "disease VARCHAR(50)," +
                    "Status VARCHAR(20)," +
                    "admissionDate VARCHAR(10)," +
                    "CNIC INT," +
                    "FOREIGN KEY (CNIC) REFERENCES PERSON(CNIC)" +
                    ")");
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createAdminTable() throws ClassNotFoundException {
        Connection connection = DBConnectionService.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Admin (" +
                    "username VARCHAR(50) PRIMARY KEY," +
                    "password VARCHAR(50)," +
                    "CNIC INT," +
                    "FOREIGN KEY (CNIC) REFERENCES PERSON(CNIC)" +
                    ")");
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createPersonTable() throws ClassNotFoundException{
        Connection connection = DBConnectionService.getConnection();
        try{
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXIST Person(" +
                    "CNIC INT PRIMARY KEY," +
                    "fname VARCHAR(50)," +
                    "lname VARCHAR(50)," +
                    "address VARCHAR(100)," +
                    "phoneNo INT," +
                    "DateofBirth VARCHAR(10)," +
                    "Gender VARCHAR(10)," +
                    ")");
            statement.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
