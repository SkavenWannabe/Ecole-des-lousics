package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.User;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class SelectionExerciceActivity extends AppCompatActivity {

    private DatabaseClient mDb;
    private MatiereAdapter adapter;

    private List<Matiere> matiereList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_exercice);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        User user = ((VGlobal) this.getApplication()).getUtilisateur();
        if (user != null) {
            setTitle(user.getNomComplet());
        } else {
            setTitle("Anonyme");
        }

        ListView matiereListView = findViewById(R.id.listview_matiere);
        adapter = new MatiereAdapter(this, new ArrayList<Matiere>());

//        matiereListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(SelectionExerciceActivity.this, ChoixNiveauActivity.class);
//                intent.putExtra(ChoixNiveauActivity.NB_NIVEAU_KEY, matieres.get(position).getNbNiveaux());
//                startActivity(intent);
//            }
//        });

        matiereListView.setAdapter(adapter);

    }

    public void goToChoixNiveau(int position) {
        Intent intent = new Intent(SelectionExerciceActivity.this, ChoixNiveauActivity.class);
        intent.putExtra(ChoixNiveauActivity.NB_NIVEAU_KEY, matiereList.get(position).getNbNiveaux());
        startActivity(intent);
    }

    private void getMatieres() {
        class GetMatieres extends AsyncTask<Void, Void, List<Matiere>> {

            @Override
            protected List<Matiere> doInBackground(Void... voids) {
                List<Matiere> matiereList = mDb.getAppDatabase().matiereDao().getAll();

                return matiereList;
            }

            @Override
            protected void onPostExecute(List<Matiere> matiere) {
                super.onPostExecute(matiere);

                adapter.clear();
                adapter.addAll(matiere);
                SelectionExerciceActivity.this.matiereList.addAll(matiere);

                adapter.notifyDataSetChanged();

            }
        }

        GetMatieres gm = new GetMatieres();
        gm.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getMatieres();
    }
}