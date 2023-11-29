package subtyping.figures;

/**
 * 도형들을 같은 속성으로 표현하기 위해 사용되는 interface
 */
public interface Figure {
    default void classInvariant(int x, int y) {
        classInvariant(x, y, 1);
    }

    default void classInvariant(int x) {
        classInvariant(x, 1, 1);
    }

    /**
     * 직육면체의 변수가 3개있으니 총 3개까지의 값을 검사한다.
     * <p>
     * 도형은 길이가 0이하가 될 수 없기 때문에
     * 0이하의 수가 들어오면 error를 던진다.
     *
     * @param x 가로의 길이
     * @param y 세로의 길이
     * @param h 높이의 길이
     */
    default void classInvariant(int x, int y, int h) {
        if (x <= 0 || y <= 0 || h <= 0) {
            throw new IllegalArgumentException("The length can't be less than 0");
        }
    }

    /**
     * 도형의 넓이를 구하기 위한 method
     * 모든 도형엔 넓이가 있어야 한다.
     *
     * @return 도형의 넓이
     */
    int getArea();
}
