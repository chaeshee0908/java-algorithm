package Doit.그래프;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N058_K번째_최단_경로_찾기 {
    static PriorityQueue<Integer>[] distQueue;
    static ArrayList<Node>[] graph;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        K = sc.nextInt();
        graph = new ArrayList[N+1];
        distQueue = new PriorityQueue[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distQueue[i] = new PriorityQueue<>(K, ((o1, o2) -> Integer.compare(o2, o1)));   // (중요) 최대 힙
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int w = sc.nextInt();
            graph[start].add(new Node(end, w));
        }
        dijkstra();
        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) {
                System.out.println(distQueue[i].peek());
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                ((o1, o2) -> Integer.compare(o1[0], o2[0]))
        );
        pq.add(new int[]{0, 1});
        distQueue[1].add(0);
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (Node next : graph[now[1]]) {
                int cost = now[0] + next.weight;
                // 저장된 경로가 K개가 안 될 때는 그냥 추가하기
                if (distQueue[next.v].size() < K) {
                    distQueue[next.v].add(cost);
                    pq.add(new int[]{cost, next.v});
                }
                // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작을 때만 추가
                else if (distQueue[next.v].peek() > cost) {
                    distQueue[next.v].poll();   // 큰 값 먼저 삭제
                    distQueue[next.v].add(cost);
                    pq.add(new int[]{cost, next.v})
;                }
            }
        }
    }
}

class Node {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}
