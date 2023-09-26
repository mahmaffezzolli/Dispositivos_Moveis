package com.aula3.lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class itemChurrascoAdapter extends ArrayAdapter<itemChurrasco> {

    Context mContext;
    int mResourse;

    public itemChurrascoAdapter(@NonNull Context context, int resource, @NonNull List<itemChurrasco> objects) {
        super(context, resource, objects);
        mContext=context;
        mResourse = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResourse,parent,false);

        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtId = convertView.findViewById(R.id.txtId);
        ImageView imgItem = convertView.findViewById(R.id.imgItem);

        txtNome.setText(getItem(position).nome);
        txtId.setText(String.valueOf(getItem(position).id));
        imgItem.setImageResource(getItem(position).imagem);

        return convertView;
    }
}
