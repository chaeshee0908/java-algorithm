package Doit.자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class N008_좋은_수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int count = 0;
        for (int k = 0; k < N; k++) {
            // 목표값 : A[k]
            int i = 0;
            int j = N-1;
            while (i < j) {
                if (A[i] + A[j] == A[k]) {
                    // 예외) 본인과 다른 숫자일 때만 좋은 수 가능
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                }
                else if (A[i] + A[j] < A[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(count);
    }
}
