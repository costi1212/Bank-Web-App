package repositories;

import models.Account;
import utils.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public static List<Account> getAllAccountsForUser(String idUser) throws SQLException {

        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "SELECT * FROM bankappdb.account WHERE idUser like '" + idUser + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        List<Account> accounts = new ArrayList<>();

        while (resultSet.next()) {
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
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "UPDATE account SET amount='" + account.adaugare_suma(suma_de_adaugat) + "'WHERE (nrCard like'" + account.getNrCard() + "')and (idUser like'"+ account.getIdUser() + "');";
        statement.execute(sql);
    }
    public static void decrease_amount(Account account,String suma_de_extras) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
        String sql = "UPDATE account SET amount='" + account.extragere_suma(suma_de_extras) + "'WHERE (nrCard like'" + account.getNrCard() + "')and (idUser like'"+ account.getIdUser() + "');";
        statement.execute(sql);
    }
    public static Account findAccoutbynrCard(String nrCard) throws SQLException {
        Statement statement = DbConnection.getConnection().createStatement();
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
