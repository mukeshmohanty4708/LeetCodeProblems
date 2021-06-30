import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {

    public class Node {
        T destination;
        int weight;
    
        Node(T destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    };

    private int vertices;
    private Map<T, ArrayList<Node>> mp;

    Graph(){
        this.mp = new HashMap<T, ArrayList<Node>>(vertices);
    }

    public void addEdge(Edge<T> e){
        T s = e.getSource();
        T d = e.getDestination();
        int w = e.getWeight();

        if(sourceExistAsKey(s)) 
            addEdgeToList(s, d, w);
        else{
            try {
                addKeyToMap(s);
                addKeyToMap(d);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            addEdgeToList(s, d, w);
        }
        System.out.println("Successfully Added " + s + "---->" + d + " : " + w);

    }

    public boolean sourceExistAsKey(T source){
        if(mp.containsKey(source)) return true;
        return false;
    }

    public void addKeyToMap(T source) throws Exception{
        if(mp.containsKey(source) == false)
            mp.put(source, new ArrayList<Node>());
        return;
    }

    public void addEdgeToList(T source, T destination, int weight){
        Node vertice = new Node(destination, weight);
        mp.get(source).add(vertice);
        return;
    }

    public int getVertices(){
        vertices = mp.size();
        return vertices;
    }
    public Map<T, ArrayList<Node>> getGraph(){
        return mp;
    }

    public void printGraph(){
        // StringBuilder out = new StringBuilder();

        for(T key : mp.keySet()){
            System.out.print(key);
            for(Node n : mp.get(key)){
                System.out.print("---->" + n.destination + "(" + n.weight + ")");
            }
            System.out.println("");
        }
        return;
    }


}
