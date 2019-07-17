package com.jukkaikavalko.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private MediaPlayer mediaPlayer;
    private ImageView artistImage;
    private TextView leftTime, rightTime;
    private Button playButton, prevButton, nextButton;
    private SeekBar seekBar;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupUI();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bensound_summer);

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                int currentPos = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                leftTime.setText(dateFormat.format(new Date(currentPos)));

                rightTime.setText(dateFormat.format(new Date(duration - currentPos)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()){
            case R.id.prevButtonID:
                prevMusic();
                break;

            case R.id.playButtonID:
                if (mediaPlayer.isPlaying()) pauseMusic();
                else startMusic();
                break;

            case R.id.nextButtonID:
                nextMusic();
                break;
        }
    }

    public void pauseMusic(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            playButton.setBackgroundResource(android.R.drawable.ic_media_play);
        }
    }

    public void startMusic(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            updateThread();
            playButton.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
    }

    public void prevMusic(){
        mediaPlayer.seekTo(0);
        startMusic();
    }

    public void nextMusic(){
        mediaPlayer.seekTo(mediaPlayer.getDuration());
        pauseMusic();
    }

    @Override
    protected void onDestroy()
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    public void SetupUI(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bensound_summer);

        playButton = findViewById(R.id.playButtonID);
        prevButton = findViewById(R.id.prevButtonID);
        nextButton = findViewById(R.id.nextButtonID);

        artistImage = findViewById(R.id.artistImageID);
        leftTime = findViewById(R.id.progressionIncrement);
        rightTime = findViewById(R.id.progressionDecrement);
        seekBar = findViewById(R.id.progressionBarID);


        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    public void updateThread()
    {
        thread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    while(mediaPlayer != null && mediaPlayer.isPlaying()){
                        Thread.sleep(50);
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                int newPosition = mediaPlayer.getCurrentPosition();
                                int newMax = mediaPlayer.getDuration();
                                seekBar.setMax(newMax);
                                seekBar.setProgress(newPosition);

                                leftTime.setText(String.valueOf(new SimpleDateFormat("mm:ss").
                                        format(new Date(mediaPlayer.getCurrentPosition()))));

                                rightTime.setText(String.valueOf(new SimpleDateFormat("mm:ss").
                                        format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));
                            }
                        });
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

}
