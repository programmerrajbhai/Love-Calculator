package com.mehedi.lovecalculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import soup.neumorphism.NeumorphCardView;

public class MainActivity2 extends AppCompatActivity {

    TextInputEditText inputText;
    NeumorphCardView neumorphCardView;
    ImageView copy, share;
    LinearLayout reset, main;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        copy = findViewById(R.id.copy);
        reset = findViewById(R.id.reset);
        main = findViewById(R.id.main);
        share = findViewById(R.id.share);

        final TextInputEditText inputText = findViewById(R.id.inputText);
        final EditText inputNumber = findViewById(R.id.inputNumber);
        TextView repeatButton = findViewById(R.id.repeatButton);
        final TextView resultText = findViewById(R.id.resultText);


        repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();
                String numberStr = inputNumber.getText().toString();

                if (text.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "অনুগ্রহ করে টেক্সট দিন", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (numberStr.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "অনুগ্রহ করে সংখ্যা দিন", Toast.LENGTH_SHORT).show();
                    return;
                }

                int count = Integer.parseInt(numberStr);

                // সংখ্যা সীমা চেক করা (১ থেকে ১০০ এর মধ্যে)
                if (count < 1 || count > 1000) {
                    Toast.makeText(MainActivity2.this, "সংখ্যাটি ১ থেকে ১০০ এর মধ্যে দিন", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder repeatedText = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    repeatedText.append(text).append("\n");
                }
                resultText.setText(repeatedText.toString());
            }
        });





        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copyTextToClipboard(resultText.getText().toString());
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText(resultText.getText().toString());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultText.setText("");

                Toast.makeText(MainActivity2.this, "সকল টেক্সট ডিলিট করা হয়েছে", Toast.LENGTH_SHORT).show();
            }
        });







    }


    private void copyTextToClipboard(String text) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text", text);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity2.this, "Text copied", Toast.LENGTH_SHORT).show();
    }

    private void shareText(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(shareIntent, "Share text via"));
    }
}
