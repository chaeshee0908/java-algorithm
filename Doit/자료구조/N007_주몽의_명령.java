package Doit.자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class N007_주몽의_명령 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 배열 오름차순 정렬
        Arrays.sort(A);
        int count = 0;
        int start = 0;
        int end = N-1;
        while (start < end) {
            int sum = A[start] + A[end];
            // 갑옷 만들기 가능
            if (sum == M) {
                count++;
                start++;
                end--;
            }
            else if (sum < M) {
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(count);
    }
}
