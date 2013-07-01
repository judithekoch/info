

public interface List<T> extends Iterable<T>{
    T getElement();

    List<T> getNext();

    int getLength();

    void insert(T value, int position);
    
    void remove(int position);
    
}
