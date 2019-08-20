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
    }

}
