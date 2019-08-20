import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The following class saves and loads
 * weights of any bot inside a file
 * called "weights.txt".
 *
 * Its organization is the following :
 *
 * For each layer of the network{
 *  1.w0
 *  2.b0
 * }
 *
 */
class Files {

    private FileWriter fileWriter;
    private FileReader fileReader;

    void saveWeights(Bot bot) {

        try {
            fileWriter = new FileWriter("weights.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Network network = bot.network;
        Layer layer;

        for(int currentLayer = 0; currentLayer < network.nbLayer; currentLayer++){
            layer = network.layers[currentLayer];
            writeMatrix(layer.w0);
            writeMatrix(layer.b0);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadWeights(Bot bot){

        try {
            fileReader = new FileReader("weights.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Network network = bot.network;
        Layer layer;

        for(int currentLayer = 0; currentLayer < network.nbLayer; currentLayer++){
            layer = network.layers[currentLayer];
            readMatrix(layer.w0);
            readMatrix(layer.b0);
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeMatrix(double[][] matrix){
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                try {
                    fileWriter.write(Double.toString(aMatrix[j]));
                    fileWriter.write('\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void readMatrix(double [][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                try {
                    matrix[i][j] = fileReader.read();
                    System.out.println(matrix[i][j]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
