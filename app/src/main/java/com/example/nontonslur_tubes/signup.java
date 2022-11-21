package com.example.nontonslur_tubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {
    // create object database reference untuk menyambungkan ke realtime database firebase
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nontonslur-tubes-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText email = findViewById(R.id.email);
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText confirm_password = findViewById(R.id.confirm_password);

        final Button signupbtn = findViewById(R.id.signupbtn);
        final TextView loginbtn = findViewById(R.id.loginbtn);

        final CheckBox checkbox = findViewById(R.id.checkbox);

        //signup button
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get data from edit text to String variable
                final String emailtxt = email.getText().toString();
                final String usernametxt = username.getText().toString();
                final String passwordtxt = password.getText().toString();
                final String conpasswordtxt = confirm_password.getText().toString();
                final String statustxt = "Default";
                final int duratiiontxt = 0;

                //checking if user fill all the edittext
                if(emailtxt.isEmpty() || usernametxt.isEmpty() ||passwordtxt.isEmpty() || conpasswordtxt.isEmpty()){
                    Toast.makeText(signup.this,"Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                //checking if password are match with confirm password
                else if(!passwordtxt.equals(conpasswordtxt)){
                    Toast.makeText(signup.this,"Password are not matching", Toast.LENGTH_SHORT).show();
                }
                //checking if check box are checked or not
                else if(!checkbox.isChecked()){
                    Toast.makeText(signup.this,"Mohon setuju dengan persyaratan yang berlaku", Toast.LENGTH_SHORT).show();
                }
                //sending data to realtime database firebase
                else{

                    databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if username is already register or not
                            if(snapshot.hasChild(usernametxt)){
                                Toast.makeText(signup.this,"Username is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                //set value username as primary key of every user
                                databaseReference.child("User").child(usernametxt).child("Email").setValue(emailtxt);
                                databaseReference.child("User").child(usernametxt).child("Username").setValue(usernametxt);
                                databaseReference.child("User").child(usernametxt).child("Password").setValue(passwordtxt);
                                databaseReference.child("User").child(usernametxt).child("Status").setValue(statustxt);
                                databaseReference.child("User").child(usernametxt).child("Duration").setValue(duratiiontxt);

                                Toast.makeText(signup.this,"SignUp Succesfull", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(signup.this, Payment.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });
    }


}