import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Run extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int trainIter = 100;

        Window window = new Window(primaryStage,500,400);

        window.initialize();

        for(int i=0;i<trainIter;i++) {
            window.newGame();

        }


    }
}