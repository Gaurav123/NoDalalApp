package com.example.nodalalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.makeText;

public class loginactivity extends AppCompatActivity {
    EditText emailid,password;
    Button btnsignup;
    TextView tvsignin;
    FirebaseAuth mFirebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        mFirebaseauth=FirebaseAuth.getInstance();
        emailid=findViewById(R.id.editText4);
        password=findViewById(R.id.editText5);
        btnsignup=findViewById(R.id.button2);
        tvsignin=findViewById(R.id.textView2);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email =emailid.getText().toString();
                final String pwd =password.getText().toString();
                if(email.isEmpty()){
                    emailid.setError("please enter email id");
                    emailid.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("please enter your password");
                    password.requestFocus();
                }
                else{
                    mFirebaseauth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(loginactivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                Intent intohi=new Intent(loginactivity.this,logsinupmid.class);
                                makeText(loginactivity.this, "Sign-up successful please login now!:)", Toast.LENGTH_SHORT).show();
                                intohi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intohi);
                                finish();
                            }
                            else{
                                makeText(loginactivity.this,"sign-up unsuccessful,Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }



            }
        });
        tvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(loginactivity.this, registeractivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
    }
}
