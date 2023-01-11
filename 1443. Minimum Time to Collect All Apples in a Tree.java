// Problem Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        /**
            1. Build an adj list from given edge array
            2. Apply DFS
         */

         Map<Integer, List<Integer>> adj = new HashMap<>();
         for (int[] edge: edges) {
             int a = edge[0], b = edge[1];
             adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
             adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
         }

         return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        int steps = 0;
        for (int nbr: adj.get(node)) {
            if (nbr != parent) {
                steps += dfs(nbr, node, adj, hasApple);
            }
        }

        if ((node != 0) && (hasApple.get(node) || steps != 0)) {
            steps += 2;
        }

        return steps;
    }

    // TC: O(n) | SC: O(H)
}
