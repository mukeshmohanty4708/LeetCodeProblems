import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class DetectCycle {

    public boolean checkCycle(Graph<Character> graph, Set<Character> white, Set<Character> gray, Set<Character> black, Character key){
        System.out.println("Iteration");
        gray.add(key); //Processing
        white.remove(key); // removing from white 
        System.out.println("White: " + white.toString());
        System.out.println("gray: " + gray.toString());
        System.out.println("black: " + black.toString());
        ArrayList<Graph<Character>.Node> adj_nodes = graph.getGraph().get(key);
        for(Graph<Character>.Node node : adj_nodes){
            if(black.contains(node.destination)) continue; //If black contains the continue;
            
            else if(gray.contains(node.destination)) return true; // if gray contians then there is a cycle

            else checkCycle(graph, white, gray, black, node.destination); //Else explore the new node recursive
        }   
        
        gray.remove(key); // processed
        black.add(key); // added to balck
        return false;
    }

    public void cycleDirected(Graph<Character> graph){

        //Define 3 sets white black and gray
        Set<Character> white = new HashSet<>();
        Set<Character> black = new HashSet<>();
        Set<Character> gray = new HashSet<>();
        
        //Adding all the vertex to the set 
        for(Character key : graph.getGraph().keySet())
            white.add(key);

        for(Character key : graph.getGraph().keySet()){
            System.out.println("Checking Vertex " + key);
            System.out.println("White: " + white.toString());
            System.out.println("gray: " + gray.toString());
            System.out.println("black: " + black.toString());
            System.out.println("------------------------------");
            if(checkCycle(graph, white, gray, black, key)) {
                // System.out.println("Printing Contents for " + key);
                // System.out.println("White: " + white.toString());
                // System.out.println("gray: " + gray.toString());
                // System.out.println("black: " + black.toString());
            } 
        }
        return ;


    }
    

    public static void main(String[] args){
        Graph<Character> graph = new Graph<Character>();
        graph.addEdge(new Edge<Character>('A','B',5));
        graph.addEdge(new Edge<Character>('C','A',4));
        graph.addEdge(new Edge<Character>('B','C',1));
        graph.addEdge(new Edge<Character>('C','D',2));
        graph.addEdge(new Edge<Character>('B','D',7));
        graph.addEdge(new Edge<Character>('E','D',7));
        System.out.println("Graph Implemented");

        graph.printGraph();

        DetectCycle obj = new DetectCycle();
        obj.cycleDirected(graph);

        
    }
}
