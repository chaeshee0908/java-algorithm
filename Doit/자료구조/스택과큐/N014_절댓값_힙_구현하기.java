package Doit.자료구조.스택과큐;

import java.util.PriorityQueue;
import java.util.Scanner;

public class N014_절댓값_힙_구현하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 배열에 x값을 넣는다(단, x!=0일 때만)
        // 절댓값이 가장 작은 수를 출력한 후 그 값을 배열에서 제거(여러 개일 경우 가장 작은 값 제거)
        PriorityQueue<Integer> myQueue = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
            else
                return first_abs - second_abs;  // 절댓값 기준으로 정렬
        }));
        for (int i = 0; i < N; i++) {
            int request = sc.nextInt();
            if (request == 0) {
                if (myQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQueue.poll());
            } else {
                myQueue.add(request);
            }
        }
    }
}
