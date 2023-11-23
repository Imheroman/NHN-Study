package subtyping.figures;

/**
 * 정육면체
 * 가로(x)와 세로(y)를 가진다.
 */
public final class Cube implements Figure {
    private final int x;

    /**
     * 생성자
     * 정육면체는 모든 변의 길이가 동일하기 때문에 1개의 값만을 받는다.
     *
     * @param x 정육면체 한 변의 길이를 가진다.
     */
    public Cube(int x) {
        this.classInvariant(x);

        this.x = x;
    }

    /**
     * 정육면체의 넓이를 구하는 method
     *
     * @return 가로(x)와 세로(x)를 곱한 면이 총 6개 있기 때문에 6을 곱한 값을 반환한다.
     */
    @Override
    public int getArea() {
        return Math.multiplyExact(Math.multiplyExact(x, x), 6);
    }

    @Override
    public String toString() {
        return "정육면체의 넓이: " + getArea();
    }
}
