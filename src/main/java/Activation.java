import static java.lang.Math.max;

public class Activation {

    public static double[][] softmax(double[][] x){
        double sum = 0;
        for(int i = 0;i < x.length; i++)
            for (int j = 0; j < x[i].length; j++)
                sum += Math.exp(x[i][j]);

        for(int i = 0; i < x.length; i++)
            for(int j = 0; j < x[i].length; j++)
            x[i][j] /= sum;

        return x;
    }

    static double relu(double x){
        return max(0,x);
    }

    static double[][] relu(double[][] x){
        double[][] y = new double[x.length][x[0].length];
        for(int i=0;i<x.length;i++)
            for(int j=0;j<x[0].length;j++)
                y[i][j] = relu(x[i][j]);
        return y;
    }

    static double[][] sigmoid(double[][] x){
        double[][] y = new double[x.length][x[0].length];
        for(int i=0;i<x.length;i++)
            for(int j=0;j<x[0].length;j++)
                y[i][j] = Math.exp(x[i][j])/(Math.exp(x[i][j])+1);
        return y;
    }

}
