import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestNetwork extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Test
    public void testNetwork() {
        Network network = new Network(5);

        for(int i = 0;  i < network.nbLayer; i++){
            network.layers[i].w0[0][0] = 2;
        }
    }

}
