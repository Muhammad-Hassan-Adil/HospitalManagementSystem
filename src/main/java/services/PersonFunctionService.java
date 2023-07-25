package services;
import domain.Person;
import java.sql.*;
public class PersonFunctionService {
    public static Person getPersonByCNIC(int CNIC) throws ClassNotFoundException {
        try{
            Connection connection = DBConnectionService.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE CNIC = ?");
            preparedStatement.setInt(1, CNIC);
            ResultSet resultSet = preparedStatement.executeQuery();
            Person person = new Person();
            while (resultSet.next()){
                person.setCnic(resultSet.getInt("CNIC"));
                person.setFname(resultSet.getString("Fname"));
                person.setLname(resultSet.getString("Lname"));
                person.setAddress(resultSet.getString("address"));
                person.setPhoneNo(resultSet.getInt("phoneNo"));
                person.setDoB(resultSet.getString("DateOfBirth"));
                person.setGender(resultSet.getString("gender"));
            }
            connection.close();
            return person;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
