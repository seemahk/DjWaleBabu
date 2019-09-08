package com.example.djwalebabu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnTouchListener, View.OnContextClickListener {
    MediaPlayer mediaPlayer1,mediaPlayer2;
    //for random number generation
    Random random=new Random();

    //For small and light music
    SoundPool soundPool;
    int dm=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        View view=new View(this);
        view.setOnContextClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);

        //soundPool
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        //allocate resources to soundpool
        dm=soundPool.load(this,R.raw.explosion,1);

        mediaPlayer1=MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer2=MediaPlayer.create(this,R.raw.soundtrack);
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(286)));

    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer2.start();
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (dm!=0){
            soundPool.play(dm,1,1,0,0,1);
        }
        return false;
    }

    @Override
    public boolean onContextClick(View view) {
        mediaPlayer1.start();
        return false;
    }
}
