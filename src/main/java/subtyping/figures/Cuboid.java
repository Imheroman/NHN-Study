package subtyping.figures;

/**
 * 직육면체
 * 가로(x)와 세로(y)를 가진다.
 */
public final class Cuboid implements Figure {
    private final int x;
    private final int y;
    private final int h;

    /**
     * 생성자
     * 직육면체는 모든 변의 길이가 동일하기 때문에 1개의 값만을 받는다.
     *
     * @param x 정육면체 한 변의 길이를 가진다.
     */
    /**
     * 생성자
     * 직육면체는 가로, 세로, 높이의 값을 가지기 때문에 3개의 파라미터를 갖는다.
     *
     * @param x 정육면체의 가로
     * @param y 정육면체의 세로
     * @param h 정육면체의 높이
     */
    public Cuboid(int x, int y, int h) {
        this.classInvariant(x, y, h);

        this.x = x;
        this.y = y;
        this.h = h;
    }

    /**
     * 직육면체의 넓이를 구하는 method
     *
     * @return 가로(x)와 세로(y)를 곱한 면이 총 4개 + 세로(y)와 높이(h)를 곱한 면이 총 2개가 있기 때문에 두개의 결과를 더해서 반환한다.
     */
    @Override
    public int getArea() {
        return Math.multiplyExact(Math.multiplyExact(x, y), 4) + Math.multiplyExact(Math.multiplyExact(y, h), 2);
    }

    @Override
    public String toString() {
        return "직육면체의 넓이: " + getArea();
    }
}
