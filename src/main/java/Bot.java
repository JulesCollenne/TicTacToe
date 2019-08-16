import java.util.Random;

class Bot {
    private Network network;
    private int playerNum;
    private Window window;
    private int board[];

    /*

    action : 1 | 2 | 3
             4 | 5 | 6
             7 | 8 | 9
     */

    public Bot(Window window, int[] board, int playerNum) {
        this.network = new Network(3);
        this.playerNum = playerNum;
        this.window = window;
        this.board = board;
    }

    void play(){
        int action;

        Random random = new Random();

        //action = random.nextInt(9)

        action = network.computeOutput(board);

        while(window.chooseSquare(action,playerNum) == -1){
            action = random.nextInt(9);
        }
        //TODO
    }

    void won(){

    }
}
