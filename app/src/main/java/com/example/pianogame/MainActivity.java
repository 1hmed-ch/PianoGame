package com.example.pianogame;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;  // MediaPlayer instance to play sound
    private List<Button> pianoKeys;
    private List<Integer> soundResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button noteC = findViewById(R.id.btnC);
        Button noteD = findViewById(R.id.btnD);
        Button noteE = findViewById(R.id.btnE);
        Button noteF = findViewById(R.id.btnF);
        Button noteG = findViewById(R.id.btnG);
        Button noteA = findViewById(R.id.btnA);
        Button noteB = findViewById(R.id.btnB);


        pianoKeys = Arrays.asList(noteC, noteD, noteE, noteF, noteG, noteA, noteB);

        soundResources = Arrays.asList(
                R.raw.a4,
                R.raw.b4,
                R.raw.c4,
                R.raw.d4,
                R.raw.e4,
                R.raw.f4,
                R.raw.g4
        );


        for (int i = 0; i < pianoKeys.size(); i++) {
            final int soundResource = soundResources.get(i);
            pianoKeys.get(i).setOnClickListener(view -> playSound(soundResource));
        }
    }


    private void playSound(int soundResource) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }


        mediaPlayer = MediaPlayer.create(this, soundResource);
        mediaPlayer.setOnCompletionListener(mp -> {
            mp.release();
        });
        mediaPlayer.start();
}

}
