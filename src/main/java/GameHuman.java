import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

class GameHuman {

    private int[] board;
    private Window window;
    private Bot bot;
    private Player player;
    private int nbMove;
    private int winner;

    GameHuman(Window window, int[] board, Bot bot, Player player){
        this.window = window;
        this.board = board;
        this.bot = bot;
        this.player = player;
        nbMove = 0;
        winner = 0;
    }


    void StartGame() {
        initializeBoard();
        window.newGame();

        BotTurn();
    }

    private void BotTurn(){
        bot.play();
        nbMove++;
        winner = analyzeMove(nbMove);
        if (winner == 1) {
            bot.won();
            System.out.println("Bot won !");
            window.canvas.removeEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        }
        window.canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }


    private EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
        @Override
        public void handle(MouseEvent e) {

            int action = window.getSquare(e.getX(), e.getY());

            if (window.chooseSquare(action, player.playerNum) == -1)
                return;

            nbMove++;
            winner = analyzeMove(nbMove);

            if (winner == 2) {
                player.won();
                System.out.println("Player won !");
                window.canvas.removeEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            } else {
                BotTurn();
            }
        }
    };


    /**
     * @param nbMove the number of move that happened until now
     * @return the winner if there is one ( p1 or p2 )
     * 0 if there is no winner
     * -1 if it's a draw
     */
    private int analyzeMove(int nbMove) {
        int winner;
        winner = isAligned();
        if (winner != 0)
            return winner;
        if (nbMove > 8)
            return -1;
        return 0;
    }


    /**
     * Is the game finished ?
     * By who ?
     * 0 = no one
     * 1 = p1
     * 2 = p2
     *
     * @return winner (1 for p1, 2 for p2 )
     * 0 if no winner
     */
    private int isAligned() {
        int i, result;
        for (i = 0; i < 3; i++) {
            result = isAlignedHorizontal(i * 3);
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

    private int isAlignedHorizontal(int i) {
        if ((board[i] == board[i + 1]) && (board[i + 1] == board[i + 2]) && board[i] != 0)
            return board[i];
        return 0;
    }

    private int isAlignedVertical(int i) {
        if ((board[i] == board[i + 3]) && (board[i + 3] == board[i + 6]) && board[i] != 0)
            return board[i];
        return 0;
    }

    private int isAlignedDiagonal() {
        if ((board[0] == board[4]) && (board[4] == board[8]) && board[0] != 0)
            return board[0];
        if ((board[2] == board[4]) && (board[4] == board[6]) && board[2] != 0)
            return board[2];
        return 0;
    }


    /**
     * Fill the board of 0's
     */
    private void initializeBoard() {
        for (int i = 0; i < board.length; i++)
            board[i] = 0;
    }
}
