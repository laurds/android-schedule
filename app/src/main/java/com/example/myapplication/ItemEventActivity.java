package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/** Activity que representa o evento */
public class ItemEventActivity extends AppCompatActivity {

    private TextView theDate;
    private TextView theEventTitle;
    private TextView theEventNote;
    private TextView theEventTime;

    private Item item;
    public LinearLayout eventContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_event);

        eventContent = (LinearLayout) findViewById(R.id.eventContent);
        theDate = (TextView) findViewById(R.id.date);
        theEventTitle = (TextView) findViewById(R.id.titleEventView);
        theEventNote = (TextView) findViewById(R.id.notesEventView);
        theEventTime = (TextView) findViewById(R.id.timeEventView);

        /**
         * Acessa a intent e obtem os dados depois adiciona nos arrays
         */
        Intent incomingIntent = getIntent();
        item = (Item) incomingIntent.getSerializableExtra("Item");
        theEventTitle.setText(item.getTitle());
        theEventNote.setText(item.getNota());
        theEventTime.setText(item.getHora());
        theDate.setText(item.getData());

    }

    public void saveItem(View view) {
        Intent i = new Intent(this, EventActivity.class);
        i.putExtra("Item", item);
        startActivity(i);
    }
}
