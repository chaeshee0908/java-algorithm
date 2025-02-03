package Doit.정수론;

import java.util.Scanner;

public class N037_소수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for (int now = M; now <= N; now++) {
            checkPrimeNumber(now);
        }
    }

    private static void checkPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            System.out.println(number);
            return;
        }
        if (number == 1 || number % 2 == 0)
            return;
        for (int i = 3; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return;
            }
        }
        System.out.println(number);
    }
}
