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

        Population population = new Population(20,window,board);

        Game game;

        //game = new Game(window, board,population.bots[i],population.bots[i+1]);
        //game.StartGame();
    }
}