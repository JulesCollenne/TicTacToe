/**
 * The playing AI
 */
class Bot {
    Network network;
    private int playerNum;
    Window window;
    int board[];
    private int subjectiveBoard[];
    boolean won;

    /*

    actions :0 | 1 | 2
             3 | 4 | 5
             7 | 8 | 9
     */

    Bot(Window window, int[] board, int playerNum) {
        this.network = new Network(5);
        this.playerNum = playerNum;
        this.window = window;
        this.board = board;
        won = false;
        subjectiveBoard = new int[9];
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

        makeSubjectiveBoard();

        actions = network.computeOutput(subjectiveBoard);

        ind = Calculs.max(actions);
        while(window.chooseSquare(ind,playerNum) == -1){
            ind = Calculs.max(actions);
        }
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
            subjectiveBoard = board;
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
    }

    void initializeGenes(Bot b1, Bot b2){
        network.mixGenes(b1.network,b2.network);
    }

    void mutate(){
        network.mutate();
    }

}
