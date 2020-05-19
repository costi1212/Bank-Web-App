package repositories;

import models.User;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {



    public static String getUserByUsername(String Username) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM user WHERE Nume_login like '" + Username + "'";
        ResultSet resultSet=statement.executeQuery(sql);

        if(resultSet.next()){
            String UserId=resultSet.getString("idUser");
            return UserId;
        }
        return null;
    }


    public static void registerUser(User user) throws SQLException {
        String sql = "INSERT INTO user(nume_login, password) VALUES(?, ?)";
        PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getNume_login());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.execute();
    }


    public static User findByNume_login(String  Nume_login) throws SQLException {

            Statement statement = DbConnection.getConnection().createStatement();
            String sql = "SELECT * FROM user WHERE Nume_login like '" + Nume_login + "'";

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                User user = new User(
                        resultSet.getString("idUser"),
                        resultSet.getString("password"),
                        resultSet.getString("Nume_login")
                );
                return user;
            } else
                return null;
        }


    public static User userLogin(String userName, String userPassword) throws SQLException {

        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM user WHERE Nume_login like '" + userName + "'" + " and password like '" + userPassword + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            User user = new User(
                    resultSet.getString("idUser"),
                    resultSet.getString("password"),
                    resultSet.getString("Nume_login")
            );
            return user;
        } else
            return null;

    }
}
