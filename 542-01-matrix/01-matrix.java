import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] distance = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize distance matrix and queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions for moving in the matrix
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // BFS to update distance matrix
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currI = cell[0];
            int currJ = cell[1];

            for (int[] direction : directions) {
                int nextI = currI + direction[0];
                int nextJ = currJ + direction[1];

                if (nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols) {
                    if (distance[nextI][nextJ] > distance[currI][currJ] + 1) {
                        distance[nextI][nextJ] = distance[currI][currJ] + 1;
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }
            }
        }

        return distance;
    }
}