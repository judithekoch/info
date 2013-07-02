package basic;


public interface Stack<T>{
     void push(T newElement); // obendrauf legen
     T pop(); // Oberstes entfernen
     T top(); // Oberstes zeigen

     Boolean isEmpty();

}
