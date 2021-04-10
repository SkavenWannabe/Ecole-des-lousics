package iut2.legendal_carminav_edl.bd;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (
        tableName = "questions",
        primaryKeys = {"matiere", "nb_niveau", "enonce"}
)
public class Question implements Serializable {

    public Question(String matiere, int nbNiveau, String enonce, String bonneReponse, String mauvaiseReponse1, String mauvaiseReponse2) {
        this.matiere = matiere;
        this.nbNiveau = nbNiveau;
        this.enonce = enonce;
        this.bonneReponse = bonneReponse;
        this.mauvaiseReponse1 = mauvaiseReponse1;
        this.mauvaiseReponse2 = mauvaiseReponse2;
    }

    @NonNull
    private String matiere;

    @NonNull
    @ColumnInfo(name = "nb_niveau")
    private int nbNiveau;

    @NonNull
    private String enonce;

    @ColumnInfo(name = "bonne_reponse")
    private String bonneReponse;

    @ColumnInfo(name = "mauvaise_reponse1")
    private String mauvaiseReponse1;

    @ColumnInfo(name = "mauvaise_reponse2")
    private String mauvaiseReponse2;

    @Ignore
    private String responseUser;

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getNbNiveau() {
        return nbNiveau;
    }

    public void setNbNiveau(int nbNiveau) {
        this.nbNiveau = nbNiveau;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public String getMauvaiseReponse1() {
        return mauvaiseReponse1;
    }

    public void setMauvaiseReponse1(String mauvaiseReponse1) {
        this.mauvaiseReponse1 = mauvaiseReponse1;
    }

    public String getMauvaiseReponse2() {
        return mauvaiseReponse2;
    }

    public void setMauvaiseReponse2(String mauvaiseReponse2) {
        this.mauvaiseReponse2 = mauvaiseReponse2;
    }

    public String getResponseUser() {
        return responseUser;
    }

    public void setResponseUser(String responseUser) {
        this.responseUser = responseUser;
    }
}
