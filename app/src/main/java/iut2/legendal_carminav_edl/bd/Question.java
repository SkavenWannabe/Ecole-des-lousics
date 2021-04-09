package iut2.legendal_carminav_edl.bd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (
        tableName = "questions"
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

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String matiere;

    @ColumnInfo(name = "nb_niveau")
    private int nbNiveau;

    private String enonce;

    @ColumnInfo(name = "bonne_reponse")
    private String bonneReponse;

    @ColumnInfo(name = "mauvaise_reponse1")
    private String mauvaiseReponse1;

    @ColumnInfo(name = "mauvaise_reponse2")
    private String mauvaiseReponse2;



}
