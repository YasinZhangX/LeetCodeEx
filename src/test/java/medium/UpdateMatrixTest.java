package medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yasin Zhang
 */
public class UpdateMatrixTest {

    @Test
    public void updateMatrix() {
        int[][] matrix = {
            {1,1,0,0,1,0,0,1,1,0},
            {1,0,0,1,0,1,1,1,1,1},
            {1,1,1,0,0,1,1,1,1,0},
            {0,1,1,1,0,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,0},
            {1,1,1,1,1,1,0,1,1,1},
            {0,1,1,1,1,1,1,0,0,1},
            {1,1,1,1,1,0,0,1,1,1},
            {0,1,0,1,1,0,1,1,1,1},
            {1,1,1,0,1,0,1,1,1,1}};
        UpdateMatrix alg = new UpdateMatrix();
        alg.updateMatrix(matrix);
    }
}
