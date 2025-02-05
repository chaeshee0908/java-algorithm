package Doit.그래프;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N057_최소_비용_구하기 {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<City>[] graph;
    static int[] busPrice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 도시 개수
        int M = sc.nextInt();   // 버스 개수
        graph = new ArrayList[N+1];
        busPrice = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            busPrice[i] = INF;
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int p = sc.nextInt();
            graph[start].add(new City(end, p));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(start);
        System.out.println(busPrice[end]);
    }

    private static void dijkstra(int start) {
        busPrice[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[0], o2[0])));
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] > busPrice[now[1]])
                continue;
            for (City next : graph[now[1]]) {
                int cost = now[0] + next.price;
                if (busPrice[next.number] > cost) {
                    busPrice[next.number] = cost;
                    pq.add(new int[]{cost, next.number});
                }
            }
        }
    }
}

class City {
    int number;
    int price;

    public City(int number, int price) {
        this.number = number;
        this.price = price;
    }
}
