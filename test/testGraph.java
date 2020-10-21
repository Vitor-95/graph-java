package test;

import data.structure.Graph;

public class testGraph {
    static void testPrint(){
        Graph graph=new Graph(false);
        graph.readFileInput("test01.txt");
        System.out.println("IMPRIMIR GRAFO");
        graph.printGraph();
       // System.out.println("IMPRIMIR GRAFO BFS");
        //graph.BFS(graph.getVertexList().getHead().getData());
        //System.out.println("IMPRIMIR GRAFO DFS");
        //graph.DFS(graph.getVertexList().getHead().getData());
        graph.shortPath(graph.getVertexList().getHead().getData(),graph.getVertex(6));
    }   
    public static void main(String[] args) {
        testPrint();
    }
}
