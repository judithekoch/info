package listStackChainNode;

public interface List<T>{
    T getElement();

    List<T> getNext();

    int getLength();

    void insert(T value, int position);
    
    void remove(int position);
    
}
