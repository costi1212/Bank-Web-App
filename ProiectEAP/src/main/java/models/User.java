package models;

public class User {

    private String idUser;
    private String Nume_login;
    private String Password;


    public User(String idUser, String nume_login, String password) {
        this.idUser = idUser;
        Nume_login = nume_login;
        Password = password;
    }

    public User( String nume_login, String password) {
        Nume_login = nume_login;
        Password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNume_login() {
        return Nume_login;
    }

    public void setNume_login(String nume_login) {
        Nume_login = nume_login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
