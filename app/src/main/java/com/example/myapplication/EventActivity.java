package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    private TextView nameUser;
    private Button btnGoCalendar;
    public ListView listView;
    private ArrayList<Item> listaItem;
    private String name;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        listaItem = new ArrayList<>();
        //recuperar do cash
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);
        listView = (ListView) findViewById((R.id.listView));
        nameUser = (TextView) findViewById(R.id.titleScreen);

        Intent getName = getIntent();
        name = (String) getName.getSerializableExtra("nameUser");
        if(name != null){
            nameUser.setText("Olá, "+name+" O que fazer hoje?");
        }


        Intent incomingIntent = getIntent();
        item = (Item) incomingIntent.getSerializableExtra("Item");
        if(item != null){
            listaItem.add(item);

            //Guardar no cache
            ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, listaItem);
            listView.setAdapter(adapter);
        }


        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(EventActivity.this, CalendarActivity.class);
                startActivity(nextActivity);
            }
        });
    }
}
