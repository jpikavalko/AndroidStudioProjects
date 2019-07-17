package com.jukkaikavalko.jan_ken_po;

public class KPS
{

    private int winner;

    public KPS(int yourAnswer, int opponentAnswer){
        winner = CheckWinner(yourAnswer, opponentAnswer);
    }

    // 0 = Player Wins, 1 = Tie, 2 = Enemy Wins, 3 = Error
    private int CheckWinner(int you, int enemy)
    {
        switch (you){
            case 0:{ // Rock
                if (enemy == 0) return 1;
                else if (enemy == 1) return 2;
                else if (enemy == 2) return 0;
                else return 3;
            }
            case 1:{ // Paper
                if (enemy == 0) return 0;
                else if(enemy == 1) return 1;
                else if (enemy == 2) return 2;
                else return 3;
            }
            case 2:{ // Scissors
                if (enemy == 0) return 2;
                else if(enemy == 1) return 0;
                else if (enemy == 2) return 1;
                else return 3;
            }
            default:
                return 3;
        }
    }

    public int getWinner()
    {
        return winner;
    }
}
