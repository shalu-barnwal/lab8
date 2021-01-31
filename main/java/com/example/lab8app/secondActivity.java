package com.example.lab8app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    private ImageButton btnWeb, btnCall, btnLocation, btnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


       btnWeb = findViewById(R.id.web);
       btnCall = findViewById(R.id.call);
       btnLocation = findViewById(R.id.location);
       btnMail = findViewById(R.id.mail);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(secondActivity.this, "Website button has been clicked.", Toast.LENGTH_SHORT).show();
                String url =  "http://newtreat.co.in/";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Unable to handle this intent!");
                }
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(secondActivity.this, "Call button has been clicked", Toast.LENGTH_SHORT).show();
                String contactNum =  "9024637882";

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Contact :" + contactNum));

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Unable to handle this intent!");
                }
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(secondActivity.this, "Location button has been clicked", Toast.LENGTH_SHORT).show();
                String location =  "NewTreat.co";

                Uri addressUri = Uri.parse("geo:0,0?q=" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Unable to handle this intent!");
                }
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(secondActivity.this, "Mail button has been clicked", Toast.LENGTH_SHORT).show();
                String subject = "Greeting";
                String[] sendTo = new String[] {"mbharti321@gmail.com", "shalubarnwal822@gmail.com"};
                String content = "Hello, Hope you got this message from my app, if yes then smile please...XD";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Unable to handle this intent!");
                }
            }
        });
    }
}