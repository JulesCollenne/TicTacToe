import org.junit.Test;

import java.util.Arrays;

public class TestActivation {

    @Test
    public void relu1Double() {
        double result;

        result = Activation.relu(0.2);
        assert result == 0.2;

        result = Activation.relu(-10);
        assert result == 0;
    }

    @Test
    public void relu() {
        double[][] result = new double[2][2];
        result[0][0] = 0.2;
        result[0][1] = 2;
        result[1][0] = -0.5;
        result[1][1] = -5;

        result = Activation.relu(result);

        assert result[0][0] == 0.2;
        assert result[0][1] == 2;
        assert result[1][0] == 0;
        assert result[1][1] == 0;

    }

    @Test
    public void softmax() {
        double[][] result = new double[2][2];
        result[0][0] = 1;
        result[0][1] = 1;
        result[1][0] = -0.5;
        result[1][1] = 5;

        result = Activation.softmax(result);

        System.out.println(Arrays.deepToString(result));
    }
}
