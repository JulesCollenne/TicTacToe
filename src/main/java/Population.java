class Population {
    private Window window;
    int[] board;
    int size;
    Bot bots[];
    private int currentBaby;

    /**
     *
     * Population size MUST be even
     * @param size size of population ( EVEN )
     */
    Population(int size, Window window, int[] board) {
        this.size = size;
        currentBaby = size/2;
        this.window = window;
        this.board = board;

        bots = new Bot[this.size];

        for(int i = 0; i < size; i += 2) {
            bots[i] = new Bot(window, board, 1);
            bots[i+1] = new Bot(window, board, 2);
        }
    }

    /**
     * Mixing 2 bots together to make a new one
     * ( Mixing genes )
     * @param b1 first bot
     * @param b2 second bot
     */
    private Bot Crossover(Bot b1, Bot b2){
        Bot baby = new Bot(b1.window,b1.board,currentBaby);

        baby.initializeGenes(b1,b2);

        return baby;
    }

    /**
     * Make a new generation of Bots by crossing over the genes of the winner bots
     */
    void MakeNewGeneration(){
        int i, botNum = size/2,newInd = 0;

        Bot[] newGeneration = new Bot[size];

        while(newInd < size/2) {
            for (i = 0; i < size; i++) {
                if (bots[i].won) {
                    newGeneration[newInd] = bots[i];
                    newInd++;
                }
            }
        }

        for(i = 0; i < size/2; i+=2){
            newGeneration[botNum] = Crossover(newGeneration[i],newGeneration[i+1]);
            botNum++;
            newGeneration[botNum] = Crossover(newGeneration[i],newGeneration[i+1]);
            botNum++;
        }


    }
}
