Graph Implemented
0---->2(5)---->3(5)
1
2
3---->1(5)
4---->2(5)---->1(5)
5---->2(5)---->0(5)
[2, 1, 3, 0, 4, 5]
The Topological Sort is: 
5 4 0 3 1 2 %                                    


import java.util.Arrays;
import java.util.Stack;



public class topological {
    
    static Stack<Integer> st = new Stack<>();
    
    public static void helperDFS(Graph<Integer> graph, boolean[] visited, int curr){
        if(visited[curr] == true) return;
        visited[curr] = true;
        if(graph.getGraph().get(curr) != null){
            for(Graph<Integer>.Node node : graph.getGraph().get(curr))
                if(visited[node.destination] == false)
                    helperDFS(graph, visited, node.destination);
        }
        st.push(curr);
        return;
    }


    public static void topoSort(Graph<Integer> graph){

        boolean[] visited = new boolean[6];
        Arrays.fill(visited, false);
        for(int i = 0; i < 6; i++){
            if(visited[i] == false)
                helperDFS(graph, visited, i);
        }
        System.out.println(st.toString());
        System.out.println("The Topological Sort is: ");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }


    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>();
        graph.addEdge(new Edge<Integer>(5,2,5));
        graph.addEdge(new Edge<Integer>(5,0,5));
        graph.addEdge(new Edge<Integer>(4,2,5));
        graph.addEdge(new Edge<Integer>(4,1,5));
        graph.addEdge(new Edge<Integer>(0,2,5));
        graph.addEdge(new Edge<Integer>(0,3,5));
        graph.addEdge(new Edge<Integer>(3,1,5));

        System.out.println("Graph Implemented");

        graph.printGraph();
        topological.topoSort(graph);

       

    }
}
