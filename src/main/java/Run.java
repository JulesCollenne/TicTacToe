import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Run is the class that will run the program
 * Window will be created etc...
 *
 */
public class Run extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int trainIter = 1000;
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        window.initialize();

        Population population = new Population(50,window,board);

        Game game;

        for(int i=0;i<trainIter;i++) {
            for(int j = 0; j < population.size; j += 2) {
                game = new Game(window, board,population.bots[j],population.bots[j+1]);
                game.StartGame();
            }
            population.MakeNewGeneration();
            System.out.println((int)((double)(i+1)/(double)trainIter * 100.) + "%");
        }

        Files files = new Files();
        files.saveWeights(population.bots[0]);
    }
}