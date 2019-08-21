import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;

public class TestPopulation extends Application {

    @Override
    public void start(Stage primaryStage) {
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        Bot b1 = new Bot(window, board,1);
        Bot b2 = new Bot(window, board,2);

        Population population = new Population(10,window,board);

        testCrossover(population,b1,b2);
    }

    @Test
    public void testCrossover(Population population, Bot b1, Bot b2) {
        Bot baby = population.Crossover(b1, b2);

        System.out.println(baby);

    }
}
