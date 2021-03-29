package iut2.legendal_carminav_edl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import iut2.legendal_carminav_edl.bd.User;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context mCtx, List<User> userList) {
        super(mCtx, R.layout.template_user, userList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final User user = getItem(position);

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        Button userButton = (Button) rowView.findViewById(R.id.user_button);

        userButton.setText(user.getNom() + " " + user.getPrenom());

        return rowView;
    }

}
