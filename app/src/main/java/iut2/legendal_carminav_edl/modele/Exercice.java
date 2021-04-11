package iut2.legendal_carminav_edl.modele;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.Question;

public class Exercice implements Parcelable {

    private Matiere matiere;
    private List<Question> questionList;
    private int numeroQuestionActive;

    public Exercice(Matiere matiere, List<Question> questionList) {
        this.matiere = matiere;
        this.questionList = questionList;
        this.numeroQuestionActive = 1;
    }

    protected Exercice(Parcel in) {
        numeroQuestionActive = in.readInt();
        questionList = new ArrayList<>();
        in.readList(questionList ,Question.class.getClassLoader());
        matiere = in.readParcelable(Matiere.class.getClassLoader());
    }

    public static final Creator<Exercice> CREATOR = new Creator<Exercice>() {
        @Override
        public Exercice createFromParcel(Parcel in) {
            return new Exercice(in);
        }

        @Override
        public Exercice[] newArray(int size) {
            return new Exercice[size];
        }
    };

    public int questionSuivante() {
        if (numeroQuestionActive == questionList.size()) {
            return 1;
        } else {
            numeroQuestionActive++;
            return 0;
        }
    }

    public int questionPrecedente() {
        if (numeroQuestionActive == 1) {
            return 1;
        } else {
            numeroQuestionActive--;
            return 0;
        }
    }

    public Question getQuestionActive() {
        return questionList.get(numeroQuestionActive - 1);
    }

    public int getNumeroQuestionActive() {
        return numeroQuestionActive;
    }

    public int getNbQuestions() {
        return questionList.size();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question getQuestion(int nbQuestion) {
        return questionList.get(nbQuestion - 1);
    }

    public void setReponse(String reponse) {
        questionList.get(numeroQuestionActive - 1).setResponseUser(reponse);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numeroQuestionActive);
        dest.writeList(questionList);
        dest.writeParcelable(matiere, flags);
    }
}
