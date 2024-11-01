package com.mehedi.lovecalculator;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView maleNameText, femaleNameText, lovePercentageText;
    ImageView loveImageView, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        maleNameText = findViewById(R.id.maleNameText);
        femaleNameText = findViewById(R.id.femaleNameText);
        lovePercentageText = findViewById(R.id.lovePercentageText);
        loveImageView = findViewById(R.id.loveImageView);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to the previous activity
            }
        });

        String maleName = getIntent().getStringExtra("maleName");
        String femaleName = getIntent().getStringExtra("femaleName");
        int lovePercentage = getIntent().getIntExtra("lovePercentage", 0); // Remove duplicate declaration

        maleNameText.setText("\uD83D\uDC96  " + maleName);
        femaleNameText.setText("\uD83D\uDC9D  " + femaleName);
        lovePercentageText.setText(lovePercentage + "%");

        animateLovePercentage(lovePercentage);

        setLoveImageAndToast(lovePercentage);
    }

    private void animateLovePercentage(int finalValue) {
        ValueAnimator animator = ValueAnimator.ofInt(0, finalValue);
        animator.setDuration(4000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                lovePercentageText.setText(animatedValue + "%");
            }
        });
        animator.start();
    }

    private void setLoveImageAndToast(int lovePercentage) {
        if (lovePercentage <= 20) {
            loveImageView.setImageResource(R.drawable.love_1_20);
            Toast.makeText(this, "অল্প ভালোবাসা", Toast.LENGTH_SHORT).show();
        } else if (lovePercentage <= 40) {
            loveImageView.setImageResource(R.drawable.love_20_40);
            Toast.makeText(this, "মাঝারি ভালোবাসা", Toast.LENGTH_SHORT).show();
        } else if (lovePercentage <= 60) {
            loveImageView.setImageResource(R.drawable.love_41_60);
            Toast.makeText(this, "গভীর ভালোবাসা", Toast.LENGTH_SHORT).show();
        } else if (lovePercentage <= 80) {
            loveImageView.setImageResource(R.drawable.love_61_80);
            Toast.makeText(this, "মহান ভালোবাসা", Toast.LENGTH_SHORT).show();
        } else {
            loveImageView.setImageResource(R.drawable.love_81_100);
            Toast.makeText(this, "অতিশয় গভীর ভালোবাসা", Toast.LENGTH_SHORT).show();
        }
    }
}
