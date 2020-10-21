package data.structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Graph {
    private boolean directed;
    //private boolean weighted;
    private ListLinked<Vertex> vertexList;
    private Vertex[] vertexs;
    private int numVertexs;
    public Graph(boolean directed){
        this.directed=directed;
        vertexList=new ListLinked<>();
    }
    public Graph(boolean directed, int numVertexs){
        this.directed=directed;
        vertexs=new Vertex[numVertexs];
    }

    public boolean getDirected(){
        return directed;
    }
    public ListLinked<Vertex> getVertexList(){
        return vertexList;
    }
    public Vertex[] getVertexs(){
        return vertexs;
    }
    public Vertex getVertex(int n){
        return vertexs[n];
    }
    public int getNumVertexs(){
        return numVertexs;
    }
    public void addVertex(Vertex vertex){
        vertexList.add(vertex);
    }
    public void addEdges(Vertex v1,Vertex v2, double weight){
        Edge edge= new Edge(v1,v2,weight);
        v1.addEdge(edge);
        if(!directed){
            Edge edge2=new Edge(v2,v1,weight);
            v2.addEdge(edge2);
        }
    }

    public void BFS(Vertex vertex){
        ListLinked<Vertex> travelBFS=new ListLinked<>();
        Queue<Vertex> queue=new LinkedList<>();
        queue.add(vertex);
        vertex.setStatus(State.VISITADO);
        travelBFS.add(vertex);
        while(!queue.isEmpty()){
            vertex=queue.poll();
            ListLinked<Edge> lEdges=vertex.getEdges();
            Node<Edge> node=lEdges.getHead();
            while(node!=null){
                Vertex oppsite=node.getData().getV2();
                if(oppsite.getState()==State.NO_VISITADO){
                    queue.add(oppsite);
                    oppsite.setStatus(State.VISITADO);
                    oppsite.setParents(vertex);
                    oppsite.setJumps(vertex.getJumps()+1);
                    travelBFS.add(oppsite);
                }
            node=node.getLink();
            }
            vertex.setStatus(State.PROCESADO);
        }
        Node<Vertex> temp=travelBFS.getHead();
        while(temp!=null){
            System.out.print(temp.getData().getLabel()+"{"+temp.getData().getJumps()+"}\t");
            temp=temp.getLink();
        }
    }

    public void shortPath(Vertex start,Vertex finish){
        BFS(start);
        Vertex parent=finish;
        System.out.println("\nRECORRIDO MAS CORTO PARA EL VERTICE : "+finish.getLabel());
        while(parent!=null){
            System.out.print(parent.getLabel());
            parent=parent.getParents();
            if(parent!=null){
                System.out.print("<--");
            }
        }
    }

    public void shortPath2(Vertex start){
        BFS(start);
        Stack<Vertex> verStack=new Stack<>();
        System.out.println("\nIMPRIMIR RECORRIDOS: ");
        for(int i=1;i<vertexs.length;i++){
            Vertex parent=vertexs[i];
            System.out.print("Vertice ("+parent.getLabel()+"): ");
            while(parent!=null){
                verStack.push(parent);
                parent=parent.getParents();
            }
            while(!verStack.isEmpty()){
                System.out.print(verStack.pop().getLabel());
                
                if(!verStack.isEmpty()){
                    System.out.print("-->");
                }
            }
            System.out.println(" ");
        }
        
        
    }

    public void DFS(Vertex vertex){
        ListLinked<Vertex> travelBFS=new ListLinked<>();
        //Queue<Vertex> queue=new LinkedList<>();
        Stack<Vertex> stack=new Stack<>();
        stack.push(vertex);
        vertex.setStatus(State.VISITADO);
        travelBFS.add(vertex);
        while(!stack.isEmpty()){
            vertex=stack.pop();
            ListLinked<Edge> lEdges=vertex.getEdges();
            Node<Edge> node=lEdges.getHead();
            while(node!=null){
                Vertex oppsite=node.getData().getV2();
                if(oppsite.getState()==State.NO_VISITADO){
                    stack.push(oppsite);
                    oppsite.setStatus(State.VISITADO);
                    oppsite.setJumps(vertex.getJumps()+1);
                    travelBFS.add(oppsite);
                }
            node=node.getLink();
            }
            vertex.setStatus(State.PROCESADO);
        }
        Node<Vertex> temp=travelBFS.getHead();
        while(temp!=null){
            System.out.print(temp.getData().getLabel()+"{"+temp.getData().getJumps()+"}\t");
            temp=temp.getLink();
        }
    }
    
   

    public void printGraph(){
        ListLinked<Edge> edges;
        String output="";
        for(int i=0;i<vertexs.length;i++){
            Vertex vertex=vertexs[i];
            output=output+vertexs[i].getLabel();
            edges= vertex.getEdges();
            output=output+"("+edges.size()+") -> ";
            Node<Edge> temp=edges.getHead();
            while(temp!=null){
                output=output+"{"+temp.getData().getV2().getLabel()+"}";
                temp=temp.getLink();
            }
            output=output+"\n";
        }
        System.out.println(output);
    }
    public void readFileInput(String filename){
        String path=System.getProperty("user.dir")+"\\input\\"+filename;
        try {
            System.out.println(path);
            File file=new File(path);
            Scanner scanner=new Scanner(file);
            String line="";
            line=scanner.nextLine();
            Pattern pattern;
            Matcher matcher;
            pattern=Pattern.compile("size\\s*=\\s*(\\d+)");
            matcher=pattern.matcher(line);
            matcher.find();
            String strSize=matcher.group(1);
            System.out.println(strSize);
            vertexs =new Vertex[Integer.parseInt(strSize)];
            //obteniendo las lineas de informacion de vertices
            while( !(line=scanner.nextLine()).equals(";")){
                pattern= Pattern.compile("(\\d+)\\s*=\\s*(.+)");
                
                matcher= pattern.matcher(line);
                if(matcher.find()){
                    Vertex vertex=new Vertex(matcher.group(2));
                    addVertex(vertex);
                    vertexs[Integer.parseInt(matcher.group(1))]=vertex;

                }
                
               // System.out.println(line);
            }
            //obteniendo las lineas de informacion de aristas
            while( !(line=scanner.nextLine()).equals(";")){
                pattern= Pattern.compile("\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)");
                
                matcher= pattern.matcher(line);
                if(matcher.find()){
                    int posV1=Integer.parseInt(matcher.group(1));
                    int posV2=Integer.parseInt(matcher.group(2));
                    double weight=Double.parseDouble(matcher.group(3));
                    Vertex v1=vertexs[posV1];
                    Vertex v2=vertexs[posV2];
                    addEdges(v1, v2, weight);
                }
                //System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            //TODO: handle exception
        }
        
        
    }
    /*public void printGraph(){
        ListLinked<Edge> edges;
        String output="";
        for(int i=0;i<vertexs.length;i++){
            Vertex vertex=vertexs[i];
            output=output+vertexs[i].getLabel();
            edges= vertex.getEdges();
            output=output+"("+edges.size()+") -> ";
            Node<Edge> temp=edges.getHead();
            while(temp!=null){
                output=output+"{"+temp.getData().getV2().getLabel()+"}";
                temp=temp.getLink();
            }
            output=output+"\n";
        }
        System.out.println(output);
    }*/
    public void connected(){
        ListLinked<Edge> edges;

    }
    public static void main(String[] args) {
        Graph graph=new Graph(false);
        Vertex LaPaz=new Vertex("La Paz");
        Vertex Cochabamba=new Vertex("Cochabamba");
        Vertex SantaCruz=new Vertex("Santa Cruz");
        Vertex Riberalta=new Vertex("Riberalta");
        LaPaz.addEdge(new Edge(LaPaz,Cochabamba));
        LaPaz.addEdge(new Edge(LaPaz,SantaCruz));
        LaPaz.addEdge(new Edge(LaPaz,Riberalta));
        graph.addVertex(LaPaz);
        graph.addVertex(Cochabamba);
        graph.addVertex(SantaCruz);
        graph.addVertex(Riberalta);
        graph.readFileInput("bolivia.txt");
    }
}
