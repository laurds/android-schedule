package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    private TextView theDate;
    private Button btnGoCalendar;
    private TextView theEventTitle;
    private TextView theEventNote;
    private TextView theEventTime;
    public  LinearLayout eventContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        eventContent = (LinearLayout) findViewById(R.id.eventContent);
        eventContent.setVisibility(View.INVISIBLE);
        theDate = (TextView) findViewById(R.id.date);
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);
        theEventTitle = (TextView) findViewById(R.id.titleEventView);
        theEventNote = (TextView) findViewById(R.id.notesEventView);
        theEventTime = (TextView) findViewById(R.id.timeEventView);


        //Acessa a intent e obtem os dados
        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);
        String title = incomingIntent.getStringExtra("titleEvent");
        theEventTitle.setText(title);
        String notes = incomingIntent.getStringExtra("notesEvent");
        theEventNote.setText(notes);
        String time = incomingIntent.getStringExtra("timeEvent");
        theEventTime.setText(time);
        Integer view = incomingIntent.getIntExtra("view", View.INVISIBLE);
        eventContent.setVisibility(view);

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextActivity = new Intent(EventActivity.this, CalendarActivity.class);
                startActivity(nextActivity);
            }
        });
    }

}
