import java.util.Arrays;
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

    private double mutationRate = 0.2;

    Layer(int nbLinesW,int nbColumnsW, int nbLinesB,int nbColumnsB){
        int i,j;

        Random rand = new Random();

        w0 = new double[nbLinesW][nbColumnsW];
        b0 = new double[nbLinesB][nbColumnsB];


        /*
        for(i = 0; i < nbLinesW; i++)
            for(j = 0; j < nbColumnsW; j++)
                w0[i][j] = rand.nextDouble();

        for(i = 0; i < nbLinesB; i++)
            for(j = 0; j < nbColumnsB; j++)
                b0[i][j] = rand.nextDouble();
                */

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("\n");
        s.append("w0 : \n");
        for(int i = 0; i < w0.length; i++){
            for(int j = 0; j < w0[0].length; j++) {
                s.append(w0[i][j]);
                s.append('\n');
            }
        }

        s.append("\n");
        s.append("b0 : \n");
        for(int i = 0; i < b0.length; i++){
            for(int j = 0; j < b0[0].length; j++) {
                s.append(b0[i][j]);
                s.append('\n');
            }
        }
        return s.toString();
    }

    /**
     * Compute the neural network of the layer
     * @param input input
     * @return output
     */
    double[][] compute(double[][] input){
        output =  Activation.relu(Calculs.matrixAdd(Calculs.matrixProduct(w0,input),b0));
        //output =  Activation.sigmoid(Calculs.matrixAdd(Calculs.matrixProduct(w0,input),b0));
        return output;
    }

    /**
     * Compute the last layer of the neural network of the layer
     * @param input input
     * @return output
     */
    double[][] computeLast(double[][] input){
        //System.out.println("Poids : " + Arrays.deepToString(input));
        //output =  Activation.softmax(Calculs.matrixAdd(Calculs.matrixProduct(w0,input),b0));
        //System.out.println("Poids après : " + Arrays.deepToString(output));
        output =  Activation.sigmoid(Calculs.matrixAdd(Calculs.matrixProduct(w0,input),b0));
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

    /**
     *
     */
    void mutate() {
        int i,j;
        double mutationStrength;
        Random rand = new Random();

        for(i = 0; i < w0.length; i++){
            for(j = 0; j < w0[0].length; j++){
                mutationStrength = rand.nextDouble()/10 - 0.05;
                w0[i][j] += rand.nextDouble() < mutationRate ? mutationStrength : 0;
            }
        }

        for(i = 0; i < b0.length; i++){
            for(j = 0; j < b0[0].length; j++){
                mutationStrength = rand.nextDouble()/10 - 0.05;
                b0[i][j] += rand.nextDouble() < mutationRate ? mutationStrength : 0;
            }
        }
    }
}
