package iut2.legendal_carminav_edl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;


import java.util.List;

import iut2.legendal_carminav_edl.modele.Multiplication;

public class TableMultiplicationAdapter extends ArrayAdapter<Multiplication> {

    public TableMultiplicationAdapter(Context mCtx, List<Multiplication> multiplicationList) {
        super(mCtx, R.layout.template_matiere, multiplicationList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Multiplication multiplication = getItem(position);

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_calcul, parent, false);

        TextView calculText = rowView.findViewById(R.id.template_calcul);
        EditText resultat = rowView.findViewById(R.id.template_resultat);

        resultat.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                int reponse;
                try {
                    reponse = Integer.parseInt(resultat.getText().toString());
                } catch (NumberFormatException e) {
                    reponse = 0;
                }
                multiplication.setReponse(reponse);
            }
        });

        calculText.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = ");

        return rowView;
    }

}
