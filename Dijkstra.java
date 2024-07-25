import java.util.*;

public class Dijkstra {

    static class Edge{
        int vertex;
        int weight;

        Edge(int vertex,int weight){
            this.vertex=vertex;
            this.weight=weight;
        }
    }
    static class Graph{
        private int v;
        private List<LinkedList<Edge>> adj;

        Graph(int v){
            this.v=v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adj.add(new LinkedList<>());
            }
        }

        void addEdge(int u,int vertex,int weight){
            adj.get(u).add(new Edge(vertex, weight));

        }

        List<Edge> getAdj(int u){
            return adj.get(u);
        }


    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);

        dijkstra(graph,0);
    }

    private static void dijkstra(Graph graph, int source) {
        int noOfV =  graph.adj.size();
        int distance[] = new int[noOfV];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source]= 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.distance));
        pq.add(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int u = currNode.vertex;
            if(visited.contains(u)) continue;
            visited.add(u);


            for (Edge edge : graph.getAdj(u)) {
                int v = edge.vertex;
                int weight = edge.weight;
                if(distance[u]+weight<distance[v]){
                    distance[v]=distance[u]+weight;
                    pq.add(new Node(v, distance[v]));
                }
            }
        }

        for (int i = 0; i < noOfV; i++) {
            if(distance[i]==Integer.MAX_VALUE){
                System.out.println("Distance from Source "+i+ " to Vertex is Infinity");
            }
            else{
                System.out.println("Distance from Source "+i+ " to Vertex is "+distance[i]);
            }
        }
    }

    static class Node{
        int vertex;
        int distance;
        Node(int vertex,int distance){
            this.vertex=vertex;
            this.distance=distance;
        }
    }
}
