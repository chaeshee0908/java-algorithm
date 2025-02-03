package Doit.그리디;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N034_수를_묶어서_최댓값_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        int N = sc.nextInt();
        int data;
        for (int i = 0; i < N; i++) {
            data = sc.nextInt();
            if (data <= 0) {
                minusPq.add(data);
            } else {
                plusPq.add(data);
            }
        }
        int n1;
        int n2;
        int answer = 0;
        while (minusPq.size() > 1) {
            n1 = minusPq.poll();
            n2 = minusPq.poll();
            answer += n1 * n2;
        }
        if (!minusPq.isEmpty()) {
            answer += minusPq.poll();
        }

        while (plusPq.size() > 1) {
            n1 = plusPq.poll();
            n2 = plusPq.poll();
            // (중요) 양수인 경우에만 두 수중 하나라도 1이면 곱한 값보다 더한 값이 더 큼
            if (n1 == 1 || n2 == 1) {
                answer += n1 + n2;
            } else {
                answer += n1 * n2;
            }
        }
        if (!plusPq.isEmpty()) {
            answer += plusPq.poll();
        }

        System.out.println(answer);
    }
}
