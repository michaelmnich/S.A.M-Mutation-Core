package matrixlibrary;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by wawrzyniak on 22.06.2016.
 */
public class IdealMatrixMathTest {
    IMatrix a1, a2, a3, a4, a5, a6,a7,a8,a9,a10,a11;
    IMatrix inv1,inv2;
    IMatrixMath math = new IMatrixMathImpl();
    @Before
    public void setUp() throws Exception {
        a1 = new IMatrixImpl(new double[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
        });
        a2 = new IMatrixImpl(new double[][]{
                {0, 2, 4},
                {6, 8, 10},
                {12, 14, 16},
        });
        a3 = new IMatrixImpl(new double[][]{
                {1, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {9, 10, 11},
        });
        a4 = new IMatrixImpl(new double[][]{
                {-1, -1, -2},
                {-3, -4, -5},
                {-6, -7, -8},
                {-9, -10, -11},
        });
        a5 = new IMatrixImpl(new double[][]{
                {15, 18, 21},
                {42, 54, 66},
                {69, 90, 111},
        });
        a6 = new IMatrixImpl(new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},

        });
        a7 = new IMatrixImpl(new double[][]{
                {7, 0, 0, 0},
                {0, 7, 0, 0},
                {0, 0, 7, 0},
                {0, 0, 0, 7},

        });
        a8 = new IMatrixImpl(new double[][]{
                {0, 1, 2},
                {3, 4, 5},
        });
        a9 = new IMatrixImpl(new double[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        a10 = new IMatrixImpl(new double[][]{
                {10, 13},
                {28, 40},

        });
        a11 = new IMatrixImpl(new double[][]{
                {0, 2, 4},
                {1, 3, 5},
        });
        inv1 = new IMatrixImpl(new double[][]{
                {-1, 0, 1},
                {0, 2, 0},
                {1, 0, 5},
        });
        inv2 = new IMatrixImpl(new double[][]{
                {-5.0/6.0, 0, 1.0/6.0},
                {0, 1.0/2.0, 0},
                {1.0/6.0, 0, 1.0/6.0},
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
    public void matrixAddition()
    {
        try {
            IMatrix m1 = math.matrixAddition(a1,a1);
            assertEquals(compareMatrices(m1,a2),true);
        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            IMatrix m2 = math.matrixAddition(a3,a4);
           IMatrix m1 = new IMatrixImpl(4,3);
            assertEquals(compareMatrices(m2,m1),true);
        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            IMatrix m1 = math.matrixAddition(a1,a3);
          fail();
        } catch (InvalidDimensionException e) {
            assert(true);
        }

    }
    @Test
    public void matrixSubtractingtest()
    {
        try {
            IMatrix m1 = math.matrixSubtracting(a1,a1);
            IMatrix m2 = new IMatrixImpl(3,3);
            assertEquals(compareMatrices(m1,m2),true);
        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            IMatrix m2 = math.matrixSubtracting(a3,a3);
            IMatrix m1 = new IMatrixImpl(4,3);
            assertEquals(compareMatrices(m2,m1),true);
        } catch (InvalidDimensionException e) {
            fail();
        }
        try {
            IMatrix m1 = math.matrixSubtracting(a1,a3);
            fail();
        } catch (InvalidDimensionException e) {
            assert(true);
        }
    }
@Test
    public void scalarMultiplicationTest()
{
    IMatrix m1 = math.scalarMultiplication(a6,7.0);

    TestCase.assertEquals(compareMatrices(m1,a7),true);
}
    @Test
    public void matrixMultiplicationTest()
    {
        IMatrix m1 = null;
        try {
            m1 = math.matrixMultiplication(a1,a1);
            TestCase.assertEquals(compareMatrices(m1,a5),true);
        } catch (InvalidDimensionException e) {
         fail();
        }
        try {
            m1 = math.matrixMultiplication(a1,a6);
        fail();
        } catch (InvalidDimensionException e) {
            assert (true);
        }
//
//        try {
//            IMatrix m2 = math.matrixMultiplication(a8,a9);
//            TestCase.assertEquals(compareMatrices(m2,a10),true);
//        } catch (InvalidDimensionException e) {
//            fail();
//        }



    }

    @Test
    public void matrixTranspositionTest()
    {
        IMatrix m1 = null;
        try {
            m1 = math.matrixTransposition(a9);
        } catch (InvalidDimensionException e) {
           fail();
        }
        TestCase.assertEquals(compareMatrices(m1,a11),true);

    }
    @Test
    public void InverseMatrixTest()
    {
        IMatrix m1 = new IMatrixImpl();
        m1.createIdentityMatrix(2);
       IMatrix r1 = math.inverseMatrix(m1);
        TestCase.assertEquals(compareMatrices(r1,m1),true);
        m1 = new IMatrixImpl();
        m1.createIdentityMatrix(3);
        r1 = math.inverseMatrix(m1);
        TestCase.assertEquals(compareMatrices(r1,m1),true);

        m1 = math.inverseMatrix(inv1);
        for(int i =0;i< m1.getWidth();i++)
        {
            for(int j =0;j< m1.getHeight();j++)
            {
                TestCase.assertEquals(m1.getMatrixValue(i,j),inv2.getMatrixValue(i,j),1e-12);
            }
        }



    }

}
