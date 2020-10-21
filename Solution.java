import org.springframework.test.context.TestConstructor;

public class Solution {

    /*
    Clarifications:
        input: int[][] => contains 0,1 => 0: sea 1: land
        output: int => number of islands that are connected with 8-directions.

        - Empty input => return 0.
        - All 1's => return 1
        - All 0's => return 0.
        - Borders are water.
        - There can't be any value other than 0 or 1.
        - Can I modify the input => Yes.

    Example:

        Input : mat[][] = {
                            {1, 1, 0, 0, 0},
                            {0, 1, 0, 0, 1},
                            {1, 0, 0, 1, 1},
                            {0, 0, 0, 0, 0},
                            {1, 0, 1, 0, 1}
                          }
        Output : 5

    Approach:
        - The matrix actually represents a graph, values are nodes, there are undirected edges between the nodes at 8-directions
        - What question asks is to finding the connected components in the given graph.

        - Apply DFS for the graph and for each unvisited land node, and return the count of DFSs.
        - Inside the dfs, change the value of the node to sea.

    Time Complexity: O(n*m) n: number of rows, m: number of columns
    Space Complexity: O(n*m) n: number of rows, m: number of columns

    Note for the Space Complexity:
    - Space Complexity comes from the recursion stack.
    - In the worst case, the depth can go up to n*m (Every cell in the matrix)
    - If we use BFS, the space complexity can be reduced to n+m (Manhattan distance from top-left corner to bottom-right corner)

     */

    static int ROW;
    static int COL;

    private static int numberOfIslands(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return 0;

        ROW = mat.length;
        COL = mat[0].length;
        int islands = 0;

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (mat[row][col] == 1) {
                    dfs(mat, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void dfs(int[][] mat, int row, int col) {
        if (row >= ROW || col >= COL || row < 0 || col < 0 || mat[row][col] == 0) {
            return;
        }

        mat[row][col] = 0;

        int[][] DIRECTIONS = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        for (int[] direction : DIRECTIONS) {
            dfs(mat, row + direction[0], col + direction[1]);
        }
    }


    public static void main(String[] args) {

        int[][] mat1 = new int[][]{ // Answer must be 5
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        int[][] mat2 = new int[][] { // Answer must be 2
                {1, 1, 0, 1, 0, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 1, 0, 1},
        };

        System.out.println(numberOfIslands(mat2));

    }

}
