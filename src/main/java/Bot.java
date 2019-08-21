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

        actions = network.computeOutput(board);

        //System.out.println("\n\n\n");
        //for (double action : actions) System.out.println(action);

        ind = Calculs.max(actions);
        while(window.chooseSquare(ind,playerNum) == -1){
            ind = Calculs.max(actions);
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
