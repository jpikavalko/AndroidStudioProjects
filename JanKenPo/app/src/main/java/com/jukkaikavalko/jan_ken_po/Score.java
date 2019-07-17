package com.jukkaikavalko.jan_ken_po;

import android.content.SharedPreferences;

import static com.jukkaikavalko.jan_ken_po.GameView.score;

public class Score
{
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";

    private static int playerScore;
    private static int enemyScore;

    public static void setPlayerScore(int playerScore)
    {
        Score.playerScore = playerScore;
    }

    public static void setEnemyScore(int enemyScore)
    {
        Score.enemyScore = enemyScore;
    }

    public Score(){
        ResetScore();
    }

    public static void ResetScore()
    {
        playerScore = 0;
        enemyScore = 0;
    }

    public static int getPlayerScore()
    {
        return playerScore;
    }

    public static void addPlayerScore()
    {
        Score.playerScore += 1;
    }

    public static int getEnemyScore()
    {
        return enemyScore;
    }

    public static void addEnemyScore()
    {
        Score.enemyScore += 1;
    }

    public static void addScore(int value){
        if (value == 0) addPlayerScore();
        if (value == 2) addEnemyScore();
    }







}
