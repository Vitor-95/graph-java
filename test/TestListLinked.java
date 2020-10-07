package test;

import data.structure.ListLinked;
import data.structure.Stack;
import data.structure.Queue;

public class TestListLinked {

    static void testAddHeadList() {
        ListLinked list = new ListLinked();
        list.addHead(5);
        list.addHead(8);
        list.addHead(15);
        list.addHead(0);
        list.addHead(10);
        System.out.println(list);
    }

    static void testAddTailList() {
        ListLinked list = new ListLinked();
        list.addTail(5);
        list.addTail(8);
        list.addTail(15);
        list.addTail(0);
        list.addTail(10);
        System.out.println(list);
    }
    static void testAddStackList(){
        Stack list=new Stack();
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        list.showStack();
        System.out.println("Elemento extraido: "+list.pop());
        list.showStack();
        list.empty();
        list.showStack();
    }
    static void testAddQueue(){
        Queue list=new Queue();
        list.push(2);
        list.push(4);
        list.push(6);
        list.push(8);
        list.showQueue();
        System.out.println("\nElemento extraido: "+list.pop());
        list.showQueue();
        list.push(7);
        list.push(5);
        list.push(9);
        list.showQueue();
    }
    public static void main(String[] args) {
        // testAddHeadList();
        //testAddTailList();
        //testAddStackList();
        testAddQueue();
    }
}
