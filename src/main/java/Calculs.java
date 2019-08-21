class Calculs {

    /**
     * Return the matrix C, which is matrix product of A and B
     * @param A 1st matrix
     * @param B 2nd matrix
     * @return C, the result of the product
     */
    static double[][] matrixProduct(double A[][], double B[][]){

        if(A.length != B[0].length)
            throw new java.lang.Error("Matrix sizes are not good !");

        double C[][] = new double[B.length][A[0].length];

        for(int i=0;i<B.length;i++){
            for(int j=0;j<A[0].length;j++){
                for(int k=0;k<A.length;k++) {
                    C[i][j] += A[k][j] * B[i][k];
                }
            }
        }
        return C;
    }

    /**
     * Return addition of A + B
     * @param A 1st matrix
     * @param B 2nd matrix
     * @return C, whoch is the matrix A+B
     */
    static double[][] matrixAdd(double A[][], double B[][]) {

        if(A.length != B.length || A[0].length != B[0].length)
            throw new java.lang.Error("Matrix sizes are not good !");

        double y[][] = new double[A.length][A[0].length];

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++) {
                y[i][j] = A[i][j] + B[i][j];
            }
        }

        return y;
    }

    static int max(double[] array){
        int maxInd = 0;
        double max = -9999;

        for(int i = 0; i < array.length; i++){
            if (array[i] > max) {
                max = array[i];
                maxInd = i;
            }
        }
        array[maxInd] = -9999;
        return maxInd;
    }
}
