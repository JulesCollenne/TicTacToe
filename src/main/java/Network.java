public class Network {
    int inputSize;
    int nbLayer;
    Layer[] layers;
    double[][] output;

    /**
        hi+1 = sigma( w * h + b0 )

        inputSize might change. It's the size of the board

     **/

    Network(int nbLayer){
        this.nbLayer = nbLayer;
        this.layers = new Layer[nbLayer];
        this.inputSize = 9;


        //TODO gérer les tailles de matrices
        layers[0] = new Layer(1,inputSize,inputSize,inputSize);

        for(int i = 1; i < nbLayer-1; i++){
            layers[i] = new Layer(inputSize,inputSize,inputSize,inputSize);
        }

        layers[nbLayer-1] = new Layer(inputSize,1,inputSize,1);
    }

    /**
     * Compute output of the network depending on input
     * @param input entrée
     * @return output
     */

    public double[][] computeOutput(double[][] input){
        layers[1].input = layers[0].compute(input);
        for(int i=1;i<layers.length-1;i++){
            layers[i+1].input = layers[i].compute(input);
        }
        output = layers[nbLayer].output;
        return output;
    }
}
