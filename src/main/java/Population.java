import java.util.Random;

class Population {
    private Window window;
    int[] board;
    int size;
    Bot bots[];

    /**
     *
     * Population size MUST be even
     * @param size size of population ( EVEN )
     */
    Population(int size, Window window, int[] board) {
        this.size = size;
        this.window = window;
        this.board = board;

        bots = new Bot[this.size];

        for(int i = 0; i < size; i++)
            bots[i] = new Bot(window, board);
    }

    /**
     * Mixing 2 bots together to make a new one
     * ( Mixing genes )
     * @param b1 first bot
     * @param b2 second bot
     */
    Bot Crossover(Bot b1, Bot b2){
        Bot baby = new Bot(b1.window,b1.board);

        baby.initializeGenes(b1,b2);

        return baby;
    }

    /**
     * Make a new generation of Bots by crossing over the genes of the winner bots
     */
    void MakeNewGeneration(){
        int i;

        int selection = 4;

        Bot[] newGeneration = new Bot[size];

        rankByScore();

        for (i = 0; i < size/selection; i++)
                newGeneration[i] = bots[i];

        if(newGeneration[1] == null)
            throw new Error("Only one bot alive !");

        int newInd = size/selection;

        while(newInd < size) {
            for (i = 0; newInd < size && i < newGeneration.length-1; i++) {
                newGeneration[newInd] = Crossover(newGeneration[i], newGeneration[i + 1]);
                newInd++;
            }
        }

        bots = newGeneration;
        //mixBots();

        for(i = 0; i < bots.length; i++){
            bots[i].won = false;
            bots[i].score = 0;
            bots[i].mutate();
            bots[i].disqualified = false;
        }
    }

    private void rouletteWheel(){

    }


    /**
     * Rank the bots in bots[] by score
     * 1st has highest score etc...
     */
    private void rankByScore(){
        int max, maxInd = 0;
        Bot tmp;
        for(int i = 0; i < size; i++){
            max = 0;
            for(int j = i; j < size; j++){
                if(bots[j].score > max){
                    max = bots[j].score;
                    maxInd = j;
                }
            }
            tmp = bots[i];
            bots[i] = bots[maxInd];
            bots[maxInd] = tmp;
        }
    }

    /**
     * Not used anymore.
     * To mix bots
     */
    private void mixBots(){
        Random rand = new Random();
        int randNb;
        Bot tmp;
        for(int i = 0; i < bots.length; i++){
            randNb = rand.nextInt(bots.length);
            tmp = bots[i];
            bots[i] = bots[randNb];
            bots[randNb] = tmp;
        }
    }
}
