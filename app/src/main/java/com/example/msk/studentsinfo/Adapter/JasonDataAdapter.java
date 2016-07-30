package com.example.msk.studentsinfo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.msk.studentsinfo.Model.Model;
import com.example.msk.studentsinfo.R;

import java.util.List;

/**
 * Created by DELL on 7/29/2016.
 */
public class JasonDataAdapter extends ArrayAdapter<Model> {



    public JasonDataAdapter(Context context, List<Model> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Model student_data = getItem(position);


        TextView nameView = (TextView) listItemView.findViewById(R.id.name_txt);
        nameView.setText(student_data.getName());

        TextView emailView = (TextView) listItemView.findViewById(R.id.email_txt);
        emailView.setText(student_data.getEmail());

        TextView addressView = (TextView) listItemView.findViewById(R.id.address_txt);
        addressView.setText(student_data.getAddress());

        TextView genderView = (TextView) listItemView.findViewById(R.id.gener_txt);
        genderView.setText(student_data.getGender());

        TextView mobileView = (TextView) listItemView.findViewById(R.id.mobile_txt);
        mobileView.setText(student_data.getMobile());








        return listItemView;
    }


}

