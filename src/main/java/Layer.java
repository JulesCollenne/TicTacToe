import java.util.Random;

/**
 * Layer class, used in the Network class
 * One Network has several Layers
 */
class Layer {
    double[][] input;
    double[][] w0;
    double[][] b0;

    double[][] output;

    private double mutationRate = 0.25;
    private double mutationStrength = 0.1;

    Layer(int nbLinesW,int nbColumnsW, int nbLinesB,int nbColumnsB){
        int i,j;

        Random rand = new Random();

        w0 = new double[nbLinesW][nbColumnsW];
        b0 = new double[nbLinesB][nbColumnsB];

        for(i = 0; i < nbLinesW; i++)
            for(j = 0; j < nbColumnsW; j++)
                w0[i][j] = rand.nextDouble();

        for(i = 0; i < nbLinesB; i++)
            for(j = 0; j < nbColumnsB; j++)
                b0[i][j] = rand.nextDouble();
    }

    /**
     * Compute the neural network of the layer
     * @param input input
     * @return output
     */
    double[][] compute(double[][] input){

        output =  Calculs.matrixProduct(w0,input);
        output =  Calculs.matrixAdd(output,b0);
        output =  Activation.relu(output);
        //output =  Activation.relu(Calculs.matrixAdd(Calculs.matrixProduct(w0,input),b0)); // TODO erreur ici : la matrice resultante devrait toujours etre de taille 1x9 mais des fois elle est 1x1 !
        System.out.println(output.length + " " + output[0].length);
        return output;
    }

    /**
     * Make a new baby by mixing 2 genes
     * @param l1 parent 1
     * @param l2 parent 2 (lol)
     */
    void mixWeights(Layer l1, Layer l2) {
        int i,j;
        Random rand = new Random();

        for(i = 0; i < w0.length; i++){
            for(j = 0; j < w0[0].length; j++){
                w0[i][j] = rand.nextDouble() < 0.5 ? l1.w0[i][j] : l2.w0[i][j];
            }
        }

        for(i = 0; i < b0.length; i++){
            for(j = 0; j < b0[0].length; j++){
                b0[i][j] = rand.nextDouble() < 0.5 ? l1.b0[i][j] : l2.b0[i][j];
            }
        }
    }

    void mutate() {
        int i,j;
        Random rand = new Random();

        for(i = 0; i < w0.length; i++){
            for(j = 0; j < w0[0].length; j++){
                w0[i][j] += rand.nextDouble() < mutationRate ? mutationStrength : 0;
            }
        }

        for(i = 0; i < b0.length; i++){
            for(j = 0; j < b0[0].length; j++){
                b0[i][j] += rand.nextDouble() < mutationRate ? mutationStrength : 0;
            }
        }
    }
}
