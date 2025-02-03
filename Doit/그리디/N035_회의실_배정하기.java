package Doit.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class N035_회의실_배정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        // 종료 시간을 기준으로 정렬
        Arrays.sort(A, (o1, o2) -> {
            if (o1[1] == o2[1]) {   // 종료 시간이 같을 때
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int count = 1;
        int endTime = A[0][1];  // 이전 회의 끝나는 시간
        for (int i = 1; i < N; i++) {
            // 이전 회의 끝나기 전에 회의가 시작하는 경우 - 회의실 사용 불가
            if (endTime > A[i][0])
                continue;
            endTime = A[i][1];
            count++;
        }
        System.out.println(count);
    }
}
