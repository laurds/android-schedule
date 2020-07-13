package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.myapplication.R.layout.activity_item_event;

public class MyAdapter  extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> lista;


    public MyAdapter(Context context,  ArrayList<Item> lista) {
        super(context, activity_item_event, R.id.titleEventView, lista);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item itemPosicao = this.lista.get(position);
        final int pos = position;

        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(activity_item_event, parent, false);

        TextView myTitle = row.findViewById(R.id.titleEventView);
        TextView myNotes = row.findViewById(R.id.notesEventView);
        TextView myTime = row.findViewById(R.id.timeEventView);
        TextView myDate = row.findViewById(R.id.date);
        Button btnRemove = row.findViewById(R.id.btnRemove);

        myTitle.setText(itemPosicao.title);
        myNotes.setText(itemPosicao.nota);
        myTime.setText(itemPosicao.hora);
        myDate.setText(itemPosicao.data);

        return row;
    }
}
