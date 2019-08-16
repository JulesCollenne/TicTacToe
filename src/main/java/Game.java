public class Game {
    private int[] board;
    private Window window;
    private Bot p1;
    private Bot p2;

    Game(Window window, int[] board) {
        this.board = board;
        this.window = window;
        p1 = new Bot(window,board,1);
        p2 = new Bot(window,board,2);
    }

    public void StartGame(){
        int winner;
        initializeBoard();
        window.newGame();
        do {
            p1.play();
            p2.play();
            winner = isAligned();
            if (winner == 1)
                p1.won();
            if (winner == 2)
                p2.won();
        } while (winner == 0);
        //TODO say who won

        System.out.println(winner + " won !");
    }


    /**
     * Is the game finished ?
     * By who ?
     * 0 = no one
     * 1 = p1
     * 2 = p2
     * @return winner
     */
    private int isAligned(){
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

    private void initializeBoard(){
        for(int i = 0; i <board.length; i++)
            board[i] = 0;
    }


}
