import java.util.Random;

/**
 * The playing AI
 */
class Bot {
    Network network;
    private int playerNum;
    Window window;
    int board[];
    boolean won;

    /*

    actions :0 | 1 | 2
             3 | 4 | 5
             7 | 8 | 9
     */

    Bot(Window window, int[] board, int playerNum) {
        this.network = new Network(3);
        this.playerNum = playerNum;
        this.window = window;
        this.board = board;
        won = false;
    }

    /**
     * Bot tries a move, if the move isn't correct,
     * it tries a random move until it does a correct
     * move
     */
    void play(){
        int action;

        Random random = new Random();

        action = network.computeOutput(board);

        while(window.chooseSquare(action,playerNum) == -1){
            action = random.nextInt(9);
        }
    }

    /**
     * The bot won
     */
    void won(){
        won = true;
    }

    void initializeGenes(Bot b1, Bot b2){
        network.mixGenes(b1.network,b2.network);
    }

    void mutate(){
        network.mutate();
    }

}
