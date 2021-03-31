package repositories;

import models.Account;
import utils.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    //method that returns a user's accounts as a list of accounts in order to be used in other operations
    public static List<Account> getAllAccountsForUser(String idUser) throws SQLException {

        Statement statement = DbConnection.getConnection().createStatement();//we connect to the database and create a statement
        String sql = "SELECT * FROM bankappdb.account WHERE idUser like '" + idUser + "'";//sql command to select all elements from the accounts belonging to the user idUser

        ResultSet resultSet = statement.executeQuery(sql);

        List<Account> accounts = new ArrayList<>();

        while (resultSet.next()) //while the user has accounts place the data in a new account and add it to the list
        {
            Account account = new Account(
                    resultSet.getString("idaccount"),
                    resultSet.getString("amount"),
                    resultSet.getString("valuta"),
                    resultSet.getString("nrCard")
            );
            accounts.add(account);

        }
        return accounts;

    }
    public static void increase_amount(Account account,String suma_de_adaugat) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();//we connect to the database and create a statement
        String sql = "UPDATE account SET amount='" + account.adaugare_suma(suma_de_adaugat) + "'WHERE (nrCard like'" + account.getNrCard() + "')and (idUser like'"+ account.getIdUser() + "');";
        statement.execute(sql);
    }
    public static void decrease_amount(Account account,String suma_de_extras) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();//we connect to the database and create a statement
        String sql = "UPDATE account SET amount='" + account.extragere_suma(suma_de_extras) + "'WHERE (nrCard like'" + account.getNrCard() + "')and (idUser like'"+ account.getIdUser() + "');";
        statement.execute(sql);
    }
    public static Account findAccoutbynrCard(String nrCard) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();//we connect to the database and create a statement
        String sql = "SELECT * FROM account WHERE nrCard like'" + nrCard + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Account account = new Account(
                    resultSet.getString("idaccount"),
                    resultSet.getString("idUser"),
                    resultSet.getString("amount"),
                    resultSet.getString("valuta"),
                    resultSet.getString("nrCard")
            );
            return account;
        }
        return null;

    }
}
