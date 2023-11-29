package subtyping.figures;

/**
 * 직사각형
 * 가로(x)와 세로(y)를 가진다.
 */
public final class Rectangle implements Figure {
    private final int x;
    private final int y;

    /**
     * 생성자
     *
     * @param x 직사각형의 가로의 값을 가진다.
     * @param y 직사각형의 세로의 값을 가진다.
     */
    public Rectangle(int x, int y) {
        this.classInvariant(x, y);

        this.x = x;
        this.y = y;
    }

    /**
     * 직사각형의 넓이를 구하는 method
     *
     * @return 가로(x)와 세로(y)를 곱한 결과를 반환한다.
     */
    @Override
    public int getArea() {
        return x * y;
    }

    @Override
    public String toString() {
        return "직사각형의 넓이: " + getArea();
    }
}
