package Doit.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N049_물의_양_구하기 {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; // A, B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
    static boolean[] answer;
    static int[] bottles;   //  물통 용량


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bottles = new int[3];
        bottles[0] = sc.nextInt();
        bottles[1] = sc.nextInt();
        bottles[2] = sc.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i])
                System.out.print(i + " ");
        }
    }

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[bottles[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = bottles[2] - A - B; // C는 전체 물의 양에서 A와 B를 뺀 것
            // A -> B, A -> C, B -> A, B -> C, C -> A, C -> B
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;
                // 물이 넘칠 때
                if (next[receiver[k]] > bottles[receiver[k]]) {
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[sender[k]] = next[receiver[k]] - bottles[receiver[k]];
                    next[receiver[k]] = bottles[receiver[k]];   // 받을 쪽은 물병에 꽉 채워줌
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    // A의 물의 양이 0일 때 C의 물의 무게 확인
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

}

// A와 B의 값만 지니고 있으면 C는 유추 가능
class AB {
    int A;
    int B;
    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}