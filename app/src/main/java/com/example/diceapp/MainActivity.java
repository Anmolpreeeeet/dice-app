package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1 = findViewById(R.id.imageview2);
        ImageView img2 = findViewById(R.id.imageView3);
        Button btn = findViewById(R.id.buttonRollTheDice);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);
        btn.setOnClickListener(new View.OnClickListener() {
            int [] diceImages = {R.drawable.diceone,R.drawable.dicetwo,
                                R.drawable.dicethree,R.drawable.dicefour,
                                R.drawable.dicefive,R.drawable.dicesix};

            @Override
            public void onClick(View view) {
                Random random = new Random();
                int myRandomNumber = random.nextInt(6);
                img1.setImageResource(diceImages[myRandomNumber]);
                myRandomNumber = random.nextInt(6);
                img2.setImageResource(diceImages[myRandomNumber]);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imageview2));
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imageView3));
                mp.start();
            }
        });
    }
}