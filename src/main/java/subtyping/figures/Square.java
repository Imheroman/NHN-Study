package subtyping.figures;

/**
 * 정사각형
 * 가로(x)와 세로(y)를 가진다.
 */
public final class Square implements Figure {
    private final int x;

    /**
     * 생성자
     * 정사각형은 모든 변의 길이가 동일하기 때문에 1개의 값만을 받는다.
     *
     * @param x 정사각형의 한 변의 길이를 가진다.
     */
    public Square(int x) {
        this.classInvariant(x);

        this.x = x;
    }

    /**
     * 정사각형의 넓이를 구하는 method
     *
     * @return 가로(x)와 세로(x)를 곱한 결과를 반환한다.
     */
    @Override
    public int getArea() {
        return Math.multiplyExact(x, x);
    }

    @Override
    public String toString() {
        return "정사각형의 넓이: " + getArea();
    }
}
