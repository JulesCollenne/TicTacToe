import static java.lang.Math.max;

public class Activation {

    public static double softmax(){
        return 0;
    }

    private static double relu(double x){
        return max(0,x);
    }

    static double[][] relu(double[][] x){
        double[][] y = new double[x.length][x[0].length];
        for(int i=0;i<x.length;i++)
            for(int j=0;j<x[0].length;j++)
                y[i][j] = relu(x[i][j]);
        return y;
    }
}
