package models;
//this class was created so that users can transfer money betwwent themselves, but only if they are "friends" with each other
public class Prieteni {
    //table entries
    String idPrieten;
    String Useri_idUser;
    String Nume_Utilizator;
    //constructor with arguments
    public Prieteni(String idPrieten, String useri_idUser, String nume_Utilizator) {
        this.idPrieten = idPrieten;
        Useri_idUser = useri_idUser;
        Nume_Utilizator = nume_Utilizator;
    }
    //getters and setters
    public String getIdPrieten() {
        return idPrieten;
    }

    public void setIdPrieten(String idPrieten) {
        this.idPrieten = idPrieten;
    }

    public String getUseri_idUser() {
        return Useri_idUser;
    }

    public void setUseri_idUser(String useri_idUser) {
        Useri_idUser = useri_idUser;
    }

    public String getNume_Utilizator() {
        return Nume_Utilizator;
    }

    public void setNume_Utilizator(String nume_Utilizator) {
        Nume_Utilizator = nume_Utilizator;
    }
}
