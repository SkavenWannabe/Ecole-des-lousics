package iut2.legendal_carminav_edl;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.User;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class MatiereAdapter extends ArrayAdapter<Matiere> {

    public MatiereAdapter(Context mCtx, List<Matiere> userList) {
        super(mCtx, R.layout.template_matiere, userList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Matiere matiere = getItem(position);

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_matiere, parent, false);

        Button matiereButton = (Button) rowView.findViewById(R.id.template_matiere);
        matiereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChoixNiveauActivity.class);
                intent.putExtra(ChoixNiveauActivity.NB_NIVEAU_KEY, matiere.getNbNiveaux());
                ((VGlobal) MatiereAdapter.this.getContext().getApplicationContext()).setMatiere(matiere);
                getContext().startActivity(intent);

            }
        });

        matiereButton.setText(matiere.getNom());

        return rowView;
    }

}
