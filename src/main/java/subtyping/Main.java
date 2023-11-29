package subtyping;

import subtyping.figures.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int x = 5;
    public static final int y = 10;
    public static final int height = 15;

    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<Figure>();
        figures.add(new Square(x));
        figures.add(new Rectangle(x, y));
        figures.add(new Cube(x));
        figures.add(new Cuboid(x, y, height));

        for (Figure figure :
                figures) {
            System.out.println(figure);
        }
//        Figure square = new Square(x);
//        Figure rectangle = new Rectangle(x, y);
//        Figure cube = new Cube(x);
//        Figure cuboid = new Cuboid(x, y, height);
//        System.out.println("정사각형의 넓이: " + square.getArea());
//        System.out.println("직사각형의 넓이: " + rectangle.getArea());
//        System.out.println("정육면체의 넓이: " + cube.getArea());
//        System.out.println("직육면체의 넓이: " + cuboid.getArea());
    }
}
