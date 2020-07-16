package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.myapplication.R.layout.activity_item_event;

public class MyAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<Item> lista;
    private Activity act;


    public MyAdapter(ArrayList<Item> lista, Activity act) {
        this.lista = lista;
        this.act = act;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
    return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        View view = act.getLayoutInflater().inflate(activity_item_event, parent, false);
        Item itemPosicao = lista.get(position);

        //LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        TextView myTitle = (TextView) view.findViewById(R.id.titleEventView);
        TextView myNotes = (TextView)  view.findViewById(R.id.notesEventView);
        TextView myTime = (TextView)  view.findViewById(R.id.timeEventView);
        TextView myDate = (TextView)  view.findViewById(R.id.date);
        Button btnRemove = view.findViewById(R.id.btnRemove);

        myTitle.setText(itemPosicao.getTitle());
        myNotes.setText(itemPosicao.getNota());
        myTime.setText(itemPosicao.getHora());
        myDate.setText(itemPosicao.getData());

        btnRemove.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Item item = lista.get(position);
                        lista.remove(item);
                        MyAdapter.this.notifyDataSetChanged();
                        PreferenceConfig.writeListInPreference(act.getBaseContext(), lista);
                        //PreferenceConfig.deleteItemFromPreference(act.getBaseContext());
                        Toast.makeText(act.getBaseContext(), "Item removido com sucesso!",Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }
}
