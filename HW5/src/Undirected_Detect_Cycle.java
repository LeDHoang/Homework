//Undirected Graph Detect Cycle
import java.io.*;
import java.util.*;
public class Undirected_Detect_Cycle {
    // vertices number
    private int V;

    // Adjacent List
    private LinkedList<Integer> adjacent[];

    // Default Constructor
    Undirected_Detect_Cycle(int v)
    {
        V = v;
        adjacent = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adjacent[i] = new LinkedList();
    }

    // Function to add an edge
    // into the graph
    void addEdge(int v,int w)
    {
        adjacent[v].add(w);
        adjacent[w].add(v);
    }

    // A recursive function
    // uses visited[] and parent to detect cycle
    Boolean isCyclicUtil(int v,
                         Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        Iterator<Integer> it = adjacent[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle
    Boolean isCyclic()
    {

        // Mark all the vertices as not visited
        // and not part of recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int u = 0; u < V; u++)
        {

            // Don't recur if u is already visited
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }

        return false;
    }


    // Driver method to test
    public static void main(String args[])
    {
        Undirected_Detect_Cycle g1 = new Undirected_Detect_Cycle(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(g1.isCyclic());

    }
}
