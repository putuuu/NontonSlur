package com.example.nontonslur_tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectpayment extends AppCompatActivity {

    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectpayment);

        confirm = (Button) findViewById(R.id.confirm_button1);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openreceipt();
            }
        });
    }

    public void openreceipt(){
        Intent intent = new Intent(this, receipt.class);
        startActivity(intent);
    }
}