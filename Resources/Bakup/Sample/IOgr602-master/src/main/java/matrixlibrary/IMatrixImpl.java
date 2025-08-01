package matrixlibrary;

public class IMatrixImpl implements IMatrix {

    public void createIdentityMatrix(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.data = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    data[i][j] = 1.0;
                } else {
                    data[i][j] = 0.0;
                }
            }
        }
        width = size;
        height = size;
    }

    public double determinant() throws InvalidDimensionException {
        if (height != width) throw new InvalidDimensionException();
        if (height > 3) throw new InvalidDimensionException("Determinant only implemented up to 3x3 matrices");
        if (height == 1)
            return data[0][0];
        if (height == 2)
            return (data[0][0] * data[1][1]) - (data[0][1] * data[1][0]);
        double a = (data[0][0] * data[1][1] * data[2][2]) + (data[0][1] * data[1][2] * data[2][0]) + (data[0][2] * data[1][0] * data[2][1]);
        double b = (data[2][0] * data[1][1] * data[0][2]) + (data[0][0] * data[1][2] * data[2][1]) + (data[0][1] * data[1][0] * data[2][2]);
        return a - b;
    }

    public double getMatrixValue(int row, int column) {
        return data[row][column];
    }

    public void setMatrixValue(int row, int column, double value) {
        data[row][column] = value;

    }

    public void setMatrixValues(double[][] values) {
        this.width = values.length;
        this.height = values[0].length;
        data = new double[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = values[i][j];
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String toString() {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                build.append(data[j][i] + " ");
            }
            build.append("\n");
        }
        return build.toString();
    }

    public IMatrixImpl() {

    }

    public IMatrixImpl(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new double[width][height];
    }

    public IMatrixImpl(double[][] data) {
        width = data.length;
        height = data[0].length;
        this.data = new double[data.length][data[0].length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    private double[][] data;
    private int width;
    private int height;
}
