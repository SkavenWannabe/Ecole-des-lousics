package iut2.legendal_carminav_edl.modele;

import android.app.Application;

import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.User;

public class VGlobal extends Application {
    private boolean exercice_math = true;
    private int level = 1;
    private User utilisateur;
    private Matiere matiere;

    public boolean isExerciceMath() {
        return exercice_math;
    }

    public void setExerciceMath(boolean exercice_math) {
        this.exercice_math = exercice_math;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
