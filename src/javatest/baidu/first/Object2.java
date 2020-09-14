package javatest.baidu.first;

import java.util.Scanner;

/**
 * @author littlecorgi
 * @date 2020/9/14
 */
public class Object2 {

    private static boolean flag = false;

    static void dfs(int[][] grid, int i, int j) {
        int ni = grid.length;
        int nj = grid[0].length;

        if (flag) {
            return;
        }

        if ((i == 0 || j == 0 || i == ni - 1 || j == nj - 1) && grid[i][j] == 0) {
            flag = true;
        }

        if (i < 0 || j < 0 || i >= ni || j >= nj || grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    static void print(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(str.charAt(j) + "");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && (i != 0 && j != 0 && i != n - 1 && j != n - 1)) {
                    int[][] tempGrid = new int[n][n];
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            tempGrid[k][l] = grid[k][l];
                        }
                    }
                    flag = false;
                    dfs(tempGrid, i, j);
                    // 更新
                    if (!flag) {
                        grid = tempGrid;
                    }
                }
            }
        }
        print(grid);
    }
}
