package iut2.legendal_carminav_edl.bd;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (
        primaryKeys = {"nom", "prenom"}
)
public class User implements Serializable {

    @ColumnInfo(name = "nom")
    @NonNull
    private String nom;

    @ColumnInfo(name = "prenom")
    @NonNull
    private String prenom;

    @ColumnInfo(name = "math_add_level")
    private int math_add_level;

    @ColumnInfo(name = "math_div_level")
    private int math_div_level;

    @ColumnInfo(name = "math_sub_level")
    private int math_sub_level;

    @ColumnInfo(name = "math_mul_level")
    private int math_mul_level;

    @ColumnInfo(name = "culture_level")
    private int culture_level;

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

    public String getNomComplet() {
        return getPrenom() + " " + getNom();
    }

    public int getMath_add_level() {
        return math_add_level;
    }

    public void setMath_add_level(int math_add_level) {
        this.math_add_level = math_add_level;
    }

    public int getMath_div_level() {
        return math_div_level;
    }

    public void setMath_div_level(int math_div_level) {
        this.math_div_level = math_div_level;
    }

    public int getMath_sub_level() {
        return math_sub_level;
    }

    public void setMath_sub_level(int math_sub_level) {
        this.math_sub_level = math_sub_level;
    }

    public int getMath_mul_level() {
        return math_mul_level;
    }

    public void setMath_mul_level(int math_mul_level) {
        this.math_mul_level = math_mul_level;
    }

    public int getCulture_level() {
        return culture_level;
    }

    public void setCulture_level(int culture_level) {
        this.culture_level = culture_level;
    }

    @Override
    public String toString() {
        return getNomComplet();
    }
}