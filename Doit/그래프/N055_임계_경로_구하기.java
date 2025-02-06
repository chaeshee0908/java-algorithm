package Doit.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

// 풀이는 맞는데 시간 초과 뜬 코드

public class N055_임계_경로_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Node1>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new Node1(end, weight));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        PriorityQueue<Info> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.cost, o1.cost)));
        queue.add(new Info(start, 0, new ArrayList<>()));
        int maxValue = 0;
        Set<String> routeSet = new HashSet<>();
        while (!queue.isEmpty()) {
            Info now = queue.poll();
            if (now.city == end) {
                if (maxValue < now.cost) {
                    routeSet = new HashSet<>();
                    maxValue = now.cost;
                }
                // maxValue가 변경되었을 때 본인이 최댓값이면 위의 maxValue가 초기화 되면서 routeSet 저장 로직 수행 가능
                if (maxValue == now.cost) {
                    for (int[] r : now.route) {
                        // [1, 2]의 String 형태로 도로를 routeSet에 저장
                        routeSet.add(Arrays.toString(r));
                    }
                }
            }
            for (Node1 next : graph[now.city]) {
                ArrayList<int[]> newRoute = new ArrayList<>(now.route);
                newRoute.add(new int[]{now.city, next.v});
                queue.add(new Info(next.v, now.cost + next.t, newRoute));
            }
        }
        System.out.println(maxValue);
        System.out.println(routeSet.size());
    }
}

class Node1 {
    int v;
    int t;

    public Node1(int v, int t) {
        this.v = v;
        this.t = t;
    }
}

class Info {
    int city;
    int cost;
    ArrayList<int[]> route;

    public Info(int city, int cost, ArrayList<int[]> route) {
        this.city = city;
        this.cost = cost;
        this.route = route;
    }
}
