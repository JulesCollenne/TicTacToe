import org.junit.Test;

public class TestCalculs {

    @Test
    public void testMatrixAdd() {
        double[][] A = new double[2][2];
        double[][] B = new double[2][2];
        double[][] result;

        A[0][0] = 0.2;
        A[0][1] = 2;
        A[1][0] = -0.5;
        A[1][1] = -5;

        B[0][0] = 0.8;
        B[0][1] = 2;
        B[1][0] = -0.5;
        B[1][1] = -5;

        result = Calculs.matrixAdd(A,B);

        assert result[0][0] == 1;
        assert result[0][1] == 4;
        assert result[1][0] == -1;
        assert result[1][1] == -10;
    }

    @Test
    public void testMatrixProduct() {
        double[][] A = new double[2][2];
        double[][] B = new double[2][2];
        double[][] result;

        A[0][0] = 1;
        A[1][0] = 2;
        A[0][1] = 3;
        A[1][1] = 4;

        B[0][0] = 1;
        B[1][0] = 2;
        B[0][1] = 3;
        B[1][1] = 4;

        result = Calculs.matrixProduct(A,B);

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }

        assert result[0][0] == 7;
        assert result[1][0] == 10;
        assert result[0][1] == 15;
        assert result[1][1] == 22;
    }

}
