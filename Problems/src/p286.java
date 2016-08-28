import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Valued Customer on 8/20/2016.
 * 286. Walls and Gates
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class p286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) dfsHelper(rooms, i, j, 0);
            }
        }
    }

    public void dfsHelper(int[][] rooms, int row, int col, int dist) {
        if (dist <= rooms[row][col]) rooms[row][col] = dist;
        else return;

        if (row > 0 && rooms[row-1][col] != -1)  dfsHelper(rooms, row-1, col, dist+1);

        if (row < rooms.length-1 && rooms[row+1][col] != -1) dfsHelper(rooms, row+1, col, dist+1);

        if (col > 0 && rooms[row][col-1] != -1) dfsHelper(rooms, row, col-1, dist+1);

        if (col < rooms[0].length-1 && rooms[row][col+1] != -1) dfsHelper(rooms, row, col+1, dist+1);
    }
}
