package com.example.nontonslur_tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Payment extends AppCompatActivity {

    private Button silver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        silver = (Button) findViewById(R.id.confirm_button2);
        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bronzepayment();
            }
        });
    }

    public void bronzepayment(){
        Intent intent = new Intent(this, selectpayment.class);
        startActivity(intent);
    }
}