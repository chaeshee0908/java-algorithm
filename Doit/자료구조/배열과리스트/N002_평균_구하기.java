package Doit.자료구조.배열과리스트;

import java.util.Scanner;

public class N002_평균_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 과목 개수
        int score[] = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        long sum = 0;
        long high = 0;
        for (int s : score) {
            if (high < s) {
                high = s;
            }
            sum += s;
        }
        double result = sum * 100.0 / high / N;
        System.out.println(result);
    }
}
