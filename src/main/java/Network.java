public class Network {
    int nbLayer;
    Layer[] layers;
    double[][] output;

    /*
    hi+1 = sigma( w * h + b0 )
     */

    public Network(int nbLayer){
        this.nbLayer = nbLayer;
    }

    public double[][] computeOutput(double[][] input){
        layers[1].input = layers[0].compute(input);
        for(int i=1;i<layers.length-1;i++){
            layers[i+1].input = layers[i].compute(input);
        }
        output = layers[nbLayer].output;
        return output;
    }
}
