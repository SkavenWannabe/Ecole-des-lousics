package iut2.legendal_carminav_edl.bd;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        tableName = "matieres"
)
public class Matiere implements Serializable, Parcelable {

    public Matiere(String nom, int nbNiveaux, int inputType) {
        this.nom = nom;
        this.nbNiveaux = nbNiveaux;
        this.inputType = inputType;
    }

    @NonNull
    @PrimaryKey
    private String nom;

    @ColumnInfo(name = "nb_niveaux")
    private int nbNiveaux;

    @ColumnInfo(name = "input_type")
    private int inputType;


    protected Matiere(Parcel in) {
        nom = in.readString();
        nbNiveaux = in.readInt();
        inputType = in.readInt();
    }

    public static final Creator<Matiere> CREATOR = new Creator<Matiere>() {
        @Override
        public Matiere createFromParcel(Parcel in) {
            return new Matiere(in);
        }

        @Override
        public Matiere[] newArray(int size) {
            return new Matiere[size];
        }
    };

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

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    @Override
    public String toString() {
        return nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(nbNiveaux);
        dest.writeInt(inputType);
    }
}
