import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Run is the class that will run the program
 * Window will be created etc...
 *
 */
public class RunHuman extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        window.initialize();

        GameHuman game;

        Bot bot = new Bot(window,board,1);
        Player player = new Player(window,board,2);

        game = new GameHuman(window, board,bot, player);
        game.StartGame();
    }
}