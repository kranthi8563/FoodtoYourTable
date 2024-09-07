package com.kranthi.foodtoyourtablelogin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Location extends AppCompatActivity {
    private EditText enter_loc;

    Spinner spinner;
    String[] rest = {"Select Restaurant","Novotel","Paradise","cafe Bahar","Mehfil","Absolute Barbecues"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        enter_loc = findViewById(R.id.enter_location);
        spinner = findViewById(R.id.sppiner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Location.this,android.R.layout.simple_spinner_item,rest);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(Location.this, value, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final Button getmenubutton = findViewById(R.id.buttongetmenu);
        getmenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = enter_loc.getText().toString();
                Intent intent = new Intent(Location.this,Menu.class);
                intent.putExtra("location",location);




                startActivity(intent);
            }
        });






    }
}