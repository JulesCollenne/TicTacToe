

public class RunAnimation {

    public static void main(String args[]) {
        int trainIter = 50;
        int board[] = new int[9];

        Animation animation = new Animation();

        Population population = new Population(300,animation,board);

        Game game;

        for(int i=0;i<trainIter;i++) {
            for(int j = 0; j < population.size-1; j++) {
                for(int k = j+1; k < population.size; k++) {
                    game = new Game(animation, board, population.bots[j], population.bots[k]);
                    game.StartGame();
                }
            }
            System.out.println("Score moyen : " + population.averageScore());
            population.MakeNewGeneration();
            System.out.println((int)((double)(i+1)/(double)trainIter * 100.) + "%");
        }

        Files files = new Files();
        files.saveWeights(population.bots[0]);
    }
    }
}
