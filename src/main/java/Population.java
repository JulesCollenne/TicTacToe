import java.util.Random;

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
        currentBaby = 1;
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
    Bot Crossover(Bot b1, Bot b2){
        Bot baby = new Bot(b1.window,b1.board,currentBaby);
        currentBaby = currentBaby == 1 ? 2 : 1;

        baby.initializeGenes(b1,b2);

        return baby;
    }

    /**
     * Make a new generation of Bots by crossing over the genes of the winner bots
     */
    void MakeNewGeneration(){
        int i,newInd = 0;

        Bot[] newGeneration = new Bot[size];
        for (i = 0; i < size; i++) {
            if (bots[i].won) {
                newGeneration[newInd] = bots[i];
                newInd++;
            }
        }

        if(newInd == 1)
            newGeneration[1] = new Bot(window,board,1);

        while(newInd < size) {
            for (i = 0; newInd < size && i < newGeneration.length-1; i++) {
                newGeneration[newInd] = Crossover(newGeneration[i], newGeneration[i + 1]);
                newInd++;
            }
        }
        System.out.println(bots[0].network.layers[0].w0[0][0]);
        bots = newGeneration;
        mixBots();
        System.out.println(bots[0].network.layers[0].w0[0][0]);

        for(i = 0; i < bots.length; i++){
            bots[i].won = false;
            bots[i].mutate();
        }
    }


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

        for(int i = 0; i < bots.length-1; i += 2){
            bots[i].playerNum = 1;
            bots[i+1].playerNum = 2;
        }
    }
}
