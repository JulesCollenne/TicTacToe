import static java.lang.Math.pow;
import static java.lang.Math.random;

public class Board {
    int board[];
    Bot p1;
    Bot p2;

    /*
    Soit board[i][j]
    score[i] =

    action = 0 | 1 | 2
             3 | 4 | 5
             6 | 7 | 8

     */

    public Board(){
        board = new int[9];
    }

    public void Play(){

    }

    public int ComputeBoard(){
        int state = 0;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                state += board[i] * pow(10,i);
        return state;
    }

    public boolean isPossible(int action){
        return board[action] == 0;
    }









}
