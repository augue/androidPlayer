package com.book.openlabsmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btnPlay,btnPause;
    MediaPlayer mPlayer;
    ImageView imView;
    Handler hld;
    SeekBar sk;
    TextView tk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     int dg;
        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.play);
        btnPause = (Button) findViewById(R.id.pause);
        hld = new Handler();
         mPlayer =  MediaPlayer.create(this,R.raw.music);
        imView = (ImageView) findViewById(R.id.imageView);
        sk = (SeekBar) findViewById(R.id.seekBar2);
        tk = (TextView) findViewById(R.id.textView) ;


       //max size will be set based on the record
        sk.setMax(1000);
        sk.setProgress(0);
        final Animation anime = AnimationUtils.loadAnimation(this,R.anim.rotate);
    btnPlay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPlayer.start();
            Integer dr = mPlayer.getDuration();
            // convert dr into minutes and seconds
            String d = dr.toString();

            tk.setText(d);
            sk.setMax(dr);
           // imView.startAnimation(anime);
//            imView.setRotation(45);

            Runnable r = new Runnable() {
                Integer m = 0;
                Integer s = 0;
                @Override
                public void run() {

                    imView.setRotation(m = m + 10);
                    hld.postDelayed(this,50);
//                    tk.setText(s);
                    sk.setProgress(s = s + 20 );
                }
            };
            hld.postDelayed(r, 50);
        }
    });



    btnPause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPlayer.pause();

        }
    });
    }



}
