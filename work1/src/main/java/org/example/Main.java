package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] MonsterStage1(int numMap[][], int d, int N, int M)
    {
        for (int y = 0; y < N; y++)
        {
            for (int x = 0; x < M; x++)
            {
                if (numMap[y][x] == -1 - d && d > 0)
                {
                    numMap = MonsterStage2(numMap, N, M, -d, x+1, y);
                    numMap = MonsterStage2(numMap, N, M, -d, x-1, y);
                    numMap = MonsterStage2(numMap, N, M, -d, x, y+1);
                    numMap = MonsterStage2(numMap, N, M, -d, x, y-1);
                }
            }
        }
        return numMap;
    }
    static int[][] MonsterStage2(int numMap[][], int N, int M, int power, int x, int y)
    {
        if (x >= 0 && x < M && y >= 0 && y < N)
        {
            if (numMap[y][x] > power) {
                numMap[y][x] = power;
                if (power < -1) {
                    numMap = MonsterStage2(numMap, N, M, power + 1, x + 1, y);
                    numMap = MonsterStage2(numMap, N, M, power + 1, x - 1, y);
                    numMap = MonsterStage2(numMap, N, M, power + 1, x, y + 1);
                    numMap = MonsterStage2(numMap, N, M, power + 1, x, y - 1);
                }
            }
        }
        return numMap;
    }
    static int[][] way(int numMap[][], int N, int M, int power, int x, int y)
    {
        if (x >= 0 && x < M && y >= 0 && y < N)
        {
            if (numMap[y][x] > power) {
                numMap[y][x] = power;
                numMap = way(numMap, N, M, power + 1, x + 1, y);
                numMap = way(numMap, N, M, power + 1, x - 1, y);
                numMap = way(numMap, N, M, power + 1, x, y + 1);
                numMap = way(numMap, N, M, power + 1, x, y - 1);
            }
        }
        return numMap;
    }
    public static void main() {
        Scanner in = new Scanner(System.in);
        System.out.print("N: ");
        int N = in.nextInt();
        System.out.print("M: ");
        int M = in.nextInt();
        System.out.print("d: ");
        int d = in.nextInt();
        //char map[][] = new char[N][M];
        int numMap[][] = new int[N][M];
        int start_x = -2, start_y = -2;
        int finish_x = 0, finish_y = 0;
        System.out.println("Map: ");
        System.out.flush();
        String line;
        line = in.nextLine();
        for (int y = 0; y < N; y++)
        {
            line = in.nextLine();
            for (int x = 0; x < M; x++)
            {
                //map[y][x] = line.charAt(x);
                switch (line.charAt(x))
                {
                    case 'M': numMap[y][x] = -1 - d; break;
                    case 'E': numMap[y][x] = Integer.MAX_VALUE; break;
                    case 'S': numMap[y][x] = 0; start_x = x; start_y = y; break;
                    case 'F': numMap[y][x] = Integer.MAX_VALUE; finish_x = x; finish_y = y; break;
                }
            }
        }
        in.close();
        numMap = MonsterStage1(numMap, d, N, M);
        numMap = way(numMap, N, M, 1, start_x + 1, start_y);
        numMap = way(numMap, N, M, 1, start_x - 1, start_y);
        numMap = way(numMap, N, M, 1, start_x, start_y + 1);
        numMap = way(numMap, N, M, 1, start_x, start_y - 1);
        /*System.out.println();
        for (int y = 0; y < N; y++)
        {
            for (int x = 0; x < M; x++)
            {
                System.out.print(numMap[y][x]);
            }
            System.out.println();
        }*/
        if (numMap[finish_y][finish_x] < 0 || numMap[finish_y][finish_x] == Integer.MAX_VALUE)
        {
            System.out.print(-1);
        }
        else {
            System.out.print(numMap[finish_y][finish_x]);
        }
    }
}
