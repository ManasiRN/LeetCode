class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<Integer>[] G = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < numCourses; ++i) {
            G[i] = new ArrayList<>();
        }
        
        // Build graph and in-degree array
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        
        // Add courses with zero in-degree to the queue
        for (int i = 0; i < numCourses; ++i) {
            if (degree[i] == 0) bfs.add(i);
        }
        
        // Process the courses in BFS order
        for (int i = 0; i < bfs.size(); ++i) {
            for (int j : G[bfs.get(i)]) {
                if (--degree[j] == 0) bfs.add(j);
            }
        }
        
        return bfs.size() == numCourses;
    }
}