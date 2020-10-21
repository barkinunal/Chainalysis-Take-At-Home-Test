# Chainalysis-Take-At-Home-Test
This repo is created for Chainalysis Take At Home Test
```

Clarifications:
        - input: int[][] => contains 0,1 => 0: sea 1: land
        - output: int => number of islands that are connected with 8-directions.

        - Empty input => return 0.
        - All 1's => return 1
        - All 0's => return 0.
        - Borders are water.
        - There can't be any value other than 0 or 1.
        - Can I modify the input => Yes.
        
    Assumptions: 
    - I can modify the input. (If this is not wanted, I could use a visited matrix, 
    this would make the space complexity O(n*m) n: number of rows, m: number of columns)

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

        - Apply DFS for the graph and for each unvisited land node, and return the number of DFS calls while iterating over the matrix.
        - Inside the dfs, change the value of the node to sea. (Which is 0)

    Time Complexity: O(n*m) n: number of rows, m: number of columns
    Space Complexity: O(n*m) n: number of rows, m: number of columns

    Note for the Space Complexity:
    - Space Complexity comes from the recursion stack.
    - In the worst case, the depth can go up to n*m (Every cell in the matrix)
    - If we use BFS, the space complexity can be reduced to n+m (Manhattan distance from top-left corner to bottom-right corner)
    

