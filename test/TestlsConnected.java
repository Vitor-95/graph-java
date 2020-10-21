package test;

import data.structure.Graph;

public class TestlsConnected {
    static void testConected(){
    Graph graph=new Graph(false);
        graph.readFileInput("Parcial.txt");
        System.out.println("IMPRIMIR GRAFO");
        graph.printGraph();
        System.out.println("VERIFICAR CONECTIVIDAD: ");
        graph.connected();
    }   
    public static void main(String[] args) {
        testConected();
    }
}
