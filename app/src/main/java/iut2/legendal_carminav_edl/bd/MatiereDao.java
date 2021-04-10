package iut2.legendal_carminav_edl.bd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MatiereDao {

    @Query("SELECT * FROM matieres")
    List<Matiere> getAll();

    @Query("SELECT * FROM matieres WHERE nom LIKE :nom")
    List<Matiere> getNbNiveauxWithNom(String nom);

    @Insert
    void insert(Matiere matiere);

    @Insert
    long[] insertAll(Matiere... matieres);

    @Delete
    void delete(Matiere matieres);

    @Update
    void update(Matiere matieres);

}
