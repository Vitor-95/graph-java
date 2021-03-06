package data.structure;

public class Queue<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setLink(node);
        }
        tail = node;
        size++;
    }
    public Object pop(){
        Object a=null;
        if(head!=null){
            //System.out.println("Se elimino el elemento: "+head.getData());
            a=head.getData();
            head=head.getLink();
        }/*else{
            System.out.println("No se puede extraer, la cola esta vacia");
        }*/
        return a;
    }
    public void showQueue(){
        Node<E> n;
        n=head;
        if(head!=null){
            System.out.println("Elementos de la Cola: ");
            while(n!=null){
                System.out.print(n.getData()+"\t");
                n=n.getLink();
            }
        }else{
            System.out.println("COLA VACIA");
        }
    }
}
