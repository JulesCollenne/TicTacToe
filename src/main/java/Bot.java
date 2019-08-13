import static java.lang.Math.pow;
import static java.lang.Math.random;

public class Bot {
    double score[][];
    Network network;

    /*

    action : 1 | 2 | 3
             4 | 5 | 6
             7 | 8 | 9
     */

    public Bot(){
        score = new double[100000000][9];
    }


    public int ChooseAction(int state){

        int action = 0;

        action = ComputeBest(state);

        return action;
    }

    public int ComputeBest(int i) {
        double max = 0;
        int maxInd = 0;
        for (int j = 0; j < 9; j++)
            if (score[i][j] > max) {
                maxInd = j;
                max = score[i][j];
            }
        return maxInd;
    }
}
