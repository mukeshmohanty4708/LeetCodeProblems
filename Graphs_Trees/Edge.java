public class Edge<T> {
    private T source;
    private T destination;
    private int weight;

    Edge(T source, T destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public T getSource(){
        return source;
    }
    public T getDestination(){
        return destination;
    }
    public int getWeight(){
        return weight;
    }
}

