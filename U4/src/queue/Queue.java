package queue;

public interface Queue<T>{
	
     void enqueue(T element);
     void dequeue();
     boolean isEmpty();
}