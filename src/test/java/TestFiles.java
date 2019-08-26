import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.IOException;

public class TestFiles extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        Bot bot = new Bot(window, board);

        testWrite(bot);
        //testRead(bot);
    }

    @Test
    public void testWrite(Bot bot){
        Files files = new Files();
        files.saveWeights(bot);
    }

    @Test
    public void testRead(Bot bot){
        Files files = new Files();
        files.loadWeights(bot);
    }
}
