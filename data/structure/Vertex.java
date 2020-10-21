package data.structure;

public class Vertex {
    private String label;
    private ListLinked<Edge> edges;
    private State state;
    private int jumps;
    private Vertex parents;
    public Vertex(String label){
        this.label=label;
        this.jumps=0;
        edges= new ListLinked<>();
        state=State.NO_VISITADO;
    }
    public Vertex getParents(){
        return parents;
    }
    public void setParents(Vertex parents){
        this.parents=parents;
    }
    public int getJumps(){
        return jumps;
    }
    public void setJumps(int jumps){
        this.jumps=jumps;
    }
    public void setStatus(State state){
        this.state=state;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public State getState(){
        return state;
    }
    public void addEdge(Vertex v1,Vertex v2, double weight){
        Edge edge=new Edge(v1,v2,weight);
        edges.add(edge);
    }
    public String getLabel(){
        return label;
    }
    public ListLinked<Edge> getEdges(){
        return edges;
    }
    public String toString(){
        return "Vertex={ladel={"+ label + "},edges={"+edges+"}}";
    }
}
