import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int trainIter = 100;

        Window window = new Window(primaryStage,500,400);
        Game game = new Game(window);

        window.initialize();

        for(int i=0;i<trainIter;i++) {


        }
    }
}