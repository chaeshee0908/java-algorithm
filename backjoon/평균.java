package backjoon;

import java.util.Scanner;

public class 평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int now = sc.nextInt();
            if (max < now) max = now;
            sum += now;
        }
        System.out.println(sum * 100.0 / max / n);
    }
}
