import java.util.Arrays;

public class minCost {
    public int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        // distance from the node to Minimum Spanning Tree
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // no of nodes in MST
        int num = 0;
        int current = 0;
        dist[current] = 0;
        while (num < points.length) {
            minCost += dist[current];
            dist[current] = 0;
            num += 1;

            // update distances
            for (int i = 0; i < points.length; i++) {
                int d = Math.abs(points[current][0] - points[i][0]) +
                        Math.abs(points[current][1] - points[i][1]);
                if (dist[i] > d) {
                    dist[i] = d;
                }
            }

            // pick up next node
            int next = -1;
            int min_dist = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                if (dist[i] < min_dist && dist[i] > 0) {
                    next = i;
                    min_dist = dist[i];
                }
            }

            // update current node
            current = next;
        }
        return minCost;
    }
}
