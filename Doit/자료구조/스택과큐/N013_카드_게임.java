package Doit.자료구조.스택과큐;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class N013_카드_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> myDeque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            myDeque.addLast(i);
        }
        while (myDeque.size() > 1) {
            myDeque.removeFirst();
            if (myDeque.size() > 1) {
                myDeque.add(myDeque.getFirst());
                myDeque.removeFirst();
            }
        }
        System.out.println(myDeque.getFirst().intValue());
    }
}
