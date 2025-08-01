package matrixlibrary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by wawrzyniak on 22.06.2016.
 */
public class IdealMatrixTest {
    IMatrix a1, a2, a3, a4, a5, a6,a7;

    @Before
    public void setUp() throws Exception {
        a1 = new IMatrixImpl(new double[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
        });
        a2 = new IMatrixImpl(new double[][]{
                {1, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
        });
        a3 = new IMatrixImpl(new double[][]{
                {1, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {9, 10, 11},
        });
        a4 = new IMatrixImpl();
        a5 = new IMatrixImpl(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        });
        a6 = new IMatrixImpl(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
        });
        a7 = new IMatrixImpl(new double[][]{
                {-1, 2,},
                {3, 4.4},

        });



    }

    @After
    public void tearDown() throws Exception {

    }

    private boolean compareMatrices(IMatrix m1, IMatrix m2) {
        if ((m1.getHeight() == m2.getHeight()) && (m1.getWidth() == m2.getWidth())) {
            for (int i = 0; i < m1.getWidth(); i++) {
                for (int j = 0; j < m1.getHeight(); j++) {
                    if (m1.getMatrixValue(i, j) != m2.getMatrixValue(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Test
    public void constructorAndGetTest() {

        boolean b = compareMatrices(a1, a1);
        assertEquals(b, true);
        b = compareMatrices(a1, a2);
        assertEquals(b, false);
        b = compareMatrices(a1, a3);
        assertEquals(b, false);
    }

    @Test
    public void createIdentityMatrixTest() {
        a4.createIdentityMatrix(3);
        assertEquals(compareMatrices(a4, a5), true);
        a4.createIdentityMatrix(4);
        assertEquals(compareMatrices(a4, a6), true);
        try {
            a4.createIdentityMatrix(0);
        } catch (IllegalArgumentException e) {
            assert (true);
        }
        try {
            a4.createIdentityMatrix(-3);
        } catch (IllegalArgumentException e) {
            assert (true);
        }
    }

    @Test
    public void setMatrixValueTest() {

        a1.setMatrixValue(0, 0, 2.3);
        a1.setMatrixValue(1, 2, 1.5);
        double v1 = a1.getMatrixValue(0, 0);
        double v2 = a1.getMatrixValue(1, 2);
        assertEquals(v1, 2.3, 0.0000001);
        assertEquals(v2, 1.5, 0.0000001);
        try {
            a1.setMatrixValues(new double[][]{
                    {1, 1, 2},
                    {3, 4, 5},
                    {6, 7, 8},
            });
        } catch (InvalidDimensionException e) {
            fail();
        }
        assertEquals(compareMatrices(a1, a2), true);
        try {
            a1.setMatrixValues(new double[][]{
                    {0, 1, 2},
                    {3, 4, 5},
                    {6, 7, 8},
                    {6, 7, 8},
            });
        } catch (InvalidDimensionException e) {
            assert (true);
        }
        try {
            a1 = new IMatrixImpl(3, 4);
            a1.setMatrixValues(new double[][]{
                    {1, 1, 2},
                    {3, 4, 5},
                    {6, 7, 8},
                    {9, 10, 11},
            });
        } catch (InvalidDimensionException e) {
            fail();
        }
        assertEquals(compareMatrices(a1, a3), true);


    }

    @Test
    public void DimensionTest() {
        assertEquals(a3.getWidth(), 4);
        assertEquals(a3.getHeight(), 3);
    }

    @Test
    public void determinantTest()
    {
        try {
            assertEquals(a1.determinant(),0.0,1e-12);

        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            assertEquals(a2.determinant(),-3.0,1e-12);

        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            assertEquals(a7.determinant(),-10.4,1e-12);

        } catch (InvalidDimensionException e) {
            fail();
        }

    }
}
