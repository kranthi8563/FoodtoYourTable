package com.kranthi.foodtoyourtablelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {
    TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent = getIntent();
        String tablenumber = intent.getStringExtra("tablenum");
        order = findViewById(R.id.orderplaced);
        order.setText("Order Placed for the Selected Items "+"\n"+"         Food will be served to Table number  "+tablenumber);
    }
}