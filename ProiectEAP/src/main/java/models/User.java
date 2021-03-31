package models;
//this class was created so that we can keep track of the users that can make requests on the database, to do so, they have to register and login using Name_login and Password
public class User {
    //table entries
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
