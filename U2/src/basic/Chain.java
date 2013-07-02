package basic;


public class Chain<T> implements List<T>{
     private Node<T> first;

     //leere Kette anlegen
     public Chain(){
     first = null;
     }

     //Kette mit vorhandener Knotenliste
     public Chain(Node<T> list){
          first = list;
     }

     public T getElement(){
          return first.getElement();
     }
     
     public Chain<T> getNext(){ // ergibt noch Fehler bekommt nur Knoten, keine Liste
          return new Chain<T>(first.getNext());
     }

     public int getLength(){
          return first == null ? 0 : first.getLength();
     }
}
