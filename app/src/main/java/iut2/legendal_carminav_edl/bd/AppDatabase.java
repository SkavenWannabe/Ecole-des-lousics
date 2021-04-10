package iut2.legendal_carminav_edl.bd;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Question.class, Matiere.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract QuestionDao questionDao();
    public abstract MatiereDao matiereDao();

}