import javafx.application.Application;
import javafx.stage.Stage;

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
        int trainIter = 100;
        int board[] = new int[9];

        Window window = new Window(primaryStage,500,400, board);
        window.initialize();

        Population population = new Population(100,window,board);

        Game game;

        for(int i=0;i<trainIter;i++) {
            for(int j = 0; j < population.size-1; j++) {
                for(int k = j+1; k < population.size; k++) {
                    game = new Game(window, board, population.bots[j], population.bots[k]);
                    game.StartGame();
                }
            }
            population.MakeNewGeneration();
            System.out.println((int)((double)(i+1)/(double)trainIter * 100.) + "%");
        }

        Files files = new Files();
        files.saveWeights(population.bots[0]);
    }
}