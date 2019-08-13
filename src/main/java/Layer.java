public class Layer {
    double[][] input;
    double[][] w0;
    double[][] b0;

    double[][] output;

    public double[][] compute(double[][] input){
        return Activation.relu(Calculs.matrixProduct(w0,input));
    }

}
