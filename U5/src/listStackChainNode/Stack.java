package listStackChainNode;

public interface Stack<T>{
    void push(T newStack); // obendrauf legen
    T pop(); // Oberstes entfernen
    T top(); // Oberstes zeigen

    Boolean isEmpty();

}