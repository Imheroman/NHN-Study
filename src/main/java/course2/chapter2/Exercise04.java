package course2.chapter2;

import java.util.Scanner;

public class Exercise04 {
    public static final int quarter = 25;
    public static final int dime = 10;
    public static final int nickels = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자에게 동전 갯수를 입력받음
        System.out.print("input numbers of quarter: ");
        int quarters = sc.nextInt();

        System.out.print("input numbers of dime: ");
        int dimes = sc.nextInt();

        System.out.print("input numbers of nickel: ");
        int nickels = sc.nextInt();

        System.out.print("input numbers of pennie: ");
        int pennies = sc.nextInt();

        // 동전 금액을 계산
        double totalCents = quarters * quarter + dimes * dime + nickels * nickels + pennies;
        double totalDollars = totalCents / 100.0;

        // 결과 출력
        System.out.println("보유한 돈은 $" + totalDollars + " 입니다.");

    }
}
