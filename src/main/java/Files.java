import java.io.BufferedReader;
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
    private BufferedReader bufferedReader;

    /**
     * Save the weigths of the bot inside a file ( weights.txt )
     * @param bot the bot containing the weights
     */
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

    /**
     * Load weights from file to bot
     * @param bot we will save this bot's weights
     */
    void loadWeights(Bot bot){

        try {
            fileReader = new FileReader("weights.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        bufferedReader = new BufferedReader(fileReader);

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

    /**
     * Write the matrix inside the file
     * @param matrix matric of weight we gonna write
     */
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

    /**
     * Read the file and put it inside the matrix
     * @param matrix that gonna contain the file's data
     */
    private void readMatrix(double [][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                try {
                    matrix[i][j] = Double.parseDouble(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
