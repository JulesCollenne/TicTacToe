class Network {
    int nbLayer;
    Layer[] layers;

    /**
        hi+1 = sigma( w * h + b0 )

        inputSize might change. It's the size of the board

     **/

    Network(int nbLayer){
        this.nbLayer = nbLayer;
        this.layers = new Layer[nbLayer];
        int inputSize = 9;


        //TODO modifier les tailles des matrices w si nécessaire
        layers[0] = new Layer(1, inputSize, inputSize, inputSize);

        for(int i = 1; i < nbLayer-1; i++){
            layers[i] = new Layer(inputSize, inputSize, inputSize, inputSize);
        }

        layers[nbLayer-1] = new Layer(inputSize,1, inputSize,1);
    }

    /**
     * Compute output of the network depending on input
     * @param rawInput entrée
     * @return output
     */
    int computeOutput(int[] rawInput){
        double[][] input;
        int action;

        input = makeInput(rawInput);

        layers[1].input = layers[0].compute(input);
        for(int i=1;i<layers.length-1;i++){
            layers[i+1].input = layers[i].compute(layers[i-1].output);
        }
        double[][] output = layers[nbLayer - 1].compute(layers[layers.length - 2].output);
        action = chooseBest(output);
        return action;
    }

    /**
     * Correct the type of the input
     * @param rawInput the input of a bad type
     * @return the correct input of the good type
     */
    private double[][] makeInput(int[] rawInput){
        double[][] input = new double[1][rawInput.length];

        normalize(input);

        return input;
    }

    /**
     * Normalize the input matrix
     * @param input input
     */
    private void normalize(double[][] input){
        for(int i = 0; i < input.length; i++)
            for(int j = 0; j < input.length; j++)
            input[i][j] /= 2;
    }

    /**
     * Take the best move ( higher score )
     * @param output outpute of the neural network
     * @return maximum ind, the bets move found
     */
    private int chooseBest(double[][] output){
        double max = 0;
        int maxInd = 0;
        for(int i = 0; i < output.length; i++) {
            if(max < output[i][0]){
                max = output[i][0];
                maxInd = i;
            }
        }
        return  maxInd;
    }

    void mixGenes(Network n1, Network n2) {
        for(int i = 0; i < nbLayer; i++){
            layers[i].mixWeights(n1.layers[i], n2.layers[i]);
        }
    }

    void mutate() {
        for(Layer layer : layers){
            layer.mutate();
        }
    }
}
