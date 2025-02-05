package Doit.그래프;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N056_최댠_경로_구하기 {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int k = sc.nextInt();
        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
        }
        distance = new int[V+1];
        for (int i = 0; i <= V; i++) {
            distance[i] = INF;
        }
        dijkstra(k);
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }

    private static void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((
                (o1, o2) -> Integer.compare(o1[0], o2[0])));
        queue.add(new int[]{0, start}); // [이동 거리, vertex]

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 이미 최단 경로 저장된 경우 패스
            if (now[0] > distance[now[1]])
                continue;
            for (Edge next : graph[now[1]]) {
                int cost = now[0] + next.weight;
                // 거리가 최소가 아닐 때 갱신
                if (distance[next.vertex] > cost) {
                    distance[next.vertex] = cost;
                    queue.add(new int[]{cost, next.vertex});
                }
            }
        }
    }
}

class Edge {
    int vertex;
    int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
