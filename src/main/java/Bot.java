import java.util.Arrays;
import java.util.Random;

/**
 * The playing AI Bot
 *
 * The bot has a score that goes up if it plays well
 *
 *      |  First player | Second player
 * Win  |    +7         |      +10
 * Draw |    +3         |      +5
 * Lose |    0          |      0
 */
class Bot {
    Network network;
    int playerNum;
    Window window;
    int board[];
    private int subjectiveBoard[];
    boolean won;
    int score;
    boolean disqualified;

    /*

    actions :0 | 1 | 2
             3 | 4 | 5
             7 | 8 | 9
     */

    Bot(Window window, int[] board) {
        this.network = new Network(5);
        this.window = window;
        this.board = board;
        won = false;
        subjectiveBoard = new int[9];
        score = 0;
        disqualified = false;
    }


    @Override
    public String toString() {
        return network.toString();
    }

    /**
     * Bot tries a move, if the move isn't correct,
     * it tries a random move until it does a correct
     * move
     */
    void play(){
        double[] actions;
        int ind;

        Random rand = new Random();

        makeSubjectiveBoard();

        actions = network.computeOutput(subjectiveBoard);

        ind = Calculs.max(actions);

        //System.out.println(Arrays.toString(actions));

        while(window.chooseSquare(ind,playerNum) == -1){
            ind = Calculs.max(actions);
        }

        //if(window.chooseSquare(ind,playerNum) == -1)
            //disqualified = true;

/*
        while(window.chooseSquare(ind,playerNum) == -1){
            ind = rand.nextInt(9);
        }*/
    }

    /**
     * makeBoard allow the AI to converge because
     * Bot is always player one on this board, and the enemy is
     * number 2
     *
     *
     */
    private void makeSubjectiveBoard() {
        if(playerNum == 1)
            System.arraycopy(board, 0, subjectiveBoard, 0, board.length);
        else{
            for(int i = 0; i < board.length; i++) {
                if (board[i] == 1)
                    subjectiveBoard[i] = 2;
                if (board[i] == 2)
                    subjectiveBoard[i] = 1;
                else
                    subjectiveBoard[i] = board[i];
            }
        }
    }


    /**
     * The bot won
     */
    void won(){
        won = true;
        if(playerNum == 1)
            score += 7;
        else
            score += 10;
    }

    /**
     * The bots drew
     */
    void drew(){
        won = false;
        if(playerNum == 1)
            score += 3;
        else
            score += 5;
    }

    void initializeGenes(Bot b1, Bot b2){
        network.mixGenes(b1.network,b2.network);
    }

    void mutate(){
        network.mutate();
    }

}
