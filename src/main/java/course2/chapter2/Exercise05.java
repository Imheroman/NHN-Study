package course2.chapter2;

public class Exercise05 {
    public static final int grossValue = 144;
    public static final int dozenValue = 12;


    public static void main(String[] args) {
        int eggs = 1342;
        int gross = eggs / grossValue;
        int dozen = (eggs % grossValue) / dozenValue;
        int remain = eggs % dozenValue;

        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + remain);
    }
}
