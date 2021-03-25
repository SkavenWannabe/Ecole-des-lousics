package iut2.legendal_carminav_edl.bd;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (
        indices = {@Index(value = {"math_level"}, unique = true)},
        primaryKeys = {"nom", "prenom"}
)
public class User implements Serializable {

    @ColumnInfo(name = "nom")
    @NonNull
    private String nom;

    @ColumnInfo(name = "prenom")
    @NonNull
    private String prenom;

    @ColumnInfo(name = "math_level")
    private int math_level;

    /*
     * Getters and Setters
     * */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getMath_level() {
        return math_level;
    }

    public void setMath_level(int math_level) {
        this.math_level = math_level;
    }
}