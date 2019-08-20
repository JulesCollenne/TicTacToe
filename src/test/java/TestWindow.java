import javafx.application.Application;
import javafx.stage.Stage;

public class TestWindow extends Application {

    public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            int board[] = new int[9];

            Window window = new Window(primaryStage,500,400, board);
            Bot bot = new Bot(window, board,1);

            for(int i=0;i<9;i++)
                board[i] = 1;

            board[2] = 2;
            board[7] = 2;

            window.initialize();
            window.newGame();
            window.drawPieces(board);
        }



    /*
    @Test
    public void testDrawBoard() {
        assertThat(outContent.toString(), equalTo(expectedOutput));
    }

    @Test
    public void testPrintLaTeX() {
        assertThat(outContent.toString(), equalTo(expectedOutput));
    }
    */
}