package Doit.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N033_카드_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.add(sc.nextInt());
        }
        int answer = 0;
        while (priorityQueue.size() > 1) {
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();
            answer += (num1 + num2);
            priorityQueue.add(num1 + num2);
        }
        System.out.println(answer);
    }
}
