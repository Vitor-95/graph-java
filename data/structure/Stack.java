package data.structure;

public class Stack<E> {
    Node<E> top;
    private int cont;
    public Stack(){
        top=null;
        cont=0;
    }
    public void push(E dato){
        Node<E> aux;
        if(top!=null){
            aux=new Node<>(dato,null);
            aux.setLink(top);
            top=aux;
        }else{
            top=new Node<>(dato,top);
        }
        cont++;
    }
    public int size(){
        return cont;
    }
    public Object topStack(){
        if(top!=null){
            return top.getData();
        }else{
            return null;  
        }
    }
    public void showStack(){
        Node<E> n;
        n=top;
        if(top!=null){
            while(n!=null){
                System.out.println(n.getData());
                n=n.getLink();
            }
        }else{
            System.out.println("PILA VACIA");
        }
    }
    public Object pop(){
        Object a=null;
        if(top!=null){
            //System.out.println("Se elimino el elemento: "+top.getData());
            a=top.getData();
            top=top.getLink();
        }/*else{
            System.out.println("No se puede extraer, la pila esta vacia");
        }*/
        return a;
    }
    public void empty(){
        top=null;
        this.cont=0;
        System.out.println("Pila Eliminada");
    }
}