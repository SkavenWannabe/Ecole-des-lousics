package iut2.legendal_carminav_edl.bd;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        tableName = "matieres"
)
public class Matiere implements Serializable {

    public Matiere(String nom, int nbNiveaux) {
        this.nom = nom;
        this.nbNiveaux = nbNiveaux;
    }

    @NonNull
    @PrimaryKey
    private String nom;

    @ColumnInfo(name = "nb_niveaux")
    private int nbNiveaux;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbNiveaux() {
        return nbNiveaux;
    }

    public void setNbNiveaux(int nbNiveaux) {
        this.nbNiveaux = nbNiveaux;
    }

    @Override
    public String toString() {
        return nom;
    }
}
