package com.jukkaikavalko.jan_ken_po;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameView extends AppCompatActivity implements View.OnClickListener
{
    static Score score;

    private ImageView iRock, iPaper, iScissors;
    private int[] imgs = {R.drawable.icon_rock_resized, R.drawable.icon_paper_resized128, R.drawable.icon_scissors_resized };
    private int[] msgs = {R.string.iv_Winner, R.string.iv_Tie, R.string.iv_Loser};
    private ImageView playerHand, enemyHand;
    private TextView playerScore, enemyScore;
    private TextView winner;

    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
        Log.d("clicked", "sdlfkh");
        SetUpUi();
        // New Game
        score = new Score();

        LoadScores();
        SetScores();

    }

    private int dealHand()
    {
        Random rand = new Random();
        int numb = rand.nextInt(3);
//        String message = String.valueOf(numb);
//        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        return numb;
    }

    private void SetWinner(int ph, int eh, int w)
    {
        playerHand.setImageResource(imgs[ph]);
        enemyHand.setImageResource(imgs[eh]);
        winner.setText(msgs[w]);
        score.addScore(w);
        SetScores();
    }

    private void SetScores(){
        playerScore.setText(String.valueOf(score.getPlayerScore()));
        enemyScore.setText(String.valueOf(score.getEnemyScore()));
        SaveScores();
    }

    private void LoadScores(){
        myPrefs = getSharedPreferences(PREFS_NAME, 0);
        if (myPrefs.contains("playerScore")){
            score.setPlayerScore(myPrefs.getInt("playerScore", 0));
        }
        if (myPrefs.contains("enemyScore")){
            score.setEnemyScore(myPrefs.getInt("enemyScore", 0));
        }
    }

    private void SaveScores(){
        myPrefs = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putInt("playerScore", score.getPlayerScore());
        editor.putInt("enemyScore", score.getEnemyScore());
        editor.commit();
    }


    public void SetUpUi(){
        // Find references by ID
        iRock = findViewById(R.id.bFrameRock);
        iPaper = findViewById(R.id.bFramePaper);
        iScissors = findViewById(R.id.bFrameScissors);
        playerHand = findViewById(R.id.playerHandID);
        enemyHand = findViewById(R.id.enemyHandID);
        playerScore = findViewById(R.id.ivPlayerScore);
        enemyScore = findViewById(R.id.ivEnemyScore);
        winner = findViewById(R.id.ivWinnerID);

        iRock.setOnClickListener(this);
        iScissors.setOnClickListener(this);
        iPaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId()){
            case R.id.bFrameRock:
            {
                int eh = dealHand();
                KPS game = new KPS(0,eh);
                int wi = game.getWinner();
                SetWinner(0, eh, wi);
                break;
            }
            case R.id.bFramePaper:
            {
                int eh = dealHand();
                KPS game = new KPS(1,eh);
                int wi = game.getWinner();
                SetWinner(1, eh, wi);
                break;
            }
            case R.id.bFrameScissors:
            {
                int eh = dealHand();
                KPS game = new KPS(2,eh);
                int wi = game.getWinner();
                SetWinner(2, eh, wi);
                break;
            }
        }
    }
}
