import static java.lang.Math.random;

public class Game {
    int[] board;
    Window window;
    Bot p1;
    Player p2;

    public Game(Window window) {
        this.board = new int[9];
        this.window = window;
    }

    public void StartGame(){
        window.newGame();
        p1.play();
        p2.play();
        isAligned();
        //TODO say who won
    }


    /**
     * Is the game finished ?
     * By who ?
     * 0 = no one
     * 1 = p1
     * 2 = p2
     * @return winner
     */
    int isAligned(){
        int i, result;
        for(i = 0; i < 3; i++) {
            result = isAlignedHorizontal(i);
            if (result != 0)
                return result;
            result = isAlignedVertical(i);
            if (result != 0)
                return result;
        }
        result = isAlignedDiagonal();
        if (result != 0)
            return result;
        return 0;
    }

    private int isAlignedHorizontal(int i){
        if ((board[i] == board[i+1]) && (board[i+1] == board[i+2]))
            return board[i];
        return 0;
    }

    private int isAlignedVertical(int i){
        if((board[i] == board[i+3]) && (board[i+3] == board[i+6]))
            return board[i];
        return 0;
    }

    private int isAlignedDiagonal(){
        if((board[0] == board[4]) && (board[4] == board[8]))
            return board[0];
        if((board[2] == board[4]) && (board[4] == board[6]))
            return board[0];
        return 0;
    }


}
