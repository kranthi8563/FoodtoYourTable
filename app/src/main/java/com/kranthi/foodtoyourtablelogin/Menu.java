package com.kranthi.foodtoyourtablelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    Button orderbutton;
    private EditText enter_table;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        orderbutton = findViewById(R.id.orderitembutton);
        enter_table = findViewById(R.id.table);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);
        list = new ArrayList<String>();
        list.add("Special Chicken Biryani        300rs");
        list.add("Egg Biryani              200rs");
        list.add("Mutton Biryani           450rs");
        list.add("Chicken Drumsticks      250rs");
        list.add("Chicken garlic kebab         200rs");
        list.add("Chicken 65                 280rs");
        list.add("Chicken Curry               180rs");
        list.add("mutton Curry                 200rs");
        list.add("Paneer Curry                  190rs");
        list.add("Paneer 65                 250rs");
        list.add("Veg Biryani              180rs");
        list.add("Gobi Manchurian             170rs");
        list.add("Gulab Jamun                70rs");
        list.add("Butterscotch Ice Cream           70rs");
        list.add("Chocolate Ice Cream             70rs");
        list.add("Venila Ice Cream                70rs");
        list.add("rumali Roti                     30rs");
        list.add("Butter Naan                      40rs");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,list);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String items = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(Menu.this,"select list of items", Toast.LENGTH_SHORT).show();
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        orderbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,Checkout.class);
                String tablenumber = enter_table.getText().toString();
                intent.putExtra("tablenum",tablenumber);

                startActivity(intent);
            }
        });
    }


}