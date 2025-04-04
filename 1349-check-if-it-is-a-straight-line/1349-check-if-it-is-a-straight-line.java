class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1, y1, x2, y2;
        x1 = coordinates[0][0];
        y1 = coordinates[0][1];
        x2 = coordinates[1][0];
        y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++)
        {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];
            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1))
                return false;
        }
        return true;     
    }
}