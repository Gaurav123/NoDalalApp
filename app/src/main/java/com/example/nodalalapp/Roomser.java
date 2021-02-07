package com.example.nodalalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Roomser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomser);
        TextView text1=findViewById(R.id.textView6);
        TextView text2,text3;
        text2=findViewById(R.id.textView7);
        text3=findViewById(R.id.textView8);
        text1.setText("HI sir If you need to avail our room service you can contact our phone number to pay on cleaning or click the button to pay at checkout");
        text2.setText("ph:9372165780");
        text3.setText("Email:gaurav.sharma45578@gmail.com");
        Button call=findViewById(R.id.button19);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobilenumber="9372165780";
                String msg="Attend for the Room Servicing Immediately";
                    Intent intowa=new Intent(Intent.ACTION_VIEW);
                    intowa.setData(Uri.parse("https://api.whatsapp.com/send?phone="+"+91"+mobilenumber+"&text="+msg));
                    startActivity(intowa);

            }
        });
    }
}
