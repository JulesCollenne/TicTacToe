import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int trainIter = 5;
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        Game game = new Game(window, board);

        window.initialize();

        for(int i=0;i<trainIter;i++) {
            game.StartGame();
        }
    }
}