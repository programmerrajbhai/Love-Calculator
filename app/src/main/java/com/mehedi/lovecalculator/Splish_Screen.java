package com.mehedi.lovecalculator;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import soup.neumorphism.NeumorphCardView;

public class Splish_Screen extends AppCompatActivity {


    CardView love,text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.splish_screen);
        love=findViewById(R.id.love);
        text=findViewById(R.id.text);


        LinearLayout policyL= findViewById(R.id.policyL);
        LinearLayout rateL= findViewById(R.id.rateL);
        LinearLayout guidL= findViewById(R.id.guidL);


        rateL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rateApp();
            //    Toast.makeText(Splish_Screen.this,"Rate Apps",Toast.LENGTH_SHORT).show();
            }
        });


        policyL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // URL you want to load
                String url = "https://sites.google.com/view/lovecheckeronlineapps?usp=sharing";

                // Create an Intent with ACTION_VIEW to open the URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Check if there is an app that can handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        guidL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Splish_Screen.this, UserGuid.class);
                startActivity(intent);
            }
        });




        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Splish_Screen.this, MainActivity.class);
               startActivity(intent);


            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Splish_Screen.this, MainActivity2.class);
                startActivity(intent);


            }
        });






    }

    private void rateApp() {
        try {
            // Try opening Google Play Store app
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Fallback to opening Google Play Store in a web browser
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }


}