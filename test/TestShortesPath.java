package test;

import data.structure.Graph;

public class TestShortesPath {
    static void testShortes(){
        Graph graph=new Graph(false);
            graph.readFileInput("test01.txt");
            System.out.println("IMPRIMIR GRAFO");
            graph.printGraph();
            
            graph.shortPath2(graph.getVertexList().getHead().getData());
        }   
        public static void main(String[] args) {
            testShortes();
        }
}
