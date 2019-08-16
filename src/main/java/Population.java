public class Population {
    int size;
    Bot bots[];
    int currentBaby;

    /**
     *
     * Population size MUST be even
     * @param size size of population ( EVEN )
     */
    public Population(int size) {
        this.size = size;
        bots = new Bot[this.size];
        currentBaby = size/2;
    }

    /**
     * Mixing 2 bots together to make a new one
     * ( Mixing genes )
     * @param b1 first bot
     * @param b2 second bot
     */
    public void Crossover(Bot b1, Bot b2){
        int i;

        Bot baby = new Bot(b1.window,b1.board,currentBaby);

        for(i = 0; i < b1.network.nbLayer; i++){

        }
    }

    public void MakeNewGeneration(){
        int i, botNum,newInd = 0;

        Bot[] newGeneration = new Bot[size];

        for(i = 0; i < size; i++){
            if(bots[i].won) {
                newGeneration[newInd] = bots[i];
                newInd++;
            }
        }


    }
}
