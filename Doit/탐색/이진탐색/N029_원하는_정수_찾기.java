package Doit.탐색.이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class N029_원하는_정수_찾기 {
    static int N;
    static int M;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int answer = searchNumber(sc.nextInt());
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int searchNumber(int target) {
        int start = 0;
        int end = N-1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (target < numbers[mid]) {  // 중앙값보다 찾는 숫자가 작은 경우
                end = mid - 1;
            } else if (target > numbers[mid]) {   // 중앙값보다 찾는 숫자가 큰 경우
                start = mid + 1;
            } else {    // 값을 찾은 경우
                return 1;
            }
        }
        return 0;
    }
}
