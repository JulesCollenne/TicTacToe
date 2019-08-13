import javafx.application.Application;
import javafx.stage.Stage;

public class TestWindow extends Application {

    Window window;

    public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            window = new Window(primaryStage,500,400);
            Bot bot = new Bot();


            int[] board = new int[9];
            for(int i=0;i<9;i++)
                board[i] = 1;

            board[2] = 2;
            board[7] = 2;

            window.initialize();
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