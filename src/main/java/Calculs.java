class Calculs {

    static double[][] matrixProduct(double A[][], double B[][]){
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

    static double[][] matrixAdd(double A[][], double B[][]) {
        double y[][] = new double[A.length][A[0].length];

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++) {
                y[i][j] = A[i][j] + B[i][j];
            }
        }

        return y;
    }

}
