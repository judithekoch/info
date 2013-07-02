package basic;

public class NodeStack<T> implements Stack<T>{
    private Node<T> ns = null;
    // optionaler Konstruktor, der nichts macht
    // public NodeStack(){}
    // entspricht Default-Konstruktor

    public void push(T neu){
         ns = new Node<T>(neu, ns);
    }

    public T pop(){
         T element = ns.getElement();
         ns = ns.getNext();
         return element;
    }
}
